package com.kencana.lms.taglib;

import javax.servlet.http.HttpServletRequest;

import com.liferay.taglib.util.IncludeTag;

public class ItemCategorySelectorTag extends IncludeTag{
	final String _PAGE = "/html/taglib/kencana/item_category_selector.jsp";
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
		request.setAttribute("kencana:item-category-selector:name", _name);
		request.setAttribute("kencana:item-category-selector:inlineLabel", _inlineLabel);
		request.setAttribute("kencana:item-category-selector:selectedId", _selectedId);
		request.setAttribute("kencana:item-category-selector:inputClass", _inputClass);
		request.setAttribute("kencana:item-category-selector:addAllOption", _addAllOption);

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