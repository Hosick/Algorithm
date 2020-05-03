package baekjoon.DP;

import java.io.*;
import java.util.StringTokenizer;

public class Code_9084 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n;  //  동전 종류 개수
        int m;  //  만들 금액
        int[] coin; //  사용가능한 동전 배열
        int[] dp;   //  dp 배열

        /* 테스트케이스만큼 반복 */
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            coin = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; ++i)
                coin[i] = Integer.parseInt(st.nextToken());

            m = Integer.parseInt(br.readLine());
            dp = new int[m + 1];
            dp[0] = 1;  //  dp[0]을 1로 초기화

            for (int i = 0; i < n; ++i) {   //  동전의 번호(0번 동전 부터 n-1번 동전까지)
                for (int j = coin[i]; j <= m; ++j) {    //  coin[i]의 값부터 만들 금액까지
                    dp[j] += dp[j - coin[i]];       //  coin[i]만 더하면 j가 만들어지는 dp값 더하기
                }
            }

            bw.write(String.valueOf(dp[m]) + "\n");
        }
        bw.flush();

        br.close();
        bw.close();
    }
}
