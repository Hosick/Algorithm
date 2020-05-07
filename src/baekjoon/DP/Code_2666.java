package baekjoon.DP;

import java.util.Arrays;
import java.util.Scanner;

public class Code_2666 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();    //  벽장의 개수
        int a = input.nextInt();    //  문이 없는 첫번째 벽장 인덱스
        int b = input.nextInt();    //  문이 없는 두번째 벽장 인덱스
        int m = input.nextInt();    //  사용할 벽장의 개수

        int dp[][][] = new int[m + 1][n + 1][n + 1];     //  dp[벽장사용순서][문이 없는 첫번째 벽장][문이 없는 두번째 벽장]
        for (int i = 0; i <= m; ++i)                     //  dp배열을 모두 Integer.MAX_VALUE로 초기화하기
            for (int j = 0; j <= n; ++j)
                Arrays.fill(dp[i][j], Integer.MAX_VALUE);
        dp[0][a][b] = 0;                                 //  dp[0][a][b]를 0으로 초기화

        int target; //  열어야 할 벽장 인덱스
        for (int i = 1; i <= m; ++i) {  //  열어야할 벽장인덱스 첫번째부터 m번째까지
            target = input.nextInt();
            for (int j = 1; j < n; ++j) {   //  문이 없는 첫번째 벽장 인덱스 1 ~ (n-1)
                for (int k = j + 1; k <= n; ++k) {  //  문이 없는 두번째 벽장 인덱스 (i+1) ~ n
                    if (dp[i - 1][j][k] != Integer.MAX_VALUE) { // i번째에 벽장 j, k 가 열려있을 경우의 수가 있을 때
                        if (target <= j)    //  열어야할 문이 j보다 작거나 같을 때
                            dp[i][target][k] = Math.min(dp[i][target][k], dp[i - 1][j][k] + (j - target));
                        else if (target >= k)   //  열어야할 문이 k보다 크거나 같을 때
                            dp[i][j][target] = Math.min(dp[i][j][target], dp[i - 1][j][k] + (target - k));
                        else {                  //  열어야할 문이 j, k 사이일 때
                            dp[i][target][k] = Math.min(dp[i][target][k], dp[i - 1][j][k] + (target - j));
                            dp[i][j][target] = Math.min(dp[i][j][target], dp[i - 1][j][k] + (k - target));
                        }
                    }
                }
            }
        }

        /* dp[m][][]에서 최저값찾고 출력 */
        int min = Integer.MAX_VALUE;
        for (int j = 1; j < n; ++j) {
            for (int k = j + 1; k <= n; ++k) {
                if (dp[m][j][k] != -1 && dp[m][j][k] < min)
                    min = dp[m][j][k];
            }
        }
        System.out.println(min);
    }
}