package lab1;

public class PUM {

    private boolean[][] pumMatrix;

    /**
     * Constructor used in testing.
     *
     * @param cvm a ready-made conditions-met vector
     * @param lcm a ready made logical-connector matrix. 0: NOTUSED, 1: ANDD, 2: ORR
     */
    public PUM(boolean[] cvm, int[][] lcm){
        pumMatrix = new boolean[lcm.length][lcm[0].length];

        for (int i = 0; i < lcm.length; i++) {
            for (int j = 0; j < lcm[0].length; j++) {
                if (lcm[i][j] == 0)
                    pumMatrix[i][j] = true;
                else if (lcm[i][j] == 1)
                    pumMatrix[i][j] = cvm[i] && cvm[j];
                else if (lcm[i][j] == 2)
                    pumMatrix[i][j] = cvm[i] || cvm[j];
                else
                    throw new IllegalArgumentException("Not a valid LCM!");
            }
        }
    }

    /**
     * Constructor that calculates its own cvm. Not used in testing.
     *
     * @param lcm a ready made logical-connector matrix. 0: NOTUSED, 1: ANDD, 2: ORR
     */
    public PUM(int[][] lcm){
        pumMatrix = new boolean[lcm.length][lcm[0].length];

    }

    /**
     * Gets the value of the (i,j) cell in the PUM matrix.
     *
     * @param i the row number.
     * @param j the column number.
     * @return the boolean value at (i,j).
     */
    public boolean get(int i, int j){
        if (i > 14 || i < 0 || j > 14 || j <0)
            throw new IllegalArgumentException("Not valid cell indices for the PUM!");
        if (i == j)
            throw new IllegalArgumentException("Not allowed to read PUM(i,j) if i ==j!");

        return pumMatrix[i][j];
    }
}
