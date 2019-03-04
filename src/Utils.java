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
        for(int i = 0; i < lines.length; i++) {
            String[] resultData = lines[i].split(",");
            output.add(new ElectionResult(Double.parseDouble(resultData[1]), Double.parseDouble(resultData[2]), Double.parseDouble(resultData[3]), Double.parseDouble(resultData[4]), Double.parseDouble(resultData[5]), resultData[6], Double.parseDouble(resultData[7].substring(0, resultData[7].length() - 1)), resultData[8], resultData[9], Integer.parseInt(resultData[10])));
        }
        return output;
    }
}
