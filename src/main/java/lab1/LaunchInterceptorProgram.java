/**
 * DD2480-VT21-1
 * Assignment #1: DECIDE
 *
 * @autors Adam Jonsson, Hovig Manjikian, Isak Vilhelmsson, Lara Rostami, Tony Le
 * @version 1.0
 * @since 28-01-2021
 */

package lab1;

public class LaunchInterceptorProgram {

    /**
     * The main function of the program. This function will take the input data and calculate
     * the decision of launching. The decision will be sent to the standard output as a string "YES" or "NO".
     * The function will also return a boolean value.
     *
     * @param inputData all the input parameters numPoints, points, lcm, puv, lenght1, etc...
     * @return true if the decision is YES, false if the decision is NO.
     */
    public static boolean DECIDE(InputData inputData) {
        PUM pumMatrix = new PUM(inputData);
        FUV fuvVector = new FUV(inputData.puv, pumMatrix);
        for (int i = 0; i < 15; i++) {
            if (!fuvVector.get(i)) {
                System.out.println("NO");
                return false;
            }
        }
        System.out.println("YES");
        return true;
    }
}
