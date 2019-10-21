package baekjoon_step.step3_For;

import java.util.Scanner;

public class Code_2739 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int x = 0;

        while (x < 1 || x > 9) {
            x = input.nextInt();
        }
        for (int i = 1; i < 10; i++) {
            System.out.println(x + " * " + i + " = " + x * i);
        }
    }
}