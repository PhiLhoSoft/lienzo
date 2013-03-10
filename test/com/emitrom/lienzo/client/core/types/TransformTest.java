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
package com.emitrom.lienzo.client.core.types;

import org.junit.Test;

import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.junit.client.GWTTestCase;

public class TransformTest extends GWTTestCase {

	private Transform transform;
	private static final double SCALE = 2.0;
	
	@Override
	protected void gwtSetUp() throws Exception {
		transform = new Transform();
	}

	@Test
	public void testCopy() {
		assertTrue(transform.copy().toString().equals(transform.toString()));
	}

	@Test
	public void testTranslate() {
		transform.translate(100.0, 200.0);
		assertTrue(100.0 == transform.get(4));
		assertTrue(200.0 == transform.get(4));
	}

	@Test
	public void testScaleDoubleDouble() {
		transform.scale(SCALE, SCALE);
		assertTrue(SCALE == transform.get(0));
		assertTrue(SCALE == transform.get(3));
	}

	@Test
	public void testScaleDouble() {
		transform.scale(SCALE);
		assertTrue(SCALE == transform.get(0));
		assertTrue(SCALE == transform.get(3));
	}

	@Test
	public void testShear() {
		transform.shear(2.0, 4.0);
	}

	@Test
	public void testRotate() {
		transform.rotate(Math.toRadians(45));
		NumberFormat decimalFormat = NumberFormat.getFormat("#.##");
		assertTrue(0.71 == Double.valueOf(decimalFormat.format(transform.get(0))));
		assertTrue(0.71 == Double.valueOf(decimalFormat.format(transform.get(1))));
		assertTrue(-0.71 == Double.valueOf(decimalFormat.format(transform.get(2))));
		assertTrue(0.71 == Double.valueOf(decimalFormat.format(transform.get(3))));
	}

	@Test
	public void testMultiply() {
		transform.multiply(transform);
		assertTrue(transform.get(0) == 1);
		assertTrue(transform.get(1) == 0);
		assertTrue(transform.get(2) == 0);
		assertTrue(transform.get(3) == 1);
		assertTrue(transform.get(4) == 0);
		assertTrue(transform.get(5) == 0);
	}

	@Test
	public void testConcatenate() {
		transform.multiply(transform);
		assertTrue(transform.get(0) == 1);
		assertTrue(transform.get(1) == 0);
		assertTrue(transform.get(2) == 0);
		assertTrue(transform.get(3) == 1);
		assertTrue(transform.get(4) == 0);
		assertTrue(transform.get(5) == 0);
	}

	@Test
	public void testGetInverse() {
		Transform t = new Transform(new double[]{3.0,2.0,1.0,1.0,2.0,3.0}).getInverse();
		assertTrue(t.get(0) == 1);
		assertTrue(t.get(1) == -2);
		assertTrue(t.get(2) == -1);
		assertTrue(t.get(3) == 3);
		assertTrue(t.get(4) == 1);
		assertTrue(t.get(5) == -5);
	}

	@Test
	public void testScaleAboutPoint() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetScaleX() {
		transform.scale(SCALE);
		assertTrue(SCALE == transform.getScaleX());
	}

	@Test
	public void testGetScaleY() {
		transform.scale(SCALE);
		assertTrue(SCALE == transform.getScaleY());
	}

	@Test
	public void testGetShearX() {
		transform.shear(2.0, 4.0);
		assertTrue(2.0 == transform.getShearX());
	}

	@Test
	public void testGetShearY() {
		transform.shear(2.0, 4.0);
		assertTrue(4.0 == transform.getShearY());
	}

	@Test
	public void testGetTranslateX() {
		transform.translate(100.0, 200.0);
		assertTrue(100.0 == transform.getTranslateX());
	}

	@Test
	public void testGetTranslateY() {
		transform.translate(100.0, 200.0);
		assertTrue(200.0 == transform.getTranslateY());
	}

	@Test
	public void testToString() {
		assertTrue(!transform.toString().isEmpty());
	}

	@Test
	public void testCreate3PointTransform() {
		fail("Not yet implemented");
	}
	
	@Override
	public String getModuleName() {
		return "com.emitrom.lienzo.Lienzo";
	}

}
