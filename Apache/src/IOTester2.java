import java.io.IOException;
import org.apache.commons.io.FilenameUtils;

public class IOTester2 {
    public static void main(String[] args) {
        try {
            //Using FilenameUtils
            usingFilenameUtils();
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void usingFilenameUtils() throws IOException {
        String path = "D:\\Download\\Projects\\JavaBeggins\\input.txt";
        System.out.println("Full Path: " +FilenameUtils.getFullPath(path));
        System.out.println("Relative Path: " +FilenameUtils.getPath(path));
        System.out.println("Prefix: " +FilenameUtils.getPrefix(path));
        System.out.println("Extension: " + FilenameUtils.getExtension(path));
        System.out.println("Base: " + FilenameUtils.getBaseName(path));
        System.out.println("Name: " + FilenameUtils.getName(path));

        String filename = "D:/commons/io/../lang/project.xml";
        System.out.println("Normalized Path: " + FilenameUtils.normalize(filename));
    }
}