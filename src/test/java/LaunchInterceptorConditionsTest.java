package lab1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import lab1.*;

public class LaunchInterceptorConditionsTest {

    /**
     * Condition 0: Testing valid data for condition 0 using only two points.
     * Condition should result in false as the length1 = 2 is greater 
     * than the distance between the points 
     */
    @Test
    void lic0_ValidData_TwoSimplePoints() {
        double[] xList = new double[]{0, 1};
        double[] yList = new double[]{0, 1};
        double length1 = 2;
        boolean result = LaunchInterceptorConditions.condition0(xList, yList, length1);
        assertFalse(result);
    }

    /**
     * Condition 0: Testing valid negative data for condition 0 which should 
     * output false as the length1 is to big. 
     */
    @Test
    void lic0_ValidData_NegativePoints() {
        double[] xList = new double[]{-1, 0};
        double[] yList = new double[]{4, -1};
        double length1 = 12;
        boolean result = LaunchInterceptorConditions.condition0(xList, yList, length1);
        assertFalse(result);
    }

    /**
     * Condition 0: Testing with no points as input data and length zero. Should result in the condition 
     * outputting false
     */
    @Test
    void lic0_InvalidData_NotPoints_ZeroLength() {
        double[] xList = new double[]{};
        double[] yList = new double[]{};
        double length1 = 0;
        boolean result = LaunchInterceptorConditions.condition0(xList, yList, length1);
        assertFalse(result);
    }

    /**
     * Condition 0: Testing if the condition can handle no points, should result in the
     * condition outputting false
     */
    @Test
    void lic0_InvalidData_NotPoints() {
        double[] xList = new double[]{};
        double[] yList = new double[]{};
        double length1 = 20;
        boolean result = LaunchInterceptorConditions.condition0(xList, yList, length1);
        assertFalse(result);
    }

    /**
     * Condition 0: Test with three points and a length = 1. The points are in a line
     * and the hypotenuse should therefore be bigger than one. 
     */
    @Test
    void lic0_ValidData_LengthGreaterExist() {
        double[] xList = new double[]{3, 4, 5};
        double[] yList = new double[]{3, 4, 5};
        double length1 = 1;
        boolean result = LaunchInterceptorConditions.condition0(xList, yList, length1);
        assertTrue(result);
    }

    /**
     * Condition 0: Testing when the points are not valid as there do not exist
     * the same amount of elements in x and y.
     */
    @Test
    void lic0_InvalidData_PointsNotSameAmount() {
        double[] xList = new double[]{37545, 954326, 68643, 68887, 1, 0, 765};
        double[] yList = new double[]{656, 65, 1, 345, 678, -7};
        double length1 = 1;
        boolean result = LaunchInterceptorConditions.condition0(xList, yList, length1);
        assertFalse(result);
    }

    /**
     * Condition 0: Testing single data point and should return false as there is
     * no length.
     */
    @Test
    void lic0_ValidInput_OnePoint() {
        double[] xList = new double[]{1};
        double[] yList = new double[]{1};
        double length1 = 1;
        boolean result = LaunchInterceptorConditions.condition0(xList, yList, length1);
        assertFalse(result);
    }

    /**
     * Condition 1: A circle with radius 5 should contain the points given in the test and
     * therefore return false.
     */
    @Test
    void lic1_ValidData_PositivePoints() {
        double[] xList = new double[]{0, 1, 2};
        double[] yList = new double[]{0, 1, 2};
        double radius1 = 5;
        boolean result = LaunchInterceptorConditions.condition1(xList, yList, radius1);
        assertFalse(result);
    }

    /**
     * Condition 1: A circle with radius 12 should contain the points given in the test and
     * therefore return false. Testing with negative points. 
     */
    @Test
    void lic1_ValidData_NegativePoints() {
        double[] xList = new double[]{-1, 0, -1};
        double[] yList = new double[]{4, -1, -1};
        double radius1 = 12;
        boolean result = LaunchInterceptorConditions.condition1(xList, yList, radius1);
        assertFalse(result);
    }
    
    /**
     * Condition 1: The conditions do not have any points and should therefore result
     * in the condition being false. Test with radius zero to check that it really 
     * return false because of no points.
     */
    @Test
    void lic1_ValidData_NoPoints_ZeroRadius() {
        double[] xList = new double[]{};
        double[] yList = new double[]{};
        double radius1 = 0;
        boolean result = LaunchInterceptorConditions.condition1(xList, yList, radius1);
        assertFalse(result);
    }

    /**
     * Condition 1: The conditions do not have any points and should therefore result
     * in the condition being false. Test with radius 20 to check that it really 
     * return false because of no points.
     */
    @Test
    void lic1_ValidData_NoPoints_BigRadius() {
        double[] xList = new double[]{};
        double[] yList = new double[]{};
        double radius1 = 20;
        boolean result = LaunchInterceptorConditions.condition1(xList, yList, radius1);
        assertFalse(result);
    }

    /**
     * Condition 1: Testing with a small radius were the points can not be contained.
     * The condition should therefore return true.
     */
    @Test
    void lic1_ValidData_CircleToSmall() {
        double[] xList = new double[]{3, 4, 5};
        double[] yList = new double[]{3, 4, 5};
        double radius1 = 1;
        boolean result = LaunchInterceptorConditions.condition1(xList, yList, radius1);
        assertTrue(result);
    }

