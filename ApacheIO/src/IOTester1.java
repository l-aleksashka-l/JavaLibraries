import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.commons.io.FileUtils;

/*
Методы записи в файл.
        Методы для чтения из файла.
        Методы создания каталога, включая родительские каталоги.
        Методы копирования файлов и каталогов.
        Методы удаления файлов и каталогов.
        Методы для преобразования в и из URL.
        Методы для вывода списка файлов и каталогов по фильтрам и расширениям.
        Методы для сравнения содержимого файла.
        Методы для регистрации даты последнего изменения.
        Методы расчета контрольной суммы.
*/

public class IOTester1 {
    public static void main(String[] args) {
        try {
            //Using FileUtils
            usingFileUtils();
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void usingFileUtils() throws IOException {
        //get the file object
        File file = FileUtils.getFile("input.txt");

        //get the temp directory
        File tmpDir = FileUtils.getTempDirectory();

        System.out.println(tmpDir.getName());

        //copy file to temp directory
        FileUtils.copyFileToDirectory(file, tmpDir);

        System.out.println(file.getName());
        //create a new file
        File newTempFile = FileUtils.getFile(tmpDir, file.getName());

        //get the content
        String data = FileUtils.readFileToString(newTempFile, Charset.defaultCharset());

        System.out.println(newTempFile.getName());
        //print the content
        System.out.println(data);
    }
}
