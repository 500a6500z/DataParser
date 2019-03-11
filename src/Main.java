import java.util.ArrayList;

/***
 * Main class for data parses
 * @author: quakalac
 */

public class Main {
    public static void main(String[] args) {
        String data = Utils.readFileAsString("data/2016_Presidential_Results.csv");
        DataManager d = Utils.parseFiles("data/2016_Presidential_Results.csv", "data/Education.csv", "data/Unemployment.csv");
    }
}
