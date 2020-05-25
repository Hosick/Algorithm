/**
 * 처음부터 중량에 맞춰 싣기 보다는
 * 짐을 내린 후 마을 i 에서 싣을 수 있는 모든 짐을 싣고
 * 초과시 마지막 칸의 짐부터 순차적으로 내린 후
 * 다음 마을로 출발하는 것이 맞다.
 **/

package baekjoon.greedy;

import java.io.*;
import java.util.StringTokenizer;

public class Code_8980 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());   //  마을의 개수
        int c = Integer.parseInt(st.nextToken());   //  트럭의 최대용량
        int m = Integer.parseInt(br.readLine());    //  박스의 개수

        /* 박스 정보 입력 */
        int[][] box = new int[n][n + 1];    //  박스의 정보, box[보내는 마을][받는 마을] = 무게
        for (int i = 0; i < m; ++i) {
            st = new StringTokenizer(br.readLine());
            box[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }
        br.close();

        int[] truck = new int[n + 1];   //  트럭의 실린 무게 배열, truck[도착 마을]
        int sum = 0;                    //  트럭의 실린 박스 합계
        int ans = 0;                    //  배송할 수 있는 최대 박스 수
        for (int i = 1; i <= n; ++i) {           //  현재 마을 (1 ~ n)
            /* 박스 하차 */
            sum -= truck[i];
            ans += truck[i];
            truck[i] = 0;

            /* 일단 모든 i에서 출발하는 모든 박스 상차 */
            for (int j = i + 1; j <= n; ++j) {
                truck[j] += box[i][j];
                sum += box[i][j];
            }

            /* 중량이 초과한다면 가장 늦게 도착하는 화물부터 내려서 중량을 c에 맞추기 */
            for (int j = n; j > i; --j){
                if (sum > c){
                    int quit = Math.min(truck[j], sum-c);   //  j에 도착할 양 중 하차할 양
                    truck[j] -= quit;
                    sum -= quit;
                }

                if (sum <= c)   //  중량이 맞추어졌다면 break;
                    break;
            }
        }

        System.out.println(ans);
    }
}
