import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class Zip {

    public static boolean zipFiles(File zipPath, File[] files){
        try (ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(zipPath))){
            for(File file : files){
                FileInputStream fileInputStream = new FileInputStream(file);
                ZipEntry entry = new ZipEntry(file.getName());
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

    public static boolean openZip(File zipPath, String dirExtractPath){
        try(ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(zipPath))) {

            ZipEntry entry;
            String fileName;

            while ((entry = zipInputStream.getNextEntry()) != null){
                fileName = entry.getName();
                File file = new File(dirExtractPath, fileName);
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                for (int i = zipInputStream.read(); i != -1 ; i = zipInputStream.read()) {
                    fileOutputStream.write(i);
                }
                fileOutputStream.flush();
                zipInputStream.closeEntry();
                fileOutputStream.close();
            }
            return true;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
