package baekjoon.DP;

import java.io.*;
import java.util.StringTokenizer;

public class Code_2096 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;


        int n = Integer.parseInt(br.readLine());    //  행의 개수 입력

        int[][] board = new int[n + 1][5];  //
        for (int i = 1; i <= n; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 3; ++j) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] max = new int[5]; //  1~3 양쪽의 공백
        int[] min = new int[5];
        min[0] = Integer.MAX_VALUE; //  min은 공백을 최대값으로
        min[4] = Integer.MAX_VALUE;

        max[1] = min[1] = board[1][1];  //  max, min을 첫번째 행으로 초기화
        max[2] = min[2] = board[1][2];
        max[3] = min[3] = board[1][3];

        int[] tempMax = new int[4]; //  중복 계산되지않도록
        int[] tempMin = new int[4]; //  최대, 최소값을 임시로 담는 배열
        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= 3; ++j) {
                tempMax[j] = Math.max(max[j], Math.max(max[j - 1], max[j + 1])) + board[i][j];  //  max[j], [j-1], [j+1]을 비교
                tempMin[j] = Math.min(min[j], Math.min(min[j - 1], min[j + 1])) + board[i][j];  //  min[j], [j-1], [j+1]을 비교
            }
            for (int j = 1; j <= 3; ++j) {  //  임시로 담았던 값들을 max min으로 다시 옮김
                max[j] = tempMax[j];
                min[j] = tempMin[j];
            }
        }

        /* 최대값, 최소값 찾고 출력 */
        int maxValue = 0;
        int minValue = Integer.MAX_VALUE;
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