package com.emitrom.lienzo.client.core.event;

import com.google.gwt.event.shared.GwtEvent;

public class OrientationChangeEvent extends GwtEvent<OrientationChangeHandler>
{

	private final int m_width;

	private final int m_height;

	public static final Type<OrientationChangeHandler> TYPE = new Type<OrientationChangeHandler>();

	public enum Orientation
	{
		PORTRAIT, LANDSCAPE
	}

	public OrientationChangeEvent(int width, int height)
	{
		m_width = width;
		m_height = height;
	}

	@Override
	public Type<OrientationChangeHandler> getAssociatedType()
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
	protected void dispatch(OrientationChangeHandler handler)
	{

		Orientation orientationChange = Orientation.PORTRAIT;

		if (m_width > m_height)
		{
			orientationChange = Orientation.LANDSCAPE;
		}
		
		handler.onOrientationChange(orientationChange, m_width, m_height);

	}

}