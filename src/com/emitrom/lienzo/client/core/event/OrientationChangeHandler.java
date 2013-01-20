package com.emitrom.lienzo.client.core.event;

import com.emitrom.lienzo.client.core.event.OrientationChangeEvent.Orientation;
import com.google.gwt.event.shared.EventHandler;

public interface OrientationChangeHandler extends EventHandler
{
	public void onOrientationChange(Orientation orientation, int width, int height);
}