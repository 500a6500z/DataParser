public class ElectionResult {
    private double votesDem;
    private double votesGop;
    private double totalVotes;
    private double perDem;
    private double perGop;
    private String diff;
    private double per_point_diff;
    private String stateAbbr;
    private String countyName;
    private int combinedFips;

    public ElectionResult(double votesDem, double votesGop, double totalVotes, double perDem, double perGop, String diff, double per_point_diff, String stateAbbr, String countyName, int combinedFips) {
        this.votesDem = votesDem;
        this.votesGop = votesGop;
        this.totalVotes = totalVotes;
        this.perDem = perDem;
        this.perGop = perGop;
        this.diff = diff;
        this.per_point_diff = per_point_diff;
        this.stateAbbr = stateAbbr;
        this.countyName = countyName;
        this.combinedFips = combinedFips;
    }

    public double getVotesDem() {
        return votesDem;
    }

    public void setVotesDem(double votesDem) {
        this.votesDem = votesDem;
    }

    public double getVotesGop() {
        return votesGop;
    }

    public void setVotesGop(double votesGop) {
        this.votesGop = votesGop;
    }

    public double getTotalVotes() {
        return totalVotes;
    }

    public void setTotalVotes(double totalVotes) {
        this.totalVotes = totalVotes;
    }

    public double getPerDem() {
        return perDem;
    }

    public void setPerDem(double perDem) {
        this.perDem = perDem;
    }

    public double getPerGop() {
        return perGop;
    }

    public void setPerGop(double perGop) {
        this.perGop = perGop;
    }

    public String getDiff() {
        return diff;
    }

    public void setDiff(String diff) {
        this.diff = diff;
    }

    public double getPer_point_diff() {
        return per_point_diff;
    }

    public void setPer_point_diff(double per_point_diff) {
        this.per_point_diff = per_point_diff;
    }

    public String getStateAbbr() {
        return stateAbbr;
    }

    public void setStateAbbr(String stateAbbr) {
        this.stateAbbr = stateAbbr;
    }

    public String getCountyName() {
        return countyName;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }

    public int getCombinedFips() {
        return combinedFips;
    }

    public void setCombinedFips(int combinedFips) {
        this.combinedFips = combinedFips;
    }

    @Override
    public String toString() {
        return "votesDem=" + votesDem +
                ", votesGop=" + votesGop +
                ", totalVotes=" + totalVotes +
                ", perDem=" + perDem +
                ", perGop=" + perGop +
                ", diff=" + diff +
                ", per_point_diff=" + per_point_diff +
                ", stateAbbr='" + stateAbbr + '\'' +
                ", countyName='" + countyName + '\'' +
                ", combinedFips=" + combinedFips;
    }
}
