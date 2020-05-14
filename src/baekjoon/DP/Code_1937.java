package baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Code_1937 {
    static int n;
    static int[][] forest;  //  n*n 2차원 숲 배열
    static int[][] dp;      //  n*n 2차원 dp 배열
    static int[] mx = {-1, 1, 0, 0};    //  x의 이동
    static int[] my = {0, 0, -1, 1};    //  y의 이동

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int k = 0;  //  판다가 최대한으로 살 수 있는 일
        n = Integer.parseInt(br.readLine());

        forest = new int[n + 1][n + 1];
        dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; ++j) {
                forest[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        /* 한칸 씩 생존일수를 구해서 최대값 찾기 */
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= n; ++j) {
                k = Math.max(k, dfs(i, j));
            }
        }

        System.out.println(k);

        br.close();
    }

    /* 좌표를 받고 dfs로 생존일 수를 계산하여 반환하는 함수 */
    private static int dfs(int x, int y) {
        int nx, ny;     //  다음 갈 숲의 좌표
        int day = 1;    //  판다 생존 일 수 1로 초기화

        /* 이미 탐색된 곳인지 검사 */
        if (dp[x][y] != 0)
            return dp[x][y];

        /* 상하좌우 탐색 */
        for (int w = 0; w < 4; ++w) {
            nx = x + mx[w];
            ny = y + my[w];
            if (nx > 0 && nx <= n && ny > 0 && ny <= n) { //  (nx,ny)가 대나무 숲 범위 내 이면서
                if (forest[nx][ny] > forest[x][y]) {     //  (x,y)보다 대나무가 많을 때
                    day = Math.max(day, dfs(nx, ny) + 1);   //  판다 생존일수를 (nx,ny) + 1과 비교하여 최대값 찾기
                    dp[x][y] = day;
                }
            }
        }
        return day;
    }
}