    /**
     * Condition 1: Testing with invalid points (x and y do not have the same amount of elements), 
     * should therefore return false.
     */
    @Test
    void lic1_InvalidData_PointsInvalid() {
        double[] xList = new double[]{37545, 954326, 68643, 68887, 1, 0, 765};
        double[] yList = new double[]{656, 65, 1, 345, 678, -7};
        double radius1 = 1;
        boolean result = LaunchInterceptorConditions.condition1(xList, yList, radius1);
        assertFalse(result);
    }

    /**
     * Condition 1: Test with a singel data points, should return false as the condition
     * ask for three points
     */
    @Test
    void lic1_InvalidData_OnePoint() {
        double[] xList = new double[]{1};
        double[] yList = new double[]{1};
        double radius1 = 20;
        boolean result = LaunchInterceptorConditions.condition1(xList, yList, radius1);
        assertFalse(result);
    }


    /**
     * Condition 1: Test with a two data points, should return false as the condition
     * ask for three points
     */
    @Test
    void lic1_InvalidData_TwoPoints() {
        double[] xList = new double[]{1, 2};
        double[] yList = new double[]{1, 2};
        double radius1 = 20;
        boolean result = LaunchInterceptorConditions.condition1(xList, yList, radius1);
        assertFalse(result);
    }

    /**
     * Condition 1: Testing valid data points that can not be contained with a big radius
     */
    @Test
    void lic1_ValidData_PointsCanNotBeContained() {
        double[] xList = new double[]{1, 2, 10000, 3};
        double[] yList = new double[]{1, 2, 10000, 3};
        double radius1 = 20;
        boolean result = LaunchInterceptorConditions.condition1(xList, yList, radius1);
        assertTrue(result);
    }

    /**
     * Condition 2: Testing valid data for angle of pi between points. Because the angle
     * is pi, the condition should be not bet as is impossible to be outside epsilon if
     * epsilon > 0
     */
    @Test
    void lic2_ValidData_PointAnglePI() {
        double[] xList = new double[]{0, 1, 2};
        double[] yList = new double[]{0, 0, 0};
        double epsilon = 1;
        boolean result = LaunchInterceptorConditions.condition2(xList, yList, epsilon);
        assertFalse(result);
    }

    /**
     * Condition 2: Testing with no points. Three points are needed to create a angle,
     * condition should therefore be false
     */
    @Test
    void lic2_InvalidData_NoPoints() {
        double[] xList = new double[]{};
        double[] yList = new double[]{};
        double epsilon = 3;
        boolean result = LaunchInterceptorConditions.condition2(xList, yList, epsilon);
        assertFalse(result);
    }

    /**
     * Condition 2: Testing with no points. Three points are needed to create a angle,
     * condition should therefore be false
     */
    @Test
    void lic2_InvalidData_OnePoint() {
        double[] xList = new double[]{3};
        double[] yList = new double[]{3};
        double epsilon = 3;
        boolean result = LaunchInterceptorConditions.condition2(xList, yList, epsilon);
        assertFalse(result);
    }

    /**
     * Condition 2: Testing with points such that it create an 45 degree angle.
     * Having epsilon one third of PI should result the condition being true
     */
    @Test
    void lic2_ValidData_PointAngleHalfPI() {
        double[] xList = new double[]{0, 0, -1};
        double[] yList = new double[]{0, 1, 0};
        double epsilon = Math.PI / 3;
        boolean result = LaunchInterceptorConditions.condition2(xList, yList, epsilon);
        assertTrue(result);
    }

    /**
     * Condition 3: Testing the function for LIC 3 with a set of data that contains a valid triangle with area larger
     * than AREA1. All points have positive coordinates.
     */
    @Test
    void lic3_ValidInput_NoneNegativeCoordinates() {
        double[] x = new double[]{0, 2, 5, 6};
        double[] y = new double[]{0, 0, 2, 0};
        double area1 = 3;
        assertTrue(LaunchInterceptorConditions.condition3(x, y, area1));
    }

    /**
     * Condition 3: Testing the function for LIC 3 with a set of data that contains a valid triangle with area larger
     * than AREA1. Some of the points have negative coordinates.
     */
    @Test
    void lic3_ValidInput_NegativeCoordinates() {
        double[] x = new double[]{-2, 1, 2};
        double[] y = new double[]{-2, 1, -2};
        double area1 = 5;
        assertTrue(LaunchInterceptorConditions.condition3(x, y, area1));
        x = new double[]{-1, 0, 3};
        y = new double[]{0.5, -2.25, 0};
        area1 = 5.1;
        assertTrue(LaunchInterceptorConditions.condition3(x, y, area1));
    }

    /**
     * Condition 3: Testing the function for LIC 3 with a set of data that contains many valid triangles but none of
     * the triangles have an area larger than AREA1.
     */
    @Test
    void lic3_ValidInput_NoTriangleGreaterThanArea1() {
        double[] x = new double[]{0, 2, 5, 6};
        double[] y = new double[]{0, 0, 2, 0};
        double area1 = 5;
        assertFalse(LaunchInterceptorConditions.condition3(x, y, area1));
    }

    /**
     * Condition 3: Testing the function for LIC 3 with a set of data that hase less than 3 points. So there cannot
     * exist any triangle.
     */
    @Test
    void lic3_ValidInput_LessThanThreePoints() {
        double[] x = new double[]{0, 2};
        double[] y = new double[]{0, 0};
        double area1 = 0.01;
        assertFalse(LaunchInterceptorConditions.condition3(x, y, area1));
        x = new double[]{0};
        y = new double[]{0};
        assertFalse(LaunchInterceptorConditions.condition3(x, y, area1));
        x = new double[]{};
        y = new double[]{};
        assertFalse(LaunchInterceptorConditions.condition3(x, y, area1));
    }

