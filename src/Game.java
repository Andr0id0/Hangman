import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Game {

    private String hiddenWord;
    private int hiddenWordLength;
    char[] playerWord;

    private void chooseWord(Path path) {
        List<String> words;
        try {
            words = Files.readAllLines(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        int length = words.size();
        int index = (int) (Math.random() * length);
        this.hiddenWord = words.get(index);
        this.hiddenWordLength = hiddenWord.length();
        playerWord = new char[hiddenWordLength];
        for (int i = 0; i < hiddenWordLength; i++) {
            playerWord[i] = '_';
        }
    }

    private void guessWord(Scanner scanner) {
        Set<Character> set = new HashSet<>();
        Set<Character> set2 = new HashSet<>();
        int errorCounter = 0;
        System.out.println(Picture.values()[errorCounter].picture);
        System.out.println("Количество ошибок : " + errorCounter);
        System.out.println(playerWord);
        while (errorCounter < 6) {
            String s = scanner.next();
            if (s.length() == 1) {
                char c = s.charAt(0);
                if (!(c >= 'а' && c <= 'я')) {
                    System.out.println("Вы ввели неправильный символ");
                    continue;
                }
                boolean isChange = false;
                for (int l = 0; l < hiddenWordLength; l++) {
                    if (hiddenWord.charAt(l) == c) {
                        playerWord[l] = c;
                        isChange = true;
                    }
                }
                if (!isChange && !set2.contains(c)) {
                    errorCounter++;
                    set2.add(c);
                }
                set.add(c);
                StringBuilder sb = new StringBuilder();
                for (char chars : set2) {
                    sb.append(chars);
                    sb.append(", ");
                }
                String sc = "";
                if (!sb.isEmpty()) {
                    sc = sb.substring(0, sb.length() - 2);
                }

                System.out.println(Picture.values()[errorCounter].picture);
                System.out.println("Количество ошибок : " + errorCounter + "     неподходящие буквы : " + sc);
                System.out.println(playerWord);
                if (Arrays.equals(playerWord, hiddenWord.toCharArray())) {
                    return;
                }

            } else {
                System.out.println("Вы ввели болше одной буквы");
            }
        }
    }


    public void play(Path path, Scanner scanner) {
        chooseWord(path);
        guessWord(scanner);
        if (Arrays.equals(playerWord, hiddenWord.toCharArray())) {
            System.out.println("Победа");
        } else {
            System.out.println("Поражение, загаднанное слово --> " + hiddenWord);
        }
    }

}
