import java.util.*;

public class Game {

    public static void play() {
        String secretWord = SelectWord.getWord();
        int secretWordLength = secretWord.length();
        char[] playerWord = new char[secretWordLength];
        for (int i = 0; i < secretWordLength; i++) {
            playerWord[i] = '_';
        }

        Set<Character> errorChars = new HashSet<>();
        int errorCounter = 0;
        System.out.println(Picture.values()[errorCounter].picture);
        System.out.println("Количество ошибок : " + errorCounter);
        System.out.println(playerWord);
        while (errorCounter < 6) {
            String input = Main.scanner.next();
            if (input.length() == 1) {
                char letter = input.charAt(0);
                if (!(letter >= 'а' && letter <= 'я')) {
                    System.out.println("Вы ввели неправильный символ");
                    continue;
                }
                boolean isChange = false;

                for (int l = 0; l < secretWordLength; l++) {
                    if (secretWord.charAt(l) == letter) {
                        playerWord[l] = letter;
                        isChange = true;
                    }
                }
                if (!isChange && !errorChars.contains(letter)) {
                    errorCounter++;
                    errorChars.add(letter);
                }

                StringBuilder errorCharsStringBuilder = new StringBuilder();
                for (char chars : errorChars) {
                    errorCharsStringBuilder.append(chars);
                    errorCharsStringBuilder.append(", ");
                }
                String errorCharsString = "";
                if (!errorCharsStringBuilder.isEmpty()) {
                    errorCharsString = errorCharsStringBuilder.substring(0, errorCharsStringBuilder.length() - 2);
                }

                System.out.println(Picture.values()[errorCounter].picture);
                System.out.println("Количество ошибок : " + errorCounter + "     неподходящие буквы : " + errorCharsString);
                System.out.println(playerWord);
                if (Arrays.equals(playerWord, secretWord.toCharArray())) {
                    break;
                }

            } else {
                System.out.println("Вы ввели болше одной буквы");
            }
        }
        if (Arrays.equals(playerWord, secretWord.toCharArray())) {
            System.out.println("Победа!!!!!");
        } else {
            System.out.println("Поражение, загаднанное слово --> " + secretWord);
        }
    }
}
