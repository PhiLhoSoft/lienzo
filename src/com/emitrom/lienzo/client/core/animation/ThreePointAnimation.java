
package com.emitrom.lienzo.client.core.animation;

import com.emitrom.lienzo.client.core.shape.Layer;
import com.emitrom.lienzo.client.core.shape.Node;
import com.emitrom.lienzo.client.core.types.Point2DArray;
import com.emitrom.lienzo.client.core.types.Transform;

public class ThreePointAnimation extends TimedAnimation implements ILayerBatchedAnimation
{
    private final Transform m_beg;

    private final Transform m_end;

    private final double[]  m_mid = new double[6];

    public ThreePointAnimation(Node<?> node, Point2DArray src, Point2DArray dst, double duration)
    {
        this(node, src, dst, duration, null);
    }

    public ThreePointAnimation(Node<?> node, Point2DArray src, Point2DArray dst, double duration, IAnimationCallback callback)
    {
        super(duration, callback);

        setNode(node);

        Transform t = node.getTransform();

        if (t != null)
        {
            m_beg = t;
        }
        else
        {
            m_beg = new Transform();
        }
        m_end = Transform.create3PointTransform(src, dst).multiply(m_beg);
    }

    @Override
    public IAnimation doStart()
    {
        apply(0.0);

        return super.doStart();
    }

    @Override
    public IAnimation doFrame()
    {
        apply(getPercent());

        return super.doFrame();
    }

    @Override
    public IAnimation doClose()
    {
        apply(1.0);

        return super.doClose();
    }

    private void apply(double percent)
    {
        for (int i = 0; i < 6; i++)
        {
            double beg = m_beg.get(i);

            m_mid[i] = beg + percent * (m_end.get(i) - beg);
        }
        Node<?> node = getNode();

        node.setTransform(new Transform(m_mid));

        scheduleBatchedRedraw(node.getLayer());
    }

    @Override
    public void scheduleBatchedRedraw(Layer layer)
    {
        LayerBatchedAnimationRedrawManager.get().scheduleBatchedRedraw(layer);
    }
}
