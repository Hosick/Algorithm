package baekjoon_step.step23_DivideAndConquer;

import java.io.*;
import java.util.StringTokenizer;

public class Code_10830 {
    public static long[][] a;
    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        /* 행렬 입력하기 */
        a = new long[n][n];
        for (int i = 0; i < n; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; ++j) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        /* 행렬 b제곱 */
        long[][] answer = squared(b);

        /* 행렬 출력 */
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                bw.write(answer[i][j] % 1000 + " ");
            }
            bw.newLine();
        }

        br.close();
        bw.close();
    }

    /* 재귀로 행렬을 b제곱하여 return */
    private static long[][] squared(long b) {
        long[][] result = new long[n][n];

        /* b가 1일 때 */
        if (b == 1)
            return a;
        if (b == 2)
            return multiply(a, a);
        else {
            long[][] tmp = squared(b / 2);
            /* b가 짝수일 때, a^(b/2) * a^(b/2) */
            if (b % 2 == 0) return multiply(tmp, tmp);
            /* b가 홀수일 때, a^(b/2) * a^(b/2) * a */
            else return multiply(multiply(tmp, tmp), a);
        }
    }

    /* 받은 함수 두개를 곱해서 return */
    private static long[][] multiply(long[][] a, long[][] b) {
        long[][] temp = new long[n][n];

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                for (int k = 0; k < n; ++k) {
                    temp[i][j] += a[i][k] * b[k][j];
                    temp[i][j] = (k == n - 1) ? temp[i][j] % 1000 : temp[i][j];
                }
            }
        }
        return temp;
    }
}