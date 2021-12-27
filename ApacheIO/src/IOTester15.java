import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.input.TeeInputStream;
import org.apache.commons.io.output.TeeOutputStream;

public class IOTester15 {


    public static void main(String[] args) {
        try {
            File file = FileUtils.getFile("input.txt");
            File tmpDir = FileUtils.getTempDirectory();
            FileUtils.copyFileToDirectory(file,tmpDir);
            File newTempFile = FileUtils.getFile(tmpDir, file.getName());
            String data = FileUtils.readFileToString(newTempFile, Charset.defaultCharset());
            usingTeeInputStream(data);
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void usingTeeInputStream(String data) throws IOException {
        TeeInputStream teeInputStream = null;
        TeeOutputStream teeOutputStream;

        try {
            ByteArrayInputStream inputStream = new ByteArrayInputStream(data.getBytes());
            ByteArrayOutputStream outputStream1 = new ByteArrayOutputStream();
            ByteArrayOutputStream outputStream2 = new ByteArrayOutputStream();

            teeOutputStream = new TeeOutputStream(outputStream1, outputStream2);
            teeInputStream = new TeeInputStream(inputStream, teeOutputStream, true);
            teeInputStream.read(new byte[data.length()]);

            System.out.println("Output stream 1: " + outputStream1);
            System.out.println("Output stream 2: " + outputStream2);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            //teeIn.close() closes teeIn and teeOut which in turn closes the out1 and out2.
            try {
                teeInputStream.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
