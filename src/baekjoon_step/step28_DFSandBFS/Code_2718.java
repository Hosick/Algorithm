package baekjoon_step.step28_DFSandBFS;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Code_2718 {
    static int n;
    static int m;
    static int[][] maze;
    static boolean[][] visit;
    static int[] am = {-1, 1, 0, 0};
    static int[] bm = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        /* 상하좌우의 공백이 있는 미로 길 및 방문 배열 */
        maze = new int[n + 2][m + 2];
        visit = new boolean[n + 2][m + 2];

        /* 미로의 길 입력 */
        for (int i = 1; i <= n; ++i) {
            String line = br.readLine();
            for (int j = 1; j <= m; ++j) {
                maze[i][j] = line.charAt(j - 1) - '0';
            }
        }

        /* bfs 를 통해 가장 빠른 길 구하고 출력  */
        bw.write(String.valueOf(bfs(1,1)));
        bw.flush();
        br.close();
        bw.close();
    }

    /* BFS 구현 */
    private static int bfs(int a, int b) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(a);
        q.offer(b);
        visit[a][b] = true;

        while (!q.isEmpty()) {
            int ta = q.poll();
            int tb = q.poll();

            /* 상하좌우 탐색*/
            for (int i = 0; i < 4; ++i) {
                int na = ta + am[i];
                int nb = tb + bm[i];

                /* 길이 있고 미방문이라면 offer 및 +1 */
                if (!visit[na][nb] && maze[na][nb] == 1) {
                    q.offer(na);
                    q.offer(nb);
                    visit[na][nb] = true;
                    maze[na][nb] = maze[ta][tb] + 1;
                    /* 미로의 탈출구라면 return */
                    if (na == n && nb == m)
                        return maze[na][nb];
                }
            }
        }
        return -1;
    }
}