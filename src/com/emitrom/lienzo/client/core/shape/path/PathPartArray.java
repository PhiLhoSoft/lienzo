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

package com.emitrom.lienzo.client.core.shape.path;

import com.emitrom.lienzo.client.core.shape.path.PathPart.PathPartJSO;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.json.client.JSONArray;

public class PathPartArray
{
    private final PathPartArrayJSO m_jso;

    PathPartArray(PathPartArrayJSO jso)
    {
        m_jso = jso;
    }

    public PathPartArray(JsArray<JavaScriptObject> jso)
    {
        m_jso = jso.cast();
    }

    public PathPartArray()
    {
        this(PathPartArrayJSO.makePathPartArrayJSO());
    }

    public final PathPartArray push(PathPart part)
    {
        getJSO().push(part.getJSO());

        return this;
    }

    public final PathPart get(int i)
    {
        if (i < getLength())
        {
            return new PathPart(m_jso.get(i));
        }
        return null;
    }

    public final int getLength()
    {
        return getJSO().length();
    }

    public final PathPartArrayJSO getJSO()
    {
        return m_jso;
    }

    public String toString()
    {
        return new JSONArray(m_jso).toString();
    }

    public static final class PathPartArrayJSO extends JsArray<PathPartJSO>
    {
        protected PathPartArrayJSO()
        {

        }

        public static final native PathPartArrayJSO makePathPartArrayJSO()
        /*-{
			return [];
        }-*/;
    }
}
