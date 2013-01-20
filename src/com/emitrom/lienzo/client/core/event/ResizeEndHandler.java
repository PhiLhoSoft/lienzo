package com.emitrom.lienzo.client.core.event;

import com.google.gwt.event.shared.EventHandler;

public interface ResizeEndHandler extends EventHandler
{
	public void onResizeEnd(int width, int height);
}