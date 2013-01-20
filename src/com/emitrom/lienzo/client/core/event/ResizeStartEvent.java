package com.emitrom.lienzo.client.core.event;

import com.google.gwt.event.shared.GwtEvent;

public class ResizeStartEvent extends GwtEvent<ResizeStartHandler>
{

	private final int m_width;

	private final int m_height;

	public static final Type<ResizeStartHandler> TYPE = new Type<ResizeStartHandler>();

	public ResizeStartEvent(int width, int height)
	{
		m_width = width;
		m_height = height;
	}

	@Override
	public Type<ResizeStartHandler> getAssociatedType()
	{
		return TYPE;
	}
	
	public int getWidth()
	{
		return m_width;
	}
	
	public int getHeight()
	{
		return m_height;
	}

	@Override
	protected void dispatch(ResizeStartHandler handler)
	{
		handler.onResizeStart(m_width, m_height);
	}

}