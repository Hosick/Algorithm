package baekjoon.baekjoon_step.step13_BruteForce;

import java.util.Scanner;

public class Code_1018 {
    public static void main(String[] args) {
        char[][] white = {{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'}, {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
                {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'}, {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
                {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'}, {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
                {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'}, {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'}};
        char[][] black = {{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'}, {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
                {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'}, {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
                {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'}, {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
                {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'}, {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'}};

        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int m = input.nextInt();
        char[][] board = new char[n][m];
        int minCount = 64;

        /* n*m 크기의 보드 상태 입력*/
        for (int i = 0; i < n; ++i) {
            String line = input.next();
            for (int j = 0; j < m; ++j) {
                board[i][j] = line.charAt(j);
            }
        }
        /*다시 칠해야 하는 정사각형 개수의 최솟값 계산하기*/
        for (int i = 0; i < n - 7; ++i) {   //  보드안에서 8x8 시작위치 (i,j)
            for (int j = 0; j < m - 7; ++j) {
                int wCount = 0;
                int bCount = 0;
                for (int k = 0; k < 8; ++k) {   //  (i,j)부터 8x8 보드와 체스판과 비교하기
                    for (int l = 0; l < 8; ++l) {
                        if (board[i + k][j + l] == white[k][l])
                            ++wCount;
                        if (board[i + k][j + l] == black[k][l])
                            ++bCount;
                    }
                }
                if (wCount < minCount) minCount = wCount;
                if (bCount < minCount) minCount = bCount;
            }
        }
        System.out.print(minCount);
    }
}