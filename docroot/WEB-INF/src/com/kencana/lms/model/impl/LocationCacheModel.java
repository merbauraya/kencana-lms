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

import com.kencana.lms.model.Location;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Location in entity cache.
 *
 * @author Mazlan Mat
 * @see Location
 * @generated
 */
public class LocationCacheModel implements CacheModel<Location>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{locationId=");
		sb.append(locationId);
		sb.append(", libraryId=");
		sb.append(libraryId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", locationName=");
		sb.append(locationName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Location toEntityModel() {
		LocationImpl locationImpl = new LocationImpl();

		locationImpl.setLocationId(locationId);
		locationImpl.setLibraryId(libraryId);
		locationImpl.setCompanyId(companyId);
		locationImpl.setGroupId(groupId);

		if (locationName == null) {
			locationImpl.setLocationName(StringPool.BLANK);
		}
		else {
			locationImpl.setLocationName(locationName);
		}

		locationImpl.resetOriginalValues();

		return locationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		locationId = objectInput.readLong();
		libraryId = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		locationName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(locationId);
		objectOutput.writeLong(libraryId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(groupId);

		if (locationName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(locationName);
		}
	}

	public long locationId;
	public long libraryId;
	public long companyId;
	public long groupId;
	public String locationName;
}