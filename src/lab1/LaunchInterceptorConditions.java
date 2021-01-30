package lab1;

public class LaunchInterceptorConditions {

    /**
     * Returns true if the area formed by the points is larger than a
     *
     * @param x1 x position of first point
     * @param y1 y position of first point
     * @param x2 x position of second point
     * @param y2 y position of second point
     * @param x3 x position of third point
     * @param y3 y position of third point
     * @param a  area to check
     * @return True or false if conditions are met
     */
    public static boolean triangleAreaIsGreaterThanArea(double x1, double y1, double x2, double y2, double x3, double y3, double a) {
        return (Math.abs(x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2))) * 0.5 > a;
    }

    public static boolean condition0() {
        return false;
    }

    /**
     * Checks if the distance between two points is greater than LENGTH1.
     *
     * @param x1      the x coordinate of the first point.
     * @param y1      the y coordinate of the first point.
     * @param x2      the x coordinate of the second point.
     * @param y2      the y coordinate of the second point.
     * @param length1
     * @return true if the distance is greater than LENGTH1.
     */
    public static boolean helperDistance(double x1, double y1, double x2, double y2, double length1) {
        if (length1 < 0) throw new IllegalArgumentException("LENGTH1 cannot be a negative value");
        double distance = Math.hypot(x2 - x1, y2 - y1);
        return distance > length1;
    }

    public static boolean condition1() {
        return false;
    }

    /**
     * Checks if there exists a triangle that fits into or on a circle with radius 1.
     *
     * @param x1 the x coordinate of the first point.
     * @param y1 the y coordinate of the first point.
     * @param x2 the x coordinate of the second point.
     * @param y2 the y coordinate of the second point.
     * @param x3 the x coordinate of the third point.
     * @param y3 the y coordinate of the third point.
     * @return true there is a triangle that fits into or on a 1r circle, otherwise false.
     */
    public static boolean helperCircle(double x1, double y1, double x2, double y2, double x3, double y3, double r) {
        if (r <= 0) throw new IllegalArgumentException("The value of r must be greater than 0");
        double a = Math.hypot(x2 - x1, y2 - y1);
        double b = Math.hypot(x3 - x2, y3 - y2);
        double c = Math.hypot(x3 - x1, y3 - y1);
        if (a > 2 * r || b > 2 * r || c > 2 * r) return false;
        double angle1 = Math.acos((a * a + c * c - b * b) / (2 * a * c));
        double angleCenter = Math.acos((2 * r * r - b * b) / (2 * r * r));
        return angle1 * 2 >= angleCenter;
    }

    public static boolean condition2() {
        return false;
    }

    /**
     * There exists at least one set of three consecutive data points that are the vertices of a triangle 
     * with area greater than AREA1.
     * 
     * @param x
     * @param y
     * @param area1
     * @return
     */
    public static boolean condition3(double[] x, double[] y, double area1) {
        if (x.length != y.length)
            return false;

        if (x.length < 3)
            return false;

        if (area1 < 0)
            throw new IllegalArgumentException("Area an not be negative");
        
        for (int i = 0; i < y.length - 2; i++) {
            boolean conditionMet = triangleAreaIsGreaterThanArea(x[i], y[i], x[i + 1], y[i + 1], x[i + 2], y[i + 2], area1);
            if (conditionMet)
                return true;
        }
        return false;
    }

    public static boolean condition4(double[] x, double[] y, int quads) {
        return false;
    }

    public static boolean condition5(double[] x, double[] y) {
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

        double distanceBToA = Math.hypot(x2 - x1, y2 - y1);
        double distanceBToC = Math.hypot(x2 - x3, y2 - y3);
        double distanceAToC = Math.hypot(x1 - x3, y1 - y3);
        double angleInRadians = Math.acos((Math.pow(distanceBToA, 2) + Math.pow(distanceBToC, 2) - Math.pow(distanceAToC, 2))
                / (2 * distanceBToA * distanceBToC));
        return angleInRadians < (Math.PI - epsilon) || angleInRadians > (Math.PI + epsilon);
    }
}