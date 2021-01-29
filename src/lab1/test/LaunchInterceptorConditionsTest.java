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

    /* CONDITION 0 */

    /**
     * Testing valid data for condition 0
     * @result true
     */
    @Test
    void co0_1() {
        double[] xList = new double[]{0, 1};
        double[] yList = new double[]{0, 1};
        double length1 = 2;
        boolean result = LaunchInterceptorConditions.condition0(xList, yList, length1);
        assertEquals(result, true);
    }

    /**
     * Testing valid negative data for condition 0
     * @result true
     */
    @Test
    void co0_2() {
        double[] xList = new double[]{-1, 0};
        double[] yList = new double[]{4, -1};
        double length1 = 12;
        boolean result = LaunchInterceptorConditions.condition0(xList, yList, length1);
        assertEquals(result, true);
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
     * @result false
     */
    @Test
    void co0_5() {
        double[] xList = new double[]{3, 4, 5};
        double[] yList = new double[]{3, 4, 5};
        double length1 = 1;
        boolean result = LaunchInterceptorConditions.condition0(xList, yList, length1);
        assertEquals(result, false);
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
        boolean result = LaunchInterceptorConditions.condition0(xList, yList, radius1);
        assertEquals(result, true);
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
        boolean result = LaunchInterceptorConditions.condition0(xList, yList, radius1);
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
        boolean result = LaunchInterceptorConditions.condition0(xList, yList, radius1);
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
        boolean result = LaunchInterceptorConditions.condition0(xList, yList, radius1);
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
        boolean result = LaunchInterceptorConditions.condition0(xList, yList, radius1);
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
        boolean result = LaunchInterceptorConditions.condition0(xList, yList, radius1);
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
        boolean result = LaunchInterceptorConditions.condition0(xList, yList, radius1);
        assertEquals(result, false);
    }


    /**
     * Testing two data points for condition 1
     * @result false
     */
    @Test
    void co1_7() {
        double[] xList = new double[]{1, 2};
        double[] yList = new double[]{1, 2};
        double radius1 = 20;
        boolean result = LaunchInterceptorConditions.condition0(xList, yList, radius1);
        assertEquals(result, false);
    }

    /**
     * Testing valid data points that are not consecutive but would return true if they were
     * @result false
     */
    @Test
    void co1_8() {
        double[] xList = new double[]{1, 2, 10000, 3};
        double[] yList = new double[]{1, 2, 10000, 3};
        double radius1 = 20;
        boolean result = LaunchInterceptorConditions.condition0(xList, yList, radius1);
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
        boolean result = LaunchInterceptorConditions.condition0(xList, yList, length1);
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
        boolean result = LaunchInterceptorConditions.condition0(xList, yList, epsilon);
        assertEquals(result, false);
    }

    /**
     * Testing valid data
     * @result true
     */
    @Test
    void co2_3() {
        double[] xList = new double[]{3, 4, 5};
        double[] yList = new double[]{3, 4, 5};
        double epsilon = 0;
        boolean result = LaunchInterceptorConditions.condition0(xList, yList, epsilon);
        assertEquals(result, true);
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
        boolean result = LaunchInterceptorConditions.condition0(xList, yList, epsilon);
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
        boolean result = LaunchInterceptorConditions.condition0(xList, yList, epsilon);
        assertEquals(result, false);
    }
    
}
