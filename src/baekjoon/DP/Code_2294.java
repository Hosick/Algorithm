package baekjoon.DP;

import java.util.Arrays;
import java.util.Scanner;

public class Code_2294 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();    //  동전의 종류
        int k = input.nextInt();    //  만들고 싶은 숫자

        int[] coin = new int[n];
        int[] dp = new int[100001];
        for (int i = 0; i < n; ++i) {
            coin[i] = input.nextInt();
            dp[coin[i]] = 1;    //  해당 dp[동전[i]] = 1
        }

        Arrays.sort(coin);  //  동전 배열 오름차순 정렬

        for (int i = 1; i <= k; ++i) {
            if (dp[i] == 1) continue;   //  해당 동전이 있다면 contibue
            int min = Integer.MAX_VALUE;    //   min을 최대값으로 초기화
            for (int j = 0; j < n; ++j) {
                if (coin[j] > i)    //  코인이 i를 넘어섰다면 break
                    break;
                if (dp[i - coin[j]] != 0)   //  dp[i = coin[j]] 가 만들 수 있을때만
                    min = Math.min(min, dp[i - coin[j]] + 1);
            }
            dp[i] = (min == Integer.MAX_VALUE) ? 0 : min;   //  최소값이 있다면 dp[i]는 최소값
        }

        System.out.print(dp[k] == 0 ? -1 : dp[k]);  //  없다면 -1 출력
    }
}
