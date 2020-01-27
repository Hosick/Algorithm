package baekjoon_step.step10_Recursion;

import java.util.Arrays;
import java.util.Scanner;

public class Code_2447 {
    private static char[][] array;  //  static 별 배열

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        array = new char[n][n];    //  배열 가로, 세로 각 n개로 설정

        for (int i = 0; i < n; i++) {
            Arrays.fill(array[i], ' '); // 배열을 공백으로 초기화
        }

        draw(0, 0, n);

        for (int i = 0; i < n; i++) {   //  별 배열 출력
            System.out.println(array[i]);
        }

    }

    private static void draw(int x, int y, int n) { //  별 찍기
        if (n == 1) {
            array[x][y] = '*';
            return;
        }
        int m = n / 3;
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (i == 1 && j == 1)
                    continue;
                draw(x + m * i, y + m * j, m);
            }
        }
    }
}
