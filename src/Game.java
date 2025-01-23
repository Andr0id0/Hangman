import java.util.*;

public class Game {

    public static void play() {
        String secretWord = HiddenWordProvider.getWord();
        int secretWordLength = secretWord.length();
        char[] playerWord = new char[secretWordLength];
        Arrays.fill(playerWord, '_');

        Set<Character> errorChars = new HashSet<>();
        int errorCounter = 0;

        printStatus(errorCounter, playerWord, setToString(errorChars));
        while (errorCounter < 6) {
            String input = Main.scanner.next();
            if (checkValidInput(input)) {
                char letter = input.charAt(0);

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

                printStatus(errorCounter, playerWord, setToString(errorChars));
                if (Arrays.equals(playerWord, secretWord.toCharArray())) {
                    System.out.println("Победа!!!!!");
                    return;
                }
            }
        }
        System.out.println("Поражение, загаднанное слово --> " + secretWord);
    }

    private static boolean checkValidInput(String input) {
        if (input.length() != 1) {
            System.out.println("Вы ввели болше одной буквы");
            return false;
        }
        char letter = input.charAt(0);
        if (!(letter >= 'а' && letter <= 'я')) {
            System.out.println("Вы ввели неправильный символ");
            return false;
        }
        return true;
    }

    private static void printStatus(int errorCounter, char[] playerWord, String errorCharsString) {
        System.out.println(HangmanAsciiPicture.values()[errorCounter].asciiPicture);
        System.out.println("Количество ошибок : " + errorCounter + "     неподходящие буквы : " + errorCharsString);
        System.out.println(playerWord);
    }

    private static String setToString(Set<Character> set) {
        StringBuilder errorCharsStringBuilder = new StringBuilder();
        for (char chars : set) {
            errorCharsStringBuilder.append(chars);
            errorCharsStringBuilder.append(", ");
        }
        String errorCharsString = "";
        if (!errorCharsStringBuilder.isEmpty()) {
            errorCharsString = errorCharsStringBuilder.substring(0, errorCharsStringBuilder.length() - 2);
        }
        return errorCharsString;
    }
}
