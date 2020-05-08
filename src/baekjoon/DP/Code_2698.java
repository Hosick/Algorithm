package baekjoon.DP;

import java.io.*;
import java.util.StringTokenizer;

public class Code_2698 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int[][][] dp = new int[101][100][2];    //  dp[자리 수][인접 비트 수][끝나는 수]
        dp[1][0][0] = 1;    //  비트 '0'
        dp[1][0][1] = 1;    //  비트 '1'
        for (int i = 1; i < 100; ++i) {
            for (int j = 0; j < i; ++j) {
                dp[i + 1][j][0] += dp[i][j][0];     //  0으로 끝나는 수열에 0을 더했을 때
                dp[i + 1][j][1] += dp[i][j][0];     //  0으로 끝나는 수열에 1을 더했을 때
                dp[i + 1][j][0] += dp[i][j][1];     //  1로 끝나는 수열에 0을 더했을 때
                dp[i + 1][j+1][1] += dp[i][j][1];   //  1로 끝나는 수열에 1을 더했을 때
            }
        }

        /* 테스트 케이스 돌리기 */
        int t = Integer.parseInt(br.readLine());
        int a, b, ans;
        while (t-- > 0){
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            ans = dp[a][b][0] + dp[a][b][1];

            bw.write(ans+"\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}