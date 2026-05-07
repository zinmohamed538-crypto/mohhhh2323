import java.io.*;
import java.util.regex.*;

public class StudentFilter {

    public static void filterGradeFive(String inputFile, String outputFile) throws IOException {

        Pattern pattern = Pattern.compile(".*\\t5$");

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));

        String line;

        while ((line = reader.readLine()) != null) {
            Matcher matcher = pattern.matcher(line);
            if (matcher.matches()) {
                writer.write(line);
                writer.newLine();
            }
        }

        reader.close();
        writer.close();
    }
}

