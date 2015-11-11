package com.kencana.lms.taglib;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.liferay.taglib.util.IncludeTag;

public class RepeatableFieldTag extends IncludeTag{
	final String _PAGE = "/html/taglib/kencana/repeatable_field.jsp";
	private String _fieldName;
	private List<String> _valueList;
	private String _namespace;
	private String _inputClass;
	
	public void setInputClass(String cssClass)
	{
		_inputClass = cssClass;
	}
	public void setNamespace(String namespace)
	{
		_namespace = namespace;
	}
	public void setFieldName(String name)
	{
		_fieldName = name;
	}
	
	public void setValueList(List<String> value)
	{
		_valueList = value;
	}
	@Override
	protected void setAttributes(HttpServletRequest request) {
		request.setAttribute("kencana:repeatable-field:fieldName", _fieldName);
		request.setAttribute("kencana:repeatable-field:valueList", _valueList);
		request.setAttribute("kencana:repeatable-field:namespace", _namespace);
		request.setAttribute("kencana:repeatable-field:inputClass", _inputClass);

	}
	@Override
	public int doStartTag() {
		return EVAL_BODY_INCLUDE;
	}
	@Override
	protected String getPage() {
		return _PAGE;
	}

}
