package baekjoon_step.step28_DFSandBFS;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Code_2206 {
    static int[][] map;
    static int n;
    static int m;
    static int[] xm = {-1, 1, 0, 0};
    static int[] ym = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for (int i = 0; i < n; ++i) {
            String line = br.readLine();
            for (int j = 0; j < m; ++j) {
                map[i][j] = line.charAt(j) - '0';
                map[i][j] = map[i][j] == 1 ? -1 : 0;    //  장애물을 -1로 변경
            }
        }

        bw.write(String.valueOf(bfs()));
        bw.flush();
        br.close();
        bw.close();
    }

    private static int bfs() {
        if (n == 1 && m == 1) return 0;
        int chance = 1; //  벽 뚫기 기회 1번 제공
        map[0][0] = 1;
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(0);
        q.offer(0);


        while (!q.isEmpty()) {
            int tx = q.poll();
            int ty = q.poll();

            int count = 0;  //  네방향이 다 막혀있는지 체크
            for (int i = 0; i < 4; ++i) {
                int nx = tx + xm[i];
                int ny = ty + ym[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) { //  map 을 벗어나면 pass
                    ++count;    //  막힌길 체크 +1
                    continue;
                } else if (map[nx][ny] == -1) { //  막힌길 체크 +1
                    ++count;
                } else if (map[nx][ny] == 0) {
                    q.offer(nx);
                    q.offer(ny);
                    map[nx][ny] = map[tx][ty] + 1;
                }
                /* 상하좌우 벽뚫기 */
                if (i == 3 && count == 4 && chance == 1) {
                    --chance;
                    if (tx - 1 >= 0) {
                        map[tx - 1][ty] = map[tx][ty] + 1;
                        q.offer(tx - 1);
                        q.offer(ty);
                    }
                    if (ty - 1 >= 0) {
                        map[tx][ty - 1] = map[tx][ty] + 1;
                        q.offer(tx);
                        q.offer(ty - 1);
                    }
                    if (tx + 1 < n) {
                        map[tx + 1][ty] = map[tx][ty] + 1;
                        q.offer(tx + 1);
                        q.offer(ty);
                    }
                    if (ty + 1 < m) {
                        map[tx][ty + 1] = map[tx][ty] + 1;
                        q.offer(tx);
                        q.offer(ty + 1);
                    }
                }
            }
        }
        return map[n - 1][m - 1] == 0 ? -1 : map[n - 1][m - 1];
    }
}
