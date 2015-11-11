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

import com.kencana.lms.model.MarcSubfield;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing MarcSubfield in entity cache.
 *
 * @author Mazlan Mat
 * @see MarcSubfield
 * @generated
 */
public class MarcSubfieldCacheModel implements CacheModel<MarcSubfield>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{MarcSubfieldId=");
		sb.append(MarcSubfieldId);
		sb.append(", tag=");
		sb.append(tag);
		sb.append(", tagType=");
		sb.append(tagType);
		sb.append(", subfield=");
		sb.append(subfield);
		sb.append(", description=");
		sb.append(description);
		sb.append(", repetable=");
		sb.append(repetable);
		sb.append(", mandatory=");
		sb.append(mandatory);
		sb.append(", authorisedValue=");
		sb.append(authorisedValue);
		sb.append(", authTypeCode=");
		sb.append(authTypeCode);
		sb.append(", isURL=");
		sb.append(isURL);
		sb.append(", helpText=");
		sb.append(helpText);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public MarcSubfield toEntityModel() {
		MarcSubfieldImpl marcSubfieldImpl = new MarcSubfieldImpl();

		marcSubfieldImpl.setMarcSubfieldId(MarcSubfieldId);

		if (tag == null) {
			marcSubfieldImpl.setTag(StringPool.BLANK);
		}
		else {
			marcSubfieldImpl.setTag(tag);
		}

		if (tagType == null) {
			marcSubfieldImpl.setTagType(StringPool.BLANK);
		}
		else {
			marcSubfieldImpl.setTagType(tagType);
		}

		if (subfield == null) {
			marcSubfieldImpl.setSubfield(StringPool.BLANK);
		}
		else {
			marcSubfieldImpl.setSubfield(subfield);
		}

		if (description == null) {
			marcSubfieldImpl.setDescription(StringPool.BLANK);
		}
		else {
			marcSubfieldImpl.setDescription(description);
		}

		marcSubfieldImpl.setRepetable(repetable);
		marcSubfieldImpl.setMandatory(mandatory);

		if (authorisedValue == null) {
			marcSubfieldImpl.setAuthorisedValue(StringPool.BLANK);
		}
		else {
			marcSubfieldImpl.setAuthorisedValue(authorisedValue);
		}

		if (authTypeCode == null) {
			marcSubfieldImpl.setAuthTypeCode(StringPool.BLANK);
		}
		else {
			marcSubfieldImpl.setAuthTypeCode(authTypeCode);
		}

		marcSubfieldImpl.setIsURL(isURL);

		if (helpText == null) {
			marcSubfieldImpl.setHelpText(StringPool.BLANK);
		}
		else {
			marcSubfieldImpl.setHelpText(helpText);
		}

		marcSubfieldImpl.resetOriginalValues();

		return marcSubfieldImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		MarcSubfieldId = objectInput.readLong();
		tag = objectInput.readUTF();
		tagType = objectInput.readUTF();
		subfield = objectInput.readUTF();
		description = objectInput.readUTF();
		repetable = objectInput.readBoolean();
		mandatory = objectInput.readBoolean();
		authorisedValue = objectInput.readUTF();
		authTypeCode = objectInput.readUTF();
		isURL = objectInput.readBoolean();
		helpText = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(MarcSubfieldId);

		if (tag == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(tag);
		}

		if (tagType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(tagType);
		}

		if (subfield == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(subfield);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeBoolean(repetable);
		objectOutput.writeBoolean(mandatory);

		if (authorisedValue == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(authorisedValue);
		}

		if (authTypeCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(authTypeCode);
		}

		objectOutput.writeBoolean(isURL);

		if (helpText == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(helpText);
		}
	}

	public long MarcSubfieldId;
	public String tag;
	public String tagType;
	public String subfield;
	public String description;
	public boolean repetable;
	public boolean mandatory;
	public String authorisedValue;
	public String authTypeCode;
	public boolean isURL;
	public String helpText;
}