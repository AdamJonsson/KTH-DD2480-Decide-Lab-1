package lab1.test;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LaunchInterceptorConditionsTest {

    /**
     * Testing the function for LIC 3 with a set of data that contains a valid triangle with area larger
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
     * Testing the function for LIC 3 with a set of data that contains a valid triangle with area larger
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
     * Testing the function for LIC 3 with a set of data that contains many valid triangles but none of
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
     * Testing the function for LIC 3 with a set of data that hase less than 3 points. So there cannot
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
     * Testing the function for LIC 3 with a set of data that do not contain any triangle.
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
     * Testing the function for LIC 3 with an invalid input of a negative AREA1.
     */
    @Test
    void lic3_InvalidInput_NegativeArea1() {
        double[] x = new double[]{-2, 1, 2};
        double[] y = new double[]{-2, 1, -2};
        double area1 = -5;
        assertThrows(IllegalArgumentException.class, () -> LaunchInterceptorConditions.condition3(x, y, area1));
    }

    /**
     * Testing a sequence of points that contain Q_PTS consecutive points in more than QUADS quadrants.
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
     * Testing a sequence of points that do not contain Q_PTS consecutive
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
     * Testing the ambiguous cases when a point is in between two or more quadrants.
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
     * Testing an invalid input when QUADS is less than 1 or more than 3.
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
     * Testing with a valid input that contains two consecutive data points
     * that fulfills X[j] - X[i] < 0.
     */
    @Test
    void lic5_ValidInput_ContainsTwoPoint() {
        double[] x = new double[]{1.25, 4, 2, 3};
        double[] y = new double[]{1, 1, 1, 1};
        assertTrue(LaunchInterceptorConditions.condition5(x, y));
    }

    /**
     * Testing with a valid input that do not contain two consecutive data points
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
     * Testing with a valid input that contains less than two data points.
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

    /* CONDITION 0 */

    /**
     * Testing valid data for condition 0
     * @result false
     */
    @Test
    void co0_1() {
        double[] xList = new double[]{0, 1};
        double[] yList = new double[]{0, 1};
        double length1 = 2;
        boolean result = LaunchInterceptorConditions.condition0(xList, yList, length1);
        assertEquals(result, false);
    }

    /**
     * Testing valid negative data for condition 0
     * @result false
     */
    @Test
    void co0_2() {
        double[] xList = new double[]{-1, 0};
        double[] yList = new double[]{4, -1};
        double length1 = 12;
        boolean result = LaunchInterceptorConditions.condition0(xList, yList, length1);
        assertEquals(result, false);
    }

    /**
     * Testing empty data for condition 0
     * @result false
     */
    @Test
    void co0_3() {
        double[] xList = new double[]{};
        double[] yList = new double[]{};
        double length1 = 0;
        boolean result = LaunchInterceptorConditions.condition0(xList, yList, length1);
        assertEquals(result, false);
    }

    /**
     * Testing empty data for condition 0
     * @result false
     */
    @Test
    void co0_4() {
        double[] xList = new double[]{};
        double[] yList = new double[]{};
        double length1 = 20;
        boolean result = LaunchInterceptorConditions.condition0(xList, yList, length1);
        assertEquals(result, false);
    }

    /**
     * Testing valid data for condition 0
     * @result true
     */
    @Test
    void co0_5() {
        double[] xList = new double[]{3, 4, 5};
        double[] yList = new double[]{3, 4, 5};
        double length1 = 1;
        boolean result = LaunchInterceptorConditions.condition0(xList, yList, length1);
        assertEquals(result, true);
    }

    /**
     * Testing large valid data for condition 0
     * @result false
     */
    @Test
    void co0_6() {
        double[] xList = new double[]{37545, 954326, 68643, 68887, 1, 0, 765};
        double[] yList = new double[]{656, 65, 1, 345, 678, -7};
        double length1 = 1;
        boolean result = LaunchInterceptorConditions.condition0(xList, yList, length1);
        assertEquals(result, false);
    }

    /**
     * Testing single data point for condition 0
     * @result false
     */
    @Test
    void co0_7() {
        double[] xList = new double[]{1};
        double[] yList = new double[]{1};
        double length1 = 1;
        boolean result = LaunchInterceptorConditions.condition0(xList, yList, length1);
        assertEquals(result, false);
    }

    /* CONDITION 1 */

    /**
     * Testing valid data for condition 0
     * @result true
     */
    @Test
    void co1_1() {
        double[] xList = new double[]{0, 1, 2};
        double[] yList = new double[]{0, 1, 2};
        double radius1 = 5;
        boolean result = LaunchInterceptorConditions.condition1(xList, yList, radius1);
        assertEquals(result, false);
    }

    /**
     * Testing valid negative data for condition 0
     * @result true
     */
    @Test
    void co1_2() {
        double[] xList = new double[]{-1, 0, -1};
        double[] yList = new double[]{4, -1, -1};
        double radius1 = 12;
        boolean result = LaunchInterceptorConditions.condition1(xList, yList, radius1);
        assertEquals(result, true);
    }

    /**
     * Testing empty data for condition 0
     * @result false
     */
    @Test
    void co1_3() {
        double[] xList = new double[]{};
        double[] yList = new double[]{};
        double radius1 = 0;
        boolean result = LaunchInterceptorConditions.condition1(xList, yList, radius1);
        assertEquals(result, false);
    }

    /**
     * Testing empty data for condition 0
     * @result false
     */
    @Test
    void co1_4() {
        double[] xList = new double[]{};
        double[] yList = new double[]{};
        double radius1 = 20;
        boolean result = LaunchInterceptorConditions.condition1(xList, yList, radius1);
        assertEquals(result, false);
    }

    /**
     * Testing valid data for condition 1
     * @result false
     */
    @Test
    void co1_5() {
        double[] xList = new double[]{3, 4, 5};
        double[] yList = new double[]{3, 4, 5};
        double radius1 = 1;
        boolean result = LaunchInterceptorConditions.condition1(xList, yList, radius1);
        assertEquals(result, false);
    }

    /**
     * Testing large valid data for condition 1
     * @result false
     */
    @Test
    void co1_6() {
        double[] xList = new double[]{37545, 954326, 68643, 68887, 1, 0, 765};
        double[] yList = new double[]{656, 65, 1, 345, 678, -7};
        double radius1 = 1;
        boolean result = LaunchInterceptorConditions.condition1(xList, yList, radius1);
        assertEquals(result, false);
    }

    /**
     * Testing single data point for condition 1
     * @result false
     */
    @Test
    void co1_7() {
        double[] xList = new double[]{1};
        double[] yList = new double[]{1};
        double radius1 = 20;
        boolean result = LaunchInterceptorConditions.condition1(xList, yList, radius1);
        assertEquals(result, false);
    }


    /**
     * Testing two data points for condition 1
     * @result false
     */
    @Test
    void co1_8() {
        double[] xList = new double[]{1, 2};
        double[] yList = new double[]{1, 2};
        double radius1 = 20;
        boolean result = LaunchInterceptorConditions.condition1(xList, yList, radius1);
        assertEquals(result, false);
    }

    /**
     * Testing valid data points that are not consecutive but would return true if they were
     * @result false
     */
    @Test
    void co1_9() {
        double[] xList = new double[]{1, 2, 10000, 3};
        double[] yList = new double[]{1, 2, 10000, 3};
        double radius1 = 20;
        boolean result = LaunchInterceptorConditions.condition1(xList, yList, radius1);
        assertEquals(result, false);
    }

    /* CONDITION 2 */

    /**
     * Testing valid data for angle of pi between points
     * @result false
     */
    @Test
    void co2_1() {
        double[] xList = new double[]{0, 1, 2};
        double[] yList = new double[]{0, 0, 0};
        double epsilon = 1;
        boolean result = LaunchInterceptorConditions.condition2(xList, yList, epsilon);
        assertEquals(result, false);
    }

    /**
     * Testing empty data
     * @result false
     */
    @Test
    void co2_2() {
        double[] xList = new double[]{};
        double[] yList = new double[]{};
        double epsilon = 3;
        boolean result = LaunchInterceptorConditions.condition2(xList, yList, epsilon);
        assertEquals(result, false);
    }

    /**
     * Testing valid data
     * @result false
     */
    @Test
    void co2_3() {
        double[] xList = new double[]{3, 4, 5};
        double[] yList = new double[]{3, 4, 5};
        double epsilon = 0;
        boolean result = LaunchInterceptorConditions.condition2(xList, yList, epsilon);
        assertEquals(result, false);
    }

    /**
     * Testing single data point
     * @result false
     */
    @Test
    void co2_4() {
        double[] xList = new double[]{3};
        double[] yList = new double[]{3};
        double epsilon = 3;
        boolean result = LaunchInterceptorConditions.condition2(xList, yList, epsilon);
        assertEquals(result, false);
    }

    /**
     * Testing two data points
     * @result false
     */
    @Test
    void co2_5() {
        double[] xList = new double[]{3, 4};
        double[] yList = new double[]{3, 4};
        double epsilon = 3;
        boolean result = LaunchInterceptorConditions.condition2(xList, yList, epsilon);
        assertEquals(result, false);
    }

    /**
     * Condition12: The condition should return false as the number of points are
     * less than three
     */
    @Test
    void condition12NumPointsInvalid() {
        double[] x = new double[] { 1, 2 };
        double[] y = x;
        boolean result = LaunchInterceptorConditions.condition12(x, y, 1, 0, 0, 2);
        assertEquals(result, false);
    }

    /**
     * Condition12: The condition should return false as the length2 are less than 0
     */
    @Test
    void condition12MaxLengthInvalid() {
        double[] x = new double[] { 1, 2, 3, 4 };
        double[] y = x;
        boolean result = LaunchInterceptorConditions.condition12(x, y, 2, -2, -1, 4);
        assertEquals(result, false);
    }

    /** Condition12: If the K_PTS are greater than the */
    @Test
    void condition12KptsInvalid() {
        double[] x = new double[] { 1, 2, 3, 4 };
        double[] y = x;
        boolean result = LaunchInterceptorConditions.condition12(x, y, 3, 0, -1, 4);
        assertEquals(result, false);
    }

    /** Condition12: Tests number of conditions were the condition should be met */
    @Test
    void condition12DataPointAndDistances() {
        double[] x = new double[] { -1, 0, 2, 5, 9, 14, 20 };
        double[] y = new double[] { -1, 0, 2, 5, 9, 14, 20 };

        double marginCheckAmount = 0.1;

        // Using K_PTS = 0.
        // The biggest length that exist should be sqrt(6^2 + 6^2) = 8.49.
        // The smallest length that should exist should be 1.
        assertEquals(LaunchInterceptorConditions.condition12(x, y, 0, (8.49 - marginCheckAmount), (1 + marginCheckAmount), 7), true);
        assertEquals(LaunchInterceptorConditions.condition12(x, y, 0, (8.49 + marginCheckAmount), (1 + marginCheckAmount), 7), false);
        assertEquals(LaunchInterceptorConditions.condition12(x, y, 0, (8.49 - marginCheckAmount), (1 - marginCheckAmount), 7), false);

        // Using K_PTS = 1.
        // The biggest length that exist should be sqrt(11^2 + 11^2) = 15.55.
        // The smallest length that should exist should be sqrt(3^2 + 3^2) = 4.24.
        assertEquals(LaunchInterceptorConditions.condition12(x, y, 0, (15.55 - marginCheckAmount), (4.24 + marginCheckAmount), 7), true);
        assertEquals(LaunchInterceptorConditions.condition12(x, y, 0, (15.55 + marginCheckAmount), (4.24 + marginCheckAmount), 7), false);
        assertEquals(LaunchInterceptorConditions.condition12(x, y, 0, (15.55 - marginCheckAmount), (4.24 - marginCheckAmount), 7), false);
    }

    /** Condition13: Test to have an invalid number of points */
    @Test
    void condition13NumOfPointsInvalid() {
        // Points on the unit circles, including a point in the origin.
        double[] x = new double[] { 0, 1, -1, 0};
        double[] y = new double[] { 0, 0, 0, -1};
        assertEquals(LaunchInterceptorConditions.condition13(x, y, 0, 0, 1.1, 1, 4), false);
    }

    /** Condition13: Test tha the condition behaves as suspected when points are located on the unit circle */
    @Test
    void condition13PointsOnUnitCircle() {
        // Points on the unit circles, including a point in the origin.
        double[] x = new double[] { 0, 1, -1, 0, 0};
        double[] y = new double[] { 0, 0, 0, -1, 1};

        // Using A_PTS = B_PTS = 0, should only make it possible to create a unit circle as the smallest circle to contain all three data points.
        assertEquals(LaunchInterceptorConditions.condition13(x, y, 0, 0, 1.1, 1, 5), true);
        assertEquals(LaunchInterceptorConditions.condition13(x, y, 0, 0, 1.1, 0.9, 5), false);
        assertEquals(LaunchInterceptorConditions.condition13(x, y, 0, 0, 1, 1, 5), false);
    }

    /** Condition14: Test when there exist an area greater than AREA1 and a area less then AREA2 */
    @Test
    void condition14InvalidNumberOfPoints() {
        // Points that have two triangles when using E_PTS = F_PTS = 1. One with area 1 and another with area 2
        double[] x = new double[] { 0, 0, 0, 0};
        double[] y = new double[] { 0, 0, 1, 2};

        // Using E_PTS = F_PTS = 1, the condition should find two triangles that meet the condition 
        assertEquals(LaunchInterceptorConditions.condition14(x, y, 1, 1, 1.9, 1.1, 4), false);
    }

    /** Condition14: Test when there exist an area greater than AREA1 and a area less then AREA2 */
    @Test
    void condition14CorrectAreaForCondition() {
        // Points that have two triangles when using E_PTS = F_PTS = 1. One with area 1 and another with area 2
        double[] x = new double[] { 0, 0, 0, 0, 1, 2};
        double[] y = new double[] { 0, 0, 1, 2, 0, 0};

        // Using E_PTS = F_PTS = 1, the condition should find two triangles that meet the condition 
        assertEquals(LaunchInterceptorConditions.condition14(x, y, 1, 1, 1.9, 1.1, 6), true);
    }

    /** Condition14: Test when there do not exist an area greater than AREA1 and a area less then AREA2 */
    @Test
    void condition14IncorrectAreaForCondition() {
        // Points that have two triangles when using E_PTS = F_PTS = 1. One with area 1 and another with area 2
        double[] x = new double[] { 0, 0, 0, 0, 1, 2};
        double[] y = new double[] { 0, 0, 1, 2, 0, 0};

        // Using E_PTS = F_PTS = 1, the condition should find not find triangles that meet the condition 
        assertEquals(LaunchInterceptorConditions.condition14(x, y, 1, 1, 2.1, 0.9, 6), false);
        assertEquals(LaunchInterceptorConditions.condition14(x, y, 1, 1, 1.9, 0.9, 6), false);
        assertEquals(LaunchInterceptorConditions.condition14(x, y, 1, 1, 2.1, 1.1, 6), false);
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
        assertFalse(LaunchInterceptorConditions.helperCircle(x1, y1, x2, y2, x3, y3, r));
        x1 = -0.2;
        y1 = 0;
        x2 = 0;
        y2 = 0;
        x3 = 0.2;
        y3 = 0;
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

    /** Should return false if epsilon is not a valid value */
    @Test
    void angleBetweenPointsEpsilonNotValid() {
        double[] x = new double[]{-2, 0, 2};
        double[] y = new double[]{1, 0, 1};
        boolean result = LaunchInterceptorConditions.angleBetweenPointsOutsideEpsilon(x[0], y[0], x[1], y[1], x[2], y[2], 4);
        assertEquals(false, result);
    }

    /** Should return false if the angle between the points is not valid */
    @Test
    void angleBetweenAngleNoValid() {
        double[] x = new double[]{0, 0, 2};
        double[] y = new double[]{0, 0, 1};
        boolean result = LaunchInterceptorConditions.angleBetweenPointsOutsideEpsilon(x[0], y[0], x[1], y[1], x[2], y[2], 4);
        assertEquals(false, result);
    }

    /** Should return false as the angle is within the epsilon range */
    @Test
    void angleBetweenAngleWithinEpsilon() {
        double[] x = new double[]{-1, 0, 1};
        double[] y = new double[]{0, 0, 0};
        boolean result = LaunchInterceptorConditions.angleBetweenPointsOutsideEpsilon(x[0], y[0], x[1], y[1], x[2], y[2], Math.PI / 4);
        assertEquals(false, result);
    }

    /** Should return true as the angle is outside the epsilon range */
    @Test
    void angleBetweenAngleOutsideEpsilon() {
        double[] x = new double[]{-1, 0, 1};
        double[] y = new double[]{1, 0, 1};
        boolean result = LaunchInterceptorConditions.angleBetweenPointsOutsideEpsilon(x[0], y[0], x[1], y[1], x[2], y[2], Math.PI / 3);
        assertEquals(true, result);
    }

}


