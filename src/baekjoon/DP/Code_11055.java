package baekjoon.DP;

import java.util.Scanner;

public class Code_11055 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; ++i)
            arr[i] = input.nextInt();

        int[] dp = new int[n];  //  길이가 n인 dp 배열 선언
        dp[0] = arr[0];         //  0까지의 LIS는 arr[0]으로 초기 설정
        int max = dp[0];        //  최대값도 dp[0]으로 초기화
        for (int i = 1; i < n; ++i) {
            for (int j = i - 1; j >= 0; --j) {
                if (arr[i] > arr[j])    //  배열의 j 번째 수 보다 작아야 LIS 성립가능
                    dp[i] = Math.max(dp[i], dp[j]); //  dp[j]의 최대값 찾기
            }
            dp[i] += arr[i];    //  배열의 i번째 수 더하고
            max = max < dp[i]? dp[i] : max; //  최대값인지 확인
        }

        System.out.print(max);
    }
}