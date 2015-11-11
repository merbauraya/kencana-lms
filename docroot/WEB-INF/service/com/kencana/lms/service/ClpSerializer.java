/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.kencana.lms.service;

import com.kencana.lms.model.CatalogClp;
import com.kencana.lms.model.CatalogItemClp;
import com.kencana.lms.model.CatalogTemplateClp;
import com.kencana.lms.model.CatalogTemplateSubfieldClp;
import com.kencana.lms.model.CatalogTemplateTagClp;
import com.kencana.lms.model.CircTransHistoryClp;
import com.kencana.lms.model.CirculationRuleClp;
import com.kencana.lms.model.CirculationTransClp;
import com.kencana.lms.model.ItemCategoryClp;
import com.kencana.lms.model.ItemTypeClp;
import com.kencana.lms.model.LibraryClp;
import com.kencana.lms.model.LocationClp;
import com.kencana.lms.model.MarcBatchUploadClp;
import com.kencana.lms.model.MarcBatchUploadItemClp;
import com.kencana.lms.model.MarcSubfieldClp;
import com.kencana.lms.model.MarcTagClp;
import com.kencana.lms.model.PatronCategoryClp;
import com.kencana.lms.model.PatronClp;
import com.kencana.lms.model.PatronStatusClp;
import com.kencana.lms.model.ReasonCodeClp;
import com.kencana.lms.model.VendorClp;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayOutputStream;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ClassLoaderObjectInputStream;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mazlan Mat
 */
public class ClpSerializer {
	public static String getServletContextName() {
		if (Validator.isNotNull(_servletContextName)) {
			return _servletContextName;
		}

		synchronized (ClpSerializer.class) {
			if (Validator.isNotNull(_servletContextName)) {
				return _servletContextName;
			}

			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Class<?> portletPropsClass = classLoader.loadClass(
						"com.liferay.util.portlet.PortletProps");

				Method getMethod = portletPropsClass.getMethod("get",
						new Class<?>[] { String.class });

				String portletPropsServletContextName = (String)getMethod.invoke(null,
						"kencana-portlet-deployment-context");

				if (Validator.isNotNull(portletPropsServletContextName)) {
					_servletContextName = portletPropsServletContextName;
				}
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info(
						"Unable to locate deployment context from portlet properties");
				}
			}

			if (Validator.isNull(_servletContextName)) {
				try {
					String propsUtilServletContextName = PropsUtil.get(
							"kencana-portlet-deployment-context");

					if (Validator.isNotNull(propsUtilServletContextName)) {
						_servletContextName = propsUtilServletContextName;
					}
				}
				catch (Throwable t) {
					if (_log.isInfoEnabled()) {
						_log.info(
							"Unable to locate deployment context from portal properties");
					}
				}
			}

			if (Validator.isNull(_servletContextName)) {
				_servletContextName = "kencana-portlet";
			}

