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

import com.kencana.lms.model.PatronCategory;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing PatronCategory in entity cache.
 *
 * @author Mazlan Mat
 * @see PatronCategory
 * @generated
 */
public class PatronCategoryCacheModel implements CacheModel<PatronCategory>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{patronCategoryId=");
		sb.append(patronCategoryId);
		sb.append(", patronCategoryName=");
		sb.append(patronCategoryName);
		sb.append(", notes=");
		sb.append(notes);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PatronCategory toEntityModel() {
		PatronCategoryImpl patronCategoryImpl = new PatronCategoryImpl();

		patronCategoryImpl.setPatronCategoryId(patronCategoryId);

		if (patronCategoryName == null) {
			patronCategoryImpl.setPatronCategoryName(StringPool.BLANK);
		}
		else {
			patronCategoryImpl.setPatronCategoryName(patronCategoryName);
		}

		if (notes == null) {
			patronCategoryImpl.setNotes(StringPool.BLANK);
		}
		else {
			patronCategoryImpl.setNotes(notes);
		}

		patronCategoryImpl.setGroupId(groupId);
		patronCategoryImpl.setCompanyId(companyId);

		patronCategoryImpl.resetOriginalValues();

		return patronCategoryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		patronCategoryId = objectInput.readLong();
		patronCategoryName = objectInput.readUTF();
		notes = objectInput.readUTF();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(patronCategoryId);

		if (patronCategoryName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(patronCategoryName);
		}

		if (notes == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(notes);
		}

		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
	}

	public long patronCategoryId;
	public String patronCategoryName;
	public String notes;
	public long groupId;
	public long companyId;
}