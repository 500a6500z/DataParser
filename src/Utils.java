import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Utils {

    public static String readFileAsString(String filepath) {
        StringBuilder output = new StringBuilder();

        try (Scanner scanner = new Scanner(new File(filepath))) {

            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                output.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return output.toString();
    }

    public static ArrayList<ElectionResult> parse2016PresidentalResults(String data) {
        String[] lines = data.split("\n");
        ArrayList<ElectionResult> output = new ArrayList<>(lines.length);
        for(int i = 1; i < lines.length; i++) {
            int splitIndex = lines[i].indexOf(',', lines[i].indexOf(',', lines[i].indexOf(',', lines[i].indexOf(',', lines[i].indexOf(',', lines[i].indexOf(',') + 1) + 1) + 1) + 1) + 1);
            String result1 = lines[i].substring(0, splitIndex);
            String result2 = lines[i].substring(splitIndex + 1);
            String[] data1 = result1.split(",");
            int extra = 0;
            for (int j = 0; j < result2.length(); j++) {
                if (result2.charAt(j) == ',') {
                    extra++;
                }
            }
            extra -= 4;
            for (int j = 0; j < extra; j++) {
                result2 = result2.substring(0, result2.indexOf(',')) + result2.substring(result2.indexOf(',') + 1);
            }
            extra = 0;
            for (int j = 0; j < result2.length(); j++) {
                if (result2.charAt(j) == '"') {
                    extra++;
                }
            }
            for (int j = 0; j < extra; j++) {
                result2 = result2.substring(0, result2.indexOf('"')) + result2.substring(result2.indexOf('"') + 1);
            }
            if (result2.indexOf('%') != -1) {
                result2 = result2.substring(0, result2.indexOf('%')) + result2.substring(result2.indexOf('%') + 1);
            }
            String[] data2 = result2.split(",");
            output.add(new ElectionResult(Double.parseDouble(data1[1]), Double.parseDouble(data1[2]), Double.parseDouble(data1[3]), Double.parseDouble(data1[4]), Double.parseDouble(data1[5]), data2[0], Double.parseDouble(data2[1]), data2[2], data2[3], Integer.parseInt(data2[4])));
        }
        return output;
    }

    public static DataManager parseFiles(String electionResultsFile, String educationFile, String unemploymentFile) {
        DataManager output = new DataManager(new ArrayList<>(51));
        String election = readFileAsString(electionResultsFile);
        String education = readFileAsString(educationFile);
        String unemployment = readFileAsString(unemploymentFile);

        parseElection(output, election);
        parseEducation(output, education);
        parseUnemployment(output, unemployment);

        return output;
    }

    private static void parseElection(DataManager d, String election) {
        String[] lines = election.split("\n");
        int startIndex = 1;
        for(int i = startIndex; i < lines.length; i++) {
            lines[i] = clean(lines[i]);
        }

        for(int i = startIndex; i < lines.length; i++) {
            String[] data = lines[i].split(",");
            double demVotes = Double.parseDouble(data[1]);
            double gopVotes = Double.parseDouble(data[2]);
            double totalVotes = Double.parseDouble(data[3]);
            int fips = Integer.parseInt(data[10]);
            String state = data[8];
            String county = data[9];
            int stateIndex = getStateIndex(state, d.getStates());
            if(stateIndex == -1) {
                d.getStates().add(new State(state, new ArrayList<>()));
                stateIndex = d.getStates().size() - 1;
            }

                int countyIndex = getCountyIndex(county, d.getStates().get(stateIndex).getCounties());
                if(countyIndex == -1) {
                    d.getStates().get(stateIndex).getCounties().add(new County(county, fips, new Election2016(-1, -1, -1),
                            new Education2016(-1, -1, -1, -1),
                            new Employment2016(-1, -1, -1, -1)));
                    countyIndex = d.getStates().get(stateIndex).getCounties().size() - 1;
                }

                d.getStates().get(stateIndex).getCounties().get(countyIndex).getVote2016().setDemVotes(demVotes);
                d.getStates().get(stateIndex).getCounties().get(countyIndex).getVote2016().setGopVotes(gopVotes);
                d.getStates().get(stateIndex).getCounties().get(countyIndex).getVote2016().setTotalVotes(totalVotes);

        }
    }

    private static void parseEducation(DataManager d, String education) {
        String[] lines = education.split("\n");
        int startIndex = 5;
        for(int i = startIndex; i < lines.length; i++) {
            lines[i] = clean(lines[i]);
        }
        for(int i = startIndex; i < lines.length; i++) {
            String[] data = lines[i].split(",");
            double noHighSchool = Double.parseDouble(data[43]);
            double onlyHighSchool = Double.parseDouble(data[44]);
            double someCollege = Double.parseDouble(data[45]);
            double bachelorsOrMore = Double.parseDouble(data[46]);
            int fips = Integer.parseInt(data[0]);
            String state = data[1];
            String county = data[2];
            int stateIndex = getStateIndex(state, d.getStates());
            if(stateIndex == -1) {
                d.getStates().add(new State(state, new ArrayList<>()));
                stateIndex = d.getStates().size() - 1;
            }

            int countyIndex = getCountyIndex(county, d.getStates().get(stateIndex).getCounties());
            if(countyIndex == -1) {
                d.getStates().get(stateIndex).getCounties().add(new County(county, fips, new Election2016(-1, -1, -1),
                        new Education2016(-1, -1, -1, -1),
                        new Employment2016(-1, -1, -1, -1)));
                countyIndex = d.getStates().get(stateIndex).getCounties().size() - 1;
            }

            d.getStates().get(stateIndex).getCounties().get(countyIndex).getEduc2016().setNoHighSchool(noHighSchool);
            d.getStates().get(stateIndex).getCounties().get(countyIndex).getEduc2016().setOnlyHighSchool(onlyHighSchool);
            d.getStates().get(stateIndex).getCounties().get(countyIndex).getEduc2016().setSomeCollege(someCollege);
            d.getStates().get(stateIndex).getCounties().get(countyIndex).getEduc2016().setBachelorsOrMore(bachelorsOrMore);
        }
    }

    private static void parseUnemployment(DataManager d, String unemployment) {
        String[] lines = unemployment.split("\n");
        int startIndex = 8;
        for(int i = startIndex; i < lines.length; i++) {
            lines[i] = clean(lines[i]);
        }
        for(int i = startIndex; i < lines.length; i++) {
            String[] data = lines[i].split(",");
            int totalLaborForce = Integer.parseInt(data[42]);
            int employedLaborForce = Integer.parseInt(data[43]);
            int unemployedLaborForce = Integer.parseInt(data[44]);
            double unemployedPercent = Double.parseDouble(data[45]);

            int fips = Integer.parseInt(data[0]);
            String state = data[1];
            String county = data[2];
            int stateIndex = getStateIndex(state, d.getStates());
            if(stateIndex == -1) {
                d.getStates().add(new State(state, new ArrayList<>()));
                stateIndex = d.getStates().size() - 1;
            }

            int countyIndex = getCountyIndex(county, d.getStates().get(stateIndex).getCounties());
            if(countyIndex == -1) {
                d.getStates().get(stateIndex).getCounties().add(new County(county, fips, new Election2016(-1, -1, -1),
                        new Education2016(-1, -1, -1, -1),
                        new Employment2016(-1, -1, -1, -1)));
                countyIndex = d.getStates().get(stateIndex).getCounties().size() - 1;
            }

            d.getStates().get(stateIndex).getCounties().get(countyIndex).getEmploy2016().setTotalLaborForce(totalLaborForce);
            d.getStates().get(stateIndex).getCounties().get(countyIndex).getEmploy2016().setEmployedLaborForce(employedLaborForce);
            d.getStates().get(stateIndex).getCounties().get(countyIndex).getEmploy2016().setUnemployedLaborForce(unemployedLaborForce);
            d.getStates().get(stateIndex).getCounties().get(countyIndex).getEmploy2016().setUnemployedPercent(unemployedPercent);
        }
    }

    private static String clean(String str) {
        ArrayList<Integer> list = new ArrayList<>();
        boolean inQuote = false;
        for(int i = str.length() - 1; i >= 0; i++) {
            if(!inQuote && str.charAt(i) == '"') {
                inQuote = true;
                list.add(i);
            }
            else if(inQuote && str.charAt(i) == '"') {
                list.add(i);
                inQuote = false;
            }
            else if(inQuote && str.charAt(i) == ',') {
                list.add(i);
            }
            else if(str.charAt(i) == ' ' || str.charAt(i) == '%' || str.charAt(i) == '$') {
                list.add(i);
            }
        }

        for(int i = 0; i < list.size(); i++) {
            str = removeChar(str, list.get(i));
        }

        return str;
    }

    private static String removeChar(String str, int i) {
        return str.substring(0, i) + str.substring(i + 1);
    }

    private static int getStateIndex(String state, ArrayList<State> list) {
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i).getName().equals(state)) {
                return i;
            }
        }
        return -1;
    }

    private static int getCountyIndex(String county, ArrayList<County> list) {
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i).getName().equals(county)) {
                return i;
            }
        }
        return -1;
    }

}