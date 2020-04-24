package baekjoon.DP;

import java.io.*;
import java.util.StringTokenizer;

public class Code_11048 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int [][] dp = new int[n+1][m+1];

        for(int i  = 1; i <= n; ++i){
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; ++j){
                dp[i][j] = Math.max(dp[i-1][j-1], Math.max(dp[i][j-1], dp[i-1][j])) + Integer.parseInt(st.nextToken());
            }
        }

        bw.write(String.valueOf(dp[n][m]));
        bw.flush();

        br.close();
        bw.close();
    }
}
