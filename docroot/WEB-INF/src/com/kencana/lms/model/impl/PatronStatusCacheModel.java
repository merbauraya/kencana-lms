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

import com.kencana.lms.model.PatronStatus;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing PatronStatus in entity cache.
 *
 * @author Mazlan Mat
 * @see PatronStatus
 * @generated
 */
public class PatronStatusCacheModel implements CacheModel<PatronStatus>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{patronStatusId=");
		sb.append(patronStatusId);
		sb.append(", patronStatusName=");
		sb.append(patronStatusName);
		sb.append(", noLogin=");
		sb.append(noLogin);
		sb.append(", noCheckout=");
		sb.append(noCheckout);
		sb.append(", noReserve=");
		sb.append(noReserve);
		sb.append(", noRenew=");
		sb.append(noRenew);
		sb.append(", color=");
		sb.append(color);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PatronStatus toEntityModel() {
		PatronStatusImpl patronStatusImpl = new PatronStatusImpl();

		patronStatusImpl.setPatronStatusId(patronStatusId);

		if (patronStatusName == null) {
			patronStatusImpl.setPatronStatusName(StringPool.BLANK);
		}
		else {
			patronStatusImpl.setPatronStatusName(patronStatusName);
		}

		patronStatusImpl.setNoLogin(noLogin);
		patronStatusImpl.setNoCheckout(noCheckout);
		patronStatusImpl.setNoReserve(noReserve);
		patronStatusImpl.setNoRenew(noRenew);
		patronStatusImpl.setColor(color);
		patronStatusImpl.setGroupId(groupId);
		patronStatusImpl.setCompanyId(companyId);

		patronStatusImpl.resetOriginalValues();

		return patronStatusImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		patronStatusId = objectInput.readLong();
		patronStatusName = objectInput.readUTF();
		noLogin = objectInput.readBoolean();
		noCheckout = objectInput.readBoolean();
		noReserve = objectInput.readBoolean();
		noRenew = objectInput.readBoolean();
		color = objectInput.readInt();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(patronStatusId);

		if (patronStatusName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(patronStatusName);
		}

		objectOutput.writeBoolean(noLogin);
		objectOutput.writeBoolean(noCheckout);
		objectOutput.writeBoolean(noReserve);
		objectOutput.writeBoolean(noRenew);
		objectOutput.writeInt(color);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
	}

	public long patronStatusId;
	public String patronStatusName;
	public boolean noLogin;
	public boolean noCheckout;
	public boolean noReserve;
	public boolean noRenew;
	public int color;
	public long groupId;
	public long companyId;
}