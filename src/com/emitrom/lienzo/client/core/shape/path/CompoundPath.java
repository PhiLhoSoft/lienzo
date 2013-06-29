
package com.emitrom.lienzo.client.core.shape.path;

import java.util.List;

import com.emitrom.lienzo.client.core.Attribute;
import com.emitrom.lienzo.client.core.Context2D;
import com.emitrom.lienzo.client.core.shape.Attributes;
import com.emitrom.lienzo.client.core.shape.Shape;
import com.emitrom.lienzo.client.core.shape.json.IFactory;
import com.emitrom.lienzo.client.core.shape.json.ShapeFactory;
import com.emitrom.lienzo.client.core.shape.json.validators.ValidationContext;
import com.emitrom.lienzo.client.core.types.Point2D;
import com.emitrom.lienzo.client.core.types.Point2DArray;
import com.emitrom.lienzo.shared.core.types.ShapeType;
import com.google.gwt.json.client.JSONObject;

public class CompoundPath extends Shape<CompoundPath> implements IPathPartBuilder<CompoundPath>
{
    public CompoundPath()
    {
        super(ShapeType.COMPOUND_PATH);

        if (null == getAttributes().getPathParts())
        {
            getAttributes().setPathParts(new PathPartArray());
        }
    }

    protected CompoundPath(JSONObject node)
    {
        super(ShapeType.COMPOUND_PATH, node);

        if (null == getAttributes().getPathParts())
        {
            getAttributes().setPathParts(new PathPartArray());
        }
    }

    @Override
    public CompoundPath m(double x, double y)
    {
        getAttributes().getPathParts().m(x, y);

        return this;
    }

    @Override
    public CompoundPath m(Point2D point)
    {
        getAttributes().getPathParts().m(point);

        return this;
    }

    @Override
    public CompoundPath m(Point2DArray points)
    {
        getAttributes().getPathParts().m(points);

        return this;
    }

    @Override
    public CompoundPath m(Point2D point, Point2D... points)
    {
        getAttributes().getPathParts().m(point, points);

        return this;
    }

    @Override
    public CompoundPath m(Point2D[] points)
    {
        getAttributes().getPathParts().m(points);

        return this;
    }

    @Override
    public CompoundPath m(List<Point2D> points)
    {
        getAttributes().getPathParts().m(points);

        return this;
    }

    @Override
    public CompoundPath M(double x, double y)
    {
        getAttributes().getPathParts().M(x, y);

        return this;
    }

    @Override
    public CompoundPath M(Point2D point)
    {
        getAttributes().getPathParts().M(point);

        return this;
    }

    @Override
    public CompoundPath M(Point2DArray points)
    {
        getAttributes().getPathParts().M(points);

        return this;
    }

    @Override
    public CompoundPath M(Point2D point, Point2D... points)
    {
        getAttributes().getPathParts().M(point, points);

        return this;
    }

    @Override
    public CompoundPath M(Point2D[] points)
    {
        getAttributes().getPathParts().M(points);

        return this;
    }

    @Override
    public CompoundPath M(List<Point2D> points)
    {
        getAttributes().getPathParts().M(points);

        return this;
    }

    @Override
    public CompoundPath l(double x, double y)
    {
        getAttributes().getPathParts().l(x, y);

        return this;
    }

    @Override
    public CompoundPath l(Point2D point)
    {
        getAttributes().getPathParts().l(point);

        return this;
    }

    @Override
    public CompoundPath l(Point2DArray points)
    {
        getAttributes().getPathParts().l(points);

        return this;
    }

    @Override
    public CompoundPath l(Point2D point, Point2D... points)
    {
        getAttributes().getPathParts().l(point, points);

        return this;
    }

    @Override
    public CompoundPath l(Point2D[] points)
    {
        getAttributes().getPathParts().l(points);

        return this;
    }

    @Override
    public CompoundPath l(List<Point2D> points)
    {
        getAttributes().getPathParts().l(points);

        return this;
    }

    @Override
    public CompoundPath L(double x, double y)
    {
        getAttributes().getPathParts().L(x, y);

        return this;
    }

    @Override
    public CompoundPath L(Point2D point)
    {
        getAttributes().getPathParts().L(point);

        return this;
    }

    @Override
    public CompoundPath L(Point2DArray points)
    {
        getAttributes().getPathParts().L(points);

        return this;
    }

    @Override
    public CompoundPath L(Point2D point, Point2D... points)
    {
        getAttributes().getPathParts().L(point, points);

        return this;
    }

    @Override
    public CompoundPath L(Point2D[] points)
    {
        getAttributes().getPathParts().L(points);

        return this;
    }

    @Override
    public CompoundPath L(List<Point2D> points)
    {
        getAttributes().getPathParts().L(points);

        return this;
    }

    @Override
    public CompoundPath z()
    {
        getAttributes().getPathParts().z();

        return this;
    }

    @Override
    public IFactory<?> getFactory()
    {
        return new CompoundPathFactory();
    }

    @Override
    protected void prepare(Context2D context, Attributes attr, double alpha)
    {
        context.beginPath();

        context.drawPath(attr.getPathParts());
    }

    public static class CompoundPathFactory extends ShapeFactory<CompoundPath>
    {
        public CompoundPathFactory()
        {
            super(ShapeType.COMPOUND_PATH);

            addAttribute(Attribute.PATH_PARTS, true);
        }

        @Override
        public CompoundPath create(JSONObject node, ValidationContext ctx)
        {
            return new CompoundPath(node);
        }
    }

}
