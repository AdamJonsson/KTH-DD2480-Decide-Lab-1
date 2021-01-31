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

    /**
     * Returns true if there exists at least one set of K PTS consecutive data points that are a distance of more than length1 apart
     * and another set of data that are a distance of more than length2 apart
     * 
     * @param x
     * @param y
     * @param length1
     * @param length2
     * @param kPts
     * @return True of false
     */

    public static boolean condition12(double[] x, double[] y, double length1, double length2, int kPts) {
        boolean length1Fulfilled = false;
        boolean length2Fulfilled = false;
        // We need kPts intervening points: if kpts = 2, this means we need two points between (x1, y1) and (x2, y2)
        // meaning we need to set the separation to kPts + 1
        kPts += 1;
        if (x.length < kPts || y.length < kPts) {
            return false;
        }

        for (int i = 0; i < x.length - kPts; i += kpts) {
            double x1 = x[i];
            double y1 = y[i];

            double x2 = x[i + kPts];
            double y2 = y[i + kPts];

            if helperDistance(x1, y1, x2, y2, length1) {
                length1Fulfilled = true;
            }

            if helperDistance(x1, y1, x2, y2, length2) {
                length2Fulfilled = true;
            }
        }
        return (length1Fulfilled && length2Fulfilled);
    }

    public static boolean condition13(double[] x, double[] y, int aPts, int bPts, double radius1, double radius2, int numPoints) {
        return false;
    }

    public static boolean condition14(double[] x, double[] y, int ePts, int fPts, double area1, double area2, int numPoints) {
        return false;
    }
}