    /**
     * Condition 3: Testing the function for LIC 3 with a set of data that do not contain any triangle.
     */
    @Test
    void lic3_ValidInput_NoTriangle() {
        double[] x = new double[]{0, 2, 5, 6};
        double[] y = new double[]{1, 1, 1, 1};
        double area1 = 0.01;
        assertFalse(LaunchInterceptorConditions.condition3(x, y, area1));
        x = new double[]{2, 2, 2, 2};
        y = new double[]{2, 2, 2, 2};
        assertFalse(LaunchInterceptorConditions.condition3(x, y, area1));
    }

    /**
     * Condition 3:Testing the function for LIC 3 with an invalid input of a negative AREA1.
     */
    @Test
    void lic3_InvalidInput_NegativeArea1() {
        double[] x = new double[]{-2, 1, 2};
        double[] y = new double[]{-2, 1, -2};
        double area1 = -5;
        assertThrows(IllegalArgumentException.class, () -> LaunchInterceptorConditions.condition3(x, y, area1));
    }

    /**
     * Condition 4: Testing a sequence of points that contain Q_PTS consecutive points in more than QUADS quadrants.
     */
    @Test
    void lic4_ValidInput_Contains() {
        double[] x = new double[]{1, 1, -1, 3};
        double[] y = new double[]{1, 3, 2, 2};
        int quads = 1;
        assertTrue(LaunchInterceptorConditions.condition4(x, y, quads, x.length));
        x = new double[]{1, 1.5, -1, 3, 3};
        y = new double[]{1, 3.2, 2, 2, -2};
        quads = 2;
        assertTrue(LaunchInterceptorConditions.condition4(x, y, quads, x.length));
        x = new double[]{-1, 1, -1, 1};
        y = new double[]{-1, 1, 1, -1};
        quads = 3;
        assertTrue(LaunchInterceptorConditions.condition4(x, y, quads, x.length));
    }

    /**
     * Condition 4: Testing a sequence of points that do not contain Q_PTS consecutive
     * points in more than QUADS quadrants.
     */
    @Test
    void lic4_ValidInput_DoesNotContain() {
        double[] x = new double[]{1, 1, -1, 3};
        double[] y = new double[]{1, 3, 2, 2};
        int quads = 2;
        assertFalse(LaunchInterceptorConditions.condition4(x, y, quads, x.length));
        x = new double[]{1, 1.5, -1, 3, 3};
        y = new double[]{1, 3.2, 2, 2, -2};
        quads = 3;
        assertFalse(LaunchInterceptorConditions.condition4(x, y, quads, x.length));
        x = new double[]{-1, -2, -1, -4};
        y = new double[]{-1, -1, -3, -1};
        quads = 1;
        assertFalse(LaunchInterceptorConditions.condition4(x, y, quads, x.length));
        x = new double[]{1, 2, -1, -4, -3, -2, 1, 4};
        y = new double[]{1, 1, 3, 1, -2, -2, -5, -1};
        quads = 2;
        assertFalse(LaunchInterceptorConditions.condition4(x, y, quads, 2));
    }

    /**
     * Condition 4: Testing the ambiguous cases when a point is in between two or more quadrants.
     */
    @Test
    void lic4_ValidInput_AmbiguousCases() {
        double[] x = new double[]{0, 2, 1};
        double[] y = new double[]{0, 1, 3};
        int quads = 1;
        assertFalse(LaunchInterceptorConditions.condition4(x, y, quads, x.length));
        x = new double[]{0, -2.2, 1};
        y = new double[]{0, 1, -3};
        quads = 3;
        assertFalse(LaunchInterceptorConditions.condition4(x, y, quads, x.length));
        quads = 2;
        assertTrue(LaunchInterceptorConditions.condition4(x, y, quads, x.length));
        x = new double[]{-3, -2.2, -1};
        y = new double[]{0, 1, 2};
        quads = 1;
        assertFalse(LaunchInterceptorConditions.condition4(x, y, quads, x.length));
        x = new double[]{0, -2, -1};
        y = new double[]{-3, -1, -2};
        quads = 1;
        assertFalse(LaunchInterceptorConditions.condition4(x, y, quads, x.length));
    }

    /**
     * Condition 4: Testing an invalid input when QUADS is less than 1 or more than 3.
     */
    @Test
    void lic4_InvalidInput_InvalidQuads() {
        double[] x = new double[]{0, 2, 1};
        double[] y = new double[]{0, 1, 3};
        int quads1 = 0;
        assertThrows(IllegalArgumentException.class, () -> LaunchInterceptorConditions.condition4(x, y, quads1, x.length));
        int quads2 = 4;
        assertThrows(IllegalArgumentException.class, () -> LaunchInterceptorConditions.condition4(x, y, quads2, x.length));
    }

    /**
     * Condition 5: Testing with a valid input that contains two consecutive data points
     * that fulfills X[j] - X[i] < 0.
     */
    @Test
    void lic5_ValidInput_ContainsTwoPoint() {
        double[] x = new double[]{1.25, 4, 2, 3};
        double[] y = new double[]{1, 1, 1, 1};
        assertTrue(LaunchInterceptorConditions.condition5(x, y));
    }

