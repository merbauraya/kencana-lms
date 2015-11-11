<%@ include file="/html/init.jsp" %>

<%@ page import="java.io.StringReader" %>
<%@ page import="java.io.ByteArrayInputStream" %>
<%@ page import="java.io.InputStream" %>

<%@ page import="com.liferay.portlet.documentlibrary.model.DLFileEntryType" %>
<%@ page import="com.liferay.portlet.documentlibrary.service.DLFileEntryTypeServiceUtil" %>
<%@ page import="com.liferay.portlet.documentlibrary.model.DLFileVersion" %>
<%@ page import="com.liferay.portlet.documentlibrary.service.DLFileEntryTypeLocalServiceUtil" %>




<%@ page import="com.kencana.lms.service.CatalogLocalServiceUtil" %>
<%@ page import="com.kencana.lms.model.MarcBatchUpload"%>
<%@ page import="com.kencana.lms.service.MarcBatchUploadLocalServiceUtil" %>
<%@ page import="com.kencana.lms.marc.MarcHelper" %>
<%@ page import="com.kencana.lms.search.CatalogItemSearch" %>
<%@ page import="com.kencana.lms.search.CatalogItemDisplayTerms" %>
<%@ page import="com.kencana.lms.search.CatalogItemSearchTerms" %>
<%@ page import="com.kencana.lms.model.CatalogItem" %>
<%@ page import="com.kencana.lms.service.CatalogItemLocalServiceUtil" %>
<%@ page import="com.kencana.lms.util.CatalogingConstants" %> 

<%@ page import="org.marc4j.MarcReader" %>
<%@ page import="org.marc4j.MarcStreamReader" %>
<%@ page import="org.marc4j.marc.Record" %>
<%@ page import="org.marc4j.MarcXmlReader" %>