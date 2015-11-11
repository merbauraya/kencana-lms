package com.kencana.lms.marc;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.marc4j.MarcReader;
import org.marc4j.MarcStreamReader;
import org.marc4j.MarcXmlReader;
import org.marc4j.marc.DataField;
import org.marc4j.marc.MarcFactory;
import org.marc4j.marc.Record;
import org.marc4j.marc.Subfield;
import org.marc4j.marc.VariableField;

import com.kencana.lms.search.KencanaField;
import com.kencana.lms.service.impl.CatalogLocalServiceImpl;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.CharPool;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;

public class MarcHelper {
	
	public static final String LOCAL_CALL_NUMBER_TAG = "090";
	public static final String KENCANA_ADDED_ELEMENT_TAG = "980";
	
	
	private Record _record;
	private HttpServletRequest _request;
	private HttpServletResponse _response;
	
	public MarcHelper()
	{
		
	}
	
	public MarcHelper(Record record)
	{
		this._record = record;
		
	}
	public void setMarcXML(String marc)
	{
		ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(marc.getBytes());
		MarcReader reader = new MarcXmlReader(byteArrayInputStream);
		if (reader.hasNext())
		{
			_record = reader.next();
		
		}
		
	}
	public void setMarc(String marc)
	{
		
		ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(marc.getBytes());
		
		
		MarcReader marcReader = new MarcStreamReader(byteArrayInputStream);
		if (marcReader.hasNext())
		{
			_record = marcReader.next();
		
		}
	}
	public Record getRecord()
	{
		return _record;
	}
	public void setRecord(Record record)
	{
		this._record = record;
	}
	public MarcHelper(HttpServletRequest request,HttpServletResponse response)
	{
		this._request = request;
		this._response  = response;
		parseData();
		
	}
	
	protected void parseData()
	{
		MarcFactory marcFactory = MarcFactory.newInstance();
		Record record = marcFactory.newRecord();
		
		long itemTypeId = ParamUtil.getLong(_request, KencanaField.ITEM_TYPE);
		String author = ParamUtil.getString(_request, KencanaField.AUTHOR_100A);
		//title
		String title245a = ParamUtil.getString(_request, KencanaField.TITLE_245A);
		String title245b = ParamUtil.getString(_request, KencanaField.TITLE_245B);
		
		String isbn = ParamUtil.getString(_request, KencanaField.ISBN_020A);
		
	}
	
	public long getItemType_980_1()
	{
		return GetterUtil.getLong(getData(MarcTag.KENCANA_ADDED_TAG,'0','0','1'),0);
		
	}
	
	public String getCallNumber090_a()
	{
		return getData("090",'0','0','a');
	}
	public String getEdition250_a()
	{
		return getData("250",'0','0','a');
	}
	public String getEdition250_b()
	{
		return getData("250",'0','0','b');
	}
	public String getPhysicalExtent300_a()
	{
		return getData("300",'0','0','a');
	}
	public String getPhysicalExtent300_b()
	{
		return getData("300",'0','0','b');
	}
	public String getPhysicalExtent300_c()
	{
		return getData("300",'0','0','c');
	}
	public String get264_placeOfProduction()
	{
		return getData("264",'0','0','a');
	}
	public String get264_nameOfProducer()
	{
		return getData("264",'0','0','b');
	}
	public String get264_dateOfProduction()
	{
		return getData("264",'0','0','c');
	}
	public String get264_placeOfPublication()
	{
		return getData("264",'0','1','a');
	}
	public String get264_dateOfPublication()
	{
		return getData("264",'0','1','c');
	}
	public String get264_nameOfPublisher()
	{
		return getData("264",'0','1','b');
	}
	
	public String getProduction264()
	{
		return getData("264",'0','1','a');
	}
	public String getPublication260_a()
	{
		return getData("260",'0','0','a');
	}
	public String getPublication260_b()
	{
		return getData("260",'0','0','b');
	}
	public String getPublication260_c()
	{
		return getData("260",'0','0','c');
	}
	public String getISBN()
	{
		return getData("020",'0','0','a');
	}
	public List<String> getISBNs()
	{
		return getRepetableData(MarcTag.ISBN,'a');

	}
	public List<String> getISSNs()
	{
		return getRepetableData(MarcTag.ISSN,'a');
	}
	private List<String> getRepetableData(String tag,char subField)
	{
		List<VariableField> fields =  _record.getVariableFields(tag);
		List<String> dataList = new ArrayList<String>();
		for (VariableField field : fields)
		{
			DataField dataField = (DataField) field;
			
			List<Subfield> subfields = dataField.getSubfields();
			Iterator i = subfields.iterator();
			while(i.hasNext())
			{
				Subfield subfield = (Subfield) i.next();
				
				if (subfield.getCode() == subField)
				{
					dataList.add(subfield.getData());
				}
				
			   
			}
			
		}
		
		return dataList;
	}
	