			return _servletContextName;
		}
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(CatalogClp.class.getName())) {
			return translateInputCatalog(oldModel);
		}

		if (oldModelClassName.equals(CatalogItemClp.class.getName())) {
			return translateInputCatalogItem(oldModel);
		}

		if (oldModelClassName.equals(CatalogTemplateClp.class.getName())) {
			return translateInputCatalogTemplate(oldModel);
		}

		if (oldModelClassName.equals(CatalogTemplateSubfieldClp.class.getName())) {
			return translateInputCatalogTemplateSubfield(oldModel);
		}

		if (oldModelClassName.equals(CatalogTemplateTagClp.class.getName())) {
			return translateInputCatalogTemplateTag(oldModel);
		}

		if (oldModelClassName.equals(CircTransHistoryClp.class.getName())) {
			return translateInputCircTransHistory(oldModel);
		}

		if (oldModelClassName.equals(CirculationRuleClp.class.getName())) {
			return translateInputCirculationRule(oldModel);
		}

		if (oldModelClassName.equals(CirculationTransClp.class.getName())) {
			return translateInputCirculationTrans(oldModel);
		}

		if (oldModelClassName.equals(ItemCategoryClp.class.getName())) {
			return translateInputItemCategory(oldModel);
		}

		if (oldModelClassName.equals(ItemTypeClp.class.getName())) {
			return translateInputItemType(oldModel);
		}

		if (oldModelClassName.equals(LibraryClp.class.getName())) {
			return translateInputLibrary(oldModel);
		}

		if (oldModelClassName.equals(LocationClp.class.getName())) {
			return translateInputLocation(oldModel);
		}

		if (oldModelClassName.equals(MarcBatchUploadClp.class.getName())) {
			return translateInputMarcBatchUpload(oldModel);
		}

		if (oldModelClassName.equals(MarcBatchUploadItemClp.class.getName())) {
			return translateInputMarcBatchUploadItem(oldModel);
		}

		if (oldModelClassName.equals(MarcSubfieldClp.class.getName())) {
			return translateInputMarcSubfield(oldModel);
		}

		if (oldModelClassName.equals(MarcTagClp.class.getName())) {
			return translateInputMarcTag(oldModel);
		}

		if (oldModelClassName.equals(PatronClp.class.getName())) {
			return translateInputPatron(oldModel);
		}

		if (oldModelClassName.equals(PatronCategoryClp.class.getName())) {
			return translateInputPatronCategory(oldModel);
		}

		if (oldModelClassName.equals(PatronStatusClp.class.getName())) {
			return translateInputPatronStatus(oldModel);
		}

		if (oldModelClassName.equals(ReasonCodeClp.class.getName())) {
			return translateInputReasonCode(oldModel);
		}

		if (oldModelClassName.equals(VendorClp.class.getName())) {
			return translateInputVendor(oldModel);
		}

		return oldModel;
	}

	public static Object translateInput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateInput(curObj));
		}

		return newList;
	}

	public static Object translateInputCatalog(BaseModel<?> oldModel) {
		CatalogClp oldClpModel = (CatalogClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getCatalogRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputCatalogItem(BaseModel<?> oldModel) {
		CatalogItemClp oldClpModel = (CatalogItemClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getCatalogItemRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputCatalogTemplate(BaseModel<?> oldModel) {
		CatalogTemplateClp oldClpModel = (CatalogTemplateClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getCatalogTemplateRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputCatalogTemplateSubfield(
		BaseModel<?> oldModel) {
		CatalogTemplateSubfieldClp oldClpModel = (CatalogTemplateSubfieldClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getCatalogTemplateSubfieldRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputCatalogTemplateTag(BaseModel<?> oldModel) {
		CatalogTemplateTagClp oldClpModel = (CatalogTemplateTagClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getCatalogTemplateTagRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputCircTransHistory(BaseModel<?> oldModel) {
		CircTransHistoryClp oldClpModel = (CircTransHistoryClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getCircTransHistoryRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputCirculationRule(BaseModel<?> oldModel) {
		CirculationRuleClp oldClpModel = (CirculationRuleClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getCirculationRuleRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputCirculationTrans(BaseModel<?> oldModel) {
		CirculationTransClp oldClpModel = (CirculationTransClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getCirculationTransRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputItemCategory(BaseModel<?> oldModel) {
		ItemCategoryClp oldClpModel = (ItemCategoryClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getItemCategoryRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputItemType(BaseModel<?> oldModel) {
		ItemTypeClp oldClpModel = (ItemTypeClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getItemTypeRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputLibrary(BaseModel<?> oldModel) {
		LibraryClp oldClpModel = (LibraryClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getLibraryRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputLocation(BaseModel<?> oldModel) {
		LocationClp oldClpModel = (LocationClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getLocationRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputMarcBatchUpload(BaseModel<?> oldModel) {
		MarcBatchUploadClp oldClpModel = (MarcBatchUploadClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getMarcBatchUploadRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputMarcBatchUploadItem(
		BaseModel<?> oldModel) {
		MarcBatchUploadItemClp oldClpModel = (MarcBatchUploadItemClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getMarcBatchUploadItemRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputMarcSubfield(BaseModel<?> oldModel) {
		MarcSubfieldClp oldClpModel = (MarcSubfieldClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getMarcSubfieldRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputMarcTag(BaseModel<?> oldModel) {
		MarcTagClp oldClpModel = (MarcTagClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getMarcTagRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputPatron(BaseModel<?> oldModel) {
		PatronClp oldClpModel = (PatronClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getPatronRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputPatronCategory(BaseModel<?> oldModel) {
		PatronCategoryClp oldClpModel = (PatronCategoryClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getPatronCategoryRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputPatronStatus(BaseModel<?> oldModel) {
		PatronStatusClp oldClpModel = (PatronStatusClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getPatronStatusRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputReasonCode(BaseModel<?> oldModel) {
		ReasonCodeClp oldClpModel = (ReasonCodeClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getReasonCodeRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputVendor(BaseModel<?> oldModel) {
		VendorClp oldClpModel = (VendorClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getVendorRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateInput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateInput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals("com.kencana.lms.model.impl.CatalogImpl")) {
			return translateOutputCatalog(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.kencana.lms.model.impl.CatalogItemImpl")) {
			return translateOutputCatalogItem(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.kencana.lms.model.impl.CatalogTemplateImpl")) {
			return translateOutputCatalogTemplate(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.kencana.lms.model.impl.CatalogTemplateSubfieldImpl")) {
			return translateOutputCatalogTemplateSubfield(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.kencana.lms.model.impl.CatalogTemplateTagImpl")) {
			return translateOutputCatalogTemplateTag(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.kencana.lms.model.impl.CircTransHistoryImpl")) {
			return translateOutputCircTransHistory(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.kencana.lms.model.impl.CirculationRuleImpl")) {
			return translateOutputCirculationRule(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.kencana.lms.model.impl.CirculationTransImpl")) {
			return translateOutputCirculationTrans(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.kencana.lms.model.impl.ItemCategoryImpl")) {
			return translateOutputItemCategory(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals("com.kencana.lms.model.impl.ItemTypeImpl")) {
			return translateOutputItemType(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals("com.kencana.lms.model.impl.LibraryImpl")) {
			return translateOutputLibrary(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals("com.kencana.lms.model.impl.LocationImpl")) {
			return translateOutputLocation(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.kencana.lms.model.impl.MarcBatchUploadImpl")) {
			return translateOutputMarcBatchUpload(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.kencana.lms.model.impl.MarcBatchUploadItemImpl")) {
			return translateOutputMarcBatchUploadItem(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.kencana.lms.model.impl.MarcSubfieldImpl")) {
			return translateOutputMarcSubfield(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals("com.kencana.lms.model.impl.MarcTagImpl")) {
			return translateOutputMarcTag(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals("com.kencana.lms.model.impl.PatronImpl")) {
			return translateOutputPatron(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.kencana.lms.model.impl.PatronCategoryImpl")) {
			return translateOutputPatronCategory(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.kencana.lms.model.impl.PatronStatusImpl")) {
			return translateOutputPatronStatus(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.kencana.lms.model.impl.ReasonCodeImpl")) {
			return translateOutputReasonCode(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals("com.kencana.lms.model.impl.VendorImpl")) {
			return translateOutputVendor(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		return oldModel;
	}

	public static Object translateOutput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateOutput(curObj));
		}

		return newList;
	}

	public static Object translateOutput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateOutput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateOutput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Throwable translateThrowable(Throwable throwable) {
		if (_useReflectionToTranslateThrowable) {
			try {
				UnsyncByteArrayOutputStream unsyncByteArrayOutputStream = new UnsyncByteArrayOutputStream();
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(unsyncByteArrayOutputStream);

				objectOutputStream.writeObject(throwable);

				objectOutputStream.flush();
				objectOutputStream.close();

				UnsyncByteArrayInputStream unsyncByteArrayInputStream = new UnsyncByteArrayInputStream(unsyncByteArrayOutputStream.unsafeGetByteArray(),
						0, unsyncByteArrayOutputStream.size());

				Thread currentThread = Thread.currentThread();

				ClassLoader contextClassLoader = currentThread.getContextClassLoader();

				ObjectInputStream objectInputStream = new ClassLoaderObjectInputStream(unsyncByteArrayInputStream,
						contextClassLoader);

				throwable = (Throwable)objectInputStream.readObject();

				objectInputStream.close();

				return throwable;
			}
			catch (SecurityException se) {
				if (_log.isInfoEnabled()) {
					_log.info("Do not use reflection to translate throwable");
				}

				_useReflectionToTranslateThrowable = false;
			}
			catch (Throwable throwable2) {
				_log.error(throwable2, throwable2);

				return throwable2;
			}
		}

		Class<?> clazz = throwable.getClass();

		String className = clazz.getName();

		if (className.equals(PortalException.class.getName())) {
			return new PortalException();
		}

		if (className.equals(SystemException.class.getName())) {
			return new SystemException();
		}

		if (className.equals("com.kencana.lms.DueDateException")) {
			return new com.kencana.lms.DueDateException();
		}

		if (className.equals("com.kencana.lms.ExpiryDateException")) {
			return new com.kencana.lms.ExpiryDateException();
		}

		if (className.equals("com.kencana.lms.NoSuchCatalogException")) {
			return new com.kencana.lms.NoSuchCatalogException();
		}

		if (className.equals("com.kencana.lms.NoSuchCatalogItemException")) {
			return new com.kencana.lms.NoSuchCatalogItemException();
		}

		if (className.equals("com.kencana.lms.NoSuchCatalogTemplateException")) {
			return new com.kencana.lms.NoSuchCatalogTemplateException();
		}

		if (className.equals(
					"com.kencana.lms.NoSuchCatalogTemplateSubfieldException")) {
			return new com.kencana.lms.NoSuchCatalogTemplateSubfieldException();
		}

		if (className.equals(
					"com.kencana.lms.NoSuchCatalogTemplateTagException")) {
			return new com.kencana.lms.NoSuchCatalogTemplateTagException();
		}

		if (className.equals("com.kencana.lms.NoSuchCircTransHistoryException")) {
			return new com.kencana.lms.NoSuchCircTransHistoryException();
		}

		if (className.equals("com.kencana.lms.NoSuchCirculationRuleException")) {
			return new com.kencana.lms.NoSuchCirculationRuleException();
		}

		if (className.equals("com.kencana.lms.NoSuchCirculationTransException")) {
			return new com.kencana.lms.NoSuchCirculationTransException();
		}

		if (className.equals("com.kencana.lms.NoSuchItemCategoryException")) {
			return new com.kencana.lms.NoSuchItemCategoryException();
		}

		if (className.equals("com.kencana.lms.NoSuchItemTypeException")) {
			return new com.kencana.lms.NoSuchItemTypeException();
		}

		if (className.equals("com.kencana.lms.NoSuchLibraryException")) {
			return new com.kencana.lms.NoSuchLibraryException();
		}

		if (className.equals("com.kencana.lms.NoSuchLocationException")) {
			return new com.kencana.lms.NoSuchLocationException();
		}

		if (className.equals("com.kencana.lms.NoSuchMarcBatchUploadException")) {
			return new com.kencana.lms.NoSuchMarcBatchUploadException();
		}

		if (className.equals(
					"com.kencana.lms.NoSuchMarcBatchUploadItemException")) {
			return new com.kencana.lms.NoSuchMarcBatchUploadItemException();
		}

		if (className.equals("com.kencana.lms.NoSuchMarcSubfieldException")) {
			return new com.kencana.lms.NoSuchMarcSubfieldException();
		}

		if (className.equals("com.kencana.lms.NoSuchMarcTagException")) {
			return new com.kencana.lms.NoSuchMarcTagException();
		}

		if (className.equals("com.kencana.lms.NoSuchPatronException")) {
			return new com.kencana.lms.NoSuchPatronException();
		}

		if (className.equals("com.kencana.lms.NoSuchPatronCategoryException")) {
			return new com.kencana.lms.NoSuchPatronCategoryException();
		}

		if (className.equals("com.kencana.lms.NoSuchPatronStatusException")) {
			return new com.kencana.lms.NoSuchPatronStatusException();
		}

		if (className.equals("com.kencana.lms.NoSuchReasonCodeException")) {
			return new com.kencana.lms.NoSuchReasonCodeException();
		}

		if (className.equals("com.kencana.lms.NoSuchVendorException")) {
			return new com.kencana.lms.NoSuchVendorException();
		}

		return throwable;
	}

	public static Object translateOutputCatalog(BaseModel<?> oldModel) {
		CatalogClp newModel = new CatalogClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setCatalogRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputCatalogItem(BaseModel<?> oldModel) {
		CatalogItemClp newModel = new CatalogItemClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setCatalogItemRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputCatalogTemplate(BaseModel<?> oldModel) {
		CatalogTemplateClp newModel = new CatalogTemplateClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setCatalogTemplateRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputCatalogTemplateSubfield(
		BaseModel<?> oldModel) {
		CatalogTemplateSubfieldClp newModel = new CatalogTemplateSubfieldClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setCatalogTemplateSubfieldRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputCatalogTemplateTag(
		BaseModel<?> oldModel) {
		CatalogTemplateTagClp newModel = new CatalogTemplateTagClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setCatalogTemplateTagRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputCircTransHistory(BaseModel<?> oldModel) {
		CircTransHistoryClp newModel = new CircTransHistoryClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setCircTransHistoryRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputCirculationRule(BaseModel<?> oldModel) {
		CirculationRuleClp newModel = new CirculationRuleClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setCirculationRuleRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputCirculationTrans(BaseModel<?> oldModel) {
		CirculationTransClp newModel = new CirculationTransClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setCirculationTransRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputItemCategory(BaseModel<?> oldModel) {
		ItemCategoryClp newModel = new ItemCategoryClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setItemCategoryRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputItemType(BaseModel<?> oldModel) {
		ItemTypeClp newModel = new ItemTypeClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setItemTypeRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputLibrary(BaseModel<?> oldModel) {
		LibraryClp newModel = new LibraryClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setLibraryRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputLocation(BaseModel<?> oldModel) {
		LocationClp newModel = new LocationClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setLocationRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputMarcBatchUpload(BaseModel<?> oldModel) {
		MarcBatchUploadClp newModel = new MarcBatchUploadClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setMarcBatchUploadRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputMarcBatchUploadItem(
		BaseModel<?> oldModel) {
		MarcBatchUploadItemClp newModel = new MarcBatchUploadItemClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setMarcBatchUploadItemRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputMarcSubfield(BaseModel<?> oldModel) {
		MarcSubfieldClp newModel = new MarcSubfieldClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setMarcSubfieldRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputMarcTag(BaseModel<?> oldModel) {
		MarcTagClp newModel = new MarcTagClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setMarcTagRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputPatron(BaseModel<?> oldModel) {
		PatronClp newModel = new PatronClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setPatronRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputPatronCategory(BaseModel<?> oldModel) {
		PatronCategoryClp newModel = new PatronCategoryClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setPatronCategoryRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputPatronStatus(BaseModel<?> oldModel) {
		PatronStatusClp newModel = new PatronStatusClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setPatronStatusRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputReasonCode(BaseModel<?> oldModel) {
		ReasonCodeClp newModel = new ReasonCodeClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setReasonCodeRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputVendor(BaseModel<?> oldModel) {
		VendorClp newModel = new VendorClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setVendorRemoteModel(oldModel);

		return newModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static String _servletContextName;
	private static boolean _useReflectionToTranslateThrowable = true;
}