package baekjoon_step.step26_DP2;

import java.io.*;
import java.util.StringTokenizer;

public class Code_1520 {
    static int[][] map;
    static int[][] dp;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
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
                dp[i][j] = -1;
            }
        }

        bw.write(String.valueOf(navigation(m - 1, n - 1)));
        bw.flush();

        br.close();
        bw.close();
    }

    private static int navigation(int y, int x) {
        /* 목표가 제자리라면 1가지의 케이스 뿐 */
        if (y == 0 && x == 0)
            return 1;

        if (dp[y][x] == -1) {
            dp[y][x] = 0;
            for (int i = 0; i < 4; ++i) {
                int nx = dx[i] + x;
                int ny = dy[i] + y;

                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (map[y][x] < map[ny][nx]) {
                        dp[y][x] += navigation(ny, nx);
                    }
                }
            }
        }
        return dp[y][x];
    }
}