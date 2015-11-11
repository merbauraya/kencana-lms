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

package com.kencana.lms.service.impl;

import java.util.List;

import com.kencana.lms.model.CirculationRule;
import com.kencana.lms.service.base.CirculationRuleLocalServiceBaseImpl;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the circulation rule local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.kencana.lms.service.CirculationRuleLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mazlan Mat
 * @see com.kencana.lms.service.base.CirculationRuleLocalServiceBaseImpl
 * @see com.kencana.lms.service.CirculationRuleLocalServiceUtil
 */
public class CirculationRuleLocalServiceImpl
	extends CirculationRuleLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.kencana.lms.service.CirculationRuleLocalServiceUtil} to access the circulation rule local service.
	 */
	public CirculationRule create() throws SystemException
	{
		long id = CounterLocalServiceUtil.increment(CirculationRule.class.getName());
		
		return circulationRulePersistence.create(id);
		
	}
	
	public CirculationRule update(CirculationRule circulationRule) throws SystemException
	{
		return circulationRulePersistence.update(circulationRule);
	}
	
	public List<CirculationRule> getByCompany(long companyId,int start,int end) throws SystemException
	{
		return circulationRulePersistence.findByCompany(companyId, start, end);
	}
	
	public int countByCompany(long companyId) throws SystemException
	{
		return circulationRulePersistence.countByCompany(companyId);
	}
}