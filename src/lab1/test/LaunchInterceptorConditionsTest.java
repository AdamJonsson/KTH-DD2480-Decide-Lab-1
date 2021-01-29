package lab1.test;

import org.junit.jupiter.api.Test;
import lab1.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LaunchInterceptorConditionsTest {
    // Dummy test
    @Test
    void co1() {
        LaunchInterceptorConditions.condition0(new int[2], 20);
        assertEquals(true, true);
    }

    /**
     * Should return false when numPoints < 3
     *
     * @result false
     */
    @Test
    void co6_1() {
        double[] xList = new double[]{3, 4};
        double[] yList = new double[]{0, 1};
        int nPts = 2;
        double dist = 0;
        int numPoints = 2;
        boolean result = LaunchInterceptorConditions.condition6(xList, yList, nPts, dist, numPoints);
        assertEquals(result, false);
    }

    /**
     * Should return false since all points are in a line
     *
     * @result false
     */
    @Test
    void co6_1() {
        double[] xList = new double[]{1, 2, 3};
        double[] yList = new double[]{1, 2, 3};
        int nPts = 3;
        double dist = 1;
        int numPoints = 3;
        boolean result = LaunchInterceptorConditions.condition6(xList, yList, nPts, dist, numPoints);
        assertEquals(result, false);
    }

    /**
     * Should return true since the distance is greater than 0
     *
     * @result true
     */
    @Test
    void co6_2() {
        double[] xList = new double[]{1, 1, 3};
        double[] yList = new double[]{1, 3, 2};
        int nPts = 3;
        double dist = 0;
        int numPoints = 3;
        boolean result = LaunchInterceptorConditions.condition6(xList, yList, nPts, dist, numPoints);
        assertEquals(result, true);
    }

    /**
     * Should return true since the distance is greater than 0
     *
     * @result true
     */
    @Test
    void co6_3() {
        double[] xList = new double[]{1, 1, 3};
        double[] yList = new double[]{1, 3, 2};
        int nPts = 3;
        double dist = 0;
        int numPoints = 3;
        boolean result = LaunchInterceptorConditions.condition6(xList, yList, nPts, dist, numPoints);
        assertEquals(result, true);
    }

    /**
     * Should return true since the end and start point is the same and distance to the middle point is >1
     *
     * @result true
     */
    @Test
    void co6_4() {
        double[] xList = new double[]{1, 1, 1};
        double[] yList = new double[]{1, 3, 1};
        int nPts = 3;
        double dist = 1;
        int numPoints = 3;
        boolean result = LaunchInterceptorConditions.condition6(xList, yList, nPts, dist, numPoints);
        assertEquals(result, true);
    }

    /**
     * Should return false since distance to all other points from the coincident point isn't >1
     *
     * @result false
     */
    @Test
    void co6_4() {
        double[] xList = new double[]{1, 1, 1, 1};
        double[] yList = new double[]{1, 3, 2, 1};
        int nPts = 4;
        double dist = 1;
        int numPoints = 4;
        boolean result = LaunchInterceptorConditions.condition6(xList, yList, nPts, dist, numPoints);
        assertEquals(result, false);
    }
}
