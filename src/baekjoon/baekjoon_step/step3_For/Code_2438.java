package baekjoon.baekjoon_step.step3_For;

import java.util.Scanner;

public class Code_2438 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = 0;

        while (N < 1 || N > 100) {
            N = input.nextInt();
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}