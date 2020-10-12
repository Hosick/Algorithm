package baekjoon.baekjoon_step.step23_DivideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Code_2630 {
    public static int bCount = 0;
    public static int wCount = 0;
    public static int[][] paper;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        /* 종이의 크기와 색 입력 */
        int n = Integer.parseInt(br.readLine());
        paper = new int[n][n];
        for (int i = 0; i < n; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; ++j) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        cut(0, 0, n);
        System.out.print(wCount + "\n" + bCount);

        br.close();
    }

    private static void cut(int x, int y, int width) {
        boolean same = true;
        int standard = paper[x][y];

        /* 색종이가 한가지 색으로 이루어져 있는지 검사 */
        out:for (int i = x; i < x + width; ++i) {
            for (int j = y; j < y + width; ++j) {
                if (paper[i][j] != standard) {
                    same = false;
                    break out;
                }
            }
        }

        /* 색종이가 한가지 색 일 때 */
        if (same) {
            wCount = standard == 0 ? ++wCount : wCount;
            bCount = standard == 1 ? ++bCount : bCount;
            return;
        }

        /* 아니라면 종이 4등분으로 찢기*/
        width = width / 2;
        cut(x, y, width);
        cut(x + width, y, width);
        cut(x, y + width, width);
        cut(x + width, y + width, width);
    }
}
