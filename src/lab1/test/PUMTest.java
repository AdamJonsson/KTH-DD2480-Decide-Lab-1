package lab1.test;

import lab1.PUM;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class PUMTest {

    boolean[] cmv1 = new boolean[]{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true};
    boolean[] cmv2 = new boolean[]{false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};
    boolean[] cmv3 = new boolean[]{true, false, true, false, true, false, true, false, true, false, true, false, true, false, true};
    boolean[] cmvInstructionsExample = new boolean[]{false, true, true, true, false, false, false, false, false, false, false, false, false, false, false};


    // 0: NOTUSED, 1: ANDD, 2: ORR
    int[][] lcm1 = new int[][]{
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
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,}};

    int[][] lcm2 = new int[][]{
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,}};

    int[][] lcm3 = new int[][]{
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,}};

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


    /**
     * Testing The PUM with different valid input combinations.
     */
    @Test
    void PUM_ValidInput_ValidOutput() {
        PUM pum = new PUM(cmvInstructionsExample, lcmInstructionsExample);
        assertFalse(pum.get(0, 1));
        assertFalse(pum.get(0, 3));
        assertTrue(pum.get(1, 2));
        assertTrue(pum.get(2, 3));
        assertTrue(pum.get(6, 9));
        pum = new PUM(cmv1, lcm1);
        assertTrue(pum.get(0, 1));
        assertTrue(pum.get(3, 8));
        assertTrue(pum.get(4, 10));
        assertTrue(pum.get(1, 13));
        pum = new PUM(cmv1, lcm2);
        assertTrue(pum.get(0, 1));
        assertTrue(pum.get(3, 8));
        assertTrue(pum.get(4, 10));
        assertTrue(pum.get(1, 13));
        pum = new PUM(cmv1, lcm3);
        assertTrue(pum.get(0, 1));
        assertTrue(pum.get(3, 8));
        assertTrue(pum.get(4, 10));
        assertTrue(pum.get(1, 13));
        pum = new PUM(cmv2, lcm1);
        assertTrue(pum.get(0, 1));
        assertTrue(pum.get(3, 8));
        assertTrue(pum.get(4, 10));
        assertTrue(pum.get(1, 13));
        pum = new PUM(cmv2, lcm2);
        assertFalse(pum.get(0, 1));
        assertFalse(pum.get(3, 8));
        assertFalse(pum.get(4, 10));
        assertFalse(pum.get(1, 13));
        pum = new PUM(cmv2, lcm3);
        assertFalse(pum.get(0, 1));
        assertFalse(pum.get(3, 8));
        assertFalse(pum.get(4, 10));
        assertFalse(pum.get(1, 13));
        pum = new PUM(cmv3, lcm1);
        assertTrue(pum.get(0, 1));
        assertTrue(pum.get(3, 8));
        assertTrue(pum.get(4, 10));
        assertTrue(pum.get(1, 13));
        pum = new PUM(cmv3, lcm2);
        assertFalse(pum.get(0, 1));
        assertFalse(pum.get(3, 8));
        assertTrue(pum.get(4, 10));
        assertFalse(pum.get(1, 13));
        pum = new PUM(cmv3, lcm3);
        assertTrue(pum.get(0, 1));
        assertTrue(pum.get(3, 8));
        assertTrue(pum.get(4, 10));
        assertFalse(pum.get(1, 13));
    }

    /**
     * Testing the symmetry of the PUM matrix.
     */
    @Test
    void PUM_ValidInput_Symmetry() {
        PUM pum = new PUM(cmvInstructionsExample, lcmInstructionsExample);
        assertEquals(pum.get(0, 1), pum.get(1, 0));
        assertEquals(pum.get(1, 3), pum.get(3, 1));
        assertEquals(pum.get(2, 3), pum.get(3, 2));
        assertEquals(pum.get(4, 9), pum.get(9, 4));
    }

    /**
     * Testing the restriction on reading the cell (i,j) when i = j.
     */
    @Test
    void PUM_ReadingInvalidCell() {
        PUM pum = new PUM(cmvInstructionsExample, lcmInstructionsExample);
        assertThrows(IllegalArgumentException.class, () -> pum.get(0, 0));
        assertThrows(IllegalArgumentException.class, () -> pum.get(5, 5));
    }

    /**
     * Testing the bounds of i and j arguments. i and j must be in the interval [0, 14].
     */
    @Test
    void PUM_InvalidCellIndex() {
        PUM pum = new PUM(cmvInstructionsExample, lcmInstructionsExample);
        assertThrows(IllegalArgumentException.class, () -> pum.get(-1, 0));
        assertThrows(IllegalArgumentException.class, () -> pum.get(15, 0));
        assertThrows(IllegalArgumentException.class, () -> pum.get(0, -1));
        assertThrows(IllegalArgumentException.class, () -> pum.get(0, 15));
    }
}
