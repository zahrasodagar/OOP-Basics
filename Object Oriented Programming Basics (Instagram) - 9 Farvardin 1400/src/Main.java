import java.time.Instant;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    static Date startingTime = new Date(); // the initial value is the current date and time

    public static void main(String[] args) {
        Instagram instagram = Instagram.getInstance();
        String input;
        Scanner scanner = new Scanner(System.in);
        System.out.println(startingTime);
        System.out.println("Enter command");

        while (!(input = scanner.nextLine()).equals("SHUT THE PROGRAM")) {
            if (!InputManager.checkInput(input))
                System.out.println("Wrong input!");
        }

    }

    public static long getTimeDiff(Date date1, Date date2, TimeUnit timeUnit) {
        long diffInMillies = date2.getTime() - date1.getTime();
        return timeUnit.convert(diffInMillies, TimeUnit.MILLISECONDS);
    }
    // get the time difference using this method, for example:
    // getTimeDiff(date,new Date(),TimeUnit.SECONDS)
}
