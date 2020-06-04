/** 나는 점화식을 포룹돌려서 풀었지만 재귀 함수를 이용해서 푸는 것이 더 편한 문제이다**/
package baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Code_10835 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());    //  카드더미 당 카드의 개수
        int answer = 0;

        /*  왼쪽 카드더미 입력*/
        int[] left = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = n; i > 0; --i)
            left[i] = Integer.parseInt(st.nextToken());
        /* 오른쪽 카드더미 입력 */
        int[] right = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = n; i > 0; --i)
            right[i] = Integer.parseInt(st.nextToken());

        /* dp배열 선언 및 dp[n][n]을 제외한 최소값으로 초기화 */
        int[][] dp = new int[n + 2][n + 2];
        for (int i = 0; i < n + 2; ++i)
            for (int j = 0; j < n + 2; ++j)
                dp[i][j] = Integer.MIN_VALUE;
        dp[n][n] = 0;

        /* dp를 이용해서 최대값 계산 */
        int r;
        for (int i = 1; i <= (n * 2); ++i) {    //  버리는 카드의 수
            for (int l = 0; l <= i; ++l) {      //  버리는 왼쪽 카드의 수
                r = i - l;                      //  버리는 오른쪽 카드의 수
                if (l > n || r > n) continue;   //  버리는 왼쪽이나 오른쪽의 카드 수가 총 카드 수를 넘어가면 continue
                /* 왼쪽에서 버렸거나, 양쪽다 버렸을 때의 값 */
                dp[n - l][n - r] = Math.max(dp[n - l + 1][n - r + 1], dp[n - l + 1][n - r]);
                /* 오른쪽에서 버렸을 때의 값 */
                if (1 <= r && right[n - r + 1] < left[n - l])
                    dp[n - l][n - r] = Math.max(dp[n - l][n - r], (dp[n - l][n - r + 1] + right[n - r + 1]));
                answer = (answer < dp[n - l][n - r]) ? dp[n - l][n - r] : answer;
            }
        }

        System.out.println(answer);
    }
}
