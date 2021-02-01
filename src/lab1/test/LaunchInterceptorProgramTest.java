package lab1.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import lab1.*;

public class LaunchInterceptorProgramTest {

    /**
     * Test the hole program using the "testInputDecisionIsTrue.json" which is
     * structured in a way that should result in the final decision being true.
     */
    @Test
    void decide_ValidInput_ManyConditionsTrue() {
        // The testInputDecisionIsTrue.json file includes four points on a unit
        // circle and one point in the origin: (0, 0), (1, 0), (-1, 0), (0, 1), (0, -1).
        // There exist also LIC parameters such that the CMV because as follows:
        // Condition 0: True because LENGTH1 = 0.99
        // Condition 1: True because RADIUS1 = 1.01
        // Condition 2: True because EPSILON = PI/2 - 0.01
        // Condition 3: True because AREA1 = 0.99
        // Condition 4: True because Q_PTS = 5 and QUADS = 3
        // Condition 5: True because (1, 0), (-1, 0) consecutive points exist
        // Condition 6: True because DIST = 0.99 and N_PTS = 5
        // Condition 7: True because LENGTH1 = 0.99 and K_PTS = 1 
        // Condition 8: False because RADIUS1 = 1.01 and A_PTS = B_PTS = 1
        // Condition 9: True because EPSILON = PI/2 -0.01 and C_PTS = D_PTS = 1
        // Condition 10: False because AREA1 = 0.99 and E_PTS = F_PTS = 1
        // Condition 11: True because G_PTS = 1
        // Condition 12: True because LENGTH1 = 0.99 and LENGTH2 = 2 and K_PTS = 1
        // Condition 13: False, see condition 8 
        // Condition 14: False, see condition 10
        // The LCM and PUV are set to test as many condition as possible
        assertTrue(LaunchInterceptorProgram.DECIDE("inputAsJSON"));
    }

}
