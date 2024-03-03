import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SecondTask {
   SecondTask() {
        Scanner scanner = new Scanner(System.in);
        int score = 0;

        Map<String, Integer> questionsAndAnswers = new HashMap<>();
        questionsAndAnswers.put("Професор ліг спати о 8 годині, а встав о 9 годині. Скільки годин проспав професор?", 1);
        questionsAndAnswers.put("На двох руках десять пальців. Скільки пальців на 10?", 50);
        questionsAndAnswers.put("Скільки цифр у дюжині?", 2);
        questionsAndAnswers.put("Скільки потрібно зробити розпилів, щоб розпиляти колоду на 12 частин?", 11);
        questionsAndAnswers.put("Лікар зробив три уколи в інтервалі 30 хвилин. скільки часу він витратив?", 30);
        questionsAndAnswers.put("Скільки цифр 9 в інтервалі 1100?", 1);
        questionsAndAnswers.put("Пастух мав 30 овець. Усі, крім однієї, розбіглися. Скільки овець лишилося?", 1);

        for (Map.Entry<String, Integer> entry : questionsAndAnswers.entrySet()) {
            System.out.println(entry.getKey());
            int answer = scanner.nextInt();
            if (answer == entry.getValue()) {
                score++;
            }
        }

        scanner.close();

        switch (score) {
            case 7:
                System.out.println("Геній");
                break;
            case 6:
                System.out.println("Ерудит");
                break;
            case 5:
                System.out.println("Нормальний");
                break;
            case 4:
                System.out.println("Здібності середні");
                break;
            case 3:
                System.out.println("Здібності нижче середнього");
                break;
            default:
                System.out.println("Вам треба відпочити!");
                break;
        }
    }
}
