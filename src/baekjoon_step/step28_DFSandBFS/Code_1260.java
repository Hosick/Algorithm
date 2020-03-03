package baekjoon_step.step28_DFSandBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Code_1260 {
    static int n;
    static int m;
    static int v;
    static int[][] map;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());   //  정점의 개수
        m = Integer.parseInt(st.nextToken());   //  간선의 개수
        v = Integer.parseInt(st.nextToken());   //  탐색을 시작한 정점의 번호

        map = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        /* 간선 채우기 */
        for (int i = 0; i < m; ++i) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map[x][y] = map[y][x] = 1;
        }

        /* 구현한 dfs,bfs 함수로 경로 출력 */
        dfs(v);
        System.out.println();
        Arrays.fill(visited, false);
        bfs(v);

        br.close();
    }

    /* DFS 구현 */
    private static void dfs(int start) {
        System.out.print(start + " ");
        visited[start] = true;
        for (int i = 1; i <= n; ++i) {
            if (map[start][i] == 1 && !visited[i])
                dfs(i);
        }
    }

    /* BFS 구현 */
    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int temp = queue.poll();
            System.out.print(temp + " ");

            for (int i = 1; i <= n; i++) {
                if (map[temp][i] == 1 && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}
