package lab1;

public class LaunchInterceptorConditions {
    public static boolean condition0(int[] listPoints, int len) {
        return false;
    }

    public static boolean condition1() {
        return false;
    }

    public static boolean condition2() {
        return false;
    }

    public static boolean condition3() {
        return false;
    }

    public static boolean condition4() {
        return false;
    }

    public static boolean condition5() {
        return false;
    }

    public static boolean condition6() {
        return false;
    }

    public static boolean condition7() {
        return false;
    }

    public static boolean condition8() {
        return false;
    }

    public static boolean condition9() {
        return false;
    }

    public static boolean condition10() {
        return false;
    }

    public static boolean condition11() {
        return false;
    }

    public static boolean condition12() {
        return false;
    }

    public static boolean condition13() {
        return false;
    }

    public static boolean condition14() {
        return false;
    }

    /**
     * Returns true if the following conditions are true: angle < (PI - epsilon)
     * or angle > (PI + epsilon). The second point of the three points is always the
     * vertex of the angle.
     * 
     * @param x1      x position of first point
     * @param y1      y position of first point
     * @param x2      x position of second point
     * @param y2      y position of second point
     * @param x3      x position of third point
     * @param y3      y position of third point
     * @param epsilon
     * @return True or false if conditions are met
     */
    public static boolean angleBetweenPointsOutsideEpsilon(double x1, double y1, double x2, double y2, double x3,
            double y3, double epsilon) {
        if (epsilon >= Math.PI)
            return false;
        if ((x1 == x2 && y1 == y2) || (x3 == x2 && y3 == y2))
            return false;

        double distanceBToA = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
        double distanceBToC = Math.sqrt(Math.pow((x2 - x3), 2) + Math.pow((y2 - y3), 2));
        double distanceAToC = Math.sqrt(Math.pow((x1 - x3), 2) + Math.pow((y1 - y3), 2));
        double angleInRadians = Math.acos((Math.pow(distanceBToA, 2) + Math.pow(distanceBToC, 2) - Math.pow(distanceAToC, 2))
                / (2 * distanceBToA * distanceBToC));
        return angleInRadians < (Math.PI - epsilon) || angleInRadians > (Math.PI + epsilon);
    }
}