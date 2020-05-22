package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Code_1507 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());    //  도시의 개수

        int[][] dist = new int[n + 1][n + 1];   //  주어진 간선 배열
        int[][] a = new int[n + 1][n + 1];      //  바로 이어진 간선 배열
        for (int i = 1; i <= n; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; ++j) {
                dist[i][j] = Integer.parseInt(st.nextToken());
                a[i][j] = dist[i][j];
            }
        }
        br.close();

        for (int k = 1; k <= n; ++k) {           //  중간지점
            for (int i = 1; i <= n; ++i) {       //  출발지점
                for (int j = 1; j <= n; ++j) {   //  도착지점
                    /* 중간지점이 출발이나 도착지점과 같다면 넘기기 */
                    if (k == i || k == j)
                        continue;
                    /* dist[i][j]가 최단거리가 아니라면 -1 출력 후 반환*/
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        System.out.println(-1);
                        return;
                    }
                    /* dist[i][j]가 k를 거쳐가는 루트였다면 dist[i][j] 간선 지우기 */
                    if (dist[i][j] == (dist[i][k] + dist[k][j])) {
                        a[i][j] = 0;
                    }
                }
            }
        }

        /* 남은 간선 값의 합 구하고 출력 */
        int ans = 0;
        for (int i = 2; i <= n; ++i) {
            for (int j = 0; j < i; ++j) {
                ans += a[i][j];
            }
        }
        System.out.println(ans);
    }
}