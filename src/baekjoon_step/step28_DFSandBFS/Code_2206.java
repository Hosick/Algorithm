package baekjoon_step.step28_DFSandBFS;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Code_2206 {
    static int[][] map;
    static boolean[][][] visited;
    static int n;
    static int m;
    static int answer = Integer.MAX_VALUE;
    static int[] xm = {-1, 1, 0, 0};
    static int[] ym = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[2][n][m];

        for (int i = 0; i < n; ++i) {
            String line = br.readLine();
            for (int j = 0; j < m; ++j) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        bw.write(String.valueOf(bfs()));
        bw.flush();
        br.close();
        bw.close();
    }

    private static int bfs() {
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(0);
        q.offer(0);
        q.offer(0);
        q.offer(1);

        while (!q.isEmpty()) {
            int broken = q.poll();
            int tx = q.poll();
            int ty = q.poll();
            int count = q.poll();

            /* 마지막에 칸에서의 최저값 구하기 */
            if (tx == n - 1 && ty == m - 1) {
                answer = Math.min(answer, count);
                continue;
            }

            for (int i = 0; i < 4; ++i) {
                int nx = tx + xm[i];
                int ny = ty + ym[i];

                /* nx, ny가 범위안에 있는지 체크 */
                if (nx < 0 || ny < 0 || nx >= n || ny >= m)
                    continue;

                /* 이미 벽을 부쉈을 때 */
                if (broken == 1 && map[nx][ny] == 0 && !visited[broken][nx][ny]) {
                    visited[broken][nx][ny] = true;
                    q.offer(1);
                    q.offer(nx);
                    q.offer(ny);
                    q.offer(count + 1);
                }
                /* 벽을 아직 안부쉈지만 벽을 만났을 때 */
                else if (broken == 0 && map[nx][ny] == 1 && !visited[broken + 1][nx][ny]) {
                    visited[broken + 1][nx][ny] = true;
                    q.offer(1);
                    q.offer(nx);
                    q.offer(ny);
                    q.offer(count + 1);
                }
                /* 벽을 아직 안부쉈고 길을 만났을 때 */
                else if (broken == 0 && map[nx][ny] == 0 && !visited[broken][nx][ny]) {
                    visited[broken][nx][ny] = true;
                    q.offer(0);
                    q.offer(nx);
                    q.offer(ny);
                    q.offer(count + 1);
                }
            }
        }
        return answer == Integer.MAX_VALUE? -1 : answer;
    }
}