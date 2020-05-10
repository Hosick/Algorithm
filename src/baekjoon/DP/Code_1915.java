package baekjoon.DP;

import java.io.*;
import java.util.StringTokenizer;

public class Code_1915 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());   //  배열의 행
        int m = Integer.parseInt(st.nextToken());   //  배열의 열

        int max = 0;    //  가장 큰 정사각형의 넓이
        int range;      //  정사각형 한 변의 길이
        int width;

        int[][] matrix = new int[n + 1][m + 1]; //  n * m 크기의 2차원 배열 선언
        for (int i = 1; i <= n; ++i) {
            String line = br.readLine();
            for (int j = 1; j <= m; ++j) {
                matrix[i][j] = line.charAt(j - 1) - '0';    //  채우기

                /* 정사각형 찾기 */
                if (matrix[i - 1][j - 1] != 0 && matrix[i][j] != 0) {   //  만약 (i,j)와 그 좌측 상단이 둘다 0이 아닐 때
                    range = (int) Math.sqrt(matrix[i - 1][j - 1]);      //  좌측 상단 정사각형의 길이
                    width = 1;                                       //  정사각형 유무를 true로 초기화
                    for (int k = 1; k <= range; ++k) {
                        if (matrix[i][j - k] != 0 && matrix[i - k][j] != 0) {   // 변이 0이 아니라면
                            width++;                                            // 길이++
                        } else break;                                           // 0이 있다면 break;
                    }
                    matrix[i][j] = width * width;    //  정사각형이라면 (길이+1)^2
                }
                max = Math.max(matrix[i][j], max);  //  최대값 찾기
            }
        }
        bw.write(String.valueOf(max));
        bw.flush();

        br.close();
        bw.close();
    }
}
