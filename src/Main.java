import java.io.File;

public class Main {
    public static void main(String[] args) {
        final File dirSave = new File("F:\\ProjectJava\\Games\\savegames");
        GameProgress[] gameProgresses = {
                new GameProgress(400, 3, 30, 13.1),
                new GameProgress(500, 3, 45, 20.9),
                new GameProgress(1500, 6, 85, 150.9)
        };
        String[] files = new String[gameProgresses.length];

        if(dirSave.exists()){
            for (int i = 0; i < gameProgresses.length; i++) {
                files[i] = dirSave + "\\save" + (i + 1) + ".dat";
                if(Serialization.saveGame(files[i], gameProgresses[i])){
                    System.out.println("Успешное сохранение файла save" + (i + 1));
                }else{
                    System.out.println("Не удачное сохранение файла save" + (i + 1));
                }
            }
        }//dirSave.exists

        String zipFile = "F:\\ProjectJava\\Games\\savegames\\zip.zip";

            if(Zip.zipFiles(zipFile, files)){
                System.out.println("Файлы упакованы в архив");
            }else {
                System.out.println("Файл не упакованы в архив");
            }





    }
}