    /**
     * Condition 5: Testing with a valid input that do not contain two consecutive data points
     * that fulfills X[j] - X[i] < 0.
     */
    @Test
    void lic5_ValidInput_DoNotContainsTwoPoint() {
        double[] x = new double[]{1, 2, 3};
        double[] y = new double[]{1, 1, 1};
        assertFalse(LaunchInterceptorConditions.condition5(x, y));
        x = new double[]{1, 2, 2};
        assertFalse(LaunchInterceptorConditions.condition5(x, y));
    }


    /**
     * Condition 5: Testing with a valid input that contains less than two data points.
     */
    @Test
    void lic5_ValidInput_LessThanTwoPoints() {
        double[] x = new double[]{1};
        double[] y = new double[]{1};
        assertFalse(LaunchInterceptorConditions.condition5(x, y));
        x = new double[]{};
        y = new double[]{};
        assertFalse(LaunchInterceptorConditions.condition5(x, y));
    }

    /**
     * Condition 6: Should return false when numPoints < 3
     */
    @Test
    void lic6_InvalidData_ToFewPoints() {
        double[] xList = new double[]{3, 4};
        double[] yList = new double[]{0, 1};
        int nPts = 2;
        double dist = 0;
        int numPoints = 2;
        boolean result = LaunchInterceptorConditions.condition6(xList, yList, nPts, dist, numPoints);
        assertEquals(result, false);
    }

    /**
     * Condition 6: Should return false since all points are in a line
     */
    @Test
    void lic6_ValidData_PointInALine() {
        double[] xList = new double[]{1, 2, 3};
        double[] yList = new double[]{1, 2, 3};
        int nPts = 3;
        double dist = 1;
        int numPoints = 3;
        boolean result = LaunchInterceptorConditions.condition6(xList, yList, nPts, dist, numPoints);
        assertFalse(result);
    }

    /**
     * Condition 6: Should return true since the distance is greater than 0
     */
    @Test
    void lic6_ValidData_DistanceAsZero() {
        double[] xList = new double[]{1, 1, 3};
        double[] yList = new double[]{1, 3, 2};
        int nPts = 3;
        double dist = 0;
        int numPoints = 3;
        boolean result = LaunchInterceptorConditions.condition6(xList, yList, nPts, dist, numPoints);
        assertTrue(result);
    }


    /**
     * Condition 6: Should return true since the end and start point is the same and 
     * distance to the middle point is >1
     */
    @Test
    void lic6_ValidData_MiddlePointDistance() {
        double[] xList = new double[]{1, 1, 1};
        double[] yList = new double[]{1, 3, 1};
        int nPts = 3;
        double dist = 1;
        int numPoints = 3;
        boolean result = LaunchInterceptorConditions.condition6(xList, yList, nPts, dist, numPoints);
        assertTrue(result);
    }

    /**
     * Condition 6: Should return true since distance to one of the points from the coincident point is > 1
     */
    @Test
    void lic6_ValidData_MultipleMiddlePoints() {
        double[] xList = new double[]{1, 1, 1, 1};
        double[] yList = new double[]{1, 3, 2, 1};
        int nPts = 4;
        double dist = 1;
        int numPoints = 4;
        boolean result = LaunchInterceptorConditions.condition6(xList, yList, nPts, dist, numPoints);
        assertTrue(result);
    }

    /**
     * Condition 7: Should return false when numPoints < 3
     */
    @Test
    void lic7_InvalidData_ToFewPoints() {
        double[] xList = new double[]{1, 1};
        double[] yList = new double[]{1, 3};
        int kPts = 4;
        double length1 = 1;
        int numPoints = 2;
        boolean result = LaunchInterceptorConditions.condition7(xList, yList, kPts, length1, numPoints);
        assertFalse(result);
    }

    /**
     * Condition 7: Should return false since first and third point aren't distance >2 from each other
     */
    @Test
    void lic7_ValidData_ToShortDistance() {
        double[] xList = new double[]{1, 2, 3};
        double[] yList = new double[]{1, 1, 1};
        int kPts = 1;
        double length1 = 2;
        int numPoints = 3;
        boolean result = LaunchInterceptorConditions.condition7(xList, yList, kPts, length1, numPoints);
        assertFalse(result);
    }

    /**
     * Condition 7: Should return true since first and third point are distance >2 from each other
     */
    @Test
    void lic7_ValidData_DistanceIsGreater() {
        double[] xList = new double[]{1, 2, 4};
        double[] yList = new double[]{1, 1, 1};
        int kPts = 1;
        double length1 = 2;
        int numPoints = 3;
        boolean result = LaunchInterceptorConditions.condition7(xList, yList, kPts, length1, numPoints);
        assertTrue(result);
    }

    /**
     * Condition 7: Should return true since second and fifth point are distance >4 from each other
     */
    @Test
    void lic7_ValidData_DistanceIsGreater_MorePoints() {
        double[] xList = new double[]{1, 2, 3, 4, 7};
        double[] yList = new double[]{1, 1, 1, 1, 1};
        int kPts = 2;
        double length1 = 4;
        int numPoints = 5;
        boolean result = LaunchInterceptorConditions.condition7(xList, yList, kPts, length1, numPoints);
        assertEquals(result, true);
    }

    /**
     * Condition 8: Should return false when numPoints < 5
     */
    @Test
    void lic8_InvalidData_ToFewPoints() {
        double[] xList = new double[]{0, 0, 0, 0};
        double[] yList = new double[]{0, 0, 0, 0};
        int aPts = 1;
        int bPts = 1;
        double radius = 1;
        int numPoints = 4;
        boolean result = LaunchInterceptorConditions.condition8(xList, yList, aPts, bPts, radius, numPoints);
        assertFalse(result);
    }


