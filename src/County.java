public class County {
    private String name;
    private int numCurrElaBenchmark;
    private double PctElaBenchmark;
    private int NumCurrMathBenchmark;
    private double PctMathBenchmark;
    private double TotNumBothBenchmark;
    private double PctBothBenchmark;

    public County(String name, int fips, Election2016 vote2016, Education2016 educ2016, Employment2016 employ2016) {
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    

}
