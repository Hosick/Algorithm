package baekjoon.DP;

import java.util.Scanner;

public class Code_2631 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();    //  전체 수열의 길이

        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; ++i)
            arr[i] = input.nextInt();

        int[] dp = new int[n + 1];  //  LIS를 구하기 위한 dp배열

        int lis = 1;
        for (int i = 1; i <= n; ++i) {
            dp[i] = 1;
            for (int j = 1; j < i; ++j) {
                if (arr[j] < arr[i])
                    dp[i] = Math.max(dp[i], dp[j] + 1); //  앞의 수가 더 작을 때 dp를 통해 증가하는 수열 구하기
            }
            lis = Math.max(lis, dp[i]); //  LIS
        }

        System.out.print(n - lis);  //  전체 수열에서 LIS에 속하지 않는 원소만 움직이는 경우의 수 (전체 - LIS)
    }
}