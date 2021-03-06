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

package com.kencana.lms.model;

import com.liferay.portal.model.PersistedModel;

/**
 * The extended model interface for the ItemType service. Represents a row in the &quot;Kencana_ItemType&quot; database table, with each column mapped to a property of this class.
 *
 * @author Mazlan Mat
 * @see ItemTypeModel
 * @see com.kencana.lms.model.impl.ItemTypeImpl
 * @see com.kencana.lms.model.impl.ItemTypeModelImpl
 * @generated
 */
public interface ItemType extends ItemTypeModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.kencana.lms.model.impl.ItemTypeImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public java.lang.String getCoverURL(
		com.liferay.portal.theme.ThemeDisplay themeDisplay);
}