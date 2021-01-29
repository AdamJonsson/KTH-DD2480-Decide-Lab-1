package lab1.test;

import org.junit.jupiter.api.Test;
import lab1.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LaunchInterceptorConditionsTest {

    /** Should return false if epsilon is not a valid value */
    @Test
    void angleBetweenPointsEpsilonNotValid() {
        double[] x = new double[]{-2, 0, 2};
        double[] y = new double[]{1, 0, 1};
        var result = LaunchInterceptorConditions.angleBetweenPointsOutsideEpsilon(x[0], y[0], x[1], y[1], x[2], y[2], 4);
        assertEquals(false, result);
    }

    /** Should return false if the angle between the points is not valid */
    @Test
    void angleBetweenAngleNoValid() {
        double[] x = new double[]{0, 0, 2};
        double[] y = new double[]{0, 0, 1};
        var result = LaunchInterceptorConditions.angleBetweenPointsOutsideEpsilon(x[0], y[0], x[1], y[1], x[2], y[2], 4);
        assertEquals(false, result);
    }

    /** Should return false as the angle is within the epsilon range */
    @Test
    void angleBetweenAngleWithinEpsilon() {
        double[] x = new double[]{-1, 0, 1};
        double[] y = new double[]{0, 0, 0};
        var result = LaunchInterceptorConditions.angleBetweenPointsOutsideEpsilon(x[0], y[0], x[1], y[1], x[2], y[2], Math.PI / 4);
        assertEquals(false, result);
    }

    /** Should return true as the angle is outside the epsilon range */
    @Test
    void angleBetweenAngleOutsideEpsilon() {
        double[] x = new double[]{-1, 0, 1};
        double[] y = new double[]{1, 0, 1};
        var result = LaunchInterceptorConditions.angleBetweenPointsOutsideEpsilon(x[0], y[0], x[1], y[1], x[2], y[2], Math.PI / 3);
        assertEquals(true, result);
    }

}
