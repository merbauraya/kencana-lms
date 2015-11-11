package com.kencana.lms.util;

import com.kencana.lms.portlet.Cataloging;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.webserver.WebServerServletTokenUtil;

public class KencanaUtil {
	
	public static String getDefaultCoverURL(String imagePath)
	{
		

			StringBundler sb = new StringBundler(9);

			sb.append(imagePath);
			sb.append("/author_");

			
			sb.append("male");
			
			sb.append("_portrait?img_id=");
			sb.append(0);

			
			sb.append("&t=");
			sb.append(WebServerServletTokenUtil.getToken(0));

			return sb.toString();
	}
	 public static Long[] toObject(long[] array) 
	 {
	     if (array == null) {
	         return null;
	     } else if (array.length == 0) {
	         return new Long[0];
	     }
	     final Long[] result = new Long[array.length];
	     for (int i = 0; i < array.length; i++) {
	         result[i] = new Long(array[i]);
	     }
	     return result;
	 }
	
	public static long[] toLongArray(String[] array)
	{
		if (ArrayUtil.isEmpty(array))
			return null;
		
		long[] longArray = new long[array.length];
		for (int i = 0; i < array.length; i++)
		{
			LOGGER.debug("val="+array[i]);
			longArray[i] = Long.valueOf(array[i]);
		}
		return longArray;
	}
	public static String ArrayToString(long[] array)
	{
		return ArrayToString(array,StringPool.COMMA);
	}
	
	public static String ArrayToString(long[] array,String delimiter)
	{
		StringBuilder sb = new StringBuilder();
		if (ArrayUtil.isEmpty(array))
			return null;
		
		
	    for (int i = 0; i < array.length; ++i)
	    {
	        sb.append(String.valueOf(array[i]));
	        if (i+1 < array.length)
	        	sb.append(delimiter);
	    }
	    return sb.toString();
	}
	
	public String statusDisplay(boolean status,String trueText,String falseText)
	{
		StringBuilder sb = new StringBuilder();
		
		return sb.toString();
	}
	
	
	
	private static Log LOGGER = LogFactoryUtil.getLog(KencanaUtil.class);
}
