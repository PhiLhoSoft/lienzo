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

package com.emitrom.lienzo.client.core;

import com.emitrom.lienzo.shared.core.types.IColor;
import com.google.gwt.canvas.client.Canvas;

/**
 * A Global Configuration Manager.
 */
public final class LienzoGlobals
{
    public static final double         DEFAULT_FONT_SIZE   = 48;

    public static final String         DEFAULT_FONT_STYLE  = "normal";

    public static final String         DEFAULT_FONT_FAMILY = "Verdana";

    private static final LienzoGlobals s_instance          = new LienzoGlobals();

    private double                     m_strokeWidth       = 1;

    private String                     m_strokeColor       = "black";

    private final boolean              m_lineDashSupport   = false;

    private final boolean              m_canvasSupported   = Canvas.isSupported();

    private LienzoGlobals()
    {
    }

    public static final LienzoGlobals getInstance()
    {
        return s_instance;
    }

    public final void setDefaultStrokeWidth(double width)
    {
        if (width > 0)
        {
            m_strokeWidth = width;
        }
        else
        {
            m_strokeWidth = 1;
        }
    }

    public final double getDefaultStrokeWidth()
    {
        return m_strokeWidth;
    }

    public final void setDefaultStrokeColor(IColor color)
    {
        if (color != null)
        {
            m_strokeColor = color.getColorString();
        }
        else
        {
            m_strokeColor = "black";
        }
    }

    public final String getDefaultStrokeColor()
    {
        return m_strokeColor;
    }

    /**
     * Returns true if the Canvas element is supported.
     * @return
     */
    public final boolean isCanvasSupported()
    {
        return m_canvasSupported;
    }

    public final boolean isLineDashSupported()
    {
        return m_lineDashSupport;
    }

    public final double getDefaultFontSize()
    {
        return DEFAULT_FONT_SIZE;
    }

    public final String getDefaultFontStyle()
    {
        return DEFAULT_FONT_STYLE;
    }

    public final String getDefaultFontFamily()
    {
        return DEFAULT_FONT_FAMILY;
    }
}
