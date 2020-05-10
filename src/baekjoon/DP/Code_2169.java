package baekjoon.DP;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Code_2169 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());   //  행의 개수
        int m = Integer.parseInt(st.nextToken());   //  열의 개수

        int[][] mars = new int[n + 1][m + 1];       //  지역의 가치 2차원 배열
        for (int i = 1; i <= n; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; ++j) {
                mars[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[n + 1][m + 1]; //  해당 지역까지의 최대 가치 dp배열
        /* 첫번째 행의 dp값 초기화 (1,1 부터 출발이므로 첫번째행은 우측 이동만 가능) */
        dp[1][1] = mars[1][1];
        for (int i = 2; i <= m; ++i)
            dp[1][i] = mars[1][i] + dp[1][i - 1];

        int[] lr = new int[m + 1];  //  left -> right 임시배열
        int[] rl = new int[m + 2];  //  left <- right 임시배열
        /* 2 ~ n 번 행의 dp값 구하기 */
        for (int i = 2; i <= n; ++i) {
            Arrays.fill(lr, -100000000); //  lr 최저값으로 초기화
            Arrays.fill(rl, -100000000); //  rl 최저값으로 초기화
            for (int j = 1; j <= m; ++j) {
                lr[j] = Integer.max(lr[j - 1], dp[i - 1][j]) + mars[i][j];  //  왼쪽, 위쪽의 max + mars[i][j]
                rl[m + 1 - j] = Integer.max(rl[m + 2 - j], dp[i - 1][m + 1 - j]) + mars[i][m + 1 - j];  //  오른쪽, 위쪽의 max + mars[i][j]
            }
            for (int j = 1; j <= m; ++j)    //  lr과 rl중 최대값을 dp에 넣기
                dp[i][j] = Integer.max(lr[j], rl[j]);
        }

        /* (n, m)까지의 최대 가치 합 출력 */
        bw.write(String.valueOf(dp[n][m]));
        bw.flush();

        br.close();
        bw.close();
    }
}