package baekjoon_step.step3_For;

import java.util.Scanner;

public class Code_8393 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = 0, m = 0;

        while (n < 1 || n > 10000) {
            n = input.nextInt();
        }

        for (int i = 1; i <= n; i++) {
            m += i;
        }
        System.out.println(m);
    }
}