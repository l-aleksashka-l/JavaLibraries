import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.monitor.FileEntry;
import java.util.Date;

public class IOTester12 {
    public static void main(String[] args) {
        try {
            usingFileEntry();
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void usingFileEntry() throws IOException {
        //get the file object
        File file = FileUtils.getFile("input.txt");

        FileEntry fileEntry = new FileEntry(file);

        System.out.println("Monitored File: " + fileEntry.getFile());
        System.out.println("File name: " + fileEntry.getName());
        System.out.println("Is Directory: " + fileEntry.isDirectory());
        System.out.println(new Date(file.lastModified()));
        System.out.println("Last modified: " + new Date(fileEntry.getLastModified()));

    }
}