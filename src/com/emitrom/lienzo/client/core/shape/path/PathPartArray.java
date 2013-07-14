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

import java.util.List;

import com.emitrom.lienzo.client.core.shape.path.PathPart.PathPartJSO;
import com.emitrom.lienzo.client.core.types.Point2D;
import com.emitrom.lienzo.client.core.types.Point2DArray;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.json.client.JSONArray;

public class PathPartArray implements IPathPartBuilder<PathPartArray>
{
    public static final class PathPartArrayJSO extends JsArray<PathPartJSO>
    {
        public static final native PathPartArrayJSO makePathPartArrayJSO()
        /*-{
			return [];
        }-*/;

        protected PathPartArrayJSO()
        {

        }
    }

    private final PathPartArrayJSO m_jso;

    public PathPartArray()
    {
        this(PathPartArrayJSO.makePathPartArrayJSO());
    }

    public PathPartArray(JsArray<JavaScriptObject> jso)
    {
        m_jso = jso.cast();
    }

    PathPartArray(PathPartArrayJSO jso)
    {
        m_jso = jso;
    }

    public final PathPartArrayJSO getJSO()
    {
        return m_jso;
    }

    public final int getLength()
    {
        return getJSO().length();
    }

    @Override
    public PathPartArray h(double x)
    {
        return h(new double[] { x });
    }

    @Override
    public PathPartArray h(double x, double... xs)
    {
        int size = 1;

        if (null != xs)
        {
            size += xs.length;
        }
        double[] array = new double[size];

        array[0] = x;

        if (null != xs)
        {
            for (int i = 0; i < xs.length; i++)
            {
                array[i + 1] = xs[i];
            }
        }
        return h(array);
    }

    @Override
    public PathPartArray h(double[] xs)
    {
        getJSO().push(new DoubleArrayPathPart(xs, PathPartType.h).getJSO());

        return this;
    }

    @Override
    public PathPartArray H(double x)
    {
        return H(new double[] { x });
    }

    @Override
    public PathPartArray H(double x, double... xs)
    {
        int size = 1;

        if (null != xs)
        {
            size += xs.length;
        }
        double[] array = new double[size];

        array[0] = x;

        if (null != xs)
        {
            for (int i = 0; i < xs.length; i++)
            {
                array[i + 1] = xs[i];
            }
        }
        return H(array);
    }

    @Override
    public PathPartArray H(double[] xs)
    {
        getJSO().push(new DoubleArrayPathPart(xs, PathPartType.H).getJSO());

        return this;
    }

    @Override
    public PathPartArray l(double x, double y)
    {
        return l(new Point2D(x, y));
    }

    @Override
    public PathPartArray l(List<Point2D> points)
    {
        Point2DArray list = new Point2DArray();

        if ((null != points) && (points.size() > 0))
        {
            final int leng = points.size();

            for (int i = 0; i < leng; i++)
            {
                Point2D point = points.get(i);

                if (null != point)
                {
                    list.push(point);
                }
            }
            return l(list);
        }
        return this;
    }

    @Override
    public PathPartArray l(Point2D point)
    {
        if (null != point)
        {
            return l(new Point2DArray(point));
        }
        return this;
    }

    @Override
    public PathPartArray l(Point2D point, Point2D... points)
    {
        Point2DArray list = new Point2DArray();

        if (null != point)
        {
            list.push(point);
        }
        if ((null != points) && (points.length > 0))
        {
            final int leng = points.length;

            for (int i = 0; i < leng; i++)
            {
                point = points[i];

                if (null != point)
                {
                    list.push(point);
                }
            }
        }
        return m(list);
    }

    @Override
    public PathPartArray l(Point2D[] points)
    {
        Point2DArray list = new Point2DArray();

        if ((null != points) && (points.length > 0))
        {
            final int leng = points.length;

            for (int i = 0; i < leng; i++)
            {
                Point2D point = points[i];

                if (null != point)
                {
                    list.push(point);
                }
            }
        }
        return l(list);
    }

    @Override
    public PathPartArray l(Point2DArray points)
    {
        Point2DArray list = new Point2DArray();

        if ((null != points) && (points.getLength() > 0))
        {
            final int leng = points.getLength();

            for (int i = 0; i < leng; i++)
            {
                Point2D point = points.getPoint(i);

                if (null != point)
                {
                    list.push(point);
                }
            }
            if (list.getLength() > 0)
            {
                getJSO().push(new LineToPathPart(list, false).getJSO());
            }
        }
        return this;
    }

