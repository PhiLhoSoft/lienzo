
package com.emitrom.lienzo.client.core.shape.path;

public class ClosePathPart extends PathPart
{
    public ClosePathPart(boolean absolute)
    {
        super(PathPartJSO.makePathPart(absolute ? PathPartType.Z : PathPartType.z));
    }
}
