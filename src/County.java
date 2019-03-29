public class County {
    private String name;
    private int numCurrElaBenchmark;
    private double PctElaBenchmark;
    private int NumCurrMathBenchmark;
    private double PctMathBenchmark;
    private double TotNumBothBenchmark;
    private double PctBothBenchmark;
    private int schoolAmt;

    public County(String name) {
        this.name = name;
        this.numCurrElaBenchmark = 0;
        PctElaBenchmark = 0;
        NumCurrMathBenchmark = 0;
        PctMathBenchmark = 0;
        TotNumBothBenchmark = 0;
        PctBothBenchmark = 0;
        this.schoolAmt = 0;
    }

    public void setNumCurrElaBenchmark(int numCurrElaBenchmark) {
        this.numCurrElaBenchmark = numCurrElaBenchmark;
    }

    public void setPctElaBenchmark(double pctElaBenchmark) {
        PctElaBenchmark = pctElaBenchmark;
    }

    public void setNumCurrMathBenchmark(int numCurrMathBenchmark) {
        NumCurrMathBenchmark = numCurrMathBenchmark;
    }

    public void setPctMathBenchmark(double pctMathBenchmark) {
        PctMathBenchmark = pctMathBenchmark;
    }

    public void setTotNumBothBenchmark(double totNumBothBenchmark) {
        TotNumBothBenchmark = totNumBothBenchmark;
    }

    public void setPctBothBenchmark(double pctBothBenchmark) {
        PctBothBenchmark = pctBothBenchmark;
    }

    public void setSchoolAmt(int schoolAmt) {
        this.schoolAmt = schoolAmt;
    }

    public int getNumCurrElaBenchmark() {
        return numCurrElaBenchmark;
    }

    public void addNumCurrElaBenchmark(int numCurrElaBenchmark) {
        this.numCurrElaBenchmark += numCurrElaBenchmark;
    }

    public double getPctElaBenchmark() {
        return PctElaBenchmark;
    }

    public void addPctElaBenchmark(double pctElaBenchmark) {
        PctElaBenchmark += pctElaBenchmark;
    }

    public int getNumCurrMathBenchmark() {
        return NumCurrMathBenchmark;
    }

    public void addNumCurrMathBenchmark(int numCurrMathBenchmark) {
        NumCurrMathBenchmark += numCurrMathBenchmark;
    }

    public double getPctMathBenchmark() {
        return PctMathBenchmark;
    }

    public void addPctMathBenchmark(double pctMathBenchmark) {
        PctMathBenchmark += pctMathBenchmark;
    }

    public double getTotNumBothBenchmark() {
        return TotNumBothBenchmark;
    }

    public void addTotNumBothBenchmark(double totNumBothBenchmark) {
        TotNumBothBenchmark += totNumBothBenchmark;
    }

    public double getPctBothBenchmark() {
        return PctBothBenchmark;
    }

    public void addPctBothBenchmark(double pctBothBenchmark) {
        PctBothBenchmark += pctBothBenchmark;
    }

    public int getSchoolAmt() {
        return schoolAmt;
    }

    public void incrementSchoolAmt() {
        schoolAmt++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
