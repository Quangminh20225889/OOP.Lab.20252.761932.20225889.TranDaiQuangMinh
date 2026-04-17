package Lab03.AimsProject.SourceCode;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class NoGarbage {
    public static void main(String[] args) throws IOException {
        String filename = "Lab03/AimsProject/SourceCode/test.pdf";

        byte[] inputBytes = Files.readAllBytes(Paths.get(filename));

        long startTime = System.currentTimeMillis();
        StringBuilder outputStringBuilder = new StringBuilder();

        for (byte b : inputBytes) {
            outputStringBuilder.append((char) b);
        }

        String outputString = outputStringBuilder.toString();

        long endTime = System.currentTimeMillis();
        System.out.println("Time using StringBuilder: " + (endTime - startTime) + " ms");
    }
}
