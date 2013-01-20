package com.emitrom.lienzo.client.core.event;

import com.google.gwt.event.shared.GwtEvent;

public class ResizeChangeEvent extends GwtEvent<ResizeChangeHandler>
{

	private final int m_width;

	private final int m_height;

	public static final Type<ResizeChangeHandler> TYPE = new Type<ResizeChangeHandler>();

	public ResizeChangeEvent(int width, int height)
	{
		m_width = width;
		m_height = height;
	}

	@Override
	public Type<ResizeChangeHandler> getAssociatedType()
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
	protected void dispatch(ResizeChangeHandler handler)
	{
		handler.onResizeChange(m_width, m_height);
	}

}