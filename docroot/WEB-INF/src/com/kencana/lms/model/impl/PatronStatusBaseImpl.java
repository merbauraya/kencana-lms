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
import com.kencana.lms.service.PatronStatusLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The extended model base implementation for the PatronStatus service. Represents a row in the &quot;Kencana_PatronStatus&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link PatronStatusImpl}.
 * </p>
 *
 * @author Mazlan Mat
 * @see PatronStatusImpl
 * @see com.kencana.lms.model.PatronStatus
 * @generated
 */
public abstract class PatronStatusBaseImpl extends PatronStatusModelImpl
	implements PatronStatus {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a patron status model instance should use the {@link PatronStatus} interface instead.
	 */
	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			PatronStatusLocalServiceUtil.addPatronStatus(this);
		}
		else {
			PatronStatusLocalServiceUtil.updatePatronStatus(this);
		}
	}
}