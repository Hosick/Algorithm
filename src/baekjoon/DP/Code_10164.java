package baekjoon.DP;

import java.io.*;
import java.util.StringTokenizer;

public class Code_10164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] dp = new int[n + 1][m + 1];
        dp[1][1] = 1;
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= m; ++j) {
                if (i == 1 && j == 1)
                    continue;
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        int answer = 1;
        int x = 1;
        int y = 1;


        int circle = Integer.parseInt(st.nextToken());
        if (circle != 0) {

            int tx = circle % m == 0 ? circle / m : circle / m + 1;
            int ty = circle % m == 0 ? m : circle % m;

            answer *= dp[tx - x + 1][ty - y + 1];
            x = tx;
            y = ty;
        }

        answer *= dp[n - x + 1][m - y + 1];

        bw.write(String.valueOf(answer));
        bw.flush();

        br.close();
        bw.close();
    }
}