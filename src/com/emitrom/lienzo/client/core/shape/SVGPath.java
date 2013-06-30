
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
    private final PathPartArray m_parts = new PathPartArray();
    
    public SVGPath()
    {
        super(ShapeType.SVG_PATH);
    }

    protected SVGPath(JSONObject node)
    {
        super(ShapeType.SVG_PATH, node);
    }

    @Override
    public IFactory<?> getFactory()
    {
        return new PSVGathFactory();
    }

    @Override
    protected void prepare(Context2D context, Attributes attr, double alpha)
    {
        context.beginPath();

        context.drawPath(m_parts);
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
