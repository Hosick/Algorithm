package baekjoon.baekjoon_step.step23_DivideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Code_1780 {
    public static int[][] paper;
    public static int minusCount = 0;
    public static int zeroCount = 0;
    public static int plusCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        /* 종이에 숫자입력하기 */
        int n = Integer.parseInt(br.readLine());
        paper = new int[n][n];
        for (int i = 0; i < n; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; ++j) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cut(0, 0, n);

        System.out.print(minusCount + "\n" + zeroCount + "\n" + plusCount);

        br.close();
    }

    private static void cut(int x, int y, int width) {
        boolean same = true;
        int standard = paper[x][y];

        /* 종이가 한가지 숫자로 이루어져 있는지 검사 */
        out:
        for (int i = x; i < x + width; ++i) {
            for (int j = y; j < y + width; ++j) {
                if (paper[i][j] != standard) {
                    same = false;
                    break out;
                }
            }
        }

        /* 종이가 한 가지 숫자일 때 */
        if (same) {
            if (standard == -1) ++minusCount;
            else if (standard == 0) ++zeroCount;
            else if (standard == 1) ++plusCount;
            return;
        }

        /* 아니라면 종이 9등분으로 찢기*/
        width = width / 3;
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                cut(x + width * i, y + width * j, width);
            }
        }
    }
}