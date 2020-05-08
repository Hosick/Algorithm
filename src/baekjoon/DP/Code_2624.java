package baekjoon.DP;

import java.io.*;
import java.util.StringTokenizer;

public class Code_2624 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());    //  지폐의 금액
        int k = Integer.parseInt(br.readLine());    //  동전의 종류 가지 수

        int[][] dp = new int[k + 1][t + 1]; //  [몇번째 동전 종류 0 ~ k][금액 0 ~ t]
        dp[0][0] = 1;   //  dp[0][0]을 1로초기화

        StringTokenizer st;
        int coin, count;
        for (int i = 1; i <= k; ++i) {  //  1 ~ k 동전 순서대로
            st = new StringTokenizer(br.readLine());
            coin = Integer.parseInt(st.nextToken());    //  동전 종류
            count = Integer.parseInt(st.nextToken());   //  동전 개수

            System.arraycopy(dp[i - 1], 0, dp[i], 0, t + 1);    //  이전 단계 dp를 복사

            for (int j = 0; j < t; ++j) {   //  금액 0 ~ (t-1) 까지
                if (dp[i - 1][j] > 0) {     //  만약 이전 단계에서 만들수 있는 금액이라면
                    for (int c = 1; c <= count; ++c) {  //  동전 1 ~ count개까지
                        if (j + (coin * c) > t)         //  지폐의 금액을 초과한다면 break
                            break;
                        dp[i][j + (coin * c)] += dp[i - 1][j];  //  coin을 더해서 만들 수 있다면 이전단계 금액의 dp를 더하기
                    }
                }
            }
        }

        bw.write(String.valueOf(dp[k][t]));
        bw.flush();

        br.close();
        bw.close();
    }
}