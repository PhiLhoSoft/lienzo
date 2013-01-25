
package com.emitrom.lienzo.client.core.shape.json;

import com.emitrom.lienzo.client.core.shape.Arc;
import com.emitrom.lienzo.client.core.shape.Arrow;
import com.emitrom.lienzo.client.core.shape.BezierCurve;
import com.emitrom.lienzo.client.core.shape.Circle;
import com.emitrom.lienzo.client.core.shape.Ellipse;
import com.emitrom.lienzo.client.core.shape.Group;
import com.emitrom.lienzo.client.core.shape.IPrimitive;
import com.emitrom.lienzo.client.core.shape.Layer;
import com.emitrom.lienzo.client.core.shape.Line;
import com.emitrom.lienzo.client.core.shape.Node;
import com.emitrom.lienzo.client.core.shape.Parallelogram;
import com.emitrom.lienzo.client.core.shape.PolyLine;
import com.emitrom.lienzo.client.core.shape.Polygon;
import com.emitrom.lienzo.client.core.shape.QuadraticCurve;
import com.emitrom.lienzo.client.core.shape.Rectangle;
import com.emitrom.lienzo.client.core.shape.RegularPolygon;
import com.emitrom.lienzo.client.core.shape.Shape;
import com.emitrom.lienzo.client.core.shape.Slice;
import com.emitrom.lienzo.client.core.shape.Star;
import com.emitrom.lienzo.client.core.shape.Text;
import com.emitrom.lienzo.client.core.shape.Triangle;
import com.emitrom.lienzo.client.core.shape.json.JSONDeserializer;
import com.emitrom.lienzo.client.core.shape.json.validators.ValidationContext;
import com.emitrom.lienzo.client.core.types.DashArray;
import com.emitrom.lienzo.client.core.types.DragBounds;
import com.emitrom.lienzo.client.core.types.LinearGradient;
import com.emitrom.lienzo.client.core.types.Point2D;
import com.emitrom.lienzo.client.core.types.Point2DArray;
import com.emitrom.lienzo.client.core.types.RadialGradient;
import com.emitrom.lienzo.client.core.types.Shadow;
import com.emitrom.lienzo.client.core.types.Transform;
import com.emitrom.lienzo.client.junit.LienzoTestCase;
import com.emitrom.lienzo.shared.core.types.ArrowType;
import com.emitrom.lienzo.shared.core.types.ColorName;
import com.emitrom.lienzo.shared.core.types.DragConstraint;
import com.emitrom.lienzo.shared.core.types.LineCap;
import com.emitrom.lienzo.shared.core.types.LineJoin;
import com.emitrom.lienzo.shared.core.types.TextAlign;
import com.emitrom.lienzo.shared.core.types.TextBaseLine;

