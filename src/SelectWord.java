import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class SelectWord {

    private static final Path PATH = Paths.get("resources/words.txt");

    public static String getWord() {
        List<String> words;
        try {
            words = Files.readAllLines(PATH);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        int length = words.size();
        int index = (int) (Math.random() * length);
        return words.get(index);
    }
}
