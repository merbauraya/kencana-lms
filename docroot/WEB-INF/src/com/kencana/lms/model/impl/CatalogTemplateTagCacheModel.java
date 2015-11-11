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

import com.kencana.lms.model.CatalogTemplateTag;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing CatalogTemplateTag in entity cache.
 *
 * @author Mazlan Mat
 * @see CatalogTemplateTag
 * @generated
 */
public class CatalogTemplateTagCacheModel implements CacheModel<CatalogTemplateTag>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{catelogTemplateTagId=");
		sb.append(catelogTemplateTagId);
		sb.append(", catelogTemplateId=");
		sb.append(catelogTemplateId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", tag=");
		sb.append(tag);
		sb.append(", repeatable=");
		sb.append(repeatable);
		sb.append(", mandatory=");
		sb.append(mandatory);
		sb.append(", helpText=");
		sb.append(helpText);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CatalogTemplateTag toEntityModel() {
		CatalogTemplateTagImpl catalogTemplateTagImpl = new CatalogTemplateTagImpl();

		catalogTemplateTagImpl.setCatelogTemplateTagId(catelogTemplateTagId);
		catalogTemplateTagImpl.setCatelogTemplateId(catelogTemplateId);
		catalogTemplateTagImpl.setGroupId(groupId);
		catalogTemplateTagImpl.setCompanyId(companyId);

		if (tag == null) {
			catalogTemplateTagImpl.setTag(StringPool.BLANK);
		}
		else {
			catalogTemplateTagImpl.setTag(tag);
		}

		catalogTemplateTagImpl.setRepeatable(repeatable);
		catalogTemplateTagImpl.setMandatory(mandatory);

		if (helpText == null) {
			catalogTemplateTagImpl.setHelpText(StringPool.BLANK);
		}
		else {
			catalogTemplateTagImpl.setHelpText(helpText);
		}

		catalogTemplateTagImpl.resetOriginalValues();

		return catalogTemplateTagImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		catelogTemplateTagId = objectInput.readLong();
		catelogTemplateId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		tag = objectInput.readUTF();
		repeatable = objectInput.readBoolean();
		mandatory = objectInput.readBoolean();
		helpText = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(catelogTemplateTagId);
		objectOutput.writeLong(catelogTemplateId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);

		if (tag == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(tag);
		}

		objectOutput.writeBoolean(repeatable);
		objectOutput.writeBoolean(mandatory);

		if (helpText == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(helpText);
		}
	}

	public long catelogTemplateTagId;
	public long catelogTemplateId;
	public long groupId;
	public long companyId;
	public String tag;
	public boolean repeatable;
	public boolean mandatory;
	public String helpText;
}