import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FourthTask {
    FourthTask(){
        Map<String, Double> menu = new HashMap<>();

        menu.put("Кава", 25.0);
        menu.put("Чай", 20.0);
        menu.put("Капучіно", 30.0);
        menu.put("Тістечко", 45.0);
        menu.put("Круасан", 40.0);
        menu.put("Торт", 60.0);

        Scanner scanner = new Scanner(System.in);
        boolean moreGroups = true;

        while (moreGroups) {
            System.out.print("На скільки людей робиться замовлення у цій компанії? ");
            int peopleCount = scanner.nextInt();

            double totalOrderCost = processGroupOrder(peopleCount, menu, scanner);

            System.out.println("Загальна сума замовлення для цієї компанії: " + totalOrderCost + " грн");

            System.out.print("Чи є ще одна компанія для обслуговування? (так/ні): ");
            moreGroups = scanner.next().equalsIgnoreCase("так");
        }

        System.out.println("Всі компанії обслуговано.");
    }

    private static double processGroupOrder(int peopleCount, Map<String, Double> menu, Scanner scanner) {
        double totalOrderCost = 0;

        for (int person = 1; person <= peopleCount; person++) {
            System.out.println("Замовлення для людини №" + person);
            double orderCost = 0;
            int itemNumber;

            while (true) {
                displayMenu(menu);
                System.out.println("Введіть номер пункту меню для додавання до замовлення (0 для завершення): ");
                itemNumber = scanner.nextInt();

                if (itemNumber == 0) {
                    break;
                } else if (itemNumber > 0 && itemNumber <= menu.size()) {
                    String selectedItem = (String) menu.keySet().toArray()[itemNumber - 1];
                    orderCost += menu.get(selectedItem);
                } else {
                    System.out.println("Неправильний вибір, спробуйте ще раз.");
                }
            }

            System.out.println("Сума замовлення для людини №" + person + ": " + orderCost + " грн");
            totalOrderCost += orderCost;
        }

        return totalOrderCost;
    }

    private static void displayMenu(Map<String, Double> menu) {
        System.out.println("Меню:");
        int index = 1;
        for (String item : menu.keySet()) {
            System.out.println(index++ + ". " + item + " - " + menu.get(item) + " грн");
        }
    }
}