public class TestSerialization extends LienzoTestCase
{
    private static final String CIRCLE_5 = "{\"type\":\"Circle\", \"attributes\":{\"visible\":true, \"listening\":true, \"x\":0, \"y\":0, \"alpha\":1, \"draggable\":false, \"radius\":5}}";
    private static final String CIRCLE_ALL = "{\"type\":\"Circle\", \"attributes\":{\"visible\":false, \"listening\":false, \"x\":-3.4, \"y\":-4.5, \"alpha\":0.8, \"draggable\":true, \"radius\":10.1, \"fill\":\"aliceblue\", \"lineCap\":\"round\", \"lineJoin\":\"miter\", \"miterLimit\":3.4, \"name\":\"shapeName\", \"stroke\":\"antiquewhite\", \"shadow\":{\"color\":\"beige\", \"blur\":12, \"offset\":{\"x\":3.4, \"y\":5.6}}, \"dragBounds\":{\"x1\":1, \"y1\":2, \"x2\":3, \"y2\":4}, \"dragConstraint\":\"horizontal\", \"offset\":{\"x\":1.2, \"y\":3.4}, \"rotation\":3.14, \"scale\":{\"x\":1.3, \"y\":3.5}, \"shear\":{\"x\":1.4, \"y\":3.6}, \"transform\":[1,2,3,4,5,6]}}";
    private static final String CIRCLE_LINEAR_GRADIENT = "{\"type\":\"Circle\", \"attributes\":{\"visible\":true, \"listening\":true, \"x\":0, \"y\":0, \"alpha\":1, \"draggable\":false, \"radius\":5, \"fill\":{\"start\":{\"x\":1, \"y\":2}, \"end\":{\"x\":3, \"y\":4}, \"colorStops\":[{\"stop\":2, \"color\":\"aqua\"},{\"stop\":4, \"color\":\"azure\"}], \"type\":\"LinearGradient\"}}}";
    private static final String CIRCLE_RADIAL_GRADIENT = "{\"type\":\"Circle\", \"attributes\":{\"visible\":true, \"listening\":true, \"x\":0, \"y\":0, \"alpha\":1, \"draggable\":false, \"radius\":5, \"fill\":{\"start\":{\"x\":1, \"y\":2, \"radius\":3}, \"end\":{\"x\":4, \"y\":5, \"radius\":6}, \"colorStops\":[{\"stop\":2, \"color\":\"aqua\"},{\"stop\":4, \"color\":\"azure\"}], \"type\":\"RadialGradient\"}}}";
    private static final String GROUP_ALL = "{\"type\":\"Group\", \"attributes\":{\"visible\":false, \"listening\":false, \"x\":-3.4, \"y\":-4.5, \"alpha\":0.8, \"draggable\":true, \"dragBounds\":{\"x1\":1, \"y1\":2, \"x2\":3, \"y2\":4}, \"dragConstraint\":\"horizontal\", \"offset\":{\"x\":1.2, \"y\":3.4}, \"rotation\":3.14, \"scale\":{\"x\":1.3, \"y\":3.5}, \"shear\":{\"x\":1.4, \"y\":3.6}, \"transform\":[1,2,3,4,5,6]}, \"children\":[{\"type\":\"Circle\", \"attributes\":{\"visible\":false, \"listening\":false, \"x\":-3.4, \"y\":-4.5, \"alpha\":0.8, \"draggable\":true, \"radius\":10.1, \"fill\":\"aliceblue\", \"lineCap\":\"round\", \"lineJoin\":\"miter\", \"miterLimit\":3.4, \"name\":\"shapeName\", \"stroke\":\"antiquewhite\", \"shadow\":{\"color\":\"beige\", \"blur\":12, \"offset\":{\"x\":3.4, \"y\":5.6}}, \"dragBounds\":{\"x1\":1, \"y1\":2, \"x2\":3, \"y2\":4}, \"dragConstraint\":\"horizontal\", \"offset\":{\"x\":1.2, \"y\":3.4}, \"rotation\":3.14, \"scale\":{\"x\":1.3, \"y\":3.5}, \"shear\":{\"x\":1.4, \"y\":3.6}, \"transform\":[1,2,3,4,5,6]}},{\"type\":\"Ellipse\", \"attributes\":{\"visible\":false, \"listening\":false, \"x\":-3.4, \"y\":-4.5, \"alpha\":0.8, \"draggable\":true, \"width\":30.1, \"height\":40.2, \"fill\":\"aliceblue\", \"lineCap\":\"round\", \"lineJoin\":\"miter\", \"miterLimit\":3.4, \"name\":\"shapeName\", \"stroke\":\"antiquewhite\", \"shadow\":{\"color\":\"beige\", \"blur\":12, \"offset\":{\"x\":3.4, \"y\":5.6}}, \"dragBounds\":{\"x1\":1, \"y1\":2, \"x2\":3, \"y2\":4}, \"dragConstraint\":\"horizontal\", \"offset\":{\"x\":1.2, \"y\":3.4}, \"rotation\":3.14, \"scale\":{\"x\":1.3, \"y\":3.5}, \"shear\":{\"x\":1.4, \"y\":3.6}, \"transform\":[1,2,3,4,5,6]}}]}";
    private static final String LAYER_ALL = "{\"type\":\"Layer\", \"attributes\":{\"visible\":false, \"listening\":true, \"clearLayerBeforeDraw\":false, \"transform\":[1,2,3,4,5,6]}, \"children\":[{\"type\":\"Circle\", \"attributes\":{\"visible\":false, \"listening\":false, \"x\":-3.4, \"y\":-4.5, \"alpha\":0.8, \"draggable\":true, \"radius\":10.1, \"fill\":\"aliceblue\", \"lineCap\":\"round\", \"lineJoin\":\"miter\", \"miterLimit\":3.4, \"name\":\"shapeName\", \"stroke\":\"antiquewhite\", \"shadow\":{\"color\":\"beige\", \"blur\":12, \"offset\":{\"x\":3.4, \"y\":5.6}}, \"dragBounds\":{\"x1\":1, \"y1\":2, \"x2\":3, \"y2\":4}, \"dragConstraint\":\"horizontal\", \"offset\":{\"x\":1.2, \"y\":3.4}, \"rotation\":3.14, \"scale\":{\"x\":1.3, \"y\":3.5}, \"shear\":{\"x\":1.4, \"y\":3.6}, \"transform\":[1,2,3,4,5,6]}},{\"type\":\"Ellipse\", \"attributes\":{\"visible\":false, \"listening\":false, \"x\":-3.4, \"y\":-4.5, \"alpha\":0.8, \"draggable\":true, \"width\":30.1, \"height\":40.2, \"fill\":\"aliceblue\", \"lineCap\":\"round\", \"lineJoin\":\"miter\", \"miterLimit\":3.4, \"name\":\"shapeName\", \"stroke\":\"antiquewhite\", \"shadow\":{\"color\":\"beige\", \"blur\":12, \"offset\":{\"x\":3.4, \"y\":5.6}}, \"dragBounds\":{\"x1\":1, \"y1\":2, \"x2\":3, \"y2\":4}, \"dragConstraint\":\"horizontal\", \"offset\":{\"x\":1.2, \"y\":3.4}, \"rotation\":3.14, \"scale\":{\"x\":1.3, \"y\":3.5}, \"shear\":{\"x\":1.4, \"y\":3.6}, \"transform\":[1,2,3,4,5,6]}}]}";

