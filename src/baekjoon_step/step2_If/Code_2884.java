package baekjoon_step.step2_If;

import java.util.Scanner;

public class Code_2884 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int hour = input.nextInt();
        int min = input.nextInt();

        if (min >= 45)
            min -= 45;
        else {
            hour -= 1;
            min += 15;
            if (hour == -1)
                hour = 23;
        }

        System.out.print(hour + " " + min);
    }
}
