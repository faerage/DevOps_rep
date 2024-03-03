import java.util.Scanner;

public class FirstTask {
    FirstTask() {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of hours: ");

        int hours = scanner.nextInt();
        scanner.close();
        String timeCategory;

        if(hours >=0 && hours< 6)
        {
            System.out.println("Good Night");
        } else if(hours< 13)
        {
            System.out.println("Good Morning");
        } else if(hours< 17)
        {
            System.out.println("Good Day");
        } else if(hours >=17||hours ==0)
        {
            System.out.println("Good Evening");
        } else
        {
            System.out.println("Invalid hour!");
        }
    }

}
