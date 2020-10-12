package baekjoon.baekjoon_step.step15_Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Code_2580 {
    public static int[][] board;
    public static List<int[]> blankIndex;
    public static boolean full;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        board = new int[9][9];
        blankIndex = new ArrayList<>();

        /*스도쿠 입력*/
        for (int i = 0; i < 9; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; ++j) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 0) blankIndex.add(new int[]{i, j});  //  빈 칸 세기
            }
        }
        sudoku(0, 0);
    }

    private static void sudoku(int index, int deep) {
        /* 빈 칸을 모두 채웠다면 return */
        if (full) return;
        if (deep == blankIndex.size()) {
            full = true;
            /* 정답 스도쿠 출력*/
            for (int i = 0; i < 9; ++i) {
                for (int j = 0; j < 9; ++j) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
            return;
        }
        if (index >= blankIndex.size()) return;

        int x = blankIndex.get(index)[0];
        int y = blankIndex.get(index)[1];

        /* 빈 칸에 가능한 숫자 넣기 */
        for (int i = 1; i <= 9; i++) {
            if (isRight(x, y, i)) {
                board[x][y] = i;
                sudoku(index + 1, deep + 1);
                board[x][y] = 0;
            }
        }

    }

    /* i,j 칸에 k가 들어 갈 수 있는지 검증 */
    private static boolean isRight(int i, int j, int k) {
        for (int z = 0; z < 9; ++z) {
            if (board[i][z] == k) return false; //  열 검사
            if (board[z][j] == k) return false;    //  행 검사
        }
        for (int ii = i / 3 * 3; ii < i / 3 * 3 + 3; ++ii) {   //  3x3 칸 검사
            for (int jj = j / 3 * 3; jj < j / 3 * 3 + 3; ++jj) {
                if (board[ii][jj] == k) return false;
            }
        }
        return true;
    }
}