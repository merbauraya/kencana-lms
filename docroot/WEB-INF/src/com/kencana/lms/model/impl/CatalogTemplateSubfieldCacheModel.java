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

import com.kencana.lms.model.CatalogTemplateSubfield;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing CatalogTemplateSubfield in entity cache.
 *
 * @author Mazlan Mat
 * @see CatalogTemplateSubfield
 * @generated
 */
public class CatalogTemplateSubfieldCacheModel implements CacheModel<CatalogTemplateSubfield>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{catalogTemplateSubfieldId=");
		sb.append(catalogTemplateSubfieldId);
		sb.append(", catalogTemplateTagId=");
		sb.append(catalogTemplateTagId);
		sb.append(", subfield=");
		sb.append(subfield);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", repeatable=");
		sb.append(repeatable);
		sb.append(", mandatory=");
		sb.append(mandatory);
		sb.append(", isURL=");
		sb.append(isURL);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CatalogTemplateSubfield toEntityModel() {
		CatalogTemplateSubfieldImpl catalogTemplateSubfieldImpl = new CatalogTemplateSubfieldImpl();

		catalogTemplateSubfieldImpl.setCatalogTemplateSubfieldId(catalogTemplateSubfieldId);
		catalogTemplateSubfieldImpl.setCatalogTemplateTagId(catalogTemplateTagId);

		if (subfield == null) {
			catalogTemplateSubfieldImpl.setSubfield(StringPool.BLANK);
		}
		else {
			catalogTemplateSubfieldImpl.setSubfield(subfield);
		}

		catalogTemplateSubfieldImpl.setGroupId(groupId);
		catalogTemplateSubfieldImpl.setCompanyId(companyId);
		catalogTemplateSubfieldImpl.setRepeatable(repeatable);
		catalogTemplateSubfieldImpl.setMandatory(mandatory);
		catalogTemplateSubfieldImpl.setIsURL(isURL);

		catalogTemplateSubfieldImpl.resetOriginalValues();

		return catalogTemplateSubfieldImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		catalogTemplateSubfieldId = objectInput.readLong();
		catalogTemplateTagId = objectInput.readLong();
		subfield = objectInput.readUTF();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		repeatable = objectInput.readBoolean();
		mandatory = objectInput.readBoolean();
		isURL = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(catalogTemplateSubfieldId);
		objectOutput.writeLong(catalogTemplateTagId);

		if (subfield == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(subfield);
		}

		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeBoolean(repeatable);
		objectOutput.writeBoolean(mandatory);
		objectOutput.writeBoolean(isURL);
	}

	public long catalogTemplateSubfieldId;
	public long catalogTemplateTagId;
	public String subfield;
	public long groupId;
	public long companyId;
	public boolean repeatable;
	public boolean mandatory;
	public boolean isURL;
}