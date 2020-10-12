package baekjoon.baekjoon_step.step26_DP2;

import java.io.*;
import java.util.StringTokenizer;

public class Code_11066 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine()); // 테스트 시행 횟수
        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine());    // 소설의 장 수
            st = new StringTokenizer(br.readLine());
            int[] chap = new int[k + 1];    //  소설 장 별 합치기 비용
            int[] sum = new int[k + 1];     //  x 장 까지 비용 합계
            int[][] dp = new int[k+1][k+1];

            for (int i = 1; i <= k; ++i) {
                chap[i] = Integer.parseInt(st.nextToken());
                sum[i] = sum[i - 1] + chap[i];
            }

            for(int distance = 1; distance < k; ++distance){     //  계산할 챕터 시작과 끝의 거리
                for(int start = 1; start + distance <= k; ++start){ //  시작할 챕터와 끝나는 챕터
                    int end = start+distance;
                    dp[start][end] = Integer.MAX_VALUE; //  start~end 의 소요비용을 우선 MAX로 초기화

                    for(int mid = start; mid<end; ++mid){   //  mid를 기준으로 양쪽을 나누어서 양쪽의 합이 비용이 더 적은 쪽을 고르기
                        dp[start][end] = Integer.min(dp[start][end], dp[start][mid]+dp[mid+1][end] +sum[end] - sum[start-1]);
                    }
                }
            }

            bw.write(String.valueOf(dp[1][k]));
            bw.newLine();
        }
        bw.flush();
        br.close();
        bw.close();
    }
}