    public void testSimpleCircle()
    {
        Circle c = new Circle(5);
        String str = c.toJSONString();
        //System.out.println(escape(str));
        assertEqualsJsonString(CIRCLE_5, str);
    }
    
    public void testDeserialize()
    {
        Circle c = deserialize(CIRCLE_5, true);

        assertNotNull(c);
        assertEquals(5.0, c.getRadius());
        assertDefaultProperties(c);
    }

    public void testDoubleSerialize()
    {
        Circle c = deserialize(CIRCLE_5, true);
        assertDoubleSerialize(c);
    }

    public void testAllArc()
    {
        Arc r = new Arc(3.14, 40.2, 5.6, true);
        
        Arc r2 = serializeShapeTest(r);  
        assertEquals(3.14, r2.getRadius());
        assertEquals(40.2, r2.getStartAngle());
        assertEquals(5.6, r2.getEndAngle());
        assertEquals(true, r2.isCounterClockwise());
    }

    public void testAllArrow()
    {
        Arrow r = new Arrow(new Point2D(1.2, 3.4), new Point2D(5.6, 7.8), 1.1, 2.2, 3.3, 4.4, ArrowType.AT_END_TAPERED);
        
        Arrow r2 = serializeShapeTest(r);  
        assertEquals(1.2, r2.getStart().getX());
        assertEquals(3.4, r2.getStart().getY());
        assertEquals(5.6, r2.getEnd().getX());
        assertEquals(7.8, r2.getEnd().getY());
        assertEquals(1.1, r2.getBaseWidth());
        assertEquals(2.2, r2.getHeadWidth());
        assertEquals(3.3, r2.getArrowAngle());
        assertEquals(4.4, r2.getBaseAngle());
        assertEquals(ArrowType.AT_END_TAPERED, r2.getArrowType());
    }

    public void testAllBezierCurve()
    {
        Point2DArray a = new Point2DArray(new Point2D(1.2, 2.3), new Point2D(3.4, 4.5), new Point2D(5.6, 6.7), new Point2D(7.8, 8.9));
        BezierCurve r = new BezierCurve(a.getPoint(0).getX(), a.getPoint(0).getY(), a.getPoint(1).getX(), a.getPoint(1).getY(), a.getPoint(2).getX(), a.getPoint(2).getY(), a.getPoint(3).getX(), a.getPoint(3).getY());
        
        BezierCurve r2 = serializeShapeTest(r);  
        Point2DArray a2 = r2.getControlPoints();
        assertEquals(a, a2);
    }
    
    public void testAllCircle()
    {
        Circle c = new Circle(10.1);
        
        setSomeShapeProperties(c);
        
        String str = c.toJSONString();
        //System.out.println(escape(str));
        assertEqualsJsonString(CIRCLE_ALL, str);
        
        Circle c2 = deserialize(str, true);
        assertEquals(10.1, c2.getRadius());
        assertSomeShapeProperties(c2);
    }

    public void testAllEllipse()
    {
        Ellipse r = new Ellipse(30.1, 40.2);
        
        Ellipse r2 = serializeShapeTest(r);  
        assertEquals(30.1, r2.getWidth());
        assertEquals(40.2, r2.getHeight());
    }
    
