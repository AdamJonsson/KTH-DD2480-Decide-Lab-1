package lab1.test;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import lab1.*;

import static org.junit.jupiter.api.Assertions.*;

public class LaunchInterceptorConditionsTest {

    /**
     * Testing the function for LIC 3 with a set of data that contains a valid triangle with area larger
     * than AREA1. All points have positive coordinates.
     */
    @Test
    void lic3_ValidInput_NoneNegativeCoordinates() {
        double[] x = new double[]{0, 2, 5, 6};
        double[] y = new double[]{0, 0, 2, 0};
        double area1 = 3;
        assertTrue(LaunchInterceptorConditions.condition3(x, y, area1));
    }

    /**
     * Testing the function for LIC 3 with a set of data that contains a valid triangle with area larger
     * than AREA1. Some of the points have negative coordinates.
     */
    @Test
    void lic3_ValidInput_NegativeCoordinates() {
        double[] x = new double[]{-2, 1, 2};
        double[] y = new double[]{-2, 1, -2};
        double area1 = 5;
        assertTrue(LaunchInterceptorConditions.condition3(x, y, area1));
        x = new double[]{-1, 0, 3};
        y = new double[]{0.5, -2.25, 0};
        area1 = 5.1;
        assertTrue(LaunchInterceptorConditions.condition3(x, y, area1));
    }

    /**
     * Testing the function for LIC 3 with a set of data that contains many valid triangles but none of
     * the triangles have an area larger than AREA1.
     */
    @Test
    void lic3_ValidInput_NoTriangleGreaterThanArea1() {
        double[] x = new double[]{0, 2, 5, 6};
        double[] y = new double[]{0, 0, 2, 0};
        double area1 = 5;
        assertFalse(LaunchInterceptorConditions.condition3(x, y, area1));
    }

    /**
     * Testing the function for LIC 3 with a set of data that hase less than 3 points. So there cannot
     * exist any triangle.
     */
    @Test
    void lic3_ValidInput_LessThanThreePoints() {
        double[] x = new double[]{0, 2};
        double[] y = new double[]{0, 0};
        double area1 = 0.01;
        assertFalse(LaunchInterceptorConditions.condition3(x, y, area1));
        x = new double[]{0};
        y = new double[]{0};
        assertFalse(LaunchInterceptorConditions.condition3(x, y, area1));
        x = new double[]{};
        y = new double[]{};
        assertFalse(LaunchInterceptorConditions.condition3(x, y, area1));
    }

    /**
     * Testing the function for LIC 3 with a set of data that do not contain any triangle.
     */
    @Test
    void lic3_ValidInput_NoTriangle() {
        double[] x = new double[]{0, 2, 5, 6};
        double[] y = new double[]{1, 1, 1, 1};
        double area1 = 0.01;
        assertFalse(LaunchInterceptorConditions.condition3(x, y, area1));
        x = new double[]{2, 2, 2, 2};
        y = new double[]{2, 2, 2, 2};
        assertFalse(LaunchInterceptorConditions.condition3(x, y, area1));
    }

    /**
     * Testing the function for LIC 3 with an invalid input of a negative AREA1.
     */
    @Test
    void lic3_InvalidInput_NegativeArea1() {
        double[] x = new double[]{-2, 1, 2};
        double[] y = new double[]{-2, 1, -2};
        double area1 = -5;
        assertThrows(IllegalArgumentException.class, () -> LaunchInterceptorConditions.condition3(x, y, area1));
    }

    /**
     * Testing a sequence of points that contain Q_PTS consecutive points in more than QUADS quadrants.
     */
    @Test
    void lic4_ValidInput_Contains() {
        double[] x = new double[]{1, 1, -1, 3};
        double[] y = new double[]{1, 3, 2, 2};
        int quads = 1;
        assertTrue(LaunchInterceptorConditions.condition4(x, y, quads));
        x = new double[]{1, 1.5, -1, 3, 3};
        y = new double[]{1, 3.2, 2, 2, -2};
        quads = 2;
        assertTrue(LaunchInterceptorConditions.condition4(x, y, quads));
        x = new double[]{-1, 1, -1, 1};
        y = new double[]{-1, 1, 1, -1};
        quads = 3;
        assertTrue(LaunchInterceptorConditions.condition4(x, y, quads));
    }

