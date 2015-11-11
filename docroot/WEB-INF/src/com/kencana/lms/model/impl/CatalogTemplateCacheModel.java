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

package com.kencana.lms.model.impl;

import com.kencana.lms.model.CatalogTemplate;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CatalogTemplate in entity cache.
 *
 * @author Mazlan Mat
 * @see CatalogTemplate
 * @generated
 */
public class CatalogTemplateCacheModel implements CacheModel<CatalogTemplate>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{templateId=");
		sb.append(templateId);
		sb.append(", templateName=");
		sb.append(templateName);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", description=");
		sb.append(description);
		sb.append(", active=");
		sb.append(active);
		sb.append(", createBy=");
		sb.append(createBy);
		sb.append(", createdDate=");
		sb.append(createdDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CatalogTemplate toEntityModel() {
		CatalogTemplateImpl catalogTemplateImpl = new CatalogTemplateImpl();

		catalogTemplateImpl.setTemplateId(templateId);

		if (templateName == null) {
			catalogTemplateImpl.setTemplateName(StringPool.BLANK);
		}
		else {
			catalogTemplateImpl.setTemplateName(templateName);
		}

		catalogTemplateImpl.setGroupId(groupId);
		catalogTemplateImpl.setCompanyId(companyId);

		if (description == null) {
			catalogTemplateImpl.setDescription(StringPool.BLANK);
		}
		else {
			catalogTemplateImpl.setDescription(description);
		}

		catalogTemplateImpl.setActive(active);
		catalogTemplateImpl.setCreateBy(createBy);

		if (createdDate == Long.MIN_VALUE) {
			catalogTemplateImpl.setCreatedDate(null);
		}
		else {
			catalogTemplateImpl.setCreatedDate(new Date(createdDate));
		}

		catalogTemplateImpl.resetOriginalValues();

		return catalogTemplateImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		templateId = objectInput.readLong();
		templateName = objectInput.readUTF();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		description = objectInput.readUTF();
		active = objectInput.readBoolean();
		createBy = objectInput.readLong();
		createdDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(templateId);

		if (templateName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(templateName);
		}

		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeBoolean(active);
		objectOutput.writeLong(createBy);
		objectOutput.writeLong(createdDate);
	}

	public long templateId;
	public String templateName;
	public long groupId;
	public long companyId;
	public String description;
	public boolean active;
	public long createBy;
	public long createdDate;
}