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

import com.kencana.lms.model.ReasonCode;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ReasonCode in entity cache.
 *
 * @author Mazlan Mat
 * @see ReasonCode
 * @generated
 */
public class ReasonCodeCacheModel implements CacheModel<ReasonCode>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{reasonCodeId=");
		sb.append(reasonCodeId);
		sb.append(", reasonCodeName=");
		sb.append(reasonCodeName);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ReasonCode toEntityModel() {
		ReasonCodeImpl reasonCodeImpl = new ReasonCodeImpl();

		reasonCodeImpl.setReasonCodeId(reasonCodeId);

		if (reasonCodeName == null) {
			reasonCodeImpl.setReasonCodeName(StringPool.BLANK);
		}
		else {
			reasonCodeImpl.setReasonCodeName(reasonCodeName);
		}

		reasonCodeImpl.setGroupId(groupId);
		reasonCodeImpl.setCompanyId(companyId);

		reasonCodeImpl.resetOriginalValues();

		return reasonCodeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		reasonCodeId = objectInput.readLong();
		reasonCodeName = objectInput.readUTF();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(reasonCodeId);

		if (reasonCodeName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(reasonCodeName);
		}

		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
	}

	public long reasonCodeId;
	public String reasonCodeName;
	public long groupId;
	public long companyId;
}