import java.io.File;

public class Main {
    public static void main(String[] args) {
        final File dirSave = new File("F:\\ProjectJava\\Games\\savegames");
        GameProgress[] gameProgresses = {
                new GameProgress(400, 3, 30, 13.1),
                new GameProgress(500, 3, 45, 20.9),
                new GameProgress(1500, 6, 85, 150.9)
        };

        if(dirSave.exists()){
            for (int i = 0; i < gameProgresses.length; i++) {
                if(Serialization.saveGame(dirSave + "\\save" + (i + 1) + ".dat", gameProgresses[i])){
                    System.out.println("Успешное сохранение файла save" + (i + 1));
                }else{
                    System.out.println("Не удачное сохранение файла save" + (i + 1));
                }
            }
        }//dirSave.exists

        File[] files_ = dirSave.listFiles(x -> !x.getName().endsWith(".zip"));
        File zipFile = new File(dirSave, "zip.zip");

        if(files_ != null && Zip.zipFiles(zipFile, files_)){
            System.out.println("Файлы упакованы в архив");
            for (File file : files_){
                if(file.delete()){
                    System.out.println("Файл " + file.getName() + " удалён");
                }else {
                    System.out.println("Файл " + file.getName() + " не удалён");
                }
            }
        }else {
            System.out.println("Файл не упакованы в архив");
        }

        if(Zip.openZip(zipFile, dirSave.getPath())){
            System.out.println("Архив распакован!");
            if(files_ != null){
                GameProgress gameProgress_1 = Serialization.openProgress(files_[2]);
                System.out.println(gameProgress_1);
            }
        }
    }
}
