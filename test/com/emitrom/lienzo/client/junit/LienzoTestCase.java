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
package com.emitrom.lienzo.client.junit;

import com.emitrom.lienzo.client.core.types.DashArray;
import com.emitrom.lienzo.client.core.types.Point2D;
import com.emitrom.lienzo.client.core.types.Point2DArray;
import com.emitrom.lienzo.client.core.types.Transform;
import com.google.gwt.junit.client.GWTTestCase;

public abstract class LienzoTestCase extends GWTTestCase
{
    public String getModuleName()
    {
        return "com.emitrom.lienzo.Lienzo";
    }
    
    public void assertEqualsJsonString(String expected, String actual)
    {
        //TODO if different implementations serialize the attributes in a different order,
        // we should parse the JSON of each and do pairwise comparisons (recursively)
        assertEquals(expected, actual);
    }

    public static void assertEquals(Point2DArray a, Point2DArray b)
    {
        int na = a.getLength();
        int nb = b.getLength();
        assertEquals(na, nb);
        for (int i = 0; i < na; i++)
        {
            Point2D pa = a.getPoint(i);
            Point2D pb = b.getPoint(i);
            assertEquals(pa, pb);
        }
    }

    public static void assertEquals(Point2D a, Point2D b)
    {
        assertEquals(a.getX(), b.getX());
        assertEquals(a.getY(), b.getY());
    }

    public static void assertEquals(Transform a, Transform b)
    {
        for (int i = 0; i < 6; i++)
        {
            assertEquals(a.get(i), b.get(i));
        }
    }

    public static void assertEquals(DashArray a, DashArray b)
    {
        assertEquals(a.getNormalizedArray(), b.getNormalizedArray());
    }
    
    public static void assertEquals(double[] a, double[] b)
    {
        assertEquals(a.length, b.length);
        for (int i = 0; i < a.length; i++)
        {
            assertEquals(a[i], b[i]);
        }
    }
    
    public static String escape(String s)
    {
        if (s == null)
            return "null";
        
        StringBuilder b = new StringBuilder("\"");
        for (int i = 0, n = s.length(); i < n; i++)
        {
            char c = s.charAt(i);
            switch (c)
            {
                case '"': b.append("\\").append(c); break;
                default: b.append(c); break;
            }            
        }
        b.append('"');
        return b.toString();
    }
}
