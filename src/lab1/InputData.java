package lab1;

/**
 * A class for representing the input data.
 */
public class InputData {
    public int numPoints;
    public double[] x;
    public double[] y;
    public int[][] lcm;
    public boolean[] puv;
    public double length1;
    public double length2;
    public double radius1;
    public double radius2;
    public double epsilon;
    public double area1;
    public double area2;
    public int quads;
    public double dist;
    public int aPts;
    public int bPts;
    public int cPts;
    public int dPts;
    public int ePts;
    public int fPts;
    public int gPts;
    public int kPts;
    public int nPts;
    public int qPts;

    /**
     * There need to exist an empty constructor for JSON parsing
     */
    public InputData() {
    }

    /**
     * This constructor is used to manually construct input data
     */
    public InputData(double[] x, double[] y, int[][] lcm, boolean[] puv, double length1, double length2,
                     double radius1, double radius2, double epsilon, double area1, double area2, int quads, double dist,
                     int aPts, int bPts, int cPts, int dPts, int ePts, int fPts, int gPts, int kPts, int nPts, int qPts) {
        this.x = x;
        this.y = y;
        this.numPoints = x.length;
        this.lcm = lcm;
        this.puv = puv;
        this.length1 = length1;
        this.length2 = length2;
        this.radius1 = radius1;
        this.radius2 = radius2;
        this.epsilon = epsilon;
        this.area1 = area1;
        this.area2 = area2;
        this.quads = quads;
        this.dist = dist;
        this.aPts = aPts;
        this.bPts = bPts;
        this.cPts = cPts;
        this.dPts = dPts;
        this.ePts = ePts;
        this.fPts = fPts;
        this.gPts = gPts;
        this.kPts = kPts;
        this.nPts = nPts;
        this.qPts = qPts;
    }
    
    public int getNumpoints() {
        return this.x.length;
    }
}


