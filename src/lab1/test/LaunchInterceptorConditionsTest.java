package lab1.test;

import org.junit.jupiter.api.Test;
import lab1.*;

import static org.junit.jupiter.api.Assertions.*;

public class LaunchInterceptorConditionsTest {
    /**
     * Should return false if the first point coincides with the vertex
     */
    @Test
    void co9_1() {
        double[] x = new double[]{1, 2, 3, 1, 4, 5, 2};
        double[] y = new double[]{0, 0, 0, 0, 0, 0, 0};
        int c_pts = 2;
        int d_pts = 2;
        double epsilon = 0;
        boolean result = LaunchInterceptorConditions.condition9(x, y, c_pts, d_pts, epsilon, 7);
        assertEquals(result, false);
    }

    /**
     * Should return false if the last point coincides with the vertex
     */
    @Test
    void co9_2() {
        double[] x = new double[]{1, 2, 3, 2, 4, 5, 2};
        double[] y = new double[]{0, 0, 0, 0, 0, 0, 0};
        int c_pts = 2;
        int d_pts = 2;
        double epsilon = 0;
        boolean result = LaunchInterceptorConditions.condition9(x, y, c_pts, d_pts, epsilon, 7);
        assertEquals(result, false);
    }

    /**
     * Should return true if neither the first or the last point coincides with the vertex
     */
    @Test
    void co9_3() {
        double[] x = new double[] {0, 1, 2, 3, 4, 5, 6};
        double[] y = new double[] {0, 0, 0, 0, 0, 0, 1};
        int c_pts = 2;
        int d_pts = 2;
        double epsilon = 0;
        boolean result = LaunchInterceptorConditions.condition9(x, y, c_pts, d_pts, epsilon, 7);
        assertEquals(result, true);
    }

    /**
     * Should return false if NUMPOINTS < 5
     */
    @Test
    void co9_4() {
        double[] x = new double[]{0, 0, 0, 0};
        double[] y = new double[]{0, 0, 0, 0};
        int c_pts = 1;
        int d_pts = 1;
        double epsilon = 0;
        boolean result = LaunchInterceptorConditions.condition9(x, y, c_pts, d_pts, epsilon, 4);
        assertEquals(result, false);
    }

    /**
     * Returns true if angle < (PI - EPSILON)
     * angle = 90 deg = 1.5708 rad
     * epsilon = 1
     */
    @Test
    void co9_5() {
        double[] x = new double[] {0, 1, 2, 0, 4, 5, 3};
        double[] y = new double[] {3, 0, 0, 0, 0, 0, 0};
        int c_pts = 2;
        int d_pts = 2;
        double epsilon = 1;
        boolean result = LaunchInterceptorConditions.condition9(x, y, c_pts, d_pts, epsilon, 7);
        assertEquals(result, true);
    }

    /**
     * Returns true if angle > (PI + EPSILON)
     * angle = 360 deg = 6.28319
     * epsilon = 1
     */
    @Test
    void co9_6() {
        double[] x = new double[] {0, 1, 2, 3, 4, 5, 0};
        double[] y = new double[] {0, 0, 0, 0, 0, 0, 0};
        int c_pts = 2;
        int d_pts = 2;
        double epsilon = 1;
        boolean result = LaunchInterceptorConditions.condition9(x, y, c_pts, d_pts, epsilon, 7);
        assertEquals(result, true);
    }

    /**
     * Should return true if the set of 3 data points separated by exactly e_pts and f_pts
     * consecutive intervening points form a triangle with area greater than AREA1
     */
    @Test
    void co10_1() {
        double[] x = new double[]{0, 2, 3, 2, 4, 5, 4};
        double[] y = new double[]{0, 2, 3, 5, 4, 5, 0};
        int e_pts = 2;
        int f_pts = 2;
        double area1 = 0;
        boolean result = LaunchInterceptorConditions.condition10(x, y, e_pts, f_pts, area1, 7);
    }

    /**
     * Should return false if NUMPOINTS < 5
     */
    @Test
    void co10_2() {
        double[] x = new double[] {0, 0, 0, 0};
        double[] y = new double[] {0, 0, 0, 0};
        int e_pts = 0;
        int f_pts = 0;
        double area1 = 0;
        boolean result = LaunchInterceptorConditions.condition10(x, y, e_pts, f_pts, area1, 4);
        assertEquals(result, false);
    }

    /**
     * Should return true if there exists a set of 2 data points (x_i, y_i), (x_j, y_j)
     * separated by exactly G_PTS consecutive intervening points
     * such that x_j - x_i < 0, where i < j
     */
    @Test
    void co11_1() {
        double[] x = new double[]{1, 1, 0};
        double[] y = new double[]{3, 2, 0};
        int g_pts = 1;
        boolean result = LaunchInterceptorConditions.condition11(x, y, g_pts, 3);
    }

    /**
     * Should return false if NUMPOINTS < 3
     */
    @Test
    void co11_2() {
        double[] x = new double[] {0, 0};
        double[] y = new double[] {0, 0};
        int g_pts = 0;
        boolean result = LaunchInterceptorConditions.condition11(x, y, g_pts, 2);
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
