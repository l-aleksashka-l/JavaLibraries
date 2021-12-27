import java.io.File;
import java.io.IOException;

import org.apache.commons.io.filefilter.OrFileFilter;
import org.apache.commons.io.filefilter.PrefixFileFilter;
import org.apache.commons.io.filefilter.WildcardFileFilter;

public class IOTester10 {
    public static void main(String[] args) {
        try {
            usingOrFileFilter();
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void usingOrFileFilter() throws IOException {
        //get the current directory
        File currentDirectory = new File(".");

        //get names of all files and directory in current directory
        String[] files = currentDirectory.list();
        System.out.println("All files and Folders.\n");
        for( int i = 0; i < files.length; i++ ) {
            System.out.println(files[i]);
        }

        System.out.println("\nFile starting with . or ends with t\n");
        String[] filesNames = currentDirectory.list(
                new OrFileFilter(new PrefixFileFilter("."), new WildcardFileFilter("*t")));
        for( int i = 0; i < filesNames.length; i++ ) {
            System.out.println(filesNames[i]);
        }
    }
}