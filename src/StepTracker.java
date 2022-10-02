
import java.util.Scanner;
import java.util.ArrayList;
public class StepTracker {


    MonthData[] monthToData;
    String[] nameMonth = new String[12];
    Converter converter = new Converter();
    int rateStepDistance = 75;
    int rateStepCCal = 50;
    int goalNumStep = 10000;



    StepTracker() {
        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
        nameMonth[0] = "январь";
        nameMonth[1] = "февраль";
        nameMonth[2] = "март";
        nameMonth[3] = "апрель";
        nameMonth[4] = "май";
        nameMonth[5] = "июнь";
        nameMonth[6] = "июль";
        nameMonth[7] = "август";
        nameMonth[8] = "сентябрь";
        nameMonth[9] = "октябрь";
        nameMonth[10] = "ноябрь";
        nameMonth[11] = "декабрь";
    }
    void saveNumStep () {
        Scanner scanner = new Scanner(System.in);
        System.out.println("За какой месяц Вы хотите внести кол-во шагов? Введите цифру от 0 до 11, где 0 - первый месяц, 11 - последний.");
        int i = scanner.nextInt();
            if (i < 0 || i > 11) {
                System.out.println("Значение введено неверно.");
                System.out.println("За какой месяц Вы хотите внести кол-во шагов? Введите цифру от 0 до 11, где 0 - первый месяц, 11 - последний.");
                i = scanner.nextInt();
            }

        System.out.println("За какой день Вы хотите внести кол-во шагов? Введите цифру от 0 до 29, где 0 - первый день месяца, 29 - последний.");
        int j = scanner.nextInt();
            if (j < 0 || j > 29) {
                System.out.println("Значение введено неверно.");
                System.out.println("За какой день Вы хотите внести кол-во шагов? Введите цифру от 0 до 29, где 0 - первый день месяца, 29 - последний.");
                j = scanner.nextInt();
            }

        System.out.println("Введите количество пройденных шагов.");
        int numStep = scanner.nextInt();
            if (numStep < 0) {
                System.out.println("Количество пройденных шагов не может быть отрицательным.");
                System.out.println("Введите количество пройденных шагов.");
                numStep = scanner.nextInt();
            }

        monthToData[i].days[j] = numStep;
        System.out.println("Значение сохранено. Количество шагов за день " + j + " месяц " + i + " равно " + monthToData[i].days[j]);
    }
    void showStatByMonth() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("За какой месяц Вы хотите отобразить статистику? Введите цифру от 0 до 11");
        int i = scanner.nextInt();

        int maxNumSteps = 0;
        int sumStepsByMonth = 0;
        ArrayList<Integer> countArray = new ArrayList<>();
        int count = 0;
        int maxCount = 0;
        for (int j = 0; j < monthToData[i].days.length; j++) {
            sumStepsByMonth = monthToData[i].days[j] + sumStepsByMonth;
            System.out.println ((j + 1) + " день: " + monthToData[i].days[j]);
            if (monthToData[i].days[j] > maxNumSteps) {
                maxNumSteps = monthToData[i].days[j];
            }
            if (monthToData[i].days[j] >= goalNumStep) {
                count++;
                countArray.add(count);
            } else {
                count = 0;
            }
            for (Integer max : countArray) {
                if (maxCount < max) {
                    maxCount = max;
                }
            }
        }

        System.out.println(" ");
        System.out.println("За " + nameMonth[i] + " количество пройденных шагов равно " + sumStepsByMonth);
        System.out.println("Максимальное количество шагов за месяц равно " + maxNumSteps);
        System.out.println("Среднее количество шагов за месяц равно " + sumStepsByMonth/30);
        converter.convertDistance (sumStepsByMonth, rateStepDistance);
        converter.convertCCal (sumStepsByMonth, rateStepCCal);
        System.out.println("Лучшая серия за месяц " + maxCount);
        }

    void updateGoalNumStep() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Текущая цель по шагам за день " + goalNumStep);
        while (true) {
            System.out.println("Введите новое значене цели шагов за день:");
            goalNumStep = scanner.nextInt();
            if (goalNumStep > 0) {
                System.out.println ("Обновленная цель по шагам за день " + goalNumStep);
                break;
            } else {
                System.out.println ("Цель по шагам не может быть равна 0 или отрицательному значению.");
            }
        }

    }

}


