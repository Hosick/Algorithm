package baekjoon.baekjoon_step.step16_DP1;

import java.util.Scanner;

public class Code_1463 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();

        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 0;

        for (int i = 2; i <= n; ++i) {
            arr[i] = arr[i - 1] + 1;
            if (i % 3 == 0) arr[i] = Math.min(arr[i / 3] + 1, arr[i]);
            if (i % 2 == 0) arr[i] = Math.min(arr[i / 2] + 1, arr[i]);
        }

        System.out.print(arr[n]);
    }
}
