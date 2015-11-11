package com.kencana.lms.taglib;

import javax.servlet.http.HttpServletRequest;

import com.liferay.taglib.util.IncludeTag;

public class StatusDisplayTag extends IncludeTag {
	final String _PAGE = "/html/taglib/kencana/status_display.jsp";
	private boolean _status;
	private String _trueText ;
	private String _falseText;
	public void setStatus(boolean status)
	{
		_status = status;
	}
	public boolean getStatus()
	{
		return _status;
	}
	public void setTrueText(String value)
	{
		_trueText = value;
	}
	public String getTrueText()
	{
		return _trueText;
	}
	public void setFalseText(String value)
	{
		_falseText = value;
	}
	public String getFalseText()
	{
		return _falseText;
	}
	
	@Override
	protected void setAttributes(HttpServletRequest request) {
		request.setAttribute("kencana:status-display:status", _status);
		request.setAttribute("kencana:status-display:trueText", _trueText);
		request.setAttribute("kencana:status-display:falseText", _falseText);
		


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
