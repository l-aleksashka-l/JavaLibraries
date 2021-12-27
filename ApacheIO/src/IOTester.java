import org.apache.commons.io.IOUtils;

import java.io.*;

public class IOTester {
    public static void main(String[] args) {
        try {
            //Using BufferedReader
            readUsingTraditionalWay();

            //Using IOUtils
            readUsingIOUtils();
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }

    //reading a file using buffered reader line by line
    public static void readUsingTraditionalWay() throws IOException {
        try(BufferedReader bufferReader
                    = new BufferedReader( new InputStreamReader(
                new FileInputStream("input.txt") ) )) {
            String line;
            while( ( line = bufferReader.readLine() ) != null ) {
                System.out.println( line );
            }
        }
    }

    //reading a file using IOUtils in one go
    public static void readUsingIOUtils() throws IOException {
        try(InputStream in = new FileInputStream("input.txt")) {
            System.out.println( IOUtils.toString( in , "UTF-8") );
        }
    }
}