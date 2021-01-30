package lab1.test;

import org.junit.jupiter.api.Test;
import lab1.*;

import static org.junit.jupiter.api.Assertions.*;

public class LaunchInterceptorConditionsTest {

    /**
     * Testing two valid points and a valid LENGTH1.
     */
    @Test
    void distance_ValidInput_GreaterThan() {
        double x1 = 1.5;
        double y1 = 1;
        double x2 = 5;
        double y2 = 1;
        double length1 = 3.2;
        assertTrue(LaunchInterceptorConditions.helperDistance(x1, y1, x2, y2, length1));
        length1 = 3.6;
        assertFalse(LaunchInterceptorConditions.helperDistance(x1, y1, x2, y2, length1));
        x1 = 1.5;
        y1 = -2;
        x2 = -2.2;
        y2 = 3;
        length1 = 6.2;
        assertTrue(LaunchInterceptorConditions.helperDistance(x1, y1, x2, y2, length1));
        length1 = 6.3;
        assertFalse(LaunchInterceptorConditions.helperDistance(x1, y1, x2, y2, length1));
    }

    /**
     * Testing and invalid input of negative LENGTH1.
     */
    @Test
    void distance_InvalidInput_NegativeLength1() {
        double x1 = 1.5;
        double y1 = 1;
        double x2 = 5;
        double y2 = 1;
        double length1 = -3;
        assertThrows(IllegalArgumentException.class, () -> LaunchInterceptorConditions.helperDistance(x1, y1, x2, y2, length1));
    }

    /**
     * Testing with a valid input of three points that make a triangle which fits into/on a circle of radius one.
     */
    @Test
    void threePoints_ValidInput_HaveTriangle() {
        double x1 = 1;
        double y1 = 0;
        double x2 = 0;
        double y2 = 1;
        double x3 = -1;
        double y3 = 0;
        assertTrue(LaunchInterceptorConditions.helperCircle(x1, y1, x2, y2, x3, y3));
        x1 = 1.2;
        y1 = 1.5;
        x2 = 1.2;
        y2 = 2.5;
        x3 = 2.2;
        y3 = 1.5;
        assertTrue(LaunchInterceptorConditions.helperCircle(x1, y1, x2, y2, x3, y3));
        x1 = 0.7071;
        y1 = 0.7071;
        x2 = -0.5;
        y2 = 0.866;
        x3 = -0.7071;
        y3 = -0.7071;
        assertTrue(LaunchInterceptorConditions.helperCircle(x1, y1, x2, y2, x3, y3));
    }

    /**
     * Testing with a valid input of three points that don not make a triangle which fits
     * into/on a circle of radius one.
     */
    @Test
    void threePoints_ValidInput_DoNotHaveTriangle() {
        double x1 = 2;
        double y1 = 0;
        double x2 = 0;
        double y2 = 3;
        double x3 = -1;
        double y3 = 0;
        assertFalse(LaunchInterceptorConditions.helperCircle(x1, y1, x2, y2, x3, y3));
        x1 = 1.2;
        y1 = 3.5;
        x2 = 1.2;
        y2 = 2.5;
        x3 = 5.2;
        y3 = 1.5;
        assertFalse(LaunchInterceptorConditions.helperCircle(x1, y1, x2, y2, x3, y3));
        x1 = 0.7071;
        y1 = 0.7071;
        x2 = -0.7;
        y2 = 0.866;
        x3 = -0.7071;
        y3 = -0.7071;
        assertFalse(LaunchInterceptorConditions.helperCircle(x1, y1, x2, y2, x3, y3));
    }

    /**
     * Testing with a valid input of three points that don not make any
     * triangle (All points are on a straight line).
     */
    @Test
    void threePoints_ValidInput_StraightLine() {
        double x1 = 1;
        double y1 = 0;
        double x2 = 1;
        double y2 = -0.2;
        double x3 = 1;
        double y3 = -0.3;
        assertFalse(LaunchInterceptorConditions.helperCircle(x1, y1, x2, y2, x3, y3));
        x1 = -0.2;
        y1 = 0;
        x2 = 0;
        y2 = 0;
        x3 = 0.2;
        y3 = 0;
        assertFalse(LaunchInterceptorConditions.helperCircle(x1, y1, x2, y2, x3, y3));
    }
}