    public void testAllGroup()
    {
        Group grp = new Group();
        setSomePrimitiveProperties(grp);
        
        Circle c = new Circle(10.1);       
        setSomeShapeProperties(c);
        grp.add(c);
        
        Ellipse r = new Ellipse(30.1, 40.2);
        setSomeShapeProperties(r);
        grp.add(r);
        
        String str = grp.toJSONString();
        //System.out.println(escape(str));
        assertEquals(GROUP_ALL, str);
        
        Group grp2 = deserialize(str, true);
        assertSomePrimitiveProperties(grp2);
        assertEquals(2, grp2.getChildNodes().length());
        
        Circle c2 = (Circle) grp2.getChildNodes().get(0);
        assertSomeShapeProperties(c2);
        
        Ellipse r2 = (Ellipse) grp2.getChildNodes().get(1);
        assertSomeShapeProperties(r2);
    }
    
    
    public void testAllLayer()
    {
        Layer layer = new Layer();
        layer.setClearLayerBeforeDraw(false);
        layer.setListening(true);
        layer.setVisible(false);
        layer.setTransform(new Transform(1,2,3,4,5,6));
        
        Circle c = new Circle(10.1);       
        setSomeShapeProperties(c);
        layer.add(c);
        
        Ellipse r = new Ellipse(30.1, 40.2);
        setSomeShapeProperties(r);
        layer.add(r);
        
        String str = layer.toJSONString();
        //System.out.println(escape(str));
        assertEquals(LAYER_ALL, str);
        
        Layer layer2 = deserialize(str, true);
        assertEquals(false, layer.isClearLayerBeforeDraw());
        assertEquals(true, layer.isListening());
        assertEquals(false, layer.isVisible());

        assertEquals(2, layer2.getChildNodes().length());
        
        Circle c2 = (Circle) layer2.getChildNodes().get(0);
        assertSomeShapeProperties(c2);
        
        Ellipse r2 = (Ellipse) layer2.getChildNodes().get(1);
        assertSomeShapeProperties(r2);
    }
    
    public void testAllLine()
    {
        Line r = new Line(1.1, 2.2, 3.3, 4.4);
        DashArray dash = createDashArray();
        r.setDashArray(dash);
        
        Line r2 = serializeShapeTest(r);  
        assertEquals(new Point2DArray(new Point2D(1.1, 2.2), new Point2D(3.3, 4.4)), r2.getPoints());
        assertEquals(dash, r2.getDashArray());
    }

    //TODO testAllMovie() ?
    
    public void testAllParallelogram()
    {
        Parallelogram r = new Parallelogram(1.1, 2.2, 3.3);
        
        Parallelogram r2 = serializeShapeTest(r);  
        assertEquals(1.1, r2.getWidth());
        assertEquals(2.2, r2.getHeight());
        assertEquals(3.3, r2.getSkew());
    }
    
    //TODO testAllPicture() ?
    
    public void testAllPolygon()
    {
        Point2DArray a = new Point2DArray(new Point2D(1.2, 2.3), new Point2D(3.4, 4.5), new Point2D(5.6, 6.7), new Point2D(7.8, 8.9));

        Polygon r = new Polygon(a);
        
        Polygon r2 = serializeShapeTest(r);  
        assertEquals(a, r2.getPoints());
    }
    
    public void testAllPolyLine()
    {
        Point2DArray a = new Point2DArray(new Point2D(1.2, 2.3), new Point2D(3.4, 4.5), new Point2D(5.6, 6.7), new Point2D(7.8, 8.9));

        PolyLine r = new PolyLine(a);
        DashArray dash = createDashArray();
        r.setDashArray(dash);
        
        PolyLine r2 = serializeShapeTest(r);  
        assertEquals(a, r2.getPoints());
        assertEquals(dash, r2.getDashArray());
    }
    
    public void testAllQuadraticCurve()
    {
        Point2DArray a = new Point2DArray(new Point2D(1.2, 2.3), new Point2D(3.4, 4.5), new Point2D(5.6, 6.7));
        QuadraticCurve r = new QuadraticCurve(a.getPoint(0).getX(), a.getPoint(0).getY(), a.getPoint(1).getX(), a.getPoint(1).getY(), a.getPoint(2).getX(), a.getPoint(2).getY());
        
        QuadraticCurve r2 = serializeShapeTest(r);  
        Point2DArray a2 = r2.getControlPoints();
        assertEquals(a, a2);
    }

