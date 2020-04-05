/**
 * Kruskal 알고리즘을 사용해서 풀어야하는 대표적인 문제이다
 * 간선의 비용을 정렬한 후 가장 낮은 비용의 간선부터 연결하는 방법이다.
 * 단 정점간의 싸이클이 연결되지 않도록 연결해야한다.
 **/

package programmers.greedy;

import java.util.Arrays;
import java.util.Comparator;

class 섬연결하기 {
    public int solution(int n, int[][] costs) {
        /* 건설 비용을 기준으로 길을 정렬 */
        Comparator<int[]> c1 = (a, b) -> {
            return a[2] - b[2];
        };
        Arrays.sort(costs, c1);

        /* 건설 비용이 가장 낮은 길부터 건설 여부 정하기 (한 줄로 이어지게) */
        boolean[] build = new boolean[costs.length];    //  i번 길의 건설 여부
        boolean[] island = new boolean[n];  //  i번 섬을 방문가능한지

        island[costs[0][0]] = true; //  0 번째 길의 출발섬
        island[costs[0][1]] = true; //  0 번째 길의 도착섬
        build[0] = true;    //  0번째 길 건설
        int answer = costs[0][2];   //  answer 을 0번째 길의 건설 비용으로 초기화
        int complete = 2;   //  방문 가능한 섬은 현재 2개

        while (complete < n) {  //  모든 섬을 방문할 수 있을 때 까지
            for (int i = 1; i < build.length; i++) {    //  모든 길을 탐색
                /* 한 쪽 섬만 방문이 가능 할 때에만 길 건설 */
                if (!build[i] && ((island[costs[i][0]] && !island[costs[i][1]]) || (island[costs[i][1]] && !island[costs[i][0]]))) {
                    build[i] = true;    // 건설 true
                    island[costs[i][0]] = island[costs[i][1]] = true;   //  두 섬 모두 방문 true
                    complete++;
                    answer += costs[i][2];
                    break;  //  건설 후 처음부터 다시 재탐색
                }
            }
        }
        return answer;
    }
}