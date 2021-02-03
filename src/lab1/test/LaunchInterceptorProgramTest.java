package lab1.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import lab1.*;
import lab1.test.LaunchInterceptorProgramInputCases.InputDataProvider;

public class LaunchInterceptorProgramTest {

    /**
     * Test the entire program using the "testInputDecisionIsTrue.json" which is
     * structured in a way that many conditions are met and should result in the
     * final decision being true.
     */
    @Test
    void decide_ValidInput_ManyConditionsTrue() {
        // The testInputDecisionIsTrue.json file includes four points on a unit
        // circle and one point in the origin: (0, 0), (1, 0), (-1, 0), (0, 1), (0, -1).
        // There exist also LIC parameters such that the CMV because as follows:
        // Condition 0: True because LENGTH1 = 0.99
        // Condition 1: True because RADIUS1 = 1.01
        // Condition 2: True because EPSILON = PI/2 - 0.01
        // Condition 3: True because AREA1 = 0.49
        // Condition 4: True because Q_PTS = 5 and QUADS = 2
        // Condition 5: True because (0, 0), (1, 0) consecutive points exist
        // Condition 6: True because DIST = 0.99 and N_PTS = 5
        // Condition 7: True because LENGTH1 = 0.99 and K_PTS = 1
        // Condition 8: False because RADIUS1 = 1.01 and A_PTS = B_PTS = 1
        // Condition 9: True because EPSILON = PI/2 -0.01 and C_PTS = D_PTS = 1
        // Condition 10: True because AREA1 = 0.49 and E_PTS = F_PTS = 1
        // Condition 11: True because G_PTS = 1
        // Condition 12: True because LENGTH1 = 0.99 and LENGTH2 = 2 and K_PTS = 1
        // Condition 13: False, see condition 8
        // Condition 14: False, see condition 10
        // The LCM and PUV are set to test as many condition as possible
        assertTrue(LaunchInterceptorProgram.DECIDE(InputDataProvider.getInputDataWhereManyConditionsMet()));
    }

    /**
     * Test the entire program using the "testInputDecisionIsTrue.json" which is
     * structured in a way that should result in a few conditions being met and the
     * final decision being false.
     */
    @Test
    void decide_ValidInput_FewConditionsTrue() {
        // The testInputDecisionIsTrue.json file includes three points that forms
        // a small rectangle: (0, 0), (1, 0), (-1, 0).
        // There exist also LIC parameters such that the CMV because as follows:
        // Condition 0: False because LENGTH1 = 0.5
        // Condition 1: False because RADIUS1 = 0.01
        // Condition 2: False because EPSILON = PI - 0.01
        // Condition 3: False because AREA1 = 2
        // Condition 4: False because Q_PTS = 2 and QUADS = 3
        // Condition 5: False because of the points
        // Condition 6: False because DIST = 6 and N_PTS = 3
        // Condition 7: True because LENGTH1 = 0.1 and K_PTS = 1
        // Condition 8: False because to few points
        // Condition 9: False because to few points
        // Condition 10: False because to few points
        // Condition 11: False because G_PTS = 1
        // Condition 12: False because LENGTH1 = 10 and LENGTH2 = 0 and K_PTS = 1
        // Condition 13: False, see condition 8
        // Condition 14: False, see condition 10
        // The LCM and PUV are set to test some conditions
        assertFalse(LaunchInterceptorProgram.DECIDE(InputDataProvider.getInputDataWhereFewConditionsMet()));
    }

    /**
     * Test the program when the PUV is only a vector with false values. The DECIDE function
     * should therefore return true
     */
    @Test
    void decide_ValidInput_PUVIsFalse() {
        assertTrue(LaunchInterceptorProgram.DECIDE(InputDataProvider.getInputDataWherePUVIsFalse()));
    }

    /**
     * Test the program when the LCM only having "NOTUSED" values. The DECIDE function
     * should therefore also return true
     */
    @Test
    void decide_ValidInput_LCINoCConnection() {
        assertTrue(LaunchInterceptorProgram.DECIDE(InputDataProvider.getInputDataWhereLCMHaveNoConnection()));
    }

}