    /**
     * Testing a sequence of points that do not contain Q_PTS consecutive
     * points in more than QUADS quadrants.
     */
    @Test
    void lic4_ValidInput_DoesNotContain() {
        double[] x = new double[]{1, 1, -1, 3};
        double[] y = new double[]{1, 3, 2, 2};
        int quads = 2;
        assertFalse(LaunchInterceptorConditions.condition4(x, y, quads));
        x = new double[]{1, 1.5, -1, 3, 3};
        y = new double[]{1, 3.2, 2, 2, -2};
        quads = 3;
        assertFalse(LaunchInterceptorConditions.condition4(x, y, quads));
        x = new double[]{-1, -2, -1, -4};
        y = new double[]{-1, -1, -3, -1};
        quads = 1;
        assertFalse(LaunchInterceptorConditions.condition4(x, y, quads));
        x = new double[]{1, 2, -1, -4, -3, -2, 1, 4};
        y = new double[]{1, 1, 3, 1, -2, -2, -5, -1};
        quads = 2;
        assertFalse(LaunchInterceptorConditions.condition4(x, y, quads));
    }

    /**
     * Testing the ambiguous cases when a point is in between two or more quadrants.
     */
    @Test
    void lic4_ValidInput_AmbiguousCases() {
        double[] x = new double[]{0, 2, 1};
        double[] y = new double[]{0, 1, 3};
        int quads = 1;
        assertFalse(LaunchInterceptorConditions.condition4(x, y, quads));
        x = new double[]{0, -2.2, 1};
        y = new double[]{0, 1, -3};
        quads = 3;
        assertFalse(LaunchInterceptorConditions.condition4(x, y, quads));
        quads = 2;
        assertTrue(LaunchInterceptorConditions.condition4(x, y, quads));
        x = new double[]{-3, -2.2, -1};
        y = new double[]{0, 1, 2};
        quads = 1;
        assertFalse(LaunchInterceptorConditions.condition4(x, y, quads));
        x = new double[]{0, -2, -1};
        y = new double[]{-3, -1, -2};
        quads = 1;
        assertFalse(LaunchInterceptorConditions.condition4(x, y, quads));
    }

    /**
     * Testing an invalid input when QUADS is less than 1 or more than 3.
     */
    @Test
    void lic4_InvalidInput_InvalidQuads() {
        double[] x = new double[]{0, 2, 1};
        double[] y = new double[]{0, 1, 3};
        int quads1 = 0;
        assertThrows(IllegalArgumentException.class, () -> LaunchInterceptorConditions.condition4(x, y, quads1));
        int quads2 = 4;
        assertThrows(IllegalArgumentException.class, () -> LaunchInterceptorConditions.condition4(x, y, quads2));
    }

    /**
     * Testing with a valid input that contains two consecutive data points
     * that fulfills X[j] - X[i] < 0.
     */
    @Test
    void lic5_ValidInput_ContainsTwoPoint() {
        double[] x = new double[]{1.25, 4, 2, 3};
        double[] y = new double[]{1, 1, 1, 1};
        assertTrue(LaunchInterceptorConditions.condition5(x, y));
    }

    /**
     * Testing with a valid input that do not contain two consecutive data points
     * that fulfills X[j] - X[i] < 0.
     */
    @Test
    void lic5_ValidInput_DoNotContainsTwoPoint() {
        double[] x = new double[]{1, 2, 3};
        double[] y = new double[]{1, 1, 1};
        assertFalse(LaunchInterceptorConditions.condition5(x, y));
        x = new double[]{1, 2, 2};
        assertFalse(LaunchInterceptorConditions.condition5(x, y));
    }


    /**
     * Testing with a valid input that contains less than two data points.
     */
    @Test
    void lic5_ValidInput_LessThanTwoPoints() {
        double[] x = new double[]{1};
        double[] y = new double[]{1};
        assertFalse(LaunchInterceptorConditions.condition5(x, y));
        x = new double[]{};
        y = new double[]{};
        assertFalse(LaunchInterceptorConditions.condition5(x, y));
    }
}