    public void testAllRectangle()
    {
        Rectangle r = new Rectangle(30.1, 40.2, 5.6);
        
        Rectangle r2 = serializeShapeTest(r);  
        assertEquals(30.1, r2.getWidth());
        assertEquals(40.2, r2.getHeight());
        assertEquals(5.6, r2.getCornerRadius());
    }

    public void testAllRegularPolygon()
    {
        RegularPolygon r = new RegularPolygon(5, 30.4);
        
        RegularPolygon r2 = serializeShapeTest(r);  
        assertEquals(5, r2.getSides());
        assertEquals(30.4, r2.getRadius());
    }

    public void testAllSlice()
    {
        Slice r = new Slice(3.14, 40.2, 5.6, true);
        
        Slice r2 = serializeShapeTest(r);  
        assertEquals(3.14, r2.getRadius());
        assertEquals(40.2, r2.getStartAngle());
        assertEquals(5.6, r2.getEndAngle());
        assertEquals(true, r2.isCounterClockwise());
    }

    public void testAllStar()
    {
        Star r = new Star(5, 30.4, 50.5);
        
        Star r2 = serializeShapeTest(r);  
        assertEquals(5, r2.getStarPoints());
        assertEquals(30.4, r2.getInnerRadius());
        assertEquals(50.5, r2.getOuterRadius());
    }

    public void testAllText()
    {
        Text r = new Text("text", "family", "style", 20.1);
        r.setTextAlign(TextAlign.CENTER);
        r.setTextBaseLine(TextBaseLine.IDEOGRAPHIC);
        
        Text r2 = serializeShapeTest(r);  
        assertEquals("text", r2.getText());
        assertEquals("family", r2.getFontFamily());
        assertEquals("style", r2.getFontStyle());
        assertEquals(TextAlign.CENTER, r2.getTextAlign());
        assertEquals(TextBaseLine.IDEOGRAPHIC, r2.getTextBaseLine());
    }

    public void testAllTriangle()
    {
        Point2DArray a = new Point2DArray(new Point2D(1.2, 2.3), new Point2D(3.4, 4.5), new Point2D(5.6, 7.8));
        Triangle r = new Triangle(a.getPoint(0), a.getPoint(1), a.getPoint(2));
        
        Triangle r2 = serializeShapeTest(r);  
        assertEquals(a, r2.getPoints());
    }
    
    public void testLinearGradient()
    {
        Circle c = new Circle(5);
        LinearGradient linear = new LinearGradient(1,2,3,4);
        linear.addColorStop(2.0, ColorName.AQUA);
        linear.addColorStop(4.0, ColorName.AZURE);
        c.setFillGradient(linear);
        
        String str = c.toJSONString();
        //System.out.println(escape(str));
        assertEqualsJsonString(CIRCLE_LINEAR_GRADIENT, str);        
        
        Circle c2 = deserialize(str, true);
        assertEqualsJsonString(CIRCLE_LINEAR_GRADIENT, c2.toJSONString());
    }
    
    public void testRadialGradient()
    {
        Circle c = new Circle(5);
        RadialGradient radial = new RadialGradient(1,2,3,4,5,6);
        radial.addColorStop(2.0, ColorName.AQUA);
        radial.addColorStop(4.0, ColorName.AZURE);
        c.setFillGradient(radial);
        
        String str = c.toJSONString();
        //System.out.println(escape(str));
        assertEqualsJsonString(CIRCLE_RADIAL_GRADIENT, str);        
        
        Circle c2 = deserialize(str, true);
        assertEqualsJsonString(CIRCLE_RADIAL_GRADIENT, c2.toJSONString());
    }
    
    public void testPatternGradient()
    {
        @SuppressWarnings("unused")
		Circle c = new Circle(5);
//        PatternGradient pattern = new PatternGradient(1,2,3,4);
//        c.setFillGradient(pattern);
        //TODO ......
    }

    private void setSomeShapeProperties(Shape<?> c)
    {
        c.setFillColor(ColorName.ALICEBLUE);
        c.setLineCap(LineCap.ROUND);
        c.setLineJoin(LineJoin.MITER);
        c.setMiterLimit(3.4);
        c.setName("shapeName");        
        c.setStrokeColor(ColorName.ANTIQUEWHITE);
        
        Shadow sh = new Shadow(ColorName.BEIGE, 12, 3.4, 5.6);
        c.setShadow(sh);
        
        setSomePrimitiveProperties(c);
    }
    
