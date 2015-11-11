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

package com.kencana.lms.service.messaging;

import com.kencana.lms.service.CatalogItemLocalServiceUtil;
import com.kencana.lms.service.CatalogItemServiceUtil;
import com.kencana.lms.service.CatalogLocalServiceUtil;
import com.kencana.lms.service.CatalogServiceUtil;
import com.kencana.lms.service.CatalogTemplateLocalServiceUtil;
import com.kencana.lms.service.CatalogTemplateServiceUtil;
import com.kencana.lms.service.CatalogTemplateSubfieldLocalServiceUtil;
import com.kencana.lms.service.CatalogTemplateSubfieldServiceUtil;
import com.kencana.lms.service.CatalogTemplateTagLocalServiceUtil;
import com.kencana.lms.service.CatalogTemplateTagServiceUtil;
import com.kencana.lms.service.CircTransHistoryLocalServiceUtil;
import com.kencana.lms.service.CircTransHistoryServiceUtil;
import com.kencana.lms.service.CirculationRuleLocalServiceUtil;
import com.kencana.lms.service.CirculationRuleServiceUtil;
import com.kencana.lms.service.CirculationTransLocalServiceUtil;
import com.kencana.lms.service.CirculationTransServiceUtil;
import com.kencana.lms.service.ClpSerializer;
import com.kencana.lms.service.ItemCategoryLocalServiceUtil;
import com.kencana.lms.service.ItemCategoryServiceUtil;
import com.kencana.lms.service.ItemTypeLocalServiceUtil;
import com.kencana.lms.service.ItemTypeServiceUtil;
import com.kencana.lms.service.LibraryLocalServiceUtil;
import com.kencana.lms.service.LibraryServiceUtil;
import com.kencana.lms.service.LocationLocalServiceUtil;
import com.kencana.lms.service.LocationServiceUtil;
import com.kencana.lms.service.MarcBatchUploadItemLocalServiceUtil;
import com.kencana.lms.service.MarcBatchUploadItemServiceUtil;
import com.kencana.lms.service.MarcBatchUploadLocalServiceUtil;
import com.kencana.lms.service.MarcBatchUploadServiceUtil;
import com.kencana.lms.service.MarcSubfieldLocalServiceUtil;
import com.kencana.lms.service.MarcSubfieldServiceUtil;
import com.kencana.lms.service.MarcTagLocalServiceUtil;
import com.kencana.lms.service.MarcTagServiceUtil;
import com.kencana.lms.service.PatronCategoryLocalServiceUtil;
import com.kencana.lms.service.PatronCategoryServiceUtil;
import com.kencana.lms.service.PatronLocalServiceUtil;
import com.kencana.lms.service.PatronServiceUtil;
import com.kencana.lms.service.PatronStatusLocalServiceUtil;
import com.kencana.lms.service.PatronStatusServiceUtil;
import com.kencana.lms.service.ReasonCodeLocalServiceUtil;
import com.kencana.lms.service.ReasonCodeServiceUtil;
import com.kencana.lms.service.VendorLocalServiceUtil;
import com.kencana.lms.service.VendorServiceUtil;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

/**
 * @author Mazlan Mat
 */
public class ClpMessageListener extends BaseMessageListener {
	public static String getServletContextName() {
		return ClpSerializer.getServletContextName();
	}

	@Override
	protected void doReceive(Message message) throws Exception {
		String command = message.getString("command");
		String servletContextName = message.getString("servletContextName");

		if (command.equals("undeploy") &&
				servletContextName.equals(getServletContextName())) {
			CatalogLocalServiceUtil.clearService();

			CatalogServiceUtil.clearService();
			CatalogItemLocalServiceUtil.clearService();

			CatalogItemServiceUtil.clearService();
			CatalogTemplateLocalServiceUtil.clearService();

			CatalogTemplateServiceUtil.clearService();
			CatalogTemplateSubfieldLocalServiceUtil.clearService();

			CatalogTemplateSubfieldServiceUtil.clearService();
			CatalogTemplateTagLocalServiceUtil.clearService();

			CatalogTemplateTagServiceUtil.clearService();
			CircTransHistoryLocalServiceUtil.clearService();

			CircTransHistoryServiceUtil.clearService();
			CirculationRuleLocalServiceUtil.clearService();

			CirculationRuleServiceUtil.clearService();
			CirculationTransLocalServiceUtil.clearService();

			CirculationTransServiceUtil.clearService();
			ItemCategoryLocalServiceUtil.clearService();

			ItemCategoryServiceUtil.clearService();
			ItemTypeLocalServiceUtil.clearService();

			ItemTypeServiceUtil.clearService();
			LibraryLocalServiceUtil.clearService();

			LibraryServiceUtil.clearService();
			LocationLocalServiceUtil.clearService();

			LocationServiceUtil.clearService();
			MarcBatchUploadLocalServiceUtil.clearService();

			MarcBatchUploadServiceUtil.clearService();
			MarcBatchUploadItemLocalServiceUtil.clearService();

			MarcBatchUploadItemServiceUtil.clearService();
			MarcSubfieldLocalServiceUtil.clearService();

			MarcSubfieldServiceUtil.clearService();
			MarcTagLocalServiceUtil.clearService();

			MarcTagServiceUtil.clearService();
			PatronLocalServiceUtil.clearService();

			PatronServiceUtil.clearService();
			PatronCategoryLocalServiceUtil.clearService();

			PatronCategoryServiceUtil.clearService();
			PatronStatusLocalServiceUtil.clearService();

			PatronStatusServiceUtil.clearService();
			ReasonCodeLocalServiceUtil.clearService();

			ReasonCodeServiceUtil.clearService();
			VendorLocalServiceUtil.clearService();

			VendorServiceUtil.clearService();
		}
	}
}