    @Override
    public PathPartArray L(double x, double y)
    {
        return L(new Point2D(x, y));
    }

    @Override
    public PathPartArray L(List<Point2D> points)
    {
        Point2DArray list = new Point2DArray();

        if ((null != points) && (points.size() > 0))
        {
            final int leng = points.size();

            for (int i = 0; i < leng; i++)
            {
                Point2D point = points.get(i);

                if (null != point)
                {
                    list.push(point);
                }
            }
            return L(list);
        }
        return this;
    }

    @Override
    public PathPartArray L(Point2D point)
    {
        if (null != point)
        {
            return L(new Point2DArray(point));
        }
        return this;
    }

    @Override
    public PathPartArray L(Point2D point, Point2D... points)
    {
        Point2DArray list = new Point2DArray();

        if (null != point)
        {
            list.push(point);
        }
        if ((null != points) && (points.length > 0))
        {
            final int leng = points.length;

            for (int i = 0; i < leng; i++)
            {
                point = points[i];

                if (null != point)
                {
                    list.push(point);
                }
            }
        }
        return L(list);
    }

    @Override
    public PathPartArray L(Point2D[] points)
    {
        Point2DArray list = new Point2DArray();

        if ((null != points) && (points.length > 0))
        {
            final int leng = points.length;

            for (int i = 0; i < leng; i++)
            {
                Point2D point = points[i];

                if (null != point)
                {
                    list.push(point);
                }
            }
        }
        return L(list);
    }

    @Override
    public PathPartArray L(Point2DArray points)
    {
        Point2DArray list = new Point2DArray();

        if ((null != points) && (points.getLength() > 0))
        {
            final int leng = points.getLength();

            for (int i = 0; i < leng; i++)
            {
                Point2D point = points.getPoint(i);

                if (null != point)
                {
                    list.push(point);
                }
            }
            if (list.getLength() > 0)
            {
                getJSO().push(new LineToPathPart(list, true).getJSO());
            }
        }
        return this;
    }

    @Override
    public PathPartArray m(double x, double y)
    {
        return m(new Point2D(x, y));
    }

    @Override
    public PathPartArray m(List<Point2D> points)
    {
        Point2DArray list = new Point2DArray();

        if ((null != points) && (points.size() > 0))
        {
            final int leng = points.size();

            for (int i = 0; i < leng; i++)
            {
                Point2D point = points.get(i);

                if (null != point)
                {
                    list.push(point);
                }
            }
            return m(list);
        }
        return this;
    }

    @Override
    public PathPartArray m(Point2D point)
    {
        if (null != point)
        {
            return m(new Point2DArray(point));
        }
        return this;
    }

    @Override
    public PathPartArray m(Point2D point, Point2D... points)
    {
        Point2DArray list = new Point2DArray();

        if (null != point)
        {
            list.push(point);
        }
        if ((null != points) && (points.length > 0))
        {
            final int leng = points.length;

            for (int i = 0; i < leng; i++)
            {
                point = points[i];

                if (null != point)
                {
                    list.push(point);
                }
            }
        }
        return m(list);
    }

    @Override
    public PathPartArray m(Point2D[] points)
    {
        Point2DArray list = new Point2DArray();

        if ((null != points) && (points.length > 0))
        {
            final int leng = points.length;

            for (int i = 0; i < leng; i++)
            {
                Point2D point = points[i];

                if (null != point)
                {
                    list.push(point);
                }
            }
        }
        return m(list);
    }

    @Override
    public PathPartArray m(Point2DArray points)
    {
        Point2DArray list = new Point2DArray();

        if ((null != points) && (points.getLength() > 0))
        {
            final int leng = points.getLength();

            for (int i = 0; i < leng; i++)
            {
                Point2D point = points.getPoint(i);

                if (null != point)
                {
                    list.push(point);
                }
            }
            if (list.getLength() > 0)
            {
                getJSO().push(new MoveToPathPart(list, false).getJSO());
            }
        }
        return this;
    }

    @Override
    public PathPartArray M(double x, double y)
    {
        return M(new Point2D(x, y));
    }

