
package com.emitrom.lienzo.client.core.animation;

import com.emitrom.lienzo.client.core.shape.Node;

public interface IAnimation
{
    public static final double INDEFINITE_ANIMATION = -1;

    public double getPercent();

    public double getDuration();

    public IAnimation doStart();

    public IAnimation doFrame();

    public IAnimation doClose();

    public Node<?> getNode();

    public IAnimation setNode(Node<?> node);
}
