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

    /**
     * Checks if there exists a triangle that fits into or on a circle with radius r.
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

    /**
     * There exists at least one set of two consecutive data points that are a distance greater than
     * the length, LENGTH1, apart.
     *
     */
    public static boolean condition0(double[] xList, double[] yList, double lenght1) {
        if (xList.length != yList.length || lenght1 < 0)
            return false;

        for (int i = 0; i < xList.length-1; i++) {
            boolean result = helperDistance(xList[i], yList[i], xList[i+1], yList[i+1], lenght1);
            if (result)
                return true;
        }
        return false;
    }

    /**
     * There exists at least one set of three consecutive data points that cannot all be contained
     * within or on a circle of radius RADIUS1.
     *
     */
    public static boolean condition1(double[] xList, double[] yList, double radius1) {
        if (xList.length != yList.length || radius1 < 0)
            return false;

        for (int i = 0; i < xList.length-2; i++) {
            boolean result = helperCircle(xList[i], yList[i], xList[i+1], yList[i+1], xList[i+2], yList[i+2], radius1);
            if (result)
                return true;
        }
        return false;
    }

    /**
     * There exists at least one set of three consecutive data points which form an angle such that:
     * angle < (PI−EPSILON)
     * or
     * angle > (PI+EPSILON)
     * The second of the three consecutive points is always the vertex of the angle. If either the first
     * point or the last point (or both) coincides with the vertex, the angle is undefined and the LIC
     * is not satisfied by those three points.
     *
     * @return
     */
    public static boolean condition2(double[] xList, double[] yList, double epsilon) {
        for (int i = 0; i < xList.length-2; i++) {
            boolean result = angleBetweenPointsOutsideEpsilon(xList[i], yList[i], xList[i+1], yList[i+1], xList[i+2], yList[i+2], epsilon);
            if (result)
                return true;
        }
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
            throw new IllegalArgumentException("Area can not be negative");
        
        for (int i = 0; i < y.length - 2; i++) {
            boolean conditionMet = triangleAreaIsGreaterThanArea(x[i], y[i], x[i + 1], y[i + 1], x[i + 2], y[i + 2], area1);
            if (conditionMet)
                return true;
        }
        return false;
    }

    /**
     * Returns true if there exists at least one set of Q PTS consecutive data points that lie in more than QUADS quadrants
     * 
     * @param x
     * @param y
     * @param quads
     * @param qPts
     * @return True of false
     */
    public static boolean condition4(double[] x, double[] y, int quads, int qPts) {
        
        if (qPts < 2 || qPts > x.length)
            return false;
        
        if (quads > 3 || quads < 1)
            throw new IllegalArgumentException("quads must be between the value 1 and 3 inclusive");
        
        for (int i = 0; i <= x.length - qPts; i++) {
            boolean[] pointsExistInQuadrant = new boolean[] {false, false, false, false};
            for (int qPtsIndex = 0; qPtsIndex < qPts; qPtsIndex++) {
                double xPos = x[qPtsIndex + i];
                double yPos = y[qPtsIndex + i];

                // Check if point is in quadrant 1
                if (xPos >= 0 && yPos >= 0) {
                    pointsExistInQuadrant[0] = true;
                }

                // Check if point is in quadrant 2
                else if (xPos < 0 && yPos >= 0) {
                    pointsExistInQuadrant[1] = true;
                }
                
                // Check if point is in quadrant 3
                else if (xPos < 0 && yPos < 0) {
                    pointsExistInQuadrant[2] = true;
                }

                // Check if point is in quadrant 4
                else if (xPos > 0 && yPos < 0) {
                    pointsExistInQuadrant[3] = true;
                }
            }

            int numConsecutivePointsInDifferentQuadrants = 0;
            for (boolean inQuadrant : pointsExistInQuadrant) {
                if (inQuadrant) {
                    numConsecutivePointsInDifferentQuadrants++;
                }
            }

            if (numConsecutivePointsInDifferentQuadrants > quads)
                return true;
        }
        return false;
    }

    /**
     * There exists at least one set of two consecutive data points, (X[i],Y[i]) and (X[j],Y[j]), such
     * that X[j] - X[i] < 0. (where i = j-1)
     * 
     * @param x
     * @param y
     * @return True if the condition is met, otherwise false
     */
    public static boolean condition5(double[] x, double[] y) {
        if (x.length != y.length || x.length < 2)
            return false;

        for (int i = 0; i < x.length - 1; i++) {
            if (x[i + 1] - x[i] < 0)
                return true;
        }

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

    public static boolean condition9(double[] x, double[] y, int c_pts, int d_pts, double epsilon, int numPoints) {
        if (numPoints < 5) return false;

        int firstIndex = 0;
        int vertexIndex = c_pts + 1;
        int lastIndex = vertexIndex + d_pts + 1;

        if (x[firstIndex] == x[vertexIndex] && y[firstIndex] == y[vertexIndex]) {
            return false;
        } else if (x[lastIndex] == x[vertexIndex] && y[lastIndex] == y[vertexIndex]) {
            return false;
        }

        return true;
    }

    public static boolean condition10(double[] x, double[] y, int e_pts, int f_pts, double area1, int numPoints) {
        return false;
    }

    public static boolean condition11(double[] x, double[] y, int g_pts, int numPoints) {
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