import java.util.Scanner;

class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("Хотите поиграть в висилцу? \n д (Да)  \n н (Нет)");
            String menu = scanner.nextLine();

            if (menu.equals("д")) {
                Game.play();
            } else if (menu.equals("н")) {
                scanner.close();
                System.exit(0);
            } else {
                System.out.println("Введите 'д' или 'н'");
            }
        }
    }
}