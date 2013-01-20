package com.emitrom.lienzo.client.core.event;

import com.google.gwt.event.shared.GwtEvent;

public class ResizeEndEvent extends GwtEvent<ResizeEndHandler>
{

	private final int m_width;

	private final int m_height;

	public static final Type<ResizeEndHandler> TYPE = new Type<ResizeEndHandler>();

	public ResizeEndEvent(int width, int height)
	{
		m_width = width;
		m_height = height;
	}

	@Override
	public Type<ResizeEndHandler> getAssociatedType()
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
	protected void dispatch(ResizeEndHandler handler)
	{
		handler.onResizeEnd(m_width, m_height);
	}

}