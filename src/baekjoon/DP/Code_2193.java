/** n자리 수 이친수의 개수는  n-1 미만 자리수의 이친수의 값의 합과 같다.**/
/** 따라서 n-1자리의 이친수는 n-2미만의 이친수의 합과 같기 때문에 **/
/** dp[i] = dp[i-1] + dp[i-2]이다 **/

package baekjoon.DP;

import java.util.Scanner;

public class Code_2193 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        long[] dp = new long[91];
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; ++i){
            dp[i] = dp[i-1] + dp[i-2];
        }

        System.out.print(dp[n]);
    }
}