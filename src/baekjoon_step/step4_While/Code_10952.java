package baekjoon_step.step4_While;

import java.util.Scanner;

public class Code_10952 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int a = -1;
        int b = -1;

        while (a != 0 || b != 0) {
            a = input.nextInt();
            b = input.nextInt();
            if (a != 0 || b != 0)
                System.out.println(a + b);
        }
    }
}