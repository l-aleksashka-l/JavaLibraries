import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.IOCase;
import org.apache.commons.io.comparator.LastModifiedFileComparator;
import org.apache.commons.io.comparator.NameFileComparator;
import org.apache.commons.io.comparator.SizeFileComparator;
import org.apache.commons.io.filefilter.FileFileFilter;

public class IOTester14 {
    public static void main(String[] args) {
        try {
            usingNameFileComparator();
            System.out.println();
            usingSizeFileComparator();
            System.out.println();
            usingLastModifiedFileComparator();
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void usingNameFileComparator() throws IOException {
        //get the current directory
        File currentDirectory = new File(".");

        NameFileComparator comparator = new NameFileComparator(IOCase.INSENSITIVE);

        File[] sortedFiles = comparator.sort(currentDirectory.listFiles((FileFilter) FileFileFilter.INSTANCE));

        System.out.println("Sorted By Name: ");
        for(File file:sortedFiles) {
            System.out.println(file.getName());
        }
    }
    public static void usingSizeFileComparator() throws IOException {
        //get the current directory
        File currentDirectory = new File(".");

        SizeFileComparator comparator = new SizeFileComparator();

        File[] sortedFiles =
                comparator.sort(currentDirectory.listFiles((FileFilter)FileFileFilter.FILE));

        System.out.println("Sorted By Size: ");
        for(File file:sortedFiles) {
            System.out.println(file.getName() + ", size(kb) :" + file.length());
        }
    }
    public static void usingLastModifiedFileComparator() throws IOException {
        //get the current directory
        File currentDirectory = new File(".");

        LastModifiedFileComparator comparator = new LastModifiedFileComparator();

        File[] sortedFiles = comparator.sort(currentDirectory.listFiles((FileFilter)FileFileFilter.FILE));

        System.out.println("Sorted By Last Modified date: ");
        for(File file:sortedFiles) {
            System.out.println(file.getName() + ", Modified on: " + new Date(file.lastModified()));
        }
    }
}