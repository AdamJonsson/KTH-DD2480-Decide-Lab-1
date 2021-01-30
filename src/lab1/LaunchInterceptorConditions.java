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
}