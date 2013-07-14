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

import java.util.List;

import com.emitrom.lienzo.client.core.Attribute;
import com.emitrom.lienzo.client.core.Context2D;
import com.emitrom.lienzo.client.core.shape.json.IFactory;
import com.emitrom.lienzo.client.core.shape.json.ShapeFactory;
import com.emitrom.lienzo.client.core.shape.json.validators.ValidationContext;
import com.emitrom.lienzo.client.core.shape.path.IPathPartBuilder;
import com.emitrom.lienzo.client.core.shape.path.PathPartArray;
import com.emitrom.lienzo.client.core.types.Point2D;
import com.emitrom.lienzo.client.core.types.Point2DArray;
import com.emitrom.lienzo.shared.core.types.ShapeType;
import com.google.gwt.json.client.JSONObject;

public class Path extends Shape<Path> implements IPathPartBuilder<Path>
{
    public static class PathFactory extends ShapeFactory<Path>
    {
        public PathFactory()
        {
            super(ShapeType.PATH);

            addAttribute(Attribute.PATH_PARTS, true);
        }

        @Override
        public Path create(JSONObject node, ValidationContext ctx)
        {
            return new Path(node);
        }
    }

    public Path()
    {
        super(ShapeType.PATH);

        if (null == getAttributes().getPathParts())
        {
            getAttributes().setPathParts(new PathPartArray());
        }
    }

    protected Path(JSONObject node)
    {
        super(ShapeType.PATH, node);

        if (null == getAttributes().getPathParts())
        {
            getAttributes().setPathParts(new PathPartArray());
        }
    }

    @Override
    public IFactory<?> getFactory()
    {
        return new PathFactory();
    }

    @Override
    public Path h(double x)
    {
        getAttributes().getPathParts().h(x);

        return this;
    }

    @Override
    public Path h(double x, double... xs)
    {
        getAttributes().getPathParts().h(x, xs);

        return this;
    }

    @Override
    public Path h(double[] xs)
    {
        getAttributes().getPathParts().h(xs);

        return this;
    }

    @Override
    public Path H(double x)
    {
        getAttributes().getPathParts().H(x);

        return this;
    }

    @Override
    public Path H(double x, double... xs)
    {
        getAttributes().getPathParts().H(x, xs);

        return this;
    }

    @Override
    public Path H(double[] xs)
    {
        getAttributes().getPathParts().H(xs);

        return this;
    }

    @Override
    public Path l(double x, double y)
    {
        getAttributes().getPathParts().l(x, y);

        return this;
    }

    @Override
    public Path l(List<Point2D> points)
    {
        getAttributes().getPathParts().l(points);

        return this;
    }

    @Override
    public Path l(Point2D point)
    {
        getAttributes().getPathParts().l(point);

        return this;
    }

    @Override
    public Path l(Point2D point, Point2D... points)
    {
        getAttributes().getPathParts().l(point, points);

        return this;
    }

    @Override
    public Path l(Point2D[] points)
    {
        getAttributes().getPathParts().l(points);

        return this;
    }

    @Override
    public Path l(Point2DArray points)
    {
        getAttributes().getPathParts().l(points);

        return this;
    }

    @Override
    public Path L(double x, double y)
    {
        getAttributes().getPathParts().L(x, y);

        return this;
    }

    @Override
    public Path L(List<Point2D> points)
    {
        getAttributes().getPathParts().L(points);

        return this;
    }

    @Override
    public Path L(Point2D point)
    {
        getAttributes().getPathParts().L(point);

        return this;
    }

    @Override
    public Path L(Point2D point, Point2D... points)
    {
        getAttributes().getPathParts().L(point, points);

        return this;
    }

    @Override
    public Path L(Point2D[] points)
    {
        getAttributes().getPathParts().L(points);

        return this;
    }

    @Override
    public Path L(Point2DArray points)
    {
        getAttributes().getPathParts().L(points);

        return this;
    }

    @Override
    public Path m(double x, double y)
    {
        getAttributes().getPathParts().m(x, y);

        return this;
    }

    @Override
    public Path m(List<Point2D> points)
    {
        getAttributes().getPathParts().m(points);

        return this;
    }

    @Override
    public Path m(Point2D point)
    {
        getAttributes().getPathParts().m(point);

        return this;
    }

    @Override
    public Path m(Point2D point, Point2D... points)
    {
        getAttributes().getPathParts().m(point, points);

        return this;
    }

    @Override
    public Path m(Point2D[] points)
    {
        getAttributes().getPathParts().m(points);

        return this;
    }

    @Override
    public Path m(Point2DArray points)
    {
        getAttributes().getPathParts().m(points);

        return this;
    }

    @Override
    public Path M(double x, double y)
    {
        getAttributes().getPathParts().M(x, y);

        return this;
    }

    @Override
    public Path M(List<Point2D> points)
    {
        getAttributes().getPathParts().M(points);

        return this;
    }

    @Override
    public Path M(Point2D point)
    {
        getAttributes().getPathParts().M(point);

        return this;
    }

    @Override
    public Path M(Point2D point, Point2D... points)
    {
        getAttributes().getPathParts().M(point, points);

        return this;
    }

    @Override
    public Path M(Point2D[] points)
    {
        getAttributes().getPathParts().M(points);

        return this;
    }

    @Override
    public Path M(Point2DArray points)
    {
        getAttributes().getPathParts().M(points);

        return this;
    }

    @Override
    protected boolean prepare(Context2D context, Attributes attr, double alpha)
    {
        context.beginPath();

        context.drawPath(attr.getPathParts());

        return true;
    }

    @Override
    public Path q(double cx, double cy, double ex, double ey)
    {
        getAttributes().getPathParts().q(cx, cy, ex, ey);

        return this;
    }

    @Override
    public Path q(Point2D cp, Point2D ep)
    {
        getAttributes().getPathParts().q(cp, ep);

        return this;
    }

    @Override
    public Path Q(double cx, double cy, double ex, double ey)
    {
        getAttributes().getPathParts().Q(cx, cy, ex, ey);

        return this;
    }

    @Override
    public Path Q(Point2D cp, Point2D ep)
    {
        getAttributes().getPathParts().Q(cp, ep);

        return this;
    }

    @Override
    public Path v(double y)
    {
        getAttributes().getPathParts().v(y);

        return this;
    }

    @Override
    public Path v(double y, double... ys)
    {
        getAttributes().getPathParts().v(y, ys);

        return this;
    }

    @Override
    public Path v(double[] ys)
    {
        getAttributes().getPathParts().v(ys);

        return this;
    }

    @Override
    public Path V(double y)
    {
        getAttributes().getPathParts().V(y);

        return this;
    }

    @Override
    public Path V(double y, double... ys)
    {
        getAttributes().getPathParts().V(y, ys);

        return this;
    }

    @Override
    public Path V(double[] ys)
    {
        getAttributes().getPathParts().V(ys);

        return this;
    }

    @Override
    public Path z()
    {
        getAttributes().getPathParts().z();

        return this;
    }

    @Override
    public Path Z()
    {
        getAttributes().getPathParts().Z();

        return this;
    }
}
