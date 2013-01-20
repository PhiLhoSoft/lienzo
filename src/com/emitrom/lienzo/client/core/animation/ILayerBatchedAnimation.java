
package com.emitrom.lienzo.client.core.animation;

import com.emitrom.lienzo.client.core.shape.Layer;

public interface ILayerBatchedAnimation
{
    public void scheduleBatchedRedraw(Layer layer);

    public final class LayerBatchedAnimationRedrawManager implements ILayerBatchedAnimation
    {
        private static final LayerBatchedAnimationRedrawManager s_instance = new LayerBatchedAnimationRedrawManager();

        public static final ILayerBatchedAnimation get()
        {
            return s_instance;
        }

        @Override
        public void scheduleBatchedRedraw(Layer layer)
        {
            if (null != layer)
            {
                layer.draw();
            }
        }
    }
}
