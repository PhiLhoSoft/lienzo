
package com.emitrom.lienzo.client.core.shape.path;

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

public class CompoundPath extends Shape<CompoundPath>
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

    public CompoundPath m(double x, double y)
    {
        return m(new Point2DArray(x, y));
    }

    public CompoundPath m(Point2D point)
    {
        return m(new Point2DArray(point));
    }

    public CompoundPath m(Point2DArray points)
    {
        getAttributes().getPathParts().push(new MoveToPathPart(points, false));

        return this;
    }

    public CompoundPath M(double x, double y)
    {
        return M(new Point2DArray(x, y));
    }

    public CompoundPath M(Point2D point)
    {
        return M(new Point2DArray(point));
    }

    public CompoundPath M(Point2DArray points)
    {
        getAttributes().getPathParts().push(new MoveToPathPart(points, true));

        return this;
    }

    public CompoundPath l(double x, double y)
    {
        return l(new Point2DArray(x, y));
    }

    public CompoundPath l(Point2D point)
    {
        return l(new Point2DArray(point));
    }

    public CompoundPath l(Point2DArray points)
    {
        getAttributes().getPathParts().push(new LineToPathPart(points, false));

        return this;
    }

    public CompoundPath L(double x, double y)
    {
        return L(new Point2DArray(x, y));
    }

    public CompoundPath L(Point2D point)
    {
        return L(new Point2DArray(point));
    }

    public CompoundPath L(Point2DArray points)
    {
        getAttributes().getPathParts().push(new LineToPathPart(points, true));

        return this;
    }

    public CompoundPath z()
    {
        getAttributes().getPathParts().push(new ClosePathPart(false));

        return this;
    }

    public CompoundPath Z()
    {
        getAttributes().getPathParts().push(new ClosePathPart(true));

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
