package baekjoon.baekjoon_step.step26_DP2;

import java.io.*;
import java.util.StringTokenizer;

public class Code_2293 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());   //  동전 개수
        int k = Integer.parseInt(br.readLine());   //  동전의 가치 합

        int coin;
        int[] dp = new int[k + 1];
        dp[0] = 1;

        for (int i = 0; i < n; ++i) {
            coin = Integer.parseInt(br.readLine());
            for (int j = 1; j <= k; ++j) {
                if (j >= coin)
                    dp[j] += dp[j - coin];
            }
        }

        bw.write(String.valueOf(dp[k]));
        bw.flush();
        br.close();
        bw.close();
    }
}