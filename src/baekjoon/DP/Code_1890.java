package baekjoon.DP;

import java.io.*;
import java.util.StringTokenizer;

public class Code_1890 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[][] board = new int[n + 1][n + 1];  //  게임판 2차원 배열
        for (int i = 1; i <= n; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; ++j) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        long[][] dp = new long[n + 1][n + 1];   //  dp 배열
        dp[1][1] = 1;   //  (1,1)은 1로 시작
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (dp[i][j] == 0)  //  해당 칸에 도착할 수 없다면 continue
                    continue;
                if(i == n && j == n)    //  마지막 칸이라면 break
                    break;
                int tmp = board[i][j];  //  움직여야하는 칸 수
                if (i + tmp <= n)
                    dp[i + tmp][j] += dp[i][j]; //  아래로 움직이기
                if (j + tmp <= n)
                    dp[i][j + tmp] += dp[i][j]; //  우측으로 움직이기
            }
        }

        System.out.print(dp[n][n]);
    }
}
