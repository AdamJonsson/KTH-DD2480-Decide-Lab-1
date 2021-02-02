package lab1.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FUVTest {

    int[][] lcmInstructionsExample = new int[][]{
        {1, 1, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,},
        {1, 1, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,},
        {2, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,},
        {1, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,}};

    boolean[] puv = new boolean[]{true, false, true, true, true, true, true, true, true, true, true, true, true, true, true};
    boolean[] cmv = new boolean[]{false, true, true, true, false, false, false, false, false, false, false, false, false, false, false};
    PUM pum = new PUM(cmv, lcm);

    /**
     * Checking that the first example given by the examples
     * is false
     */
    @Test
    void assertFirstInstructionExampleIsFalse() {
        FUV fuv = new FUV(puv, pum);
        assertFalse(fuv.get(0));
    }

    /**
     * Checking that the second example given by the examples
     * is false
     */
    @Test
    void assertSecondInstructionExampleIsTrue() {
        FUV fuv = new FUV(puv, pum);
        assertTrue(fuv.get(1));
    }

    /**
     * Checking that the third example given by the examples
     * is false
     */
    @Test
    void assertThirdInstructionExampleIsTrue() {
        FUV fuv = new FUV(puv, pum);
        assertTrue(fuv.get(2));
    }

}