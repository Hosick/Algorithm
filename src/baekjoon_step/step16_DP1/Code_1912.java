package baekjoon_step.step16_DP1;

import java.util.Scanner;

public class Code_1912 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int max;

        int[] arr = new int[n];
        int[] dp = new int[n];
        for (int i = 0; i < n; ++i)
            arr[i] = input.nextInt();

        dp[0] = arr[0];
        max = arr[0];
        for (int i = 1; i < n; ++i) {
            dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
            max = Math.max(dp[i], max);
        }

        System.out.print(max);
    }
}