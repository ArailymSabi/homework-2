import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MUDController {
    private Set<String> inventory = new HashSet<>();
    private String currentRoom = "Начальная комната";

    public static void main(String[] args) {
        MUDController game = new MUDController();
        game.start();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("ДОБРО ПОЖАЛОВАТЬ В ПРИКЛЮЧЕНИЕ В ПОДЗЕМЕЛЬЕ\nВведите 'help', чтобы увидеть доступные команды.");

        while (true) {
            System.out.print("\n> ");
            String command = scanner.nextLine().trim().toLowerCase();

            switch (command) {
                case "look":
                    System.out.println("Вы видите древние надписи на стенах и ржавый ключ, лежащий в углу.");
                    break;
                case "go north":
                    currentRoom = "Длинный коридор";
                    System.out.println("Вы открываете деревянную дверь и заходите в длинный коридор. Выходы: Юг, Запад.");
                    break;
                case "inventory":
                    if (inventory.isEmpty()) {
                        System.out.println("Ваш инвентарь пуст.");
                    } else {
                        System.out.println("Вы несете:");
                        for (String item : inventory) {
                            System.out.println("- " + item);
                        }
                    }
                    break;
                case "pick up key":
                    if (!inventory.contains("ржавый ключ")) {
                        inventory.add("ржавый ключ");
                        System.out.println("Вы подобрали ржавый ключ.");
                    } else {
                        System.out.println("У вас уже есть ржавый ключ.");
                    }
                    break;
                case "help":
                    System.out.println("Доступные команды:");
                    System.out.println("- look : Описать окружающую обстановку.");
                    System.out.println("- go north : Переместиться на север в другую комнату.");
                    System.out.println("- inventory : Проверить, какие предметы у вас есть.");
                    System.out.println("- pick up key : Подобрать предмет.");
                    System.out.println("- help : Показать это сообщение с подсказками.");
                    break;
                case "exit":
                    System.out.println("Выход из игры. До свидания!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Неизвестная команда. Введите 'help' для списка команд.");
                    break;
            }
        }
    }
}

