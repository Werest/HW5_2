import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    public static boolean zipFiles(String path, String[] files){
        try (ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(path))){
            for(String file : files){
                File file1 = new File(file);
                FileInputStream fileInputStream = new FileInputStream(file1);
                ZipEntry entry = new ZipEntry(file1.getName());
                zipOutputStream.putNextEntry(entry);

                byte[] buffer = new byte[fileInputStream.available()];
                fileInputStream.read(buffer);
                zipOutputStream.write(buffer);
                zipOutputStream.closeEntry();
                fileInputStream.close();
            }
            return true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
