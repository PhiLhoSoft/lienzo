package com.emitrom.lienzo.client.core.event;

import com.google.gwt.event.shared.EventHandler;

public interface ResizeChangeHandler extends EventHandler
{
	public void onResizeChange(int width, int height);
}