    @Override
    public PathPartArray M(List<Point2D> points)
    {
        Point2DArray list = new Point2DArray();

        if ((null != points) && (points.size() > 0))
        {
            final int leng = points.size();

            for (int i = 0; i < leng; i++)
            {
                Point2D point = points.get(i);

                if (null != point)
                {
                    list.push(point);
                }
            }
            return M(list);
        }
        return this;
    }

    @Override
    public PathPartArray M(Point2D point)
    {
        if (null != point)
        {
            return M(new Point2DArray(point));
        }
        return this;
    }

    @Override
    public PathPartArray M(Point2D point, Point2D... points)
    {
        Point2DArray list = new Point2DArray();

        if (null != point)
        {
            list.push(point);
        }
        if ((null != points) && (points.length > 0))
        {
            final int leng = points.length;

            for (int i = 0; i < leng; i++)
            {
                point = points[i];

                if (null != point)
                {
                    list.push(point);
                }
            }
        }
        return M(list);
    }

    @Override
    public PathPartArray M(Point2D[] points)
    {
        Point2DArray list = new Point2DArray();

        if ((null != points) && (points.length > 0))
        {
            final int leng = points.length;

            for (int i = 0; i < leng; i++)
            {
                Point2D point = points[i];

                if (null != point)
                {
                    list.push(point);
                }
            }
        }
        return M(list);
    }

    @Override
    public PathPartArray M(Point2DArray points)
    {
        Point2DArray list = new Point2DArray();

        if ((null != points) && (points.getLength() > 0))
        {
            final int leng = points.getLength();

            for (int i = 0; i < leng; i++)
            {
                Point2D point = points.getPoint(i);

                if (null != point)
                {
                    list.push(point);
                }
            }
            if (list.getLength() > 0)
            {
                getJSO().push(new MoveToPathPart(list, true).getJSO());
            }
        }
        return this;
    }

    public final PathPartArray push(PathPart part)
    {
        getJSO().push(part.getJSO());

        return this;
    }

    @Override
    public PathPartArray q(double cx, double cy, double ex, double ey)
    {
        return q(new Point2D(cx, cy), new Point2D(ex, ey));
    }

    @Override
    public PathPartArray q(Point2D cp, Point2D ep)
    {
        getJSO().push(new QuadraticCurveToPathPart(new Point2DArray(cp, ep), false).getJSO());

        return this;
    }

    @Override
    public PathPartArray Q(double cx, double cy, double ex, double ey)
    {
        return Q(new Point2D(cx, cy), new Point2D(ex, ey));
    }

    @Override
    public PathPartArray Q(Point2D cp, Point2D ep)
    {
        getJSO().push(new QuadraticCurveToPathPart(new Point2DArray(cp, ep), true).getJSO());

        return this;
    }

    public String toString()
    {
        return new JSONArray(m_jso).toString();
    }

    @Override
    public PathPartArray v(double y)
    {
        return v(new double[] { y });
    }

    @Override
    public PathPartArray v(double y, double... ys)
    {
        int size = 1;

        if (null != ys)
        {
            size += ys.length;
        }
        double[] array = new double[size];

        array[0] = y;

        if (null != ys)
        {
            for (int i = 0; i < ys.length; i++)
            {
                array[i + 1] = ys[i];
            }
        }
        return v(array);
    }

    @Override
    public PathPartArray v(double[] ys)
    {
        getJSO().push(new DoubleArrayPathPart(ys, PathPartType.v).getJSO());

        return this;
    }

    @Override
    public PathPartArray V(double y)
    {
        return V(new double[] { y });
    }

    @Override
    public PathPartArray V(double y, double... ys)
    {
        int size = 1;

        if (null != ys)
        {
            size += ys.length;
        }
        double[] array = new double[size];

        array[0] = y;

        if (null != ys)
        {
            for (int i = 0; i < ys.length; i++)
            {
                array[i + 1] = ys[i];
            }
        }
        return V(array);
    }

    @Override
    public PathPartArray V(double[] ys)
    {
        getJSO().push(new DoubleArrayPathPart(ys, PathPartType.V).getJSO());

        return this;
    }

    @Override
    public PathPartArray z()
    {
        getJSO().push(new ClosePathPart(false).getJSO());

        return this;
    }

    @Override
    public PathPartArray Z()
    {
        getJSO().push(new ClosePathPart(true).getJSO());

        return this;
    }
}
