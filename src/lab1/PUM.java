package lab1;

import java.lang.reflect.Parameter;

public class PUM {

    private boolean[][] pumMatrix;
    boolean[] cmvVector;    //used when not performing tests

    /**
     * Constructor used in testing.
     *
     * @param cmv a ready-made conditions-met vector
     * @param lcm a ready made logical-connector matrix. 0: NOTUSED, 1: ANDD, 2: ORR
     */
    public PUM(boolean[] cmv, int[][] lcm){
        pumMatrix = new boolean[lcm.length][lcm[0].length];

        //calculate the pum
        for (int i = 0; i < lcm.length; i++) {
            for (int j = 0; j < lcm[0].length; j++) {
                if (lcm[i][j] == 0)
                    pumMatrix[i][j] = true;
                else if (lcm[i][j] == 1)
                    pumMatrix[i][j] = cmv[i] && cmv[j];
                else if (lcm[i][j] == 2)
                    pumMatrix[i][j] = cmv[i] || cmv[j];
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
    public PUM(LaunchInterceptorConditions lic, int[][] lcm, InputData params){
        pumMatrix = new boolean[lcm.length][lcm[0].length];
        cmvVector = new boolean[lcm.length];

        //calculate the cmv
        cmvVector[0] = LaunchInterceptorConditions.condition0(params.xList, params.yList, params.length1);
        cmvVector[1] = LaunchInterceptorConditions.condition1(params.xList, params.yList, params.radius1);
        cmvVector[2] = LaunchInterceptorConditions.condition2(params.xList, params.yList, params.epsilon);
        cmvVector[3] = LaunchInterceptorConditions.condition3(params.xList, params.yList, params.area1);
        cmvVector[4] = LaunchInterceptorConditions.condition4(params.xList, params.yList, params.quads, qPts);
        cmvVector[5] = LaunchInterceptorConditions.condition5(params.xList, params.yList);
        cmvVector[6] = LaunchInterceptorConditions.condition6(params.xList, params.yList, params.nPts, params.dist, params.getNumpoints());
        cmvVector[7] = LaunchInterceptorConditions.condition7(params.xList, params.yList, params.kPts, params.length1, params.getNumpoints());
        cmvVector[8] = LaunchInterceptorConditions.condition8(params.xList, params.yList, params.aPts, params.bPts, params.radius1, params.getNumpoints());
        cmvVector[9] = LaunchInterceptorConditions.condition9(params.xList, params.yList, params.cPts, params.dPts, params.epsilon, params.getNumpoints());
        cmvVector[10] = LaunchInterceptorConditions.condition10(params.xList, params.yList, params.ePts, params.fPts, params.area1, params.getNumpoints());
        cmvVector[11] = LaunchInterceptorConditions.condition11(params.xList, params.yList, params.gPts, params.getNumpoints());
        cmvVector[12] = LaunchInterceptorConditions.condition12(params.xList, params.yList, params.length1, params.length2, params.kPts);
        cmvVector[13] = LaunchInterceptorConditions.condition13(params.xList, params.yList, params.aPts, params.bPts, params.radius1, params.radius2, params.getNumpoints());
        cmvVector[14] = LaunchInterceptorConditions.condition14(params.xList, params.yList, params.ePts, params.fPts, params.area1, params.area2, params.getNumpoints());

        //calculate the pum
        for (int i = 0; i < lcm.length; i++) {
            for (int j = 0; j < lcm[0].length; j++) {
                if (lcm[i][j] == 0)
                    pumMatrix[i][j] = true;
                else if (lcm[i][j] == 1)
                    pumMatrix[i][j] = cmvVector[i] && cmvVector[j];
                else if (lcm[i][j] == 2)
                    pumMatrix[i][j] = cmvVector[i] || cmvVector[j];
                else
                    throw new IllegalArgumentException("Not a valid LCM!");
            }
        }

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
