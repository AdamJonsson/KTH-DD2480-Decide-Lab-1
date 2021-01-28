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
        assertEquals(result, true);
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
    
}
