package baekjoon.baekjoon_step.step26_DP2;

import java.io.*;
import java.util.StringTokenizer;

public class Code_11049 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());    //  행렬의 갯수

        int[][] matrix = new int[n + 1][2]; //  n개의 행렬 크기 배열
        for (int i = 1; i <= n; ++i) {
            st = new StringTokenizer(br.readLine());
            matrix[i][0] = Integer.parseInt(st.nextToken());    //  행 입력
            matrix[i][1] = Integer.parseInt(st.nextToken());    //  열 입력
        }

        long[][] dp = new long[n + 1][n + 1];
        for (int distance = 1; distance < n; ++distance) {  //  특정 배열 구간의 시작과 끝의 차이
            for (int start = 1; start + distance <= n; ++start) {   //  구간의 시작 배열 정하기
                int end = start + distance;     //  구간의 끝 배열 정하기
                dp[start][end] = Long.MAX_VALUE;

                for (int mid = start; mid < end; ++mid) {   //  곱셈횟수가 최솟값인 mid를 정하고 dp에 저장
                    dp[start][end] = Long.min(dp[start][end], dp[start][mid] + dp[mid + 1][end] + matrix[start][0] * matrix[mid][1] * matrix[end][1]);
                }
            }
        }
        bw.write(String.valueOf(dp[1][n]));
        bw.flush();

        br.close();
        bw.close();
    }
}