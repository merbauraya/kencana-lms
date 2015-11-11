package com.kencana.lms.search;

import com.liferay.portal.kernel.search.Field;

public class KencanaField extends Field {
	
	public final static String ITEM_TYPE="itemType";
	public final static String ITEM_TYPE_STRING="itemTypeString";
	
	/* 245 title*/
	public final static String TAG_245 = "title245";
	public final static String  TITLE_245A = "title245a";
	public final static String  TITLE_245B = "title245b";
	public final static String  TITLE_245C = "title245c";
	public final static String OTHER_TITLE="otherTitle";
	
	/* identifier */
	public final static String ISBN_020A = "isbn";
	public final static String LOC_CONTROL_NO_010A = "locControlNumber";
	public final static String SYSTEM_CONTORL_NO_035A = "systemControlNumber";
	
	public final static String LOC_CALL_NUMBER_050A = "locCallNumberClassification";
	public final static String LOC_CALL_NUMBER_050B = "locCallNumberItemNumber";
	
	
	
	/* author */
	public final static String AUTHOR_100A = "author100a";
	
	/* 260 publication  */
	public static final String PUBLICATION_260A = "placeOfPublication";
	public static final String PUBLICATION_260B = "nameOfPublisher";
	public static final String PUBLICATION_260C = "dateOfPublication";
	
	
	/* 300 Physical Description */
	public static final String PHYSICAL_EXTENT_300A = "physicalExtents";
	public static final String PHYSICAL_OTHER_300B = "physicalOther";
	public static final String PHYSICAL_DIMENSIONS_300C = "physicalDimensions";
	
	
	/* 336 Content Type */
	public static final String CONTENT_TYPE_TERM = "contentTypeTerm";
	public static final String CONTENT_TYPE_CODE = "contentTypeCode";
	
	/* 337 Media Type */
	public static final String MEDIA_TYPE_TERM_337A = "mediaTypeTerms";
	public static final String MEDIA_TYPE_TERM_337B = "mediaTypeCodes";
	public static final String MEDIA_TYPE_TERM_3372 = "mediaTypeSource";
	
	/* index status */
	public static final String CATALOG_VISIBLE = "visible";
	
	public KencanaField(String name, String value) {
		super(name, value);
		
	}

}
