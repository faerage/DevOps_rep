import java.util.Scanner;
public class SixthTask {
    SixthTask(){
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введіть додатні числа. Для завершення вводу введіть 0 або число <= 9:");
            int min = searchMinimum(scanner, Integer.MAX_VALUE);
            if (min == Integer.MAX_VALUE) {
                System.out.println("Жодного валідного числа не було введено.");
            } else {
                System.out.println("Мінімальне введене число: " + min);
            }
        }
    }

    private static int searchMinimum(Scanner scanner, int currentMin) {
        if (!scanner.hasNextInt()) {
            System.out.println("Було введено не число. Спробуйте знову:");
            scanner.next();
            return searchMinimum(scanner, currentMin);
        }
        int number = scanner.nextInt();
        if (number == 0 || number <= 9) {
            return currentMin;
        } else {
            currentMin = Math.min(currentMin, number);
            return searchMinimum(scanner, currentMin);
        }
    }
}
