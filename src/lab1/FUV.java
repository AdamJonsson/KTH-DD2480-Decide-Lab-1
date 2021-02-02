/**
 * DD2480-VT21-1
 * Assignment #1: DECIDE
 *
 * @autors Adam Jonsson, Hovig Manjikian, Isak Vilhelmsson, Lara Rostami, Tony Le
 * @version 1.0
 * @since 02-02-2021
 */

package lab1;

public class FUV {
    private boolean[] FUV;

    // TODO: add comment and fix program
    /**
     *
     * @param PUV  
     * @param pumMatrix
     * @return
     */

    public FUV(boolean[] PUV, PUM pumMatrix) {
        FUV = new boolean[pumMatrix.getRowLength()];

        // FUV[i] should be set to true iff all elements in PUM[i][] are true
        for (int i = 0; i < pumMatrix.getRowLength(); i++) {
            boolean allTrueRow = true;
            for (int j = 0; j < pumMatrix.getColLength(); j++) {
                if (i == j) continue;

                if (!pumMatrix.get(i, j)) {
                    allTrueRow = false;
                }
            }
            if (allTrueRow) {
                FUV[i] = true;
            } else {
                FUV[i] = false;
            }
        }

        // FUV[i] should be set to true if PUV[i] is false, otherwise false (default)
        for (int i = 0; i < PUV.length; i++) {
            // FUV[i] should be set to true if PUV[i] is false
            if (!PUV[i]) {
                FUV[i] = true;
            }
        }
    }

    public boolean get(int i) {
        return FUV[i];
    }
}