	public String getISSN()
	{
		return getData("022",'0','0','a');
	}
	public String get100_AuthorPersonalName()
	{
		return getNRDataBySubfield("100",'a');
	}
	public String get100_AuthorNumeration()
	{
		return getNRDataBySubfield("100",'b');
	}
	
	private String getNRDataBySubfield(String tag,char subfieldCode)
	{
		DataField field = (DataField) _record.getVariableField(tag);
		List<Subfield> subfields = field.getSubfields();
		Iterator i = subfields.iterator();
		while (i.hasNext()) {
		    Subfield subfield = (Subfield) i.next();
		    char code = subfield.getCode();
		    String data = subfield.getData();
		    if (code == subfieldCode)
		    {
		    	return data;
		    }
		    
		}
		return null;
	}
	public String getAuthor()
	{
		return get100_AuthorPersonalName();
	}
	public String getFullTitle()
	{
		StringBuilder sb  = new StringBuilder(3);
		sb.append(getTitle245_a());
		sb.append(getTitle245_b());
		sb.append(getTitle245_c());
		
		return sb.toString();
	}
	public String[] getTitles245()
	{
		String[] data = new String[3];
		data[0] = getTitle245_a();
		data[1] = getTitle245_b();
		data[2] = getTitle245_c();
		
		return data;
	}
	public String getTitle245_a()
	{
		return get245('a');
		
	}
	
	private String get245(char subfieldCode)
	{
		return getNRDataBySubfield("245",subfieldCode);
	}
	public String getTitle245_b()
	{
		return get245('b');
	}
	public String getTitle245_c()
	{
		return get245('c');
	}
	
	private String getData(String tag, char indi1, char indi2, char code)
	{
		if (Validator.isNull(_record))
		{
			return StringPool.BLANK;
			
		}
		List<VariableField> fields =  _record.getVariableFields(tag);
		
		for (VariableField field : fields)
		{
			DataField dataField = (DataField) field;
			
			List<Subfield> subfields = dataField.getSubfields();
			Iterator i = subfields.iterator();
			while(i.hasNext())
			{
				Subfield subfield = (Subfield) i.next();
		
			    StringBuilder sb = new StringBuilder();
			    
			    sb.append(dataField.getTag());
			    sb.append(StringPool.MINUS);
			    sb.append(dataField.getIndicator1());
			    sb.append(dataField.getIndicator2());
			    if (equalsIgnoreCase(subfield.getCode(), code) && dataField.getIndicator1() == indi1 
			    		&& dataField.getIndicator2() == indi2)
			    	return subfield.getData();
			    
			    
			    
			}
			
		}
		return null;
	}
	
	
	public String getTitle()
	{
		
		if (Validator.isNull(_record))
		{
			return StringPool.BLANK;
		}
		List<VariableField> titles =  _record.getVariableFields("245");
		
		for (VariableField field : titles)
		{
			DataField dataField = (DataField) field;
			
			List<Subfield> subfields = dataField.getSubfields();
			Iterator i = subfields.iterator();
			while(i.hasNext())
			{
				Subfield subfield = (Subfield) i.next();
		
			    StringBuilder sb = new StringBuilder();
			    
			    sb.append(dataField.getTag());
			    sb.append(StringPool.MINUS);
			    sb.append(dataField.getIndicator1());
			    sb.append(dataField.getIndicator2());
			    if (subfield.getCode() == CharPool.LOWER_CASE_A || subfield.getCode() == CharPool.UPPER_CASE_A)
			    	return subfield.getData();
			    
			    
			    
			}
			
		}
		return null;
	}
	
	public Map<String,String> getTitleMap()
	{
		
		if (Validator.isNull(_record))
		{
			return null;
		}
		
		Map<String,String> titleMap = new HashMap<String,String>();
		
		List<VariableField> titles =  _record.getVariableFields("245");
		for (VariableField field : titles)
		{
			DataField dataField = (DataField) field;
			
			List<Subfield> subfields = dataField.getSubfields();
			Iterator i = subfields.iterator();
			while(i.hasNext())
			{
				Subfield subfield = (Subfield) i.next();
		
			    StringBuilder sb = new StringBuilder();
			    
			    sb.append(dataField.getTag());
			    sb.append(StringPool.MINUS);
			    sb.append(dataField.getIndicator1());
			    sb.append(dataField.getIndicator2());
			    sb.append(subfield.getCode());
			    
			    titleMap.put(sb.toString(), subfield.getData());
			}
			
		}
		
		return titleMap;
	}
	
	boolean equalsIgnoreCase(char character1, char character2) 
	{
		
		if(Character.toLowerCase(character1) == Character.toLowerCase(character2)) {
		
		        return true;
		
		    }
		
		return false;
		
	}

	private static Log LOGGER = LogFactoryUtil.getLog(MarcHelper.class);

}
