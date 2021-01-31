package lab1;

import java.awt.*;

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

    /**
     *
     * @author Tony Le
     * @return
     */
    public static boolean condition9(int[] x, int[] y, int c_pts, int d_pts, int epsilon, int numPoints) {
        if (numPoints < 5) return false;

        Point a = new Point(x[0],y[0]);
        Point vertex = new Point(x[0 + c_pts],y[0 + c_pts]);
        Point b = new Point(x[numPoints-1],y[numPoints-1]);

        if (a.getX() == vertex.getX() && a.getY() == vertex.getY()) {
            return false;
        } else if (b.getX() == vertex.getX() && b.getY() == vertex.getY()) {
            return false;
        }

        return true;
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