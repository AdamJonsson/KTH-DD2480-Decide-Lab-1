package lab1.test;

import org.junit.jupiter.api.Test;
import lab1.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LaunchInterceptorConditionsTest {

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
}
