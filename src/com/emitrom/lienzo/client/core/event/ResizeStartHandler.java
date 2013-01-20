package com.emitrom.lienzo.client.core.event;

import com.google.gwt.event.shared.EventHandler;

public interface ResizeStartHandler extends EventHandler
{
	public void onResizeStart(int width, int height);
}