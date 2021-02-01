package lab1.test.LaunchInterceptorProgramInputCases;

import lab1.InputData;

public class InputDataProvider {
    public static InputData  getInputDataWhereManyConditionsMet() {
        return new InputData(
            new double[]{0, 1, -1, 0, -1},
            new double[]{0, 0,  0, 1,  0},
            new String[][]{
                {"A", "A", "A", "A", "A", "A", "A", "A", "N", "A", "N", "A", "A", "N", "N"},
                {"A", "A", "A", "A", "A", "A", "A", "A", "N", "A", "N", "A", "A", "N", "N"},
                {"A", "A", "A", "A", "A", "A", "A", "A", "N", "A", "N", "A", "A", "N", "N"},
                {"A", "A", "A", "A", "A", "A", "A", "A", "N", "A", "N", "A", "A", "N", "N"},
                {"A", "A", "A", "A", "A", "A", "A", "A", "N", "A", "N", "A", "A", "N", "N"},
                {"A", "A", "A", "A", "A", "A", "A", "A", "N", "A", "N", "A", "A", "N", "N"},
                {"A", "A", "A", "A", "A", "A", "A", "A", "N", "A", "N", "A", "A", "N", "N"},
                {"A", "A", "A", "A", "A", "A", "A", "A", "N", "A", "N", "A", "A", "N", "N"},
                {"N", "N", "N", "N", "N", "N", "N", "N", "A", "N", "N", "N", "N", "N", "N"},
                {"A", "A", "A", "A", "A", "A", "A", "A", "N", "A", "N", "A", "A", "N", "N"},
                {"N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "A", "N", "N", "N", "N"},
                {"A", "A", "A", "A", "A", "A", "A", "A", "N", "A", "N", "A", "A", "N", "N"},
                {"A", "A", "A", "A", "A", "A", "A", "A", "N", "A", "N", "A", "A", "N", "N"},
                {"N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "A", "N"},
                {"N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "A"}
            },
            new boolean[] {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true },
            0.99,   // LENGTH1
            2,      // LENGTH2
            1.01,   // RADIUS1
            0,      // RADIUS2
            0,      // EPSILON
            0.49,   // AREA1
            0,      // AREA2
            3,      // QUADS
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
    }

    public static InputData  getInputDataWhereFewConditionsMet() {
        return new InputData(
            new double[]{0, 0, -1},
            new double[]{0, -1, 0},
            new String[][]{
                {"A", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N"},
                {"N", "A", "N", "N", "A", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N"},
                {"N", "N", "A", "N", "N", "N", "N", "N", "N", "A", "N", "N", "A", "N", "N"},
                {"N", "N", "N", "A", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N"},
                {"N", "N", "N", "N", "A", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N"},
                {"N", "A", "N", "N", "N", "A", "N", "N", "N", "N", "N", "N", "N", "N", "N"},
                {"N", "N", "N", "N", "N", "N", "A", "N", "N", "N", "N", "N", "N", "N", "N"},
                {"N", "N", "N", "N", "N", "N", "N", "A", "N", "N", "N", "N", "N", "N", "N"},
                {"N", "N", "N", "N", "N", "A", "N", "N", "A", "N", "N", "N", "N", "N", "N"},
                {"N", "N", "N", "N", "N", "N", "N", "N", "N", "A", "N", "N", "N", "N", "N"},
                {"N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "A", "N", "N", "N", "N"},
                {"N", "N", "N", "N", "N", "N", "N", "A", "N", "N", "N", "A", "N", "N", "N"},
                {"N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "A", "N", "N"},
                {"N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "A", "N"},
                {"N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "A"}
            },
            new boolean[] {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true },
            0.5,    // LENGTH1
            0,      // LENGTH2
            0.01,   // RADIUS1
            0,      // RADIUS2
            Math.PI - 0.01,     // EPSILON
            2,      // AREA1
            0,      // AREA2
            3,      // QUADS
            6,      // DIST
            1,      // A_PTS
            1,      // B_PTS
            1,      // C_PTS
            1,      // D_PTS
            1,      // E_PTS
            1,      // F_PTS
            1,      // G_PTS
            1,      // K_PTS
            3,      // N_PTS
            3       // Q_PTS
        );
    }

    public static InputData  getInputDataWherePUVIsFalse() {
        return new InputData(
            new double[]{0, 0, -1},
            new double[]{0, -1, 0},
            new String[][]{
                {"A", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N"},
                {"N", "A", "N", "N", "A", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N"},
                {"N", "N", "A", "N", "N", "N", "N", "N", "N", "A", "N", "N", "A", "N", "N"},
                {"N", "N", "N", "A", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N"},
                {"N", "N", "N", "N", "A", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N"},
                {"N", "A", "N", "N", "N", "A", "N", "N", "N", "N", "N", "N", "N", "N", "N"},
                {"N", "N", "N", "N", "N", "N", "A", "N", "N", "N", "N", "N", "N", "N", "N"},
                {"N", "N", "N", "N", "N", "N", "N", "A", "N", "N", "N", "N", "N", "N", "N"},
                {"N", "N", "N", "N", "N", "A", "N", "N", "A", "N", "N", "N", "N", "N", "N"},
                {"N", "N", "N", "N", "N", "N", "N", "N", "N", "A", "N", "N", "N", "N", "N"},
                {"N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "A", "N", "N", "N", "N"},
                {"N", "N", "N", "N", "N", "N", "N", "A", "N", "N", "N", "A", "N", "N", "N"},
                {"N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "A", "N", "N"},
                {"N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "A", "N"},
                {"N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "A"}
            },
            new boolean[] {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false },
            0.5,    // LENGTH1
            0,      // LENGTH2
            0.01,   // RADIUS1
            0,      // RADIUS2
            Math.PI - 0.01,     // EPSILON
            2,      // AREA1
            0,      // AREA2
            3,      // QUADS
            6,      // DIST
            1,      // A_PTS
            1,      // B_PTS
            1,      // C_PTS
            1,      // D_PTS
            1,      // E_PTS
            1,      // F_PTS
            1,      // G_PTS
            1,      // K_PTS
            3,      // N_PTS
            3       // Q_PTS
        );
    }

    public static InputData  getInputDataWhereLCMHaveNoConnection() {
        return new InputData(
            new double[]{0, 0, -1},
            new double[]{0, -1, 0},
            new String[][]{
                {"A", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N"},
                {"N", "A", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N"},
                {"N", "N", "A", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N"},
                {"N", "N", "N", "A", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N"},
                {"N", "N", "N", "N", "A", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N"},
                {"N", "N", "N", "N", "N", "A", "N", "N", "N", "N", "N", "N", "N", "N", "N"},
                {"N", "N", "N", "N", "N", "N", "A", "N", "N", "N", "N", "N", "N", "N", "N"},
                {"N", "N", "N", "N", "N", "N", "N", "A", "N", "N", "N", "N", "N", "N", "N"},
                {"N", "N", "N", "N", "N", "N", "N", "N", "A", "N", "N", "N", "N", "N", "N"},
                {"N", "N", "N", "N", "N", "N", "N", "N", "N", "A", "N", "N", "N", "N", "N"},
                {"N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "A", "N", "N", "N", "N"},
                {"N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "A", "N", "N", "N"},
                {"N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "A", "N", "N"},
                {"N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "A", "N"},
                {"N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "A"}
            },
            new boolean[] {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true },
            0.5,    // LENGTH1
            0,      // LENGTH2
            0.01,   // RADIUS1
            0,      // RADIUS2
            Math.PI - 0.01,     // EPSILON
            2,      // AREA1
            0,      // AREA2
            3,      // QUADS
            6,      // DIST
            1,      // A_PTS
            1,      // B_PTS
            1,      // C_PTS
            1,      // D_PTS
            1,      // E_PTS
            1,      // F_PTS
            1,      // G_PTS
            1,      // K_PTS
            3,      // N_PTS
            3       // Q_PTS
        );
    }
}
