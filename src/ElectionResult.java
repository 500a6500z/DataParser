public class ElectionResult {
    private int votesDem;
    private int votesGop;
    private int totalVotes;
    private double perDem;
    private double perGop;
    private int diff;
    private double per_point_diff;
    private String stateAbbr;
    private String countyName;
    private int combinedFips;

    public int getVotesDem() {
        return votesDem;
    }

    public void setVotesDem(int votesDem) {
        this.votesDem = votesDem;
    }

    public int getVotesGop() {
        return votesGop;
    }

    public void setVotesGop(int votesGop) {
        this.votesGop = votesGop;
    }

    public int getTotalVotes() {
        return totalVotes;
    }

    public void setTotalVotes(int totalVotes) {
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

    public int getDiff() {
        return diff;
    }

    public void setDiff(int diff) {
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
