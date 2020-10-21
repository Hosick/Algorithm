package graph;

import java.util.*;
import java.util.stream.IntStream;

public class 가장_먼_노드 {
    public int solution(int n, int[][] edge) {
        boolean[][] map = new boolean[n + 1][n + 1]; // 연결 확인 2차원 배열
        int[] distance = new int[n + 1]; //  각 노드의 거리 배열

        /* map 채우기 */
        for (int[] i : edge)
            map[i[0]][i[1]] = map[i[1]][i[0]] = true;

        /* bfs 탐색으로 시작점으로 부터 거리 계산 */
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int i = 2; i <= n; ++i) {
                if (map[now][i] && distance[i] == 0) {
                    queue.offer(i);
                    distance[i] = distance[now] + 1;
                }
            }
        }

        /* 최대 거리의 노드 수 반환 */
        return (int) IntStream.range(0, n + 1)
                .filter(i -> distance[i] == Arrays.stream(distance).max().getAsInt())
                .count();
    }
}
