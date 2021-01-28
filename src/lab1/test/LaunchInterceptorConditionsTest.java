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
        int[] xList = {0, 1};
        int[] yList = {0, 1};
        int length1 = 2;
        boolean result = LaunchInterceptorConditions.condition0(xList, yList, length1);
        assertEquals(result, true);
    }
    // Testing negative numbers for condition 0
    @Test
    void co0_2() {
        int[] xList = {-1, 0};
        int[] yList = {4, -1};
        int length1 = 12;
        boolean result = LaunchInterceptorConditions.condition0(xList, yList, length1);
        assertEquals(result, true);
    }
    
}
