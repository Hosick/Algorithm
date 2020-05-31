/**
 * 주유소에 들릴 때 순서대로 들릴 곳을 정할 필요는 없다
 * 갈 수 있는 주유소 중 가장 연료가 많은 주유소를 방문하면 된다.
 * 위의 탐색을 목적지에 갈 수 있을 때까지 반복한다.
 **/
package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Code_1826 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        /* 주유소 개수, 정보 입력 및 정렬(거리 오름차순) */
        int n = Integer.parseInt(br.readLine());
        int[][] station = new int[n][2];
        for (int i = 0; i < n; ++i) {
            st = new StringTokenizer(br.readLine());
            station[i][0] = Integer.parseInt(st.nextToken());
            station[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(station, Comparator.comparingInt(o -> o[0]));

        /* 목표 위치와 기존 연료양 입력 */
        st = new StringTokenizer(br.readLine());
        int l = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        br.close();

        /* 갈 수 있는 정류장 pq(연료 내림차 순) */
        Queue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);   //  들릴 수 있는 정류장 pq
        int ans = 0;
        int now = 0;            //  현재 위치
        int fuel = p;           //  현재 연료
        int limit = now + fuel; //  최대 위치
        int idx = 0;

        /* 목적지를 갈 수 있을 때까지 */
        while (limit < l) {
            ans++;
            /* 갈수 있는 정류장 추가  */
            while (idx < n && station[idx][0] <= limit)
                pq.add(station[idx++]);

            /* 갈수 있는 정류장이 안남았다면 -1 출력 */
            if (pq.isEmpty()) {
                ans = -1;
                break;
            }

            /* 연료가 가장많은 주유소가 다음 주유소이다(방향은 상관없음) */
            int[] stop = pq.remove();
            fuel -= (stop[0] > now) ? (stop[0] - now) : 0;
            fuel += stop[1];
            now = Math.max(now, stop[0]);
            limit = now + fuel;
        }

        System.out.println(ans);
    }
}