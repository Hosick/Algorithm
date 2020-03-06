package baekjoon_step.step28_DFSandBFS;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Code_7576 {
    static int[][] store;
    static boolean[][] visit;
    static int m;
    static int n;
    static int[] xm = {-1, 1, 0, 0};
    static int[] ym = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());    //  창고의 가로길이
        n = Integer.parseInt(st.nextToken());    //  창고의 세로길이


        store = new int[n][m];
        visit = new boolean[n][m];
        int[][] tomato = new int[m * n][2];   //  익은 토마토의 위치 배열
        int amount = 0;                     //  익은 토마토 갯수
        int empty = 0;                      //  빈 공간의 갯수

        /* 창고의 토마토 위치 입력 */
        for (int i = 0; i < n; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; ++j) {
                store[i][j] = Integer.parseInt(st.nextToken());
                if (store[i][j] == 1) {
                    tomato[amount][0] = i;    //  익은 토마토의 x
                    tomato[amount++][1] = j;    //  익은 토마토의 y
                } else if (store[i][j] == -1) {   //  토마토가 없다면 방문여부를 true로 초기화
                    visit[i][j] = true;
                    empty++;
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
        int freq = amount+empty;  //  지금까지 익은 토마토 개수

        if (freq == m * n)    //  안익은 토마토가 없다면 0을 리턴
            return 0;

        for (int i = 0; i < amount; ++i) {
            int x = tomato[i][0];
            int y = tomato[i][1];
            q.offer(x);
            q.offer(y);
            visit[x][y] = true;
        }

        while (!q.isEmpty()) {
            int nx = q.poll();
            int ny = q.poll();

            for (int i = 0; i < 4; ++i) {
                int tx = nx + xm[i];
                int ty = ny + ym[i];

                if (tx < 0 || ty < 0 || tx >= n || ty >= m)
                    continue;
                else if (!visit[tx][ty]) {
                    q.offer(tx);
                    q.offer(ty);
                    store[tx][ty] = store[nx][ny] + 1;
                    visit[tx][ty] = true;
                    max = Math.max(max, store[tx][ty]); //  더 늦은 일수 찾기
                    freq++;
                }
            }
        }

        return freq == m * n ? max - 1 : -1;    //  토마토가 없는곳과 익은곳의 합이 m*n과 다르다면 -1 리턴
    }
}
