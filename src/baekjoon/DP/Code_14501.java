package baekjoon.DP;

import java.io.*;
import java.util.StringTokenizer;

public class Code_14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[][] day = new int[n + 6][2];
        for (int i = 1; i <= n; ++i) {
            st = new StringTokenizer(br.readLine());
            day[i][0] = Integer.parseInt(st.nextToken());
            day[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n + 6];
        for (int i = n; i > 0; --i) {
            dp[i] = (day[i][0] + i - 1 > n) ? 0 : day[i][1];    //  i일에 주어진 일이 가능하다면 일하기
            dp[i] += dp[day[i][0] + i];                         //  일을 마친 다음 날의 dp값
            dp[i] = Math.max(dp[i], dp[i+1]);                   //  다음날과 비교해서 최대값
        }

        bw.write(dp[1]);
        bw.flush();

        br.close();
        bw.close();
    }
}
