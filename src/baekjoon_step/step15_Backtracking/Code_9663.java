package baekjoon_step.step15_Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Code_9663 {
    static int count = 0;   //  정답의 갯수
    static int[] path = new int[16];
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());   //  체스판 : n*n, 퀸의 갯수 : n개

        for (int i = 0; i < n; ++i) {
            path[0] = i;    //  0행 i열에 부터 탐색
            nQueen(i, 0);
        }
        System.out.print(count);
    }

    private static void nQueen(int x, int amount) {
        for (int i = 0; i < amount; i++) {
            if (path[i] == x || Math.abs(x - path[i]) == amount - i)    //  열이 같거나, 대각선에 겹친다면 return
                return;
        }

        /*n 개의 queen이 배치되었다면 정답 갯수올리고 return*/
        if (amount == n-1) {
            count++;
            return;
        }

        /*다음 queen 배치장소 찾기*/
        for (int i = 0; i < n; i++) {
            path[amount + 1] = i;
            nQueen(i, amount + 1);
        }
    }
}