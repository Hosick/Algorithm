package baekjoon_step.step6_Array;

import java.util.Scanner;

public class Code_10818 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int[] num = new int[n];

        for (int i = 0; i < n; ++i) {
            num[i] = input.nextInt();
        }
        int min = num[0];
        int max = num[0];

        for (int i = 1; i < n; ++i) {
            if (num[i] > max) max = num[i];
            if (num[i] < min) min = num[i];
        }

        System.out.print(min + " " + max);
    }
}