    /**
     * Condition 8: Should return false since the first and fifth point would be on a circle with 
     * center in third point
     */
    @Test
    void lic8_ValidData_PointInCircle() {
        double[] xList = new double[]{1, 2, 3, 4, 5};
        double[] yList = new double[]{0, 0, 0, 0, 0};
        int aPts = 1;
        int bPts = 1;
        double radius = 2;
        int numPoints = 5;
        boolean result = LaunchInterceptorConditions.condition8(xList, yList, aPts, bPts, radius, numPoints);
        assertFalse(result);
    }

    /**
     * Condition 8: Should return true due to the small radius
     */
    @Test
    void lic8_ValidData_ToSmallRadius() {
        double[] xList = new double[]{1, 2, 3, 4, 5, 6, 7};
        double[] yList = new double[]{0, 0, 0, 0, 0, 0, 0};
        int aPts = 1;
        int bPts = 2;
        double radius = 1;
        int numPoints = 7;
        boolean result = LaunchInterceptorConditions.condition8(xList, yList, aPts, bPts, radius, numPoints);
        assertTrue(result);
    }

    /**
     * Condition 9: Should return false if the first point coincides with the vertex
     */
    @Test
    void lic9_ValidData_FirstPointCoincideWithVertex() {
        double[] x = new double[]{1, 2, 3, 1, 4, 5, 2};
        double[] y = new double[]{0, 0, 0, 0, 0, 0, 0};
        int c_pts = 2;
        int d_pts = 2;
        double epsilon = 0;
        boolean result = LaunchInterceptorConditions.condition9(x, y, c_pts, d_pts, epsilon, 7);
        assertFalse(result);
    }

    /**
     * Condition 9: Should return false if the last point coincides with the vertex
     */
    @Test
    void lic9_ValidData_LastPointCoincideWithVertex() {
        double[] x = new double[]{1, 2, 3, 2, 4, 5, 2};
        double[] y = new double[]{0, 0, 0, 0, 0, 0, 0};
        int c_pts = 2;
        int d_pts = 2;
        double epsilon = 0;
        boolean result = LaunchInterceptorConditions.condition9(x, y, c_pts, d_pts, epsilon, 7);
        assertFalse(result);
    }

    /**
     * Condition 9: Should return true if neither the first or the last point coincides with the vertex
     */
    @Test
    void lic9_ValidData_AngleOutsideEpsilon() {
        double[] x = new double[] {0, 1, 2, 3, 4, 5, 6};
        double[] y = new double[] {0, 0, 0, 0, 0, 0, 1};
        int c_pts = 2;
        int d_pts = 2;
        double epsilon = 0;
        boolean result = LaunchInterceptorConditions.condition9(x, y, c_pts, d_pts, epsilon, 7);
        assertTrue(result);
    }

    /**
     * Condition 9: Should return false if NUMPOINTS < 5
     */
    @Test
    void lic9_InvalidData_PointsToFew() {
        double[] x = new double[]{0, 0, 0, 0};
        double[] y = new double[]{0, 0, 0, 0};
        int c_pts = 1;
        int d_pts = 1;
        double epsilon = 0;
        boolean result = LaunchInterceptorConditions.condition9(x, y, c_pts, d_pts, epsilon, 4);
        assertEquals(result, false);
    }

    /**
     * Condition 9: Returns true if angle < (PI - EPSILON)
     * angle = 90 deg = 1.5708 rad
     * epsilon = 1
     */
    @Test
    void lic9_ValidData_AnglePIOutsideEpsilon() {
        double[] x = new double[] {0, 1, 2, 0, 4, 5, 3};
        double[] y = new double[] {3, 0, 0, 0, 0, 0, 0};
        int c_pts = 2;
        int d_pts = 2;
        double epsilon = 1;
        boolean result = LaunchInterceptorConditions.condition9(x, y, c_pts, d_pts, epsilon, 7);
        assertEquals(result, true);
    }

    /**
     * Condition 9: Returns true if angle > (PI + EPSILON)
     * angle = 360 deg = 6.28319
     * epsilon = 1
     */
    @Test
    void lic9_ValidData_Angle2PIOutsideEpsilon() {
        double[] x = new double[] {0, 1, 2, 3, 4, 5, 0};
        double[] y = new double[] {0, 0, 0, 0, 0, 0, 0};
        int c_pts = 2;
        int d_pts = 2;
        double epsilon = 1;
        boolean result = LaunchInterceptorConditions.condition9(x, y, c_pts, d_pts, epsilon, 7);
        assertEquals(result, true);
    }

    /**
     * Condition 10: Should return true if the set of 3 data points separated by exactly e_pts and f_pts
     * consecutive intervening points form a triangle with area greater than AREA1
     */
    @Test
    void lic10_ValidData_AreaGreater() {
        double[] x = new double[]{0, 2, 3, 2, 4, 5, 4};
        double[] y = new double[]{0, 2, 3, 5, 4, 5, 0};
        int e_pts = 2;
        int f_pts = 2;
        double area1 = 0;
        boolean result = LaunchInterceptorConditions.condition10(x, y, e_pts, f_pts, area1, 7);
        assertEquals(result, true);
    }

