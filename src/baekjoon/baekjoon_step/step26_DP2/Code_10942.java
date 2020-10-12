package baekjoon.baekjoon_step.step26_DP2;

import java.io.*;
import java.util.StringTokenizer;

public class Code_10942 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; ++i)
            num[i] = Integer.parseInt(st.nextToken());

        boolean[][] dp = new boolean[n + 1][n + 1];

        for (int i = 0; i < n; ++i) {         //  start와 end사이의 거리
            for (int j = 1; j <= n; ++j) {    //  start의 인덱스
                if (i == 0) {   //  거리가 0이라면 팰린드롬 true
                    dp[j][j] = true;
                    continue;
                } else if (j + i > n)   //  end가 n을 넘으면 break
                    break;
                else if (i == 1 && num[j] == num[j + 1]) { //  거리가 1일 때는 두 수가 같아야 팰린드롬 true
                    dp[j][j + 1] = true;
                    continue;
                }

                int start = j;
                int end = j + i;
                if (dp[start + 1][end - 1] == true && num[start] == num[end])   //  양쪽 끝을 제외한 배열이 true이고 양쪽 끝의 수가 같다면 팰린드롬 true
                    dp[start][end] = true;
            }
        }

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; ++i) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            bw.write(dp[s][e] ? "1" : "0");
            bw.newLine();
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
