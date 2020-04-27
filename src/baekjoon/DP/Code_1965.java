package baekjoon.DP;

import java.util.Arrays;
import java.util.Scanner;

public class Code_1965 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();

        int[] arr = new int[n + 1]; //  상자배열
        for (int i = 1; i <= n; ++i)
            arr[i] = input.nextInt();

        int max = 1;    //  LIS
        int[] dp = new int[n + 1];  //  DP배열
        Arrays.fill(dp, 1);    //  모두 1로 초기화
        for (int i = 2; i <= n; ++i) {
            for (int j = i - 1; j > 0; --j) {
                if (arr[i] > arr[j])    //  i 상자에 j 상자를 넣을 수 있을 때
                    dp[i] = Math.max(dp[i], dp[j] + 1); // 가장 많이 들어있는 j 상자 찾기
            }
            max = Math.max(max, dp[i]);
        }

        System.out.print(max);
    }
}
