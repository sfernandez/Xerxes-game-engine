/* This file is part of Xerxes game engine.

    Xerxes game engine is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Xerxes game engine is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with Xerxes game engine.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.xerxes.engine.math.tests;

import com.xerxes.engine.math.LineSegment;
import com.xerxes.engine.ui.Position;
import junit.framework.TestCase;

public class LineSegmentTest extends TestCase {

    private Position initialPosition;
    private Position finalPosition;

    @Override
    protected void setUp() throws Exception {
        initialPosition = new Position(0, 0, 0);
        finalPosition = new Position(10, 10, 0);
    }

    public void testConstructALineWithAnInitialPositionAndAfinalPositionReturnsALineConfigured() {
        LineSegment segment = new LineSegment(initialPosition, finalPosition);
        assertEquals("incorrect initial position", initialPosition, segment.getInitialPosition());
        assertEquals("incorrect final position", finalPosition, segment.getFinalPosition());
    }

    public void testGetPositionWithAnIncrementOf2ReturnsPoint2x2y() {
        Position expectedPosition = new Position(2, 2, 0);
        LineSegment segment = new LineSegment(initialPosition, finalPosition);
        Position actualPosition = segment.getPosition(2);
        assertEquals("incorrect position", expectedPosition, actualPosition);
    }

    public void testPendentgetPendentReturnsCorrectPendent() {
        double expectedValue = 1;
        LineSegment segment = new LineSegment(initialPosition, finalPosition);
        LineSegment.Pendent pendent = segment.getPendent();
        double actualValue = pendent.getPendent();
        assertEquals("incorrect pendent", expectedValue, actualValue);
    }

    public void testGetLineEquationShouldReturnTheLineEquationValue() {
        double expected = 1.5;
        LineSegment segment = new LineSegment(new Position(2.0, 2.0, 1), new Position(10.0, 4.0, 1));
        double actual = segment.getLineEq();
        assertEquals("incorrect line", expected, actual);
    }

}
