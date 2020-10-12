package baekjoon.baekjoon_step.step23_DivideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Code_1992 {
    public static int[][] screen;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /* 스크린 픽셀 입력 */
        int n = Integer.parseInt(br.readLine());
        screen = new int[n][n];
        for (int i = 0; i < n; ++i) {
            String line = br.readLine();
            for (int j = 0; j < n; ++j) {
                screen[i][j] = line.charAt(j) - '0';
            }
        }

        quadTree(0, 0, n);
        br.close();
    }

    private static void quadTree(int x, int y, int width) {
        boolean same = true;
        int standard = screen[x][y];

        /* 스크린이 같은 색상으로 이루어져 있는지 검사 */
        out: for (int i = x; i < x + width; ++i) {
            for (int j = y; j < y + width; ++j) {
                if (screen[i][j] != standard) {
                    same = false;
                    break out;
                }
            }
        }


        /* 스크린이 한 가지 색상 일 때*/
        if (same) {
            System.out.print(standard == 0 ? 0 : 1);
            return;
        }

        System.out.print("(");

        /* 아니라면 스크린 4등분 해서 검사*/
        width = width / 2;
        quadTree(x, y, width);
        quadTree(x, y + width, width);
        quadTree(x + width, y, width);
        quadTree(x + width, y + width, width);

        System.out.print(")");
    }
}