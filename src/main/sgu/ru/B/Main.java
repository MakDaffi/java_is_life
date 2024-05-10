package src.main.sgu.ru.B;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Main {
    public void main() throws IOException {
        String[] args = System.console().readLine("Enter directory path and name separated by a space: ").split(" ");
        String directoryName = args[0];
        String pattern = args[1];
        File directory = new File(directoryName);
        ArrayList<String> files = findFilesByPatter(directory, pattern);
        saveToZip(directoryName, files);
    }

    public static void saveToZip(String directoryName, ArrayList<String> filesPath) throws IOException {
        FileOutputStream fileOutput = new FileOutputStream(directoryName + ".zip");
        ZipOutputStream zipOut = new ZipOutputStream(fileOutput);
        for (String filePath: filesPath) {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            ZipEntry zipEntry = new ZipEntry(filePath);
            zipOut.putNextEntry(zipEntry);
            byte[] bytes = new byte[1024];
            int length;
            while ((length = fileInputStream.read(bytes)) >= 0) {
                zipOut.write(bytes, 0, length);
            }
            zipOut.closeEntry();
            fileInputStream.close();
        }
        zipOut.close();
    }

    public static ArrayList<String> findFilesByPatter(File curDirectory, String pattern) {
        ArrayList<String> result = new ArrayList<String>();
        for (File curFile : curDirectory.listFiles())  {
            String curFilePath = curFile.getPath();
            if (curFile.isFile()) {
                if (curFilePath.toLowerCase().contains(pattern)) {
                    result.add(curFilePath);
                }
            } else {
                result.addAll(findFilesByPatter(new File(curFilePath), pattern));
            }
        }
        return result;
    }
}
