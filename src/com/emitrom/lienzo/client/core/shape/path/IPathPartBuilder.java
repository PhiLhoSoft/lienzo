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

import com.emitrom.lienzo.client.core.types.Point2D;
import com.emitrom.lienzo.client.core.types.Point2DArray;

public interface IPathPartBuilder<T extends IPathPartBuilder<T>>
{
    public T h(double x);

    public T h(double x, double... xs);

    public T h(double[] xs);

    public T H(double x);

    public T H(double x, double... xs);

    public T H(double[] xs);

    public T l(double x, double y);

    public T l(List<Point2D> points);

    public T l(Point2D point);

    public T l(Point2D point, Point2D... points);

    public T l(Point2D[] points);

    public T l(Point2DArray points);

    public T L(double x, double y);

    public T L(List<Point2D> points);

    public T L(Point2D point);

    public T L(Point2D point, Point2D... points);

    public T L(Point2D[] points);

    public T L(Point2DArray points);

    public T m(double x, double y);

    public T m(List<Point2D> points);

    public T m(Point2D point);

    public T m(Point2D point, Point2D... points);

    public T m(Point2D[] points);

    public T m(Point2DArray points);

    public T M(double x, double y);

    public T M(List<Point2D> points);

    public T M(Point2D point);

    public T M(Point2D point, Point2D... points);

    public T M(Point2D[] points);

    public T M(Point2DArray points);

    public T q(double cx, double cy, double ex, double ey);

    public T q(Point2D cp, Point2D ep);

    public T Q(double cx, double cy, double ex, double ey);

    public T Q(Point2D cp, Point2D ep);

    public T v(double y);

    public T v(double y, double... ys);

    public T v(double[] ys);

    public T V(double y);

    public T V(double y, double... ys);

    public T V(double[] ys);

    public T z();

    public T Z();
}
