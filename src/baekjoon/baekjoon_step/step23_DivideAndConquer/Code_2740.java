package baekjoon.baekjoon_step.step23_DivideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Code_2740 {
    public static int[][] processionA;
    public static int[][] processionB;
    public static int n;
    public static int m;
    public static int k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        /* 행렬 a 입력 */
        processionA = new int[n][m];
        for (int i = 0; i < n; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; ++j) {
                processionA[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        /* 행렬 b 입력 */
        processionB = new int[m][k];
        for (int i = 0; i < m; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < k; ++j) {
                processionB[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        /* 두 행렬을 곱하고 출력 */
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < k; ++j) {
                product(i, j);
            }
            System.out.println();
        }
        br.close();
    }

    /* 두 행렬을 곱하고 출력하는 함수 */
    private static void product(int x, int y) {
        int answer = 0;
        for (int i = 0; i < m; ++i)
            answer += processionA[x][i] * processionB[i][y];

        System.out.print(answer + " ");
    }
}
