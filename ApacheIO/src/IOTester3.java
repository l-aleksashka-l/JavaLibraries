import java.io.IOException;

import org.apache.commons.io.FileSystemUtils;

public class IOTester3 {
    public static void main(String[] args) {
        try {
            System.out.println("Free Space " + FileSystemUtils.freeSpaceKb("D:/") + " Bytes on D:/");

        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }
}