package com.kencana.lms.marc;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.marc4j.MarcReader;
import org.marc4j.MarcStreamReader;
import org.marc4j.marc.DataField;
import org.marc4j.marc.MarcFactory;
import org.marc4j.marc.Record;
import org.marc4j.marc.VariableField;

import com.kencana.lms.model.Catalog;
import com.kencana.lms.portlet.Cataloging;
import com.kencana.lms.search.KencanaField;
import com.kencana.lms.service.CatalogLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;

public class MarcBuilder {
	
	
	public static Record buildMarcSimple(ActionRequest request,ActionResponse response) throws SystemException
	{
		long catalogId = ParamUtil.getLong(request, "catalogId");
		Catalog catalog = null;
		MarcFactory marcFactory = MarcFactory.newInstance();
		Record record = marcFactory.newRecord();
		
		if (catalogId > 0)
		{
			catalog = CatalogLocalServiceUtil.fetchCatalog(catalogId);
			String marc = catalog.getMarc();
			
			ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(marc.getBytes());
			
			
			MarcReader marcReader = new MarcStreamReader(byteArrayInputStream);
			if (marcReader.hasNext())
			{
				record = marcReader.next();
			
			}
		}
		
		String callNumber = ParamUtil.getString(request, "callNumber");
		long itemTypeId = ParamUtil.getLong(request, KencanaField.ITEM_TYPE);
		String author = ParamUtil.getString(request, KencanaField.AUTHOR_100A);
		//title
		String title245a = ParamUtil.getString(request, KencanaField.TITLE_245A);
		String title245b = ParamUtil.getString(request, KencanaField.TITLE_245B);
		String edition = ParamUtil.getString(request, "edition");
		
		//isbn
		
		
		//call number
		DataField df = marcFactory.newDataField(MarcTag.LOCAL_CALL_NUMBER, '0', '0');
		df.addSubfield(marcFactory.newSubfield('a', callNumber));
		record.addVariableField(df);
		
		
		
		df = marcFactory.newDataField(MarcTag.TITLE, '0', '0');
		df.addSubfield(marcFactory.newSubfield('a', title245a));
		df.addSubfield(marcFactory.newSubfield('b', title245b));
		record.addVariableField(df);
		
		df = marcFactory.newDataField(MarcTag.AUTHOR, '0', '0');
		df.addSubfield(marcFactory.newSubfield('a', author));
		record.addVariableField(df);
		
		
		
		//kencana added element
		
		df = marcFactory.newDataField(MarcTag.KENCANA_ADDED_TAG, '0', '0');
		df.addSubfield(marcFactory.newSubfield('1', String.valueOf(itemTypeId)));
		record.addVariableField(df);
		
		//edition
		df = marcFactory.newDataField("250", '0', '0');
		df.addSubfield(marcFactory.newSubfield('a', edition));
		record.addVariableField(df);
		
		//publication
		String publicationPlace = ParamUtil.getString(request, KencanaField.PUBLICATION_260A);
		String publicationName = ParamUtil.getString(request, KencanaField.PUBLICATION_260B);
		String publicationDate = ParamUtil.getString(request, KencanaField.PUBLICATION_260C);
		
		//ISBN
		
		
		record = removeVariableField(MarcTag.ISBN,record);
		
		List<String> isbns = getRepetableField("isbn",request);
		for (String isbn : isbns)
		{
			
			df = marcFactory.newDataField(MarcTag.ISBN, '0', '0');
			df.addSubfield(marcFactory.newSubfield('a', isbn));
			record.addVariableField(df);
		}
		
		
		df = marcFactory.newDataField(MarcTag.PUBLICATION, '0', '0');
		boolean publicationEntered = false;
		if (Validator.isNotNull(publicationPlace))
		{
			df.addSubfield(marcFactory.newSubfield('a', publicationPlace));
			publicationEntered = true;
		}
		if (Validator.isNotNull(publicationName))
		{
			df.addSubfield(marcFactory.newSubfield('b', publicationName));
			publicationEntered = true;
		}
		if (Validator.isNotNull(publicationDate))
		{
			df.addSubfield(marcFactory.newSubfield('c', publicationDate));
			publicationEntered = true;
		}
		if (publicationEntered)
		{
			record.addVariableField(df);
		}
		
		
		
		return record;
	}
	private static List<String> getRepetableField(String fieldName,ActionRequest request)
	{
		List<String> values = new ArrayList<String>();
		
		String[] fieldValues = ParamUtil.getParameterValues(request, fieldName);// request.getParameterValues(fieldName);
		
		for (String value : fieldValues)
		{
			LOGGER.info(value);
			values.add(value);
		}
		return values;	
		/*
		Map<String, String[]> parameterMap = request.getParameterMap();
		for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) 
		{
			String name = entry.getKey();

			if (name.startsWith(fieldName)) 
			{
				String val = ParamUtil.getString(request, name);
				LOGGER.info("map"+ val);
				values.add(val);
				
				
			}
		}
		
		return values;
		*/
	}
	private  static Record removeVariableField(String tag,Record record)
	{
		List<VariableField> fields = record.getVariableFields(tag);
		for (VariableField field : fields)
		{
			
			record.removeVariableField(field);
		}
		return record;
	}
	private static Log LOGGER = LogFactoryUtil.getLog(MarcBuilder.class);
}
