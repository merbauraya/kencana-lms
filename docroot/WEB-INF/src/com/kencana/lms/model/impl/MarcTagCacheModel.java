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

import com.kencana.lms.model.MarcTag;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing MarcTag in entity cache.
 *
 * @author Mazlan Mat
 * @see MarcTag
 * @generated
 */
public class MarcTagCacheModel implements CacheModel<MarcTag>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{tagId=");
		sb.append(tagId);
		sb.append(", tag=");
		sb.append(tag);
		sb.append(", description=");
		sb.append(description);
		sb.append(", helpText=");
		sb.append(helpText);
		sb.append(", repetable=");
		sb.append(repetable);
		sb.append(", defaultValue=");
		sb.append(defaultValue);
		sb.append(", indicator1=");
		sb.append(indicator1);
		sb.append(", indicator2=");
		sb.append(indicator2);
		sb.append(", tagType=");
		sb.append(tagType);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public MarcTag toEntityModel() {
		MarcTagImpl marcTagImpl = new MarcTagImpl();

		marcTagImpl.setTagId(tagId);

		if (tag == null) {
			marcTagImpl.setTag(StringPool.BLANK);
		}
		else {
			marcTagImpl.setTag(tag);
		}

		if (description == null) {
			marcTagImpl.setDescription(StringPool.BLANK);
		}
		else {
			marcTagImpl.setDescription(description);
		}

		if (helpText == null) {
			marcTagImpl.setHelpText(StringPool.BLANK);
		}
		else {
			marcTagImpl.setHelpText(helpText);
		}

		marcTagImpl.setRepetable(repetable);

		if (defaultValue == null) {
			marcTagImpl.setDefaultValue(StringPool.BLANK);
		}
		else {
			marcTagImpl.setDefaultValue(defaultValue);
		}

		marcTagImpl.setIndicator1(indicator1);
		marcTagImpl.setIndicator2(indicator2);

		if (tagType == null) {
			marcTagImpl.setTagType(StringPool.BLANK);
		}
		else {
			marcTagImpl.setTagType(tagType);
		}

		marcTagImpl.resetOriginalValues();

		return marcTagImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		tagId = objectInput.readLong();
		tag = objectInput.readUTF();
		description = objectInput.readUTF();
		helpText = objectInput.readUTF();
		repetable = objectInput.readBoolean();
		defaultValue = objectInput.readUTF();
		indicator1 = objectInput.readBoolean();
		indicator2 = objectInput.readBoolean();
		tagType = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(tagId);

		if (tag == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(tag);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (helpText == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(helpText);
		}

		objectOutput.writeBoolean(repetable);

		if (defaultValue == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(defaultValue);
		}

		objectOutput.writeBoolean(indicator1);
		objectOutput.writeBoolean(indicator2);

		if (tagType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(tagType);
		}
	}

	public long tagId;
	public String tag;
	public String description;
	public String helpText;
	public boolean repetable;
	public String defaultValue;
	public boolean indicator1;
	public boolean indicator2;
	public String tagType;
}