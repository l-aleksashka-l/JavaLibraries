import java.io.File;
import java.io.IOException;

import org.apache.commons.io.filefilter.PrefixFileFilter;

public class IOTester9 {
    public static void main(String[] args) {
        try {
            usingPrefixFileFilter();
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void usingPrefixFileFilter() throws IOException {
        //get the current directory
        File currentDirectory = new File(".");

        //get names of all files and directory in current directory
        String[] files = currentDirectory.list();
        System.out.println("All files and Folders.\n");
        for( int i = 0; i < files.length; i++ ) {
            System.out.println(files[i]);
        }

        System.out.println("\nFile starting with input\n");
        String[] filesNames = currentDirectory.list( new PrefixFileFilter("input") );
        for( int i = 0; i < filesNames.length; i++ ) {
            System.out.println(filesNames[i]);
        }
    }
}