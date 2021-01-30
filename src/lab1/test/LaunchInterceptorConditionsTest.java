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
    void co6_5() {
        double[] xList = new double[]{1, 1, 1, 1};
        double[] yList = new double[]{1, 3, 2, 1};
        int nPts = 4;
        double dist = 1;
        int numPoints = 4;
        boolean result = LaunchInterceptorConditions.condition6(xList, yList, nPts, dist, numPoints);
        assertEquals(result, false);
    }

    /**
     * Should return false when numPoints < 3
     *
     * @result false
     */
    @Test
    void co7_1() {
        double[] xList = new double[]{1, 1};
        double[] yList = new double[]{1, 3};
        int kPts = 4;
        double length1 = 1;
        int numPoints = 2;
        boolean result = LaunchInterceptorConditions.condition7(xList, yList, kPts, length1, numPoints);
        assertEquals(result, false);
    }

    /**
     * Should return false since first and third point aren't distance >2 from each other
     *
     * @result false
     */
    @Test
    void co7_2() {
        double[] xList = new double[]{1, 2, 3};
        double[] yList = new double[]{1, 1, 1};
        int kPts = 1;
        double length1 = 2;
        int numPoints = 3;
        boolean result = LaunchInterceptorConditions.condition7(xList, yList, kPts, length1, numPoints);
        assertEquals(result, false);
    }

    /**
     * Should return true since first and third point are distance >2 from each other
     *
     * @result true
     */
    @Test
    void co7_3() {
        double[] xList = new double[]{1, 2, 4};
        double[] yList = new double[]{1, 1, 1};
        int kPts = 1;
        double length1 = 2;
        int numPoints = 3;
        boolean result = LaunchInterceptorConditions.condition7(xList, yList, kPts, length1, numPoints);
        assertEquals(result, true);
    }

    /**
     * Should return true since second and fifth point are distance >4 from each other
     *
     * @result true
     */
    @Test
    void co7_4() {
        double[] xList = new double[]{1, 2, 3, 4, 7};
        double[] yList = new double[]{1, 1, 1, 1, 1};
        int kPts = 2;
        double length1 = 4;
        int numPoints = 5;
        boolean result = LaunchInterceptorConditions.condition7(xList, yList, kPts, length1, numPoints);
        assertEquals(result, true);
    }

    /**
     * Should return false when numPoints < 5
     *
     * @result false
     */
    @Test
    void co8_1() {
        double[] xList = new double[]{0, 0, 0, 0};
        double[] yList = new double[]{0, 0, 0, 0};
        int aPts = 1;
        int bPts = 1;
        double radius = 1;
        int numPoints = 4;
        boolean result = LaunchInterceptorConditions.condition8(xList, yList, aPts, bPts, radius, numPoints);
        assertEquals(result, false);
    }

    /**
     * Should return false since the first and fifth point would be on a circle with center in third point
     *
     * @result false
     */
    @Test
    void co8_2() {
        double[] xList = new double[]{1, 2, 3, 4, 5};
        double[] yList = new double[]{0, 0, 0, 0, 0};
        int aPts = 1;
        int bPts = 1;
        double radius = 2;
        int numPoints = 5;
        boolean result = LaunchInterceptorConditions.condition8(xList, yList, aPts, bPts, radius, numPoints);
        assertEquals(result, false);
    }

    /**
     * Should return true due to the small radius
     *
     * @result true
     */
    @Test
    void co8_3() {
        double[] xList = new double[]{1, 2, 3, 4, 5, 6, 7};
        double[] yList = new double[]{0, 0, 0, 0, 0, 0, 0};
        int aPts = 1;
        int bPts = 2;
        double radius = 1;
        int numPoints = 7;
        boolean result = LaunchInterceptorConditions.condition8(xList, yList, aPts, bPts, radius, numPoints);
        assertEquals(result, true);
    }
}
