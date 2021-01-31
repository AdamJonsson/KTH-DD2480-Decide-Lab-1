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
     * Should return false if the first point coincides with the vertex
     */
    @Test
    void co9_1 {
        double[] x = new double[] {1, 2, 3, 1, 4, 5, 2};
        double[] y = new double[] {0, 0, 0, 0, 0, 0, 0};
        int c_pts = 2;
        int d_pts = 2;
        int epsilon = 1;
        boolean result = LaunchInterceptorConditions.condition9(x, y, c_pts, d_pts, epsilon, 7);
        assertEquals(result, false);
    }

    /**
     * Should return false if the last point coincides with the vertex
     */
    @Test
    void co9_2 {
        double[] x = new double[] {1, 2, 3, 2, 4, 5, 2};
        double[] y = new double[] {0, 0, 0, 0, 0, 0, 0};
        int c_pts = 2;
        int d_pts = 2;
        int epsilon = 1;
        boolean result = LaunchInterceptorConditions.condition9(x, y, c_pts, d_pts, epsilon, 7);
        assertEquals(result, false);
    }

    /**
     * Should return false if NUMPOINTS < 5
     */
    @Test
    void co9_3 {
        double[] x = new double[] {0, 0, 0, 0};
        double[] y = new double[] {0, 0, 0, 0};
        int c_pts = 1;
        int d_pts = 1;
        int epsilon = 1;
        boolean result = LaunchInterceptorConditions.condition9(x, y, c_pts, d_pts, epsilon, 4);
        assertEquals(result, false);
    }

    /**
     * Should return true if the set of 3 data points separated by exactly e_pts and f_pts
     * consecutive intervening points form a triangle with area greater than AREA1
     */
    @Test
    void co10_1 {
        double[] x = new double[] {0, 2, 3, 2, 4, 5, 4};
        double[] y = new double[] {0, 2, 3, 5, 4, 5, 0};
        int e_pts = 2;
        int f_pts = 2;
        int area1 = 0;
        boolean result = LaunchInterceptorConditions.condition10(x, y, e_pts, f_pts, area1, 7);
        assertEquals(result, true);
    }

    /**
     * Should return false if NUMPOINTS < 5
     */
    @Test
    void co10_2 {
        double[] x = new double[] {0, 0, 0, 0};
        double[] y = new double[] {0, 0, 0, 0};
        int e_pts = 0;
        int f_pts = 0;
        int area1 = 0;
        boolean result = LaunchInterceptorConditions.condition10(x, y, e_pts, f_pts, area1, 4);
        assertEquals(result, false);
    }

    /**
     * Should return true if there exists a set of 2 data points (x_i, y_i), (x_j, y_j)
     * separated by exactly G_PTS consecutive intervening points
     * such that x_j - x_i < 0, where i < j
     */
    @Test
    void co11_1 {
        double[] x = new double[] {1, 1, 0};
        double[] y = new double[] {3, 2, 0};
        int g_pts = 1;
        boolean result = LaunchInterceptorConditions.condition11(x, y, g_pts, 3);
        assertEquals(result, true);
    }

    /**
     * Should return false if NUMPOINTS < 3
     */
    @Test
    void co11_2 {
        double[] x = new double[] {0, 0};
        double[] y = new double[] {0, 0};
        int g_pts = 0;
        boolean result = LaunchInterceptorConditions.condition11(x, y, g_pts, 2);
        assertEquals(result, false);
    }
}
