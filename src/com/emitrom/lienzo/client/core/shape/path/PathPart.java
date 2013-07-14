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

package com.emitrom.lienzo.client.core.shape.path;

import com.emitrom.lienzo.client.core.types.Point2DArray;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayNumber;

class PathPart
{
    private final PathPartJSO m_jso;

    protected PathPart(PathPartJSO jso)
    {
        m_jso = jso;
    }

    public PathPartJSO getJSO()
    {
        return m_jso;
    }

    public PathPartType getType()
    {
        return PathPartType.lookup(m_jso.getType());
    }

    public static class ArrayOfDoubleJSO extends JsArrayNumber
    {
        protected ArrayOfDoubleJSO()
        {

        }

        public final static native ArrayOfDoubleJSO make()
        /*-{
			return [];
        }-*/;
    }

    public static class PathPartJSO extends JavaScriptObject
    {
        protected PathPartJSO()
        {

        }

        public final native String getType()
        /*-{
			return this.type;
        }-*/;

        public static final PathPartJSO makePathPartPoints(PathPartType type, Point2DArray points)
        {
            return makePathPart(type.getValue(), points.getJSO());
        }

        public static final PathPartJSO makePathPartArrayOfDouble(PathPartType type, double[] array)
        {
            ArrayOfDoubleJSO aodj = ArrayOfDoubleJSO.make();

            for (int i = 0; i < array.length; i++)
            {
                aodj.push(array[i]);
            }
            return makePathPart(type.getValue(), aodj);
        }

        public static final PathPartJSO makePathPart(PathPartType type, JavaScriptObject data)
        {
            return makePathPart(type.getValue(), data);
        }

        public static final PathPartJSO makePathPart(PathPartType type)
        {
            return makePathPart(type.getValue());
        }

        private static final native PathPartJSO makePathPart(String tval)
        /*-{
			return {
				type : tval
			};
        }-*/;

        private static final native PathPartJSO makePathPart(String tval, JavaScriptObject dval)
        /*-{
			return {
				type : tval,
				data : dval
			};
        }-*/;
    }
}
