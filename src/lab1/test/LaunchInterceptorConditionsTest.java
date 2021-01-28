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
        int[] xList = new int[]{0, 1};
        int[] yList = new int[]{0, 1};
        int length1 = 2;
        boolean result = LaunchInterceptorConditions.condition0(xList, yList, length1);
        assertEquals(result, true);
    }

    /**
     * Testing valid negative data for condition 0
     * @result true
     */
    @Test
    void co0_2() {
        int[] xList = new int[]{-1, 0};
        int[] yList = new int[]{4, -1};
        int length1 = 12;
        boolean result = LaunchInterceptorConditions.condition0(xList, yList, length1);
        assertEquals(result, true);
    }

    /**
     * Testing empty data for condition 0
     * @result false
     */
    @Test
    void co0_3() {
        int[] xList = new int[]{};
        int[] yList = new int[]{};
        int length1 = 0;
        boolean result = LaunchInterceptorConditions.condition0(xList, yList, length1);
        assertEquals(result, false);
    }

    /**
     * Testing empty data for condition 0
     * @result false
     */
    @Test
    void co0_4() {
        int[] xList = new int[]{};
        int[] yList = new int[]{};
        int length1 = 20;
        boolean result = LaunchInterceptorConditions.condition0(xList, yList, length1);
        assertEquals(result, false);
    }

    /**
     * Testing valid data for condition 0
     * @result false
     */
    @Test
    void co0_5() {
        int[] xList = new int[]{3, 4, 5};
        int[] yList = new int[]{3, 4, 5};
        int length1 = 1;
        boolean result = LaunchInterceptorConditions.condition0(xList, yList, length1);
        assertEquals(result, false);
    }

    /**
     * Testing large valid data for condition 0
     * @result false
     */
    @Test
    void co0_6() {
        int[] xList = new int[]{37545, 954326, 68643, 68887, 1, 0, 765};
        int[] yList = new int[]{656, 65, 1, 345, 678, -7};
        int length1 = 1;
        boolean result = LaunchInterceptorConditions.condition0(xList, yList, length1);
        assertEquals(result, false);
    }

    /**
     * Testing single data point for condition 0
     * @result false
     */
    @Test
    void co0_7() {
        int[] xList = new int[]{1};
        int[] yList = new int[]{1};
        int length1 = 1;
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
        int[] xList = new int[]{0, 1, 2};
        int[] yList = new int[]{0, 1, 2};
        int radius1 = 5;
        boolean result = LaunchInterceptorConditions.condition0(xList, yList, radius1);
        assertEquals(result, true);
    }

    /**
     * Testing valid negative data for condition 0
     * @result true
     */
    @Test
    void co1_2() {
        int[] xList = new int[]{-1, 0, -1};
        int[] yList = new int[]{4, -1, -1};
        int radius1 = 12;
        boolean result = LaunchInterceptorConditions.condition0(xList, yList, radius1);
        assertEquals(result, true);
    }

    /**
     * Testing empty data for condition 0
     * @result false
     */
    @Test
    void co1_3() {
        int[] xList = new int[]{};
        int[] yList = new int[]{};
        int radius1 = 0;
        boolean result = LaunchInterceptorConditions.condition0(xList, yList, radius1);
        assertEquals(result, false);
    }

    /**
     * Testing empty data for condition 0
     * @result false
     */
    @Test
    void co1_4() {
        int[] xList = new int[]{};
        int[] yList = new int[]{};
        int radius1 = 20;
        boolean result = LaunchInterceptorConditions.condition0(xList, yList, radius1);
        assertEquals(result, false);
    }

    /**
     * Testing valid data for condition 1
     * @result false
     */
    @Test
    void co1_5() {
        int[] xList = new int[]{3, 4, 5};
        int[] yList = new int[]{3, 4, 5};
        int radius1 = 1;
        boolean result = LaunchInterceptorConditions.condition0(xList, yList, radius1);
        assertEquals(result, false);
    }

    /**
     * Testing large valid data for condition 1
     * @result false
     */
    @Test
    void co1_6() {
        int[] xList = new int[]{37545, 954326, 68643, 68887, 1, 0, 765};
        int[] yList = new int[]{656, 65, 1, 345, 678, -7};
        int radius1 = 1;
        boolean result = LaunchInterceptorConditions.condition0(xList, yList, radius1);
        assertEquals(result, false);
    }

    /**
     * Testing single data point for condition 1
     * @result false
     */
    @Test
    void co1_7() {
        int[] xList = new int[]{1};
        int[] yList = new int[]{1};
        int radius1 = 20;
        boolean result = LaunchInterceptorConditions.condition0(xList, yList, radius1);
        assertEquals(result, false);
    }


    /**
     * Testing two data points for condition 1
     * @result false
     */
    @Test
    void co1_7() {
        int[] xList = new int[]{1, 2};
        int[] yList = new int[]{1, 2};
        int radius1 = 20;
        boolean result = LaunchInterceptorConditions.condition0(xList, yList, radius1);
        assertEquals(result, false);
    }

    /**
     * Testing valid data points that are not consecutive but would return true if they were
     * @result false
     */
    @Test
    void co1_8() {
        int[] xList = new int[]{1, 2, 10000, 3};
        int[] yList = new int[]{1, 2, 10000, 3};
        int radius1 = 20;
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
        int[] xList = new int[]{0, 1, 2};
        int[] yList = new int[]{0, 0, 0};
        int epsilon = 1;
        boolean result = LaunchInterceptorConditions.condition0(xList, yList, length1);
        assertEquals(result, false);
    }

    /**
     * Testing empty data
     * @result false
     */
    @Test
    void co2_2() {
        int[] xList = new int[]{};
        int[] yList = new int[]{};
        int epsilon = 3;
        boolean result = LaunchInterceptorConditions.condition0(xList, yList, epsilon);
        assertEquals(result, false);
    }

    /**
     * Testing valid data
     * @result true
     */
    @Test
    void co2_3() {
        int[] xList = new int[]{3, 4, 5};
        int[] yList = new int[]{3, 4, 5};
        int epsilon = 0;
        boolean result = LaunchInterceptorConditions.condition0(xList, yList, epsilon);
        assertEquals(result, true);
    }
    
}
