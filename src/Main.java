import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Path path = Paths.get("resources/words.txt");
        Scanner scanner = new Scanner(System.in);
        Game game = new Game();

        while (true) {
            System.out.println("Хотите поиграть в висилцу? \n 1. Да \n 2. Нет");
            int menu = scanner.nextInt();
            if (menu == 1) {
                game.play(path, scanner);
            } else {
                System.out.println("конец игры");
                break;
            }
        }
    }
}