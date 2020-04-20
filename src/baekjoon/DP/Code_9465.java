package baekjoon.DP;

import java.io.*;
import java.util.StringTokenizer;

public class Code_9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[][] sticker = new int[2][n + 1];

            for (int i = 0; i < 2; ++i) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= n; ++j) {
                    sticker[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] dp = new int[n+1][3];
            dp[1][0] = 0;   //  1번 열에서 아무 스티커도 붙지않았을 때
            dp[1][1] = sticker[0][1];   //  1번 열에서 상위 행의 스티커만 붙었을 때
            dp[1][2] = sticker[1][1];   //  1번 열에서 하위 행의 스티커만 붙었을 때

            for (int i = 2; i <= n; ++i){
                dp[i][0] = Math.max(dp[i-1][1], dp[i-1][2]);    //  i번 열에서 아무 스티커도 붙지않았을 때
                dp[i][1] = Math.max(dp[i-1][0], dp[i-1][2]) + sticker[0][i];    //  i번 열에서 상위 행의 스티커만 붙었을 때
                dp[i][2] = Math.max(dp[i-1][0], dp[i-1][1]) + sticker[1][i];    //  i번 열에서 하위 행의 스티커만 붙었을 때
            }

            bw.write(String.valueOf(Math.max(dp[n][0], Math.max(dp[n][1], dp[n][2]))));
            bw.newLine();
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
