/*
   Copyright (c) 2012 Emitrom LLC. All rights reserved. 
   For licensing questions, please contact us at licensing@emitrom.com

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */

package com.emitrom.lienzo.client.core.mediator;

import com.emitrom.lienzo.client.core.event.NodeMouseDownEvent;
import com.emitrom.lienzo.client.core.event.NodeMouseMoveEvent;
import com.emitrom.lienzo.client.core.event.NodeMouseUpEvent;
import com.emitrom.lienzo.client.core.types.Point2D;
import com.emitrom.lienzo.client.core.types.Transform;
import com.google.gwt.event.shared.GwtEvent;

/**
 * MousePanMediator provides pan behavior similar to dragging the mouse in Google Maps.
 * Only the zoomable Layers are affected.
 * 
 * @see Mediators
 * 
 * @since 1.1
 */
public class MousePanMediator extends AbstractMediator
{
    private Point2D   m_last = new Point2D();
    private boolean   m_dragging;
    private Transform m_inverseTransform;

    public MousePanMediator()
    {
    }

    public MousePanMediator(IEventFilter... filters)
    {
        setEventFilter(EventFilter.and(filters));
    }

    @Override
    public void cancel()
    {
        m_dragging = false;
    }

    @Override
    public boolean handleEvent(GwtEvent<?> event)
    {
        if (event instanceof NodeMouseMoveEvent)
        {
            if (!m_dragging)
                return false;

            onMouseMove((NodeMouseMoveEvent) event);
            return true;
        }
        else if (event instanceof NodeMouseDownEvent)
        {
            if (!m_eventFilter.matches(event))
                return false;

            onMouseDown((NodeMouseDownEvent) event);
            return true;
        }
        else if (event instanceof NodeMouseUpEvent)
        {
            if (!m_dragging)
                return false;

            onMouseUp((NodeMouseUpEvent) event);
            return true;
        }

        return false;
    }

    protected void onMouseDown(NodeMouseDownEvent event)
    {
        m_last = new Point2D(event.getX(), event.getY());
        m_dragging = true;

        Transform transform = getTransform();
        if (transform == null)
        {
            setTransform(transform = new Transform());
        }

        m_inverseTransform = transform.getInverse();
        m_inverseTransform.transform(m_last, m_last);
    }
    
    protected void onMouseMove(NodeMouseMoveEvent event)
    {
        Point2D curr = new Point2D(event.getX(), event.getY());
        m_inverseTransform.transform(curr, curr);

        Transform transform = getTransform().copy();
        transform.translate(curr.getX() - m_last.getX(), curr.getY() - m_last.getY());
        setTransform(transform);
        
        m_last = curr;
        
        redraw();
    }

    protected void onMouseUp(NodeMouseUpEvent event)
    {
        cancel();
    }

    protected Transform getTransform()
    {
        return m_viewport.getTransform();
    }

    protected void setTransform(Transform transform)
    {
        m_viewport.setTransform(transform);
    }
    
    protected void redraw()
    {
        m_viewport.getScene().draw();
    }
}
