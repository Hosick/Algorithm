package baekjoon_step.step28_DFSandBFS;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Code_7569 {
    static int[][][] store;
    static boolean[][][] visit;
    static int m;
    static int n;
    static int h;
    static int[] xm = {0, 0, -1, 1, 0, 0};
    static int[] ym = {0, 0, 0, 0, -1, 1};
    static int[] zm = {-1, 1, 0, 0, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());    //  창고의 가로길이
        n = Integer.parseInt(st.nextToken());    //  창고의 세로길이
        h = Integer.parseInt(st.nextToken());    //  창고의 높이

        store = new int[h][n][m];
        visit = new boolean[h][n][m];
        int[][] tomato = new int[h * m * n][3];   //  익은 토마토의 위치 배열
        int amount = 0;                     //  익은 토마토 갯수
        int empty = 0;                      //  빈 공간의 갯수

        /* 창고의 토마토 위치 입력 */
        for (int i = 0; i < h; ++i) {
            for (int j = 0; j < n; ++j) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; ++k) {
                    store[i][j][k] = Integer.parseInt(st.nextToken());
                    if (store[i][j][k] == 1) {
                        tomato[amount][0] = i;    // 익은 토마토의 높이
                        tomato[amount][1] = j;    //  익은 토마토의 x
                        tomato[amount++][2] = k;    //  익은 토마토의 y
                    } else if (store[i][j][k] == -1) {   //  토마토가 없다면 방문여부를 true로 초기화
                        visit[i][j][k] = true;
                        empty++;
                    }
                }
            }
        }

        /* BFS로 토마토가 모두 익을 때까지의 최소 날짜 구하기 */
        bw.write(String.valueOf(bfs(tomato, amount, empty)));
        bw.flush();
        br.close();
        bw.close();


    }

    private static int bfs(int[][] tomato, int amount, int empty) {
        Queue<Integer> q = new LinkedList<Integer>();
        int max = 0;    //  가장 늦게 익는 토마토의 일 수
        int freq = amount + empty;  //  지금까지 익은 토마토 개수

        if (freq == h * m * n)    //  안익은 토마토가 없다면 0을 리턴
            return 0;

        for (int i = 0; i < amount; ++i) {
            int z = tomato[i][0];
            int x = tomato[i][1];
            int y = tomato[i][2];
            q.offer(z);
            q.offer(x);
            q.offer(y);
            visit[z][x][y] = true;
        }

        while (!q.isEmpty()) {
            int nz = q.poll();
            int nx = q.poll();
            int ny = q.poll();

            for (int i = 0; i < 6; ++i) {
                int tz = nz + zm[i];
                int tx = nx + xm[i];
                int ty = ny + ym[i];

                if (tx < 0 || ty < 0 || tz < 0 || tx >= n || ty >= m || tz >= h)
                    continue;
                else if (!visit[tz][tx][ty]) {
                    q.offer(tz);
                    q.offer(tx);
                    q.offer(ty);
                    store[tz][tx][ty] = store[nz][nx][ny] + 1;
                    visit[tz][tx][ty] = true;
                    max = Math.max(max, store[tz][tx][ty]); //  더 늦은 일수 찾기
                    freq++;
                }
            }
        }

        return freq == m * n * h ? max - 1 : -1;    //  토마토가 없는곳과 익은곳의 합이 m*n과 다르다면 -1 리턴
    }
}
