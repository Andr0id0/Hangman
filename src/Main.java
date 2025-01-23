import java.util.Scanner;

class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        boolean gameIsOn = true;
        while (gameIsOn) {
            System.out.println("Хотите поиграть в висилцу? \n д (Да)  \n н (Нет)");
            String menu = scanner.next();

            if (menu.equals("д")) {
                Game.play();
            } else if (menu.equals("н")) {
                scanner.close();
                gameIsOn = false;
            } else {
                System.out.println("Введите 'д' или 'н'");
            }
        }
    }
}