    private void setSomePrimitiveProperties(IPrimitive<?> c)
    {
        c.setAlpha(0.8);
        c.setDragBounds(new DragBounds(1,2,3,4));
        c.setDragConstraint(DragConstraint.HORIZONTAL);
        c.setDraggable(true);
        c.setListening(false);
        c.setOffset(1.2, 3.4);
        c.setRotation(3.14);
        c.setScale(1.3, 3.5);
        c.setShear(1.4, 3.6);
        c.setTransform(new Transform(1,2,3,4,5,6));
        c.setVisible(false);
        c.setX(-3.4);
        c.setY(-4.5);
        
        //TODO c.rotationInDegrees
    }

    private void assertSomeShapeProperties(Shape<?> c)
    {
        assertEquals(ColorName.ALICEBLUE.getValue(), c.getFillColor());
        assertEquals(LineCap.ROUND, c.getLineCap());
        assertEquals(LineJoin.MITER, c.getLineJoin());
        assertEquals(3.4, c.getMiterLimit());
        assertEquals("shapeName", c.getName());
        assertEquals(ColorName.ANTIQUEWHITE.getValue(), c.getStrokeColor());
        
        Shadow sh = c.getShadow();
        assertEquals(ColorName.BEIGE.getValue(), sh.getColor());
        assertEquals(12, sh.getBlur());
        assertEquals(new Point2D(3.4, 5.6), sh.getOffset());
        
        assertSomePrimitiveProperties(c);
    }

    private void assertSomePrimitiveProperties(IPrimitive<?> c)
    {
        assertEquals(0.8, c.getAlpha());
        
        DragBounds bounds = c.getDragBounds();
        assertEquals(bounds.getX1(), 1.0);
        assertEquals(bounds.getY1(), 2.0);
        assertEquals(bounds.getX2(), 3.0);
        assertEquals(bounds.getY2(), 4.0);
        
        assertEquals(DragConstraint.HORIZONTAL, c.getDragConstraint());
        assertEquals(true, c.isDraggable());
        assertEquals(false, c.isListening());

        Point2D offset = c.getOffset();
        assertEquals(1.2, offset.getX());
        assertEquals(3.4, offset.getY());
        
        assertEquals(3.14, c.getRotation());
        
        Point2D scale = c.getScale();
        assertEquals(1.3, scale.getX());
        assertEquals(3.5, scale.getY());
        
        Point2D shear = c.getShear();
        assertEquals(1.4, shear.getX());
        assertEquals(3.6, shear.getY());
        
        assertEquals(new Transform(1,2,3,4,5,6), c.getTransform());
        
        assertEquals(false, c.isVisible());
        assertEquals(-3.4, c.getX());
        assertEquals(-4.5, c.getY());        
    }
    
    private void assertDoubleSerialize(Node<?> n)
    {
        String str = n.toJSONString();
        Node<?> n2 = deserialize(str, true);
        String str2 = n2.toJSONString();
        assertEquals(str, str2);
    }
    
    private void assertDefaultProperties(Shape<?> node)
    {
        assertDefaultPrimitiveProperties(node);
    }

    private void assertDefaultPrimitiveProperties(IPrimitive<?> node)
    {
        assertEquals(node.getX(), 0.0);
        assertEquals(node.getY(), 0.0);
        assertEquals(node.getAlpha(), 1.0);
        assertEquals(node.isDraggable(), false);
        assertEquals(node.isListening(), true);
        assertEquals(node.isVisible(), true);
    }
    
    private DashArray createDashArray()
    {
        DashArray a = new DashArray();
        a.push(2);
        a.push(4.5);
        a.push(8);
        return a;
    }
    
    private <T extends Shape<?>> T serializeShapeTest(T r)
    {
        setSomeShapeProperties(r);
        String s = r.toJSONString();
        T r2 = deserialize(s, true);
        assertSomeShapeProperties(r2);
        return r2;
    }

    @SuppressWarnings("unchecked")
    private <T extends Node<?>> T deserialize(String string, boolean validate)
    {
        ValidationContext ctx = new ValidationContext();
        ctx.setValidate(validate);
        ctx.setStopOnError(!validate);
        T node = (T) JSONDeserializer.getInstance().fromString(string, ctx);
        if (ctx.getErrorCount() > 0)
        {
            assertEquals("", ctx.getDebugString());
        }
        assertNotNull(node);
        return node;
    }
}
