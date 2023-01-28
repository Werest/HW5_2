import java.io.*;

public class Serialization {
    public static boolean saveGame(String path, GameProgress gameProgress){
        try(FileOutputStream fileOutputStream     = new FileOutputStream(path);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)){

            objectOutputStream.writeObject(gameProgress);
            return true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static GameProgress openProgress(File file){
        try (FileInputStream fileInputStream       = new FileInputStream(file);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            return (GameProgress) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
