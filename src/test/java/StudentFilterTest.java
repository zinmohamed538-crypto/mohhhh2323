import org.junit.jupiter.api.*;
import java.io.*;
import java.nio.file.*;

import static org.junit.jupiter.api.Assertions.*;

public class StudentFilterTest {

    private File inputFile;
    private File outputFile;

    @BeforeEach
    public void setup() throws IOException {
        inputFile = File.createTempFile("input", ".txt");
        outputFile = File.createTempFile("output", ".txt");

        BufferedWriter writer = new BufferedWriter(new FileWriter(inputFile));
        writer.write("John\t3\nAnna\t5\nMike\t4\nSara\t5");
        writer.close();
    }

    @Test
    public void testFilterGradeFive() throws IOException {

        StudentFilter.filterGradeFive(inputFile.getAbsolutePath(), outputFile.getAbsolutePath());

        String result = Files.readString(outputFile.toPath());

        assertTrue(result.contains("Anna\t5"));
        assertTrue(result.contains("Sara\t5"));
    }
}
