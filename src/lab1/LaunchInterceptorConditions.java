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
     * Checks if there exists three points that fits into or on a circle with radius r.
     *
     * @param x1 the x coordinate of the first point.
     * @param y1 the y coordinate of the first point.
     * @param x2 the x coordinate of the second point.
     * @param y2 the y coordinate of the second point.
     * @param x3 the x coordinate of the third point.
     * @param y3 the y coordinate of the third point.
     * @return true there are three points that fits into or on an r circle, otherwise false.
     */
    public static boolean helperCircle(double x1, double y1, double x2, double y2, double x3, double y3, double r) {
        if (r <= 0) throw new IllegalArgumentException("The value of r must be greater than 0");
        double scale = Math.pow(10, 8);
        double a = Math.round((Math.hypot(x2 - x1, y2 - y1)) * scale) / scale;
        double b = Math.round((Math.hypot(x3 - x2, y3 - y2)) * scale) / scale;
        double c = Math.round((Math.hypot(x3 - x1, y3 - y1)) * scale) / scale;
        if (a > 2 * r || b > 2 * r || c > 2 * r) return false;
        double angle1 = Math.acos((a * a + c * c - b * b) / (2 * a * c));

        if (Math.abs(angle1) < 0.00001 || Math.abs(angle1 - Math.PI) < 0.000001) { // When the three points are one a straight line
            return (a <= 2 * r && b <= 2 * r && c <= 2 * r);
        } else {
            double angleCenter = Math.acos((2 * r * r - b * b) / (2 * r * r));
            return angle1 * 2 >= angleCenter;
        }
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


    /**
     * There exists at least one set of two consecutive data points that are a distance greater than
     * the length, LENGTH1, apart.
     */
    public static boolean condition0(double[] xList, double[] yList, double lenght1) {
        if (xList.length != yList.length || lenght1 < 0)
            return false;

        for (int i = 0; i < xList.length - 1; i++) {
            boolean result = helperDistance(xList[i], yList[i], xList[i + 1], yList[i + 1], lenght1);
            if (result)
                return true;
        }
        return false;
    }

    /**
     * There exists at least one set of three consecutive data points that cannot all be contained
     * within or on a circle of radius RADIUS1.
     */
    public static boolean condition1(double[] xList, double[] yList, double radius1) {
        if (xList.length < 3)
            return false;

        if (xList.length != yList.length || radius1 < 0)
            return false;

        for (int i = 0; i < xList.length - 2; i++) {
            boolean result = helperCircle(xList[i], yList[i], xList[i + 1], yList[i + 1], xList[i + 2], yList[i + 2], radius1);
            if (result)
                return false;
        }
        return true;
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
        for (int i = 0; i < xList.length - 2; i++) {
            boolean result = angleBetweenPointsOutsideEpsilon(xList[i], yList[i], xList[i + 1], yList[i + 1], xList[i + 2], yList[i + 2], epsilon);
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
     * Returns true if there exists at least one set of Q PTS consecutive data points that lie in more 
     * than QUADS quadrants
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
            boolean[] pointsExistInQuadrant = new boolean[]{false, false, false, false};
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

    /**
     * There exists at least one set of nPTS consecutive data points such that at least one of the points lies
     * a distance greater than DIST from the line joining the first and last of these nPTS points.
     * If the first and last points of these nPTS are identical, then the calculated distance to compare with DIST
     * will be the distance from the coincident point to all other points of the nPTS consecutive points.
     * The condition is not met when NUMPOINTS < 3.
     *
     * @param x         the x-coordinates of the data points
     * @param y         the y-coordinates of the data points
     * @param nPts
     * @param dist
     * @param numPoints the number of data points.
     * @return true if such a point exist, otherwise false.
     */
    public static boolean condition6(double[] x, double[] y, int nPts, double dist, int numPoints) {
        if (numPoints < 3) return false;
        if (nPts > numPoints || nPts < 3) {
            throw new IllegalArgumentException("nPts must be in the the interval [3, NUMPOIUNTS]");
        }
        
        for (int i = 0; i <= numPoints - nPts; i++) {
            if (x[i + nPts - 1] == x[i] && y[i + nPts - 1] == y[i]) {
                for (int j = 1; j < nPts - 1; j++) {
                    if (helperDistance(x[i], y[i], x[i + j], y[i + j], dist)) return true;
                }
            } else {
                for (int j = 1; j < nPts - 1; j++) {
                    double a = Math.hypot(x[i + nPts - 1] - x[i], y[i + nPts - 1] - y[i]);
                    double b = Math.hypot(x[i + j] - x[i], y[i + j] - y[i]);
                    double c = Math.hypot(x[i + nPts - 1] - x[i + j], y[i + nPts - 1] - y[i + j]);
                    double angle = Math.acos((a * a + b * b - c * c) / (2 * a * b));
                    double pointDist = Math.sin(angle) * b;
                    if (pointDist > dist) return true;
                }
            }
        }

        return false;
    }

    /**
     * There exists at least one set of two data points separated by exactly kPTS consecutive
     * intervening points that are a distance greater than the length, LENGTH1, apart.
     * The condition is not met when NUMPOINTS < 3.
     *
     * @param xList     the x-coordinates of the data points
     * @param yList     the y-coordinates of the data points
     * @param kPts
     * @param length1
     * @param numPoints the number of data points.
     * @return true if such two points exist, otherwise false.
     */
    public static boolean condition7(double[] xList, double[] yList, int kPts, double length1, int numPoints) {
        if (length1 < 0)
            throw new IllegalArgumentException("length1 cannot be a negative number.");
        if (numPoints < 3) return false;
        for (int i = 0; i <= numPoints - kPts - 2; i++) {
            if (helperDistance(xList[i], yList[i], xList[i + kPts + 1], yList[i + kPts + 1], length1)) return true;
        }
        return false;
    }

    /**
     * There exists at least one set of three data points separated by exactly aPTS and bPTS consecutive
     * intervening points, respectively, that cannot be contained within or on a circle of radius RADIUS1.
     * The condition is not met when NUMPOINTS < 5.
     *
     * @param xList     the x-coordinates of the data points
     * @param yList     the y-coordinates of the data points
     * @param aPts
     * @param bPts
     * @param radius
     * @param numPoints the number of data points.
     * @return true if such three points exist, otherwise false.
     */
    public static boolean condition8(double[] xList, double[] yList, int aPts, int bPts, double radius, int numPoints) {
        if (numPoints < 5) return false;
        if (aPts < 1 || bPts < 1) throw new IllegalArgumentException();
        if (aPts + bPts > numPoints - 3) throw new IllegalArgumentException();
        for (int i = 0; i <= numPoints - aPts - bPts - 3; i++) {
            if (!helperCircle(
                    xList[i], yList[i],
                    xList[i + aPts + 1], yList[i + aPts + 1],
                    xList[i + aPts + bPts + 2], yList[i + aPts + bPts + 2],
                    radius))
                return true;
        }
        return false;
    }

    public static boolean condition9(double[] x, double[] y, int c_pts, int d_pts, double epsilon, int numPoints) {
        if (numPoints < 5) return false;

        for (int i = 0; i < (numPoints - c_pts - d_pts - 2); i++) {
            int firstIndex = i;
            int vertexIndex = i + c_pts + 1;
            int lastIndex = vertexIndex + d_pts + 1;

            if (angleBetweenPointsOutsideEpsilon(x[firstIndex], y[firstIndex], x[vertexIndex], y[vertexIndex], x[lastIndex], y[lastIndex], epsilon)) {
                return true;
            }
        }

        return false;
    }

    public static boolean condition10(double[] x, double[] y, int e_pts, int f_pts, double area1, int numPoints) {
        if (numPoints < 5) return false;

        boolean ret = true;

        for (int i = 0; i < (numPoints - e_pts - f_pts - 2); i++) {
            int firstIndex = i;
            int vertexIndex = i + e_pts + 1;
            int lastIndex = vertexIndex + f_pts + 1;

            if (!triangleAreaIsGreaterThanArea(x[firstIndex], y[firstIndex], x[vertexIndex], y[vertexIndex], x[lastIndex], y[lastIndex], area1)) {
                ret = false;
            }
        }

        return ret;
    }

    public static boolean condition11(double[] x, double[] y, int g_pts, int numPoints) {
        if (numPoints < 3) return false;

        boolean ret = false;

        for (int i = 0; i < (numPoints - g_pts - 1); i++) {
            int firstIndex = i;
            int secondIndex = i + g_pts + 1;

            if ((x[secondIndex] - x[firstIndex]) < 0) {
                ret = true;
            }
        }

        return ret;
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

    public static boolean condition12(double[] x, double[] y, double length1, double length2, int kPts, int numPoints) {
        boolean length1Fulfilled = false;
        boolean length2Fulfilled = false;
        // We need kPts intervening points: if kpts = 2, this means we need two points between (x1, y1) and (x2, y2)
        // meaning we need to set the separation to kPts + 1
        
        if (length2 < 0 || length1 < 0) {
            throw new IllegalArgumentException("length1 and length2 can not be negative");
        }
        
        if (kPts < 0) {
            throw new IllegalArgumentException("kPts must be bigger than 0");
        }

        if (x.length < kPts || y.length < kPts || numPoints < 3) {
            return false;
        }

        for (int i = 0; i < x.length - kPts - 1; i += 1) {
            double x1 = x[i];
            double y1 = y[i];

            double x2 = x[i + kPts + 1];
            double y2 = y[i + kPts + 1];

            if (helperDistance(x1, y1, x2, y2, length1)) {
                length1Fulfilled = true;
            }

            if (!helperDistance(x1, y1, x2, y2, length2)) {
                length2Fulfilled = true;
            }
        }
        return (length1Fulfilled && length2Fulfilled);
    }

    /**
     * Returns true if there exists at least one set of three data points, 
     * separated by exactly A PTS and B PTS consecutive intervening points, 
     * respectively, that cannot be contained within or on a circle of radius RADIUS1 and RADIUS2.
     * 
     * @param x
     * @param y
     * @param length1
     * @param length2
     * @param aPts
     * @param bPts
     * @return True of false
     */

    public static boolean condition13(double[] x, double[] y, int aPts, int bPts, double radius1, double radius2, int numPoints) {
        boolean radius1Fulfilled = false;
        boolean radius2Fulfilled = false;

        aPts += 1;
        bPts += 1;
        if (x.length < aPts + bPts || y.length < aPts + bPts || numPoints < 5) {
            return false;
        }

        for (int i = 0; i < x.length - aPts - bPts; i += 1) {
            double x1 = x[i];
            double y1 = y[i];

            double x2 = x[i + aPts];
            double y2 = y[i + aPts];

            double x3 = x[i + aPts + bPts];
            double y3 = y[i + aPts + bPts];

            if (!helperCircle(x1, y1, x2, y2, x3, y3, radius1)) {
                radius1Fulfilled = true;
            }

            if (helperCircle(x1, y1, x2, y2, x3, y3, radius2)) {
                radius2Fulfilled = true;
            }
        }
        return (radius1Fulfilled && radius2Fulfilled);
    }

    /**
     * Returns true if there exists at least one set of three data points, 
     * separated by exactly E PTS and F PTS consecutive intervening points, 
     * respectively, that have an area greater than AREA1 and AREA2
     * 
     * @param x
     * @param y
     * @param area1
     * @param area2
     * @param ePts
     * @param fPts
     * @return True of false
     */

    public static boolean condition14(double[] x, double[] y, int ePts, int fPts, double area1, double area2, int numPoints) {
        boolean triangle1Fulfilled = false;
        boolean triangle2Fulfilled = false;

        ePts += 1;
        fPts += 1;
        if (x.length < ePts + fPts || y.length < ePts + fPts || numPoints < 5) {
            return false;
        }

        for (int i = 0; i < x.length - ePts - fPts; i += 1) {
            double x1 = x[i];
            double y1 = y[i];

            double x2 = x[i + ePts];
            double y2 = y[i + ePts];

            double x3 = x[i + ePts + fPts];
            double y3 = y[i + ePts + fPts];

            if (triangleAreaIsGreaterThanArea(x1, y1, x2, y2, x3, y3, area1)) {
                triangle1Fulfilled = true;
            }

            if (!triangleAreaIsGreaterThanArea(x1, y1, x2, y2, x3, y3, area2)) {
                triangle2Fulfilled = true;
            }
        }
        return (triangle1Fulfilled && triangle2Fulfilled);
    }
}