    /**
     * Condition 10: Should return false if NUMPOINTS < 5
     */
    @Test
    void lic10_InvalidData_ToFewPoints() {
        double[] x = new double[] {0, 0, 0, 0};
        double[] y = new double[] {0, 0, 0, 0};
        int e_pts = 0;
        int f_pts = 0;
        double area1 = 0;
        boolean result = LaunchInterceptorConditions.condition10(x, y, e_pts, f_pts, area1, 4);
        assertEquals(result, false);
    }

    /**
     * Condition 11: Should return true if there exists a set of 2 data points (x_i, y_i), (x_j, y_j)
     * separated by exactly G_PTS consecutive intervening points
     * such that x_j - x_i < 0, where i < j
     */
    @Test
    void lic11_ValidData_CheckConditionsMet() {
        double[] x = new double[]{1, 1, 0};
        double[] y = new double[]{3, 2, 0};
        int g_pts = 1;
        boolean result = LaunchInterceptorConditions.condition11(x, y, g_pts, 3);
        assertEquals(result, true);
    }

    /**
     * Condition 11: Should return false if there doesn't exist a set of 2 data points (x_i, y_i), (x_j, y_j)
     * separated by exactly G_PTS consecutive intervening points
     * such that x_j - x_i < 0, where i < j
     */
    @Test
    void lic11_ValidData_CheckConditionsNotMet() {
        double[] x = new double[]{0, 1, 2};
        double[] y = new double[]{0, 2, 3};
        int g_pts = 1;
        boolean result = LaunchInterceptorConditions.condition11(x, y, g_pts, 3);
        assertEquals(result, false);
    }

    /**
     * Condition 11: Should return false if NUMPOINTS < 3
     */
    @Test
    void lic11_InvalidData_ToFewPoints() {
        double[] x = new double[] {0, 0};
        double[] y = new double[] {0, 0};
        int g_pts = 0;
        boolean result = LaunchInterceptorConditions.condition11(x, y, g_pts, 2);
        assertEquals(result, false);
    }

    /**
     * Condition12: The condition should return false as the number of points are
     * less than three
     */
    @Test
    void lic12_InvalidData_NumPointsInvalid() {
        double[] x = new double[] { 1, 2 };
        double[] y = x;
        boolean result = LaunchInterceptorConditions.condition12(x, y, 1, 0, 0, 2);
        assertEquals(result, false);
    }

    /**
     * Condition 12: The condition should return false as the length2 are less than 0
     */
    @Test
    void lic12_InvalidData_MaxLengthInvalid() {
        double[] x = new double[] { 1, 2, 3, 4 };
        double[] y = x;
        assertThrows(IllegalArgumentException.class, () -> LaunchInterceptorConditions.condition12(x, y, 2, -2, -1, 4));
    }
    
    /** Condition 12: Should return false If the K_PTS are negative */
    @Test
    void lic12_InvalidData_KptsInvalid() {
        double[] x = new double[] { 1, 2, 3, 4 };
        double[] y = x;
        assertThrows(IllegalArgumentException.class, () -> LaunchInterceptorConditions.condition12(x, y, 3, 0, -1, 4));
    }

    /** 
     * Condition 12: Check for multiple distances and that the condition return correct output
     * See code body for more details.
     */
    @Test
    void lic12_ValidData_DataPointAndDistances() {
        double[] x = new double[] { -1, 0, 2, 5, 9, 14, 20 };
        double[] y = new double[] { -1, 0, 2, 5, 9, 14, 20 };

        double marginCheckAmount = 0.1;

        // Using K_PTS = 0.
        // The biggest length that exist should be sqrt(6^2 + 6^2) = 8.49.
        // The smallest length that should exist should be 1.41.
        assertEquals(LaunchInterceptorConditions.condition12(x, y, (8.49 - marginCheckAmount), (1.41 + marginCheckAmount), 0, 7), true);
        assertEquals(LaunchInterceptorConditions.condition12(x, y, (8.49 + marginCheckAmount), (1.41 + marginCheckAmount), 0, 7), false);
        assertEquals(LaunchInterceptorConditions.condition12(x, y, (8.49 - marginCheckAmount), (1.41 - marginCheckAmount), 0, 7), false);

        // Using K_PTS = 1.
        // The biggest length that exist should be sqrt(11^2 + 11^2) = 15.55.
        // The smallest length that should exist should be sqrt(3^2 + 3^2) = 4.24.
        assertEquals(LaunchInterceptorConditions.condition12(x, y, (15.55 - marginCheckAmount), (4.24 + marginCheckAmount), 1, 7), true);
        assertEquals(LaunchInterceptorConditions.condition12(x, y, (15.55 + marginCheckAmount), (4.24 + marginCheckAmount), 1, 7), false);
        assertEquals(LaunchInterceptorConditions.condition12(x, y, (15.55 - marginCheckAmount), (4.24 - marginCheckAmount), 1, 7), false);
    }

    /** Condition13: Should return false as the number of points need to be at least five */
    @Test
    void lic13_InvalidData_NumOfPointsInvalid() {
        // Points on the unit circles, including a point in the origin.
        double[] x = new double[] { 0, 1, -1, 0};
        double[] y = new double[] { 0, 0, 0, -1};
        assertEquals(LaunchInterceptorConditions.condition13(x, y, 0, 0, 1.1, 1, 4), false);
    }

