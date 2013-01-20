package com.emitrom.lienzo.client.core.event;

import com.google.gwt.event.shared.EventHandler;

public interface ViewportTransformChangedHandler extends EventHandler
{
    public void onViewportTransformChanged(ViewportTransformChangedEvent event);
}
