package baekjoon.baekjoon_step.step26_DP2;

import java.io.*;
import java.util.StringTokenizer;

public class Code_1520 {
    static int[][] map;
    static int[][] dp;
    static int[] dx = {-1, 0, 1, 0};    //  좌표의 좌우 확인 용
    static int[] dy = {0, -1, 0, 1};    //  좌표의 상하 확인 용
    static int m;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new int[m][n];
        dp = new int[m][n];

        /* 지도의 높이 입력 및 dp 배열 -1로 초기화  */
        for (int i = 0; i < m; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; ++j) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;  //  방문여부를 확인하기 위해 -1로 초기화
            }
        }

        bw.write(String.valueOf(navigation(m - 1, n - 1)));
        bw.flush();

        br.close();
        bw.close();
    }

    private static int navigation(int y, int x) {
        /* 시작점에서 1을 return */
        if (y == 0 && x == 0)
            return 1;

        if (dp[y][x] == -1) {   //  처음 방문이라면
            dp[y][x] = 0;   //  방문확인으로 0 초기화
            for (int i = 0; i < 4; ++i) {   //  상하좌우를 확인하기
                int nx = dx[i] + x;
                int ny = dy[i] + y;

                if (0 <= nx && nx < n && 0 <= ny && ny < m) {   //  정해진 범위 내에 있을 때
                    if (map[y][x] < map[ny][nx]) {  //  내리막이라면
                        dp[y][x] += navigation(ny, nx); //  더하기
                    }
                }
            }
        }
        return dp[y][x];
    }
}