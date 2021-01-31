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
     * Testing with a valid input of three points that make a triangle which fits into/on a circle of radius r.
     */
    @Test
    void threePoints_ValidInput_HaveTriangle() {
        double x1 = 1;
        double y1 = 0;
        double x2 = 0;
        double y2 = 1;
        double x3 = -1;
        double y3 = 0;
        double r = 1;
        assertTrue(LaunchInterceptorConditions.helperCircle(x1, y1, x2, y2, x3, y3, r));
        x1 = 1.2;
        y1 = 1.5;
        x2 = 1.2;
        y2 = 2.5;
        x3 = 2.2;
        y3 = 1.5;
        assertTrue(LaunchInterceptorConditions.helperCircle(x1, y1, x2, y2, x3, y3, r));
        x1 = 0.7071;
        y1 = 0.7071;
        x2 = -0.5;
        y2 = 0.866;
        x3 = -0.7071;
        y3 = -0.7071;
        assertTrue(LaunchInterceptorConditions.helperCircle(x1, y1, x2, y2, x3, y3, r));
        x1 = 3.031;
        y1 = 1.75;
        x2 = 1.75;
        y2 = 3.031;
        x3 = -1.75;
        y3 = -3.031;
        r = 3.5;
        assertTrue(LaunchInterceptorConditions.helperCircle(x1, y1, x2, y2, x3, y3, r));
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
        double r = 1;
        assertFalse(LaunchInterceptorConditions.helperCircle(x1, y1, x2, y2, x3, y3, r));
        x1 = 1.2;
        y1 = 3.5;
        x2 = 1.2;
        y2 = 2.5;
        x3 = 5.2;
        y3 = 1.5;
        assertFalse(LaunchInterceptorConditions.helperCircle(x1, y1, x2, y2, x3, y3, r));
        x1 = 0.7071;
        y1 = 0.7071;
        x2 = -0.7;
        y2 = 0.866;
        x3 = -0.7071;
        y3 = -0.7071;
        assertFalse(LaunchInterceptorConditions.helperCircle(x1, y1, x2, y2, x3, y3, r));
        x1 = 3.031;
        y1 = 1.75;
        x2 = 1.75;
        y2 = 3.031;
        x3 = -1.75;
        y3 = -3.031;
        r = 3.4;
        assertFalse(LaunchInterceptorConditions.helperCircle(x1, y1, x2, y2, x3, y3, r));
    }

    /* CONDITION 0 */

    /**
     * Testing valid data for condition 0
     * @result false
     */
    @Test
    void co0_1() {
        double[] xList = new double[]{0, 1};
        double[] yList = new double[]{0, 1};
        double length1 = 2;
        boolean result = LaunchInterceptorConditions.condition0(xList, yList, length1);
        assertEquals(result, false);
    }

    /**
     * Testing valid negative data for condition 0
     * @result false
     */
    @Test
    void co0_2() {
        double[] xList = new double[]{-1, 0};
        double[] yList = new double[]{4, -1};
        double length1 = 12;
        boolean result = LaunchInterceptorConditions.condition0(xList, yList, length1);
        assertEquals(result, false);
    }

    /**
     * Testing empty data for condition 0
     * @result false
     */
    @Test
    void co0_3() {
        double[] xList = new double[]{};
        double[] yList = new double[]{};
        double length1 = 0;
        boolean result = LaunchInterceptorConditions.condition0(xList, yList, length1);
        assertEquals(result, false);
    }

    /**
     * Testing empty data for condition 0
     * @result false
     */
    @Test
    void co0_4() {
        double[] xList = new double[]{};
        double[] yList = new double[]{};
        double length1 = 20;
        boolean result = LaunchInterceptorConditions.condition0(xList, yList, length1);
        assertEquals(result, false);
    }

    /**
     * Testing valid data for condition 0
     * @result true
     */
    @Test
    void co0_5() {
        double[] xList = new double[]{3, 4, 5};
        double[] yList = new double[]{3, 4, 5};
        double length1 = 1;
        boolean result = LaunchInterceptorConditions.condition0(xList, yList, length1);
        assertEquals(result, true);
    }

    /**
     * Testing large valid data for condition 0
     * @result false
     */
    @Test
    void co0_6() {
        double[] xList = new double[]{37545, 954326, 68643, 68887, 1, 0, 765};
        double[] yList = new double[]{656, 65, 1, 345, 678, -7};
        double length1 = 1;
        boolean result = LaunchInterceptorConditions.condition0(xList, yList, length1);
        assertEquals(result, false);
    }

    /**
     * Testing single data point for condition 0
     * @result false
     */
    @Test
    void co0_7() {
        double[] xList = new double[]{1};
        double[] yList = new double[]{1};
        double length1 = 1;
        boolean result = LaunchInterceptorConditions.condition0(xList, yList, length1);
        assertEquals(result, false);
    }

    /* CONDITION 1 */

    /**
     * Testing valid data for condition 0
     * @result true
     */
    @Test
    void co1_1() {
        double[] xList = new double[]{0, 1, 2};
        double[] yList = new double[]{0, 1, 2};
        double radius1 = 5;
        boolean result = LaunchInterceptorConditions.condition1(xList, yList, radius1);
        assertEquals(result, false);
    }

    /**
     * Testing valid negative data for condition 0
     * @result true
     */
    @Test
    void co1_2() {
        double[] xList = new double[]{-1, 0, -1};
        double[] yList = new double[]{4, -1, -1};
        double radius1 = 12;
        boolean result = LaunchInterceptorConditions.condition1(xList, yList, radius1);
        assertEquals(result, true);
    }

    /**
     * Testing empty data for condition 0
     * @result false
     */
    @Test
    void co1_3() {
        double[] xList = new double[]{};
        double[] yList = new double[]{};
        double radius1 = 0;
        boolean result = LaunchInterceptorConditions.condition1(xList, yList, radius1);
        assertEquals(result, false);
    }

    /**
     * Testing empty data for condition 0
     * @result false
     */
    @Test
    void co1_4() {
        double[] xList = new double[]{};
        double[] yList = new double[]{};
        double radius1 = 20;
        boolean result = LaunchInterceptorConditions.condition1(xList, yList, radius1);
        assertEquals(result, false);
    }

    /**
     * Testing valid data for condition 1
     * @result false
     */
    @Test
    void co1_5() {
        double[] xList = new double[]{3, 4, 5};
        double[] yList = new double[]{3, 4, 5};
        double radius1 = 1;
        boolean result = LaunchInterceptorConditions.condition1(xList, yList, radius1);
        assertEquals(result, false);
    }

    /**
     * Testing large valid data for condition 1
     * @result false
     */
    @Test
    void co1_6() {
        double[] xList = new double[]{37545, 954326, 68643, 68887, 1, 0, 765};
        double[] yList = new double[]{656, 65, 1, 345, 678, -7};
        double radius1 = 1;
        boolean result = LaunchInterceptorConditions.condition1(xList, yList, radius1);
        assertEquals(result, false);
    }

    /**
     * Testing single data point for condition 1
     * @result false
     */
    @Test
    void co1_7() {
        double[] xList = new double[]{1};
        double[] yList = new double[]{1};
        double radius1 = 20;
        boolean result = LaunchInterceptorConditions.condition1(xList, yList, radius1);
        assertEquals(result, false);
    }


    /**
     * Testing two data points for condition 1
     * @result false
     */
    @Test
    void co1_8() {
        double[] xList = new double[]{1, 2};
        double[] yList = new double[]{1, 2};
        double radius1 = 20;
        boolean result = LaunchInterceptorConditions.condition1(xList, yList, radius1);
        assertEquals(result, false);
    }

    /**
     * Testing valid data points that are not consecutive but would return true if they were
     * @result false
     */
    @Test
    void co1_9() {
        double[] xList = new double[]{1, 2, 10000, 3};
        double[] yList = new double[]{1, 2, 10000, 3};
        double radius1 = 20;
        boolean result = LaunchInterceptorConditions.condition1(xList, yList, radius1);
        assertEquals(result, false);
    }

    /* CONDITION 2 */

    /**
     * Testing valid data for angle of pi between points
     * @result false
     */
    @Test
    void co2_1() {
        double[] xList = new double[]{0, 1, 2};
        double[] yList = new double[]{0, 0, 0};
        double epsilon = 1;
        boolean result = LaunchInterceptorConditions.condition2(xList, yList, epsilon);
        assertEquals(result, false);
    }

    /**
     * Testing empty data
     * @result false
     */
    @Test
    void co2_2() {
        double[] xList = new double[]{};
        double[] yList = new double[]{};
        double epsilon = 3;
        boolean result = LaunchInterceptorConditions.condition2(xList, yList, epsilon);
        assertEquals(result, false);
    }

    /**
     * Testing valid data
     * @result false
     */
    @Test
    void co2_3() {
        double[] xList = new double[]{3, 4, 5};
        double[] yList = new double[]{3, 4, 5};
        double epsilon = 0;
        boolean result = LaunchInterceptorConditions.condition2(xList, yList, epsilon);
        assertEquals(result, false);
    }

    /**
     * Testing single data point
     * @result false
     */
    @Test
    void co2_4() {
        double[] xList = new double[]{3};
        double[] yList = new double[]{3};
        double epsilon = 3;
        boolean result = LaunchInterceptorConditions.condition2(xList, yList, epsilon);
        assertEquals(result, false);
    }

    /**
     * Testing two data points
     * @result false
     */
    @Test
    void co2_5() {
        double[] xList = new double[]{3, 4};
        double[] yList = new double[]{3, 4};
        double epsilon = 3;
        boolean result = LaunchInterceptorConditions.condition2(xList, yList, epsilon);
        assertEquals(result, false);
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
        double r = 1;
        assertFalse(LaunchInterceptorConditions.helperCircle(x1, y1, x2, y2, x3, y3, r));
        x1 = -0.2;
        y1 = 0;
        x2 = 0;
        y2 = 0;
        x3 = 0.2;
        y3 = 0;
        assertFalse(LaunchInterceptorConditions.helperCircle(x1, y1, x2, y2, x3, y3, r));
    }

    /**
     * Testing with an invalid input of radius 0 or less.
     */
    @Test
    void threePoints_InvalidInput_RZeroOrLess() {
        double x1 = 1;
        double y1 = 0;
        double x2 = 1;
        double y2 = -0.2;
        double x3 = 1;
        double y3 = -0.3;
        double r1 = 0;
        assertThrows(IllegalArgumentException.class, () -> LaunchInterceptorConditions.helperCircle(x1, y1, x2, y2, x3, y3, r1));
        double r2 = -1.5;
        assertThrows(IllegalArgumentException.class, () -> LaunchInterceptorConditions.helperCircle(x1, y1, x2, y2, x3, y3, r1));
    }

    /**
     * Check if triangle area of the points are on a single line
     */
    @Test
    void checkIfTriangleAreaIsZero() {
        double x1 = 0;
        double y1 = 0;
        double x2 = 1;
        double y2 = 1;
        double x3 = 2;
        double y3 = 2;
        double a = 3;
        boolean result = LaunchInterceptorConditions.triangleAreaIsGreaterThanArea(x1, y1, x2, y2, x3, y3, a);
        assertEquals(result, false);
    }

    /**
     * Check if a basic triangle pass the test
     */
    @Test
    void checkIfTriangleHasArea() {
        double x1 = 0;
        double y1 = 0;
        double x2 = 1;
        double y2 = 0;
        double x3 = 0;
        double y3 = 1;
        assertEquals(LaunchInterceptorConditions.triangleAreaIsGreaterThanArea(x1, y1, x2, y2, x3, y3, 0.55), false);
        assertEquals(LaunchInterceptorConditions.triangleAreaIsGreaterThanArea(x1, y1, x2, y2, x3, y3, 0.45), true);
    }

    /** Should return false if epsilon is not a valid value */
    @Test
    void angleBetweenPointsEpsilonNotValid() {
        double[] x = new double[]{-2, 0, 2};
        double[] y = new double[]{1, 0, 1};
        boolean result = LaunchInterceptorConditions.angleBetweenPointsOutsideEpsilon(x[0], y[0], x[1], y[1], x[2], y[2], 4);
        assertEquals(false, result);
    }

    /** Should return false if the angle between the points is not valid */
    @Test
    void angleBetweenAngleNoValid() {
        double[] x = new double[]{0, 0, 2};
        double[] y = new double[]{0, 0, 1};
        boolean result = LaunchInterceptorConditions.angleBetweenPointsOutsideEpsilon(x[0], y[0], x[1], y[1], x[2], y[2], 4);
        assertEquals(false, result);
    }

    /** Should return false as the angle is within the epsilon range */
    @Test
    void angleBetweenAngleWithinEpsilon() {
        double[] x = new double[]{-1, 0, 1};
        double[] y = new double[]{0, 0, 0};
        boolean result = LaunchInterceptorConditions.angleBetweenPointsOutsideEpsilon(x[0], y[0], x[1], y[1], x[2], y[2], Math.PI / 4);
        assertEquals(false, result);
    }

    /** Should return true as the angle is outside the epsilon range */
    @Test
    void angleBetweenAngleOutsideEpsilon() {
        double[] x = new double[]{-1, 0, 1};
        double[] y = new double[]{1, 0, 1};
        boolean result = LaunchInterceptorConditions.angleBetweenPointsOutsideEpsilon(x[0], y[0], x[1], y[1], x[2], y[2], Math.PI / 3);
        assertEquals(true, result);
    }

}
