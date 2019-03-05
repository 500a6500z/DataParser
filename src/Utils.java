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
}
