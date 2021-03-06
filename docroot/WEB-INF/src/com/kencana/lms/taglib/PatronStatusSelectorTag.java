package com.kencana.lms.taglib;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.liferay.taglib.util.IncludeTag;

public class PatronStatusSelectorTag extends IncludeTag{
	final String _PAGE = "/html/taglib/kencana/patron_status_selector.jsp";
	private String _name;
	private long _selectedId;
	private String _inlineLabel;
	private String _inputClass;
	private boolean _addAllOption;
	
	public void setAddAllOption(boolean value)
	{
		_addAllOption = value;
	}
	public void setInputClass(String cssClass)
	{
		_inputClass = cssClass;
	}
	public void setName(String name)
	{
		_name = name;
	}
	public void setInlineLabel(String name)
	{
		_inlineLabel = name;
	}
	
	public void setSelectedId(long value)
	{
		_selectedId = value;
	}
	@Override
	protected void setAttributes(HttpServletRequest request) {
		request.setAttribute("kencana:patron-status-selector:name", _name);
		request.setAttribute("kencana:patron-status-selector:inlineLabel", _inlineLabel);
		request.setAttribute("kencana:patron-status-selector:selectedId", _selectedId);
		request.setAttribute("kencana:patron-status-selector:inputClass", _inputClass);
		request.setAttribute("kencana:patron-status-selector:addAllOption", _addAllOption);

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