import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

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


}
