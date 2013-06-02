
package com.emitrom.lienzo.client.core.animation;

import com.emitrom.lienzo.client.core.shape.Layer;
import com.emitrom.lienzo.client.core.types.FastArrayList;
import com.google.gwt.animation.client.AnimationScheduler;
import com.google.gwt.animation.client.AnimationScheduler.AnimationCallback;

public final class LayerRedrawManager
{
    private static final LayerRedrawManager s_instance = new LayerRedrawManager();

    private FastArrayList<Layer>            m_layers   = new FastArrayList<Layer>();

    private AnimationCallback               m_redraw;

    public static final LayerRedrawManager get()
    {
        return s_instance;
    }

    private LayerRedrawManager()
    {
        m_redraw = new AnimationCallback()
        {
            @Override
            public void execute(double time)
            {
                final FastArrayList<Layer> list = m_layers;

                m_layers = new FastArrayList<Layer>();

                final int leng = list.length();

                for (int i = 0; i < leng; i++)
                {
                    list.get(i).draw();
                }
            }
        };
    }

    public void schedule(Layer layer)
    {
        if ((null != layer) && (false == m_layers.contains(layer)))
        {
            m_layers.add(layer);

            kick();
        }
    }

    private void kick()
    {
        if (m_layers.length() > 0)
        {
            AnimationScheduler.get().requestAnimationFrame(m_redraw);
        }
    }
}
