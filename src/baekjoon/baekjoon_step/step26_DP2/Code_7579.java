package baekjoon.baekjoon_step.step26_DP2;

import java.io.*;
import java.util.StringTokenizer;

public class Code_7579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());   //  현재 실행중인 앱의 갯수
        int m = Integer.parseInt(st.nextToken());   //  새로운 앱을 실행하기 종료해야할 최소 메모리

        int[] memory = new int[n];  //  실행중인 앱들의 메모리 배열
        int[] cost = new int[n];    //  실행중이 앱들의 비활성화 비용 배열
        int sumCost = 0;
        st = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; ++i) {
            memory[i] = Integer.parseInt(st.nextToken());
            cost[i] = Integer.parseInt(st2.nextToken());
            sumCost += cost[i];
        }

        /* 앱을 종료하는 비용 별 최댓값을 저장할 dp 배열 */
        long[] dp = new long[sumCost + 1];

        /* dp 값 계산 */
        for (int i = 0; i < n; ++i) {   //  0번 어플부터 n-1번 어플까지
            for (int j = sumCost; j >= cost[i]; --j) {  //   종료 비용 합계부터 특정 어플의 종료 비용까지
                dp[j] = Math.max(dp[j], dp[j - cost[i]] + memory[i]);   // 동일비용 최대값 찾기
            }
        }

        /* 최저비용 출력 */
        for (int i = 0; i <= sumCost; ++i)
            if (dp[i] >= m) {
                bw.write(String.valueOf(i));
                break;
            }

        bw.flush();
        br.close();
        bw.close();

    }
}
