package baekjoon.DP;

import java.io.*;

public class Code_2302 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        /* i개의 붙어있는 좌석의 경우의 수 (VIP가 없을 때) */
        int[] dp = new int[41];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < 41; ++i)
            dp[i] = dp[i - 1] + dp[i - 2];

        int answer = 1; //  경우의 수 1로 초기화
        int start = 1;  //  좌석의 시작 or 고정석 다음의 시작
        int end;        //  고정석 전의 마지막 or 좌석의 마지막

        int m = Integer.parseInt(br.readLine());
        while (m-- > 0) {
            int fixing = Integer.parseInt(br.readLine());   //  고정석 번호
            end = fixing;   //  end를 고정석 번호로 초기화
            answer *= dp[end - start];  //  dp[end - start]를 곱
            start = end + 1;            //  시작점을 고정석 다음으로 초기화
        }
        end = n + 1;                    //  마지막 고정석 이후
        answer *= dp[end - start];

        System.out.print(answer);
    }
}
