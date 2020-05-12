package baekjoon.DP;

import java.io.*;
import java.util.StringTokenizer;

public class Code_2229 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());    //  학생 수
        int[] student = new int[n + 1];             //  학생 배열 선언
        int[] dp = new int[n + 1]; //  [학생 번호] 까지의 최대 효율 dp 배열 선언

        st = new StringTokenizer(br.readLine());
        int max, min;   // 실력 최대값과 최소값
        for (int i = 1; i <=n; ++i){    //  1 ~ n 번 학생까지
            student[i] = Integer.parseInt(st.nextToken());
            max = 0;
            min = 10000;
            for (int j = i; j > 0; --j){    //  i번과 같이 조를 할 시작하는 학생번호 (n~1번 학생까지)
                max = Math.max(max, student[j]);    //  최고 실력
                min = Math.min(min, student[j]);    //  최저 실력
                dp[i] = Math.max(dp[i], max - min + dp[j-1]);   //  j 이전까지와의 합 과 비교하여 최대값 구하기
            }
        }

        bw.write(String.valueOf(dp[n]));

        br.close();
        bw.close();
    }
}