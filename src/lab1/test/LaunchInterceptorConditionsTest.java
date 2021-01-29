package lab1.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import lab1.LaunchInterceptorConditions;

public class LaunchInterceptorConditionsTest {
    // Dummy test
    @Test
    void co1() {
        LaunchInterceptorConditions.condition0(new int[2], 20);
        assertEquals(true, true);
    }

    /**
     * Condition12: The condition should return false as the number of points are
     * less than three
     */
    @Test
    void condition12NumPointsInvalid() {
        double[] x = new double[] { 1, 2 };
        double[] y = x;
        boolean result = LaunchInterceptorConditions.condition12(x, y, 1, 0, 0, 2);
        assertEquals(result, false);
    }

    /**
     * Condition12: The condition should return false as the length2 are less than 0
     */
    @Test
    void condition12MaxLengthInvalid() {
        double[] x = new double[] { 1, 2, 3, 4 };
        double[] y = x;
        boolean result = LaunchInterceptorConditions.condition12(x, y, 2, -2, -1, 4);
        assertEquals(result, false);
    }

    /** Condition12: If the K_PTS are greater than the */
    @Test
    void condition12KptsInvalid() {
        double[] x = new double[] { 1, 2, 3, 4 };
        double[] y = x;
        boolean result = LaunchInterceptorConditions.condition12(x, y, 3, 0, -1, 4);
        assertEquals(result, false);
    }

    /** Condition12: Tests number of conditions were the condition should be met */
    @Test
    void condition12DataPointAndDistances() {
        double[] x = new double[] { -1, 0, 2, 5, 9, 14, 20 };
        double[] y = new double[] { -1, 0, 2, 5, 9, 14, 20 };

        double marginCheckAmount = 0.1;

        // Using K_PTS = 0.
        // The biggest length that exist should be sqrt(6^2 + 6^2) = 8.49.
        // The smallest length that should exist should be 1.
        assertEquals(LaunchInterceptorConditions.condition12(x, y, 0, (8.49 - marginCheckAmount), (1 + marginCheckAmount), 7), true);
        assertEquals(LaunchInterceptorConditions.condition12(x, y, 0, (8.49 + marginCheckAmount), (1 + marginCheckAmount), 7), false);
        assertEquals(LaunchInterceptorConditions.condition12(x, y, 0, (8.49 - marginCheckAmount), (1 - marginCheckAmount), 7), false);

        // Using K_PTS = 1.
        // The biggest length that exist should be sqrt(11^2 + 11^2) = 15.55.
        // The smallest length that should exist should be sqrt(3^2 + 3^2) = 4.24.
        assertEquals(LaunchInterceptorConditions.condition12(x, y, 0, (15.55 - marginCheckAmount), (4.24 + marginCheckAmount), 7), true);
        assertEquals(LaunchInterceptorConditions.condition12(x, y, 0, (15.55 + marginCheckAmount), (4.24 + marginCheckAmount), 7), false);
        assertEquals(LaunchInterceptorConditions.condition12(x, y, 0, (15.55 - marginCheckAmount), (4.24 - marginCheckAmount), 7), false);
    }

    /** Condition13: Test to have an invalid number of points */
    @Test
    void condition13NumOfPointsInvalid() {
        // Points on the unit circles, including a point in the origin.
        double[] x = new double[] { 0, 1, -1, 0};
        double[] y = new double[] { 0, 0, 0, -1};
        assertEquals(LaunchInterceptorConditions.condition13(x, y, 0, 0, 1.1, 1, 4), false);
    }

    /** Condition13: Test tha the condition behaves as suspected when points are located on the unit circle */
    @Test
    void condition13PointsOnUnitCircle() {
        // Points on the unit circles, including a point in the origin.
        double[] x = new double[] { 0, 1, -1, 0, 0};
        double[] y = new double[] { 0, 0, 0, -1, 1};

        // Using A_PTS = B_PTS = 0, should only make it possible to create a unit circle as the smallest circle to contain all three data points.
        assertEquals(LaunchInterceptorConditions.condition13(x, y, 0, 0, 1.1, 1, 5), true);
        assertEquals(LaunchInterceptorConditions.condition13(x, y, 0, 0, 1.1, 0.9, 5), false);
        assertEquals(LaunchInterceptorConditions.condition13(x, y, 0, 0, 1, 1, 5), false);
    }

    /** Condition14: Test when there exist an area greater than AREA1 and a area less then AREA2 */
    @Test
    void condition14InvalidNumberOfPoints() {
        // Points that have two triangles when using E_PTS = F_PTS = 1. One with area 1 and another with area 2
        double[] x = new double[] { 0, 0, 0, 0};
        double[] y = new double[] { 0, 0, 1, 2};

        // Using E_PTS = F_PTS = 1, the condition should find two triangles that meet the condition 
        assertEquals(LaunchInterceptorConditions.condition14(x, y, 1, 1, 1.9, 1.1, 4), false);
    }

    /** Condition14: Test when there exist an area greater than AREA1 and a area less then AREA2 */
    @Test
    void condition14CorrectAreaForCondition() {
        // Points that have two triangles when using E_PTS = F_PTS = 1. One with area 1 and another with area 2
        double[] x = new double[] { 0, 0, 0, 0, 1, 2};
        double[] y = new double[] { 0, 0, 1, 2, 0, 0};

        // Using E_PTS = F_PTS = 1, the condition should find two triangles that meet the condition 
        assertEquals(LaunchInterceptorConditions.condition14(x, y, 1, 1, 1.9, 1.1, 6), true);
    }

    /** Condition14: Test when there do not exist an area greater than AREA1 and a area less then AREA2 */
    @Test
    void condition14IncorrectAreaForCondition() {
        // Points that have two triangles when using E_PTS = F_PTS = 1. One with area 1 and another with area 2
        double[] x = new double[] { 0, 0, 0, 0, 1, 2};
        double[] y = new double[] { 0, 0, 1, 2, 0, 0};

        // Using E_PTS = F_PTS = 1, the condition should find not find triangles that meet the condition 
        assertEquals(LaunchInterceptorConditions.condition14(x, y, 1, 1, 2.1, 0.9, 6), false);
        assertEquals(LaunchInterceptorConditions.condition14(x, y, 1, 1, 1.9, 0.9, 6), false);
        assertEquals(LaunchInterceptorConditions.condition14(x, y, 1, 1, 2.1, 1.1, 6), false);
    }


}
