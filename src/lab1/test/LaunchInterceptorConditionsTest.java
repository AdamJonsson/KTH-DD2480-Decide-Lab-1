package lab1.test;

import org.junit.jupiter.api.Test;
import lab1.*;

import static org.junit.jupiter.api.Assertions.*;

public class LaunchInterceptorConditionsTest {

    /**
     * Testing two valid points and a valid LENGTH1.
     */
    @Test
    void length_ValidInput_GreaterThan() {
        double x1 = 1.5;
        double y1 = 1;
        double x2 = 5;
        double y2 = 1;
        double length1 = 3.2;
        assertTrue(LaunchInterceptorConditions.helperDistance(x1, y1, x2, y2, length1));
        length1 = 3.6;
        assertFalse(LaunchInterceptorConditions.helperDistance(x1, y1, x2, y2, length1));
        x1 = 1.5;
        y1 = -2;
        x2 = -2.2;
        y2 = 3;
        length1 = 6.2;
        assertTrue(LaunchInterceptorConditions.helperDistance(x1, y1, x2, y2, length1));
        length1 = 6.3;
        assertFalse(LaunchInterceptorConditions.helperDistance(x1, y1, x2, y2, length1));
    }

    /**
     * Testing and invalid input of negative LENGTH1.
     */
    @Test
    void length_InvalidInput_NegativeLength1() {
        double x1 = 1.5;
        double y1 = 1;
        double x2 = 5;
        double y2 = 1;
        double length1 = -3;
        assertThrows(IllegalArgumentException.class, () -> LaunchInterceptorConditions.helperDistance(x1, y1, x2, y2, length1));
    }
}
