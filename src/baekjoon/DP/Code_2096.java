package baekjoon.DP;

import java.io.*;
import java.util.StringTokenizer;

public class Code_2096 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;


        int n = Integer.parseInt(br.readLine());

        int[][] board = new int[n + 1][5];
        for (int i = 1; i <= n; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 3; ++j) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] max = new int[5];
        int[] min = new int[5];
        for (int i = 1; i <= n; ++i) {
            min[0] = 10;
            min[4] = 10;
        }

        max[1] = min[1] = board[1][1];
        max[2] = min[2] = board[1][2];
        max[3] = min[3] = board[1][3];

        int[] tempMax = new int[4];
        int[] tempMin = new int[4];
        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= 3; ++j) {
                tempMax[j] = Math.max(max[j], Math.max(max[j - 1], max[j + 1])) + board[i][j];
                tempMin[j] = Math.min(min[j], Math.min(min[j - 1], min[j + 1])) + board[i][j];
            }
            for (int j = 1; j <= 3; ++j){
                max[j] = tempMax[j];
                min[j] = tempMin[j];
            }
        }

        int maxValue = 0;
        int minValue = 900001;
        for (int i = 1; i <= 3; ++i) {
            maxValue = Math.max(maxValue, max[i]);
            minValue = Math.min(minValue, min[i]);
        }

        bw.write((maxValue) + " " + (minValue));
        bw.flush();

        br.close();
        bw.close();
    }
}