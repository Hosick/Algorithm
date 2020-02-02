package baekjoon_step.step15_Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Code_9663 {
    static int count = 0;   //  정답의 갯수
    static boolean[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());   //  체스판 : n*n, 퀸의 갯수 : n개
        board = new boolean[n][n];
        nQueen(0, n);
    }

    private static void nQueen(int amount, int n) {
        if (amount == n-1) {    //  n-queen인 상태라면 ++count 후 return
            ++count;
            System.out.println("카운트 : "+ count);
            return;
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (board[i][j] && !safe(i, j, n)) continue;  //  (i,j)자리에 이미 퀸이 있거나 // 올라가도 다른 퀸에게 잡히는 자리라면 패스
                System.out.println(amount);
                board[i][j] = true;         //  (i,j)자리에 퀸넣기
                nQueen(amount + 1, n);   //  다음 퀸 찾기(재귀)
                board[i][j] = false;
            }
        }
    }

    private static boolean safe(int i, int j, int n) { //  (i,j)가 안전한 구역인지 boolean으로 return
        for (int x = 0; x < n; ++x) {
            for (int y = 0; y < n; ++y) {
                if (board[x][y] == true) {
                    if (x == i || y == j || (Math.abs(x - i) < 2 && Math.abs(y - j) < 2)) ;
                }
            }
        }
        return true;
    }
}
