package com.kencana.lms.util;

import java.util.Calendar;

import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletRequest;


import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.CalendarUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.documentlibrary.NoSuchFolderException;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil;

public class FolderUtil {
	static ThemeDisplay _themeDisplay;
	public static long getFolderId(PortletRequest request,ThemeDisplay themeDisplay)
	{
		_themeDisplay = themeDisplay;
		
		Calendar now = Calendar.getInstance();
		String year = String.valueOf(now.get(Calendar.YEAR));
		String[] months = CalendarUtil.getMonths(_themeDisplay.getLocale());
		String month = months[now.get(Calendar.MONTH)];
		
		//check if 
		
		DLFolder dir = getRootFolder(request);
		DLFolder folderYear = getFolder(dir.getFolderId(),year,request);
		DLFolder folderMonth = getFolder(folderYear.getFolderId(),month,request);
		
		return folderMonth.getFolderId();
	}
	public static long getFolderId(HttpServletRequest request,ThemeDisplay themeDisplay)
	{
		_themeDisplay = themeDisplay;
		
		Calendar now = Calendar.getInstance();
		String year = String.valueOf(now.get(Calendar.YEAR));
		String[] months = CalendarUtil.getMonths(_themeDisplay.getLocale());
		String month = months[now.get(Calendar.MONTH)];
		
		//check if 
		
		DLFolder dir = getRootFolder(request);
		DLFolder folderYear = getFolder(dir.getFolderId(),year,request);
		DLFolder folderMonth = getFolder(folderYear.getFolderId(),month,request);
		
		return folderMonth.getFolderId();
	}
	private static DLFolder getFolder(long parentFolderId,String folderName,PortletRequest request)
	{
		//logger.info("getfolder "+ folderName + parentFolderId);
		try {
			DLFolder dir = DLFolderLocalServiceUtil.getFolder(_themeDisplay.getScopeGroupId(), parentFolderId, folderName);
			return dir;
		}catch (NoSuchFolderException e)
		{
			return createFolder(folderName,parentFolderId,request);
		}
		
		catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
			
		}
		return null;
	}
	private static DLFolder getFolder(long parentFolderId,String folderName,HttpServletRequest request)
	{
		
		try {
			DLFolder dir = DLFolderLocalServiceUtil.getFolder(_themeDisplay.getScopeGroupId(), parentFolderId, folderName);
			return dir;
		}catch (NoSuchFolderException e)
		{
			return createFolder(folderName,parentFolderId,request);
		}
		
		catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
			
		}
		return null;
	}
	private static DLFolder getRootFolder(PortletRequest request)
	{
		long ROOT_FOLDER=0;
		try {
			DLFolder dir = DLFolderLocalServiceUtil.getFolder(_themeDisplay.getScopeGroupId(), 0, KencanaConstant.KENCANA_ROOT_FOLDER);
			return dir;
		}catch (NoSuchFolderException e)
		{
			return createFolder(KencanaConstant.KENCANA_ROOT_FOLDER,ROOT_FOLDER,request);
		}
		catch (PortalException e) {
			
			e.printStackTrace();
		} catch (SystemException e) {
			
			
		}
		return null;
	}
	private static DLFolder getRootFolder(HttpServletRequest request)
	{
		long ROOT_FOLDER=0;
		try {
			DLFolder dir = DLFolderLocalServiceUtil.getFolder(_themeDisplay.getScopeGroupId(), 0, KencanaConstant.KENCANA_ROOT_FOLDER);
			return dir;
		}catch (NoSuchFolderException e)
		{
			return createFolder(KencanaConstant.KENCANA_ROOT_FOLDER,ROOT_FOLDER,request);
		}
		catch (PortalException e) {
			
			e.printStackTrace();
		} catch (SystemException e) {
			
			
		}
		return null;
	}
	private static DLFolder createFolder(String folderName,long parentFolderId,PortletRequest request) 
	{
		
		DLFolder folder = null;
		try {
			ServiceContext folderServiceContext = ServiceContextFactory.getInstance(DLFolder.class.getName(), request);
			folderServiceContext.setAddGuestPermissions(true);
			
			folder = DLFolderLocalServiceUtil.addFolder(
					_themeDisplay.getUserId(), _themeDisplay.getScopeGroupId(),
					_themeDisplay.getScopeGroupId(), false,
					 parentFolderId,
					 folderName, folderName, false,
					 folderServiceContext);
			return folder;
		} catch (PortalException e) {
			
			e.printStackTrace();
		} catch (SystemException e) {
			
			e.printStackTrace();
		}
		return folder;
	}
	private static DLFolder createFolder(String folderName,long parentFolderId,HttpServletRequest request) 
	{
		
		DLFolder folder = null;
		try {
			ServiceContext folderServiceContext = ServiceContextFactory.getInstance(request);
			folderServiceContext.setAddGuestPermissions(true);

			folder = DLFolderLocalServiceUtil.addFolder(
					_themeDisplay.getUserId(), _themeDisplay.getScopeGroupId(),
					_themeDisplay.getScopeGroupId(), false,
					 parentFolderId,
					 folderName, folderName, false,
					 folderServiceContext);
			return folder;
		} catch (PortalException e) {
			
			e.printStackTrace();
		} catch (SystemException e) {
			
			e.printStackTrace();
		}
		return folder;
		
	}

}
