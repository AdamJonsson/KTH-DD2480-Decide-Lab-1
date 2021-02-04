package lab1;

public class Main {
    /** 
     * This is used for demonstration purposes. Feel free to change the parameters in the input data
     * to test the program.
     */
    public static void main(String[] args) {
        InputData inputData = new InputData(
            new double[]{0, 1, -1, 0, 0},
            new double[]{0, 0,  0, 1,  -1},
            new int[][]{
                //LCM 0: NOTUSED, 1: ANDD, 2: ORR
                {1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1}
            },
            new boolean[] {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true },
            0.99,   // LENGTH1
            2,      // LENGTH2
            0.99,   // RADIUS1
            0.01,   // RADIUS2
            0,      // EPSILON
            0.49,   // AREA1
            0,      // AREA2
            2,      // QUADS
            0.99,   // DIST
            1,      // A_PTS
            1,      // B_PTS
            1,      // C_PTS
            1,      // D_PTS
            1,      // E_PTS
            1,      // F_PTS
            1,      // G_PTS
            1,      // K_PTS
            5,      // N_PTS
            5       // Q_PTS
        );
        LaunchInterceptorProgram.DECIDE(inputData);
    }
}