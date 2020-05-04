/**
 * 전선이 겹치지 않게 하려먼 전선의 왼쪽과 마찬가지로 전선의 오른쪽도 오름차순이 되어야 한다.
 * 한마디로 LIS(최장 증가 부분 수열)의 길이를 구하는 문제이다.
 **/
package baekjoon.DP;

import java.util.Arrays;
import java.util.Scanner;

public class Code_2352 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();

        int[] line = new int[n + 1];
        for (int i = 1; i <= n; ++i)
            line[i] = input.nextInt();

        int max = 1;    //  LIS 저장할 변수
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 1);
        for (int i = 2; i <= n; ++i) {      //  i는 2 ~ n
            for (int j = 1; j < i; ++j) {   //  j는 1 ~ (i-1)
                if (line[j] < line[i]) {    //  i와 j, line[i]와 line[j]가 모두 오름차순이라면
                    dp[i] = Math.max(dp[i], dp[j] + 1); //  dp[i] = dp[j] + 1
                }
                max = Math.max(max, dp[i]);
            }
        }

        System.out.print(max);
    }
}