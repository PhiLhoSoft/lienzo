/*
   Copyright (c) 2013 Emitrom LLC. All rights reserved. 
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

package com.emitrom.lienzo.client.core.shape;

import com.emitrom.lienzo.client.core.Attribute;
import com.emitrom.lienzo.client.core.Context2D;
import com.emitrom.lienzo.client.core.shape.json.IFactory;
import com.emitrom.lienzo.client.core.shape.json.ShapeFactory;
import com.emitrom.lienzo.client.core.shape.json.validators.ValidationContext;
import com.emitrom.lienzo.client.core.shape.path.PathPartArray;
import com.emitrom.lienzo.shared.core.types.ShapeType;
import com.google.gwt.json.client.JSONObject;

public class SVGPath extends Shape<SVGPath>
{
    private final static String   BREAKER = "#";

    private static final String[] SYMBOLS = new String[] { "m", "M", "l", "L", "v", "V", "h", "H", "z", "Z", "c", "C", "q", "Q", "t", "T", "s", "S", "a", "A" };

    private PathPartArray         m_parts = null;

    public SVGPath()
    {
        super(ShapeType.SVG_PATH);
    }

    protected SVGPath(JSONObject node)
    {
        super(ShapeType.SVG_PATH, node);
    }

    final void makePathParts(String path)
    {
        m_parts = new PathPartArray();

        if ((null == path) || ((path = path.trim()).isEmpty()))
        {
            return;
        }
        path = path.replaceAll("\\s+", ",");

        for (int i = 0; i < SYMBOLS.length; i++)
        {
            String s = SYMBOLS[i];

            path = path.replaceAll(s, BREAKER + s);
        }
        path = path.replaceAll(",-", "-").replaceAll("-", ",-");

        if (path.startsWith(BREAKER))
        {
            path = path.substring(1);
        }
        // String[] list = path.split(BREAKER);

        // create path parts
    }

    @Override
    public IFactory<?> getFactory()
    {
        return new PSVGathFactory();
    }

    @Override
    protected boolean prepare(Context2D context, Attributes attr, double alpha)
    {
        if (null != m_parts)
        {
            context.beginPath();

            context.drawPath(m_parts);

            return true;
        }
        return false;
    }

    public static class PSVGathFactory extends ShapeFactory<SVGPath>
    {
        public PSVGathFactory()
        {
            super(ShapeType.SVG_PATH);

            addAttribute(Attribute.PATH_STRING, true);
        }

        @Override
        public SVGPath create(JSONObject node, ValidationContext ctx)
        {
            return new SVGPath(node);
        }
    }
}
