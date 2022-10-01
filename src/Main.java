import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();

        while (true){
            printMenu();
            int userInput = scanner.nextInt();
            if (userInput == 1) {
                stepTracker.saveNumStep();
            } else if (userInput == 2) {
                stepTracker.showStatByMonth();
            } else if (userInput == 3) {
                stepTracker.updateGoalNumStep();
            } else if (userInput == 4) {
                System.out.println("Работа приложения завершена");
                break;
            } else {
                System.out.println("Не верно введено число");
            }
        }
    }
    private static void printMenu() {
        System.out.println("......................");
        System.out.println("Что Вы хотите сделать?");
        System.out.println("1. Ввести количество шагов за один день;");
        System.out.println("2. Напечатать статистику за определенный месяц;");
        System.out.println("3. Изменить цель по количеству шагов в день;");
        System.out.println("4. Выйти из приложения;");
        System.out.println("......................");
    }
}

