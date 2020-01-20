package baekjoon_step.step3_For;

import java.util.Scanner;

public class Code_11021 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int a[] = new int[n];
        int b[] = new int[n];
        int c[] = new int[n];

        for (int i = 0; i < n; ++i) {
            a[i] = input.nextInt();
            b[i] = input.nextInt();
            c[i] = a[i] + b[i];
        }

        for (int j = 0; j < n; ++j) {
            System.out.println("Case #" + (j + 1) + ": " + c[j]);
        }
    }
}