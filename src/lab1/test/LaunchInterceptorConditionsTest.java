package lab1.test;

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
    void lic3_InvalidInput_NoTriangleGreaterThanArea1() {
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
    void lic3_InvalidInput_LessThanThreePoints() {
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
    void lic3_InvalidInput_NoTriangle() {
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
        assertFalse(LaunchInterceptorConditions.condition3(x, y, area1));
    }
}
