import java.util.*;

public class Game {
    private static Set<Character> errorChars;
    private static int errorCounter;
    private static String secretWord;
    private static int secretWordLength;

    public static void play() {
        secretWord = HiddenWordProvider.getWord();
        secretWordLength = secretWord.length();
        char[] playerWord = new char[secretWordLength];
        Arrays.fill(playerWord, '_');

        errorChars = new HashSet<>();
        errorCounter = 0;

        printStatus(playerWord, errorChars);
        while (errorCounter < 6) {
            String input = Main.scanner.next();
            if (checkValidInput(input)) {
                char letter = input.charAt(0);

                changePlayerWord(playerWord, letter);

                printStatus(playerWord, errorChars);
                if (Arrays.equals(playerWord, secretWord.toCharArray())) {
                    System.out.println("Победа!!!!!");
                    return;
                }
            }
        }
        System.out.println("Поражение, загаднанное слово --> " + secretWord);
    }

    private static void changePlayerWord(char[] playerWord, char letter) {
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

    private static void printStatus(char[] playerWord, Set<Character> errorChars) {
        System.out.println(HangmanAsciiPicture.values()[errorCounter].asciiPicture);
        System.out.println("Количество ошибок : " + errorCounter + "     неподходящие буквы : " + setToString(errorChars));
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