    /** Condition13: Test that the condition behaves as suspected when points are located on the unit circle */
    @Test
    void lic13_ValidData_PointsOnUnitCircle() {
        // Points on the unit circles, including a point in the origin.
        double[] x = new double[] { 0, 1, -1, 0, 0};
        double[] y = new double[] { 0, 0, 0, -1, 1};

        // Using A_PTS = B_PTS = 0, should only make it possible to create a unit circle as the smallest circle to contain all three data points.
        assertTrue(LaunchInterceptorConditions.condition13(x, y, 0, 0, 0.9, 1, 5));
        assertFalse(LaunchInterceptorConditions.condition13(x, y, 0, 0, 1.1, 0.9, 5));
        assertFalse(LaunchInterceptorConditions.condition13(x, y, 0, 0, 1, 1, 5));
    }

    /** Condition14: Test when there exist an area greater than AREA1 and a area less then AREA2 */
    @Test
    void lic14_InvalidData_InvalidNumberOfPoints() {
        // Points that have two triangles when using E_PTS = F_PTS = 1. One with area 1 and another with area 2
        double[] x = new double[] { 0, 0, 0, 0};
        double[] y = new double[] { 0, 0, 1, 2};

        // Using E_PTS = F_PTS = 1, the condition should find two triangles that meet the condition
        assertEquals(LaunchInterceptorConditions.condition14(x, y, 1, 1, 1.9, 1.1, 4), false);
    }

    /** Condition14: Test when there exist an area greater than AREA1 and a area less then AREA2 */
    @Test
    void lic14_ValidData_CorrectAreaForCondition() {
        // Points that have two triangles when using E_PTS = F_PTS = 1. One with area 1 and another with area 2
        double[] x = new double[] { 0, 0, 0, 0, 1, 2};
        double[] y = new double[] { 0, 0, 1, 2, 0, 0};

        // Using E_PTS = F_PTS = 1, the condition should find two triangles that meet the condition
        assertEquals(LaunchInterceptorConditions.condition14(x, y, 1, 1, 1.9, 1.1, 6), true);
    }

    /** Condition14: Test when there do not exist an area greater than AREA1 and a area less then AREA2 */
    @Test
    void lic14_ValidData_IncorrectAreasForConditionToBeMet() {
        // Points that have two triangles when using E_PTS = F_PTS = 1. One with area 0.5 and another with area 1
        double[] x = new double[] { 0, 0, 0, 0, 1, 2};
        double[] y = new double[] { 0, 0, 1, 2, 0, 0};

        // Using E_PTS = F_PTS = 1, the condition should find not find triangles that meet the condition
        assertFalse(LaunchInterceptorConditions.condition14(x, y, 1, 1, 1.05, 0.45, 6));
        assertFalse(LaunchInterceptorConditions.condition14(x, y, 1, 1, 0.95, 0.45, 6));
        assertTrue(LaunchInterceptorConditions.condition14(x, y, 1, 1, 1.05, 0.55, 6));
    }

     /**
     * Testing two valid points and a valid LENGTH1.
     */
    @Test
    void distance_ValidInput_GreaterThan() {
        double x1 = 1.5;
        double y1 = 1;
        double x2 = 5;
        double y2 = 1;
        double length1 = 3.2;
        assertTrue(LaunchInterceptorConditions.helperDistance(x1, y1, x2, y2, length1));
        length1 = 3.6;
        assertFalse(LaunchInterceptorConditions.helperDistance(x1, y1, x2, y2, length1));
        x1 = 1.5;
        y1 = -2;
        x2 = -2.2;
        y2 = 3;
        length1 = 6.2;
        assertTrue(LaunchInterceptorConditions.helperDistance(x1, y1, x2, y2, length1));
        length1 = 6.3;
        assertFalse(LaunchInterceptorConditions.helperDistance(x1, y1, x2, y2, length1));
    }

    /**
     * Testing and invalid input of negative LENGTH1.
     */
    @Test
    void distance_InvalidInput_NegativeLength1() {
        double x1 = 1.5;
        double y1 = 1;
        double x2 = 5;
        double y2 = 1;
        double length1 = -3;
        assertThrows(IllegalArgumentException.class, () -> LaunchInterceptorConditions.helperDistance(x1, y1, x2, y2, length1));
    }

    /**
     * Testing with a valid input of three points that make a triangle which fits into/on a circle of radius r.
     */
    @Test
    void threePoints_ValidInput_HaveTriangle() {
        double x1 = 1;
        double y1 = 0;
        double x2 = 0;
        double y2 = 1;
        double x3 = -1;
        double y3 = 0;
        double r = 1;
        assertTrue(LaunchInterceptorConditions.helperCircle(x1, y1, x2, y2, x3, y3, r));
        x1 = 1.2;
        y1 = 1.5;
        x2 = 1.2;
        y2 = 2.5;
        x3 = 2.2;
        y3 = 1.5;
        assertTrue(LaunchInterceptorConditions.helperCircle(x1, y1, x2, y2, x3, y3, r));
        x1 = 0.7071;
        y1 = 0.7071;
        x2 = -0.5;
        y2 = 0.866;
        x3 = -0.7071;
        y3 = -0.7071;
        assertTrue(LaunchInterceptorConditions.helperCircle(x1, y1, x2, y2, x3, y3, r));
        x1 = 3.031;
        y1 = 1.75;
        x2 = 1.75;
        y2 = 3.031;
        x3 = -1.75;
        y3 = -3.031;
        r = 3.5;
        assertTrue(LaunchInterceptorConditions.helperCircle(x1, y1, x2, y2, x3, y3, r));
    }

