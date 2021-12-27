import java.io.File;
import java.io.IOException;

import org.apache.commons.io.IOCase;
import org.apache.commons.io.filefilter.NameFileFilter;

public class IOTester7 {
    public static void main(String[] args) {
        try {
            usingNameFileFilter();
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void usingNameFileFilter() throws IOException {
        //get the current directory
        File currentDirectory = new File(".");

        //get names of all files and directory in current directory
        String[] files = currentDirectory.list();
        System.out.println("All files and Folders.\n");
        for( int i = 0; i < files.length; i++ ) {
            System.out.println(files[i]);
        }

        System.out.println("\nFile with name input.txt\n");
        String[] acceptedNames = {"input", "input.txt"};
        String[] filesNames = currentDirectory.list( new NameFileFilter(acceptedNames, IOCase.INSENSITIVE) );

        for( int i = 0; i < filesNames.length; i++ ) {
            System.out.println(filesNames[i]);
        }
    }
}