    /**
     * Testing with a valid input of three points that don not make a triangle which fits
     * into/on a circle of radius one.
     */
    @Test
    void threePoints_ValidInput_DoNotHaveTriangle() {
        double x1 = 2;
        double y1 = 0;
        double x2 = 0;
        double y2 = 3;
        double x3 = -1;
        double y3 = 0;
        double r = 1;
        assertFalse(LaunchInterceptorConditions.helperCircle(x1, y1, x2, y2, x3, y3, r));
        x1 = 1.2;
        y1 = 3.5;
        x2 = 1.2;
        y2 = 2.5;
        x3 = 5.2;
        y3 = 1.5;
        assertFalse(LaunchInterceptorConditions.helperCircle(x1, y1, x2, y2, x3, y3, r));
        x1 = 0.7071;
        y1 = 0.7071;
        x2 = -0.7;
        y2 = 0.866;
        x3 = -0.7071;
        y3 = -0.7071;
        assertFalse(LaunchInterceptorConditions.helperCircle(x1, y1, x2, y2, x3, y3, r));
        x1 = 3.031;
        y1 = 1.75;
        x2 = 1.75;
        y2 = 3.031;
        x3 = -1.75;
        y3 = -3.031;
        r = 3.4;
        assertFalse(LaunchInterceptorConditions.helperCircle(x1, y1, x2, y2, x3, y3, r));
    }

    /**
     * Testing with a valid input of three points that don not make any
     * triangle (All points are on a straight line).
     */
    @Test
    void threePoints_ValidInput_StraightLine() {
        double x1 = 1;
        double y1 = 0;
        double x2 = 1;
        double y2 = -0.2;
        double x3 = 1;
        double y3 = -0.3;
        double r = 1;
        assertTrue(LaunchInterceptorConditions.helperCircle(x1, y1, x2, y2, x3, y3, r));
        x1 = -0.2;
        y1 = 0;
        x2 = 0;
        y2 = 0;
        x3 = 0.2;
        y3 = 0;
        r =  0.1;
        assertFalse(LaunchInterceptorConditions.helperCircle(x1, y1, x2, y2, x3, y3, r));
    }

    /**
     * Testing with an invalid input of radius 0 or less.
     */
    @Test
    void threePoints_InvalidInput_RZeroOrLess() {
        double x1 = 1;
        double y1 = 0;
        double x2 = 1;
        double y2 = -0.2;
        double x3 = 1;
        double y3 = -0.3;
        double r1 = 0;
        assertThrows(IllegalArgumentException.class, () -> LaunchInterceptorConditions.helperCircle(x1, y1, x2, y2, x3, y3, r1));
        double r2 = -1.5;
        assertThrows(IllegalArgumentException.class, () -> LaunchInterceptorConditions.helperCircle(x1, y1, x2, y2, x3, y3, r1));
    }

    /**
     * Check if triangle area of the points are on a single line
     */
    @Test
    void checkIfTriangleAreaIsZero() {
        double x1 = 0;
        double y1 = 0;
        double x2 = 1;
        double y2 = 1;
        double x3 = 2;
        double y3 = 2;
        double a = 3;
        boolean result = LaunchInterceptorConditions.triangleAreaIsGreaterThanArea(x1, y1, x2, y2, x3, y3, a);
        assertEquals(result, false);
    }

    /**
     * Check if a basic triangle pass the test
     */
    @Test
    void checkIfTriangleHasArea() {
        double x1 = 0;
        double y1 = 0;
        double x2 = 1;
        double y2 = 0;
        double x3 = 0;
        double y3 = 1;
        assertEquals(LaunchInterceptorConditions.triangleAreaIsGreaterThanArea(x1, y1, x2, y2, x3, y3, 0.55), false);
        assertEquals(LaunchInterceptorConditions.triangleAreaIsGreaterThanArea(x1, y1, x2, y2, x3, y3, 0.45), true);
    }

    /**
     * Should return false if epsilon is not a valid value
     */
    @Test
    void angleBetweenPointsEpsilonNotValid() {
        double[] x = new double[]{-2, 0, 2};
        double[] y = new double[]{1, 0, 1};
        boolean result = LaunchInterceptorConditions.angleBetweenPointsOutsideEpsilon(x[0], y[0], x[1], y[1], x[2], y[2], 4);
        assertEquals(false, result);
    }

    /**
     * Should return false if the angle between the points is not valid
     */
    @Test
    void angleBetweenAngleNoValid() {
        double[] x = new double[]{0, 0, 2};
        double[] y = new double[]{0, 0, 1};
        boolean result = LaunchInterceptorConditions.angleBetweenPointsOutsideEpsilon(x[0], y[0], x[1], y[1], x[2], y[2], 4);
        assertEquals(false, result);
    }

    /**
     * Should return false as the angle is within the epsilon range
     */
    @Test
    void angleBetweenAngleWithinEpsilon() {
        double[] x = new double[]{-1, 0, 1};
        double[] y = new double[]{0, 0, 0};
        boolean result = LaunchInterceptorConditions.angleBetweenPointsOutsideEpsilon(x[0], y[0], x[1], y[1], x[2], y[2], Math.PI / 4);
        assertEquals(false, result);
    }

    /**
     * Should return true as the angle is outside the epsilon range
     */
    @Test
    void angleBetweenAngleOutsideEpsilon() {
        double[] x = new double[]{-1, 0, 1};
        double[] y = new double[]{1, 0, 1};
        boolean result = LaunchInterceptorConditions.angleBetweenPointsOutsideEpsilon(x[0], y[0], x[1], y[1], x[2], y[2], Math.PI / 3);
        assertEquals(true, result);
    }
}

