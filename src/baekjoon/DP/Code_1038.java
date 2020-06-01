package baekjoon.DP;

import java.util.Arrays;
import java.util.Scanner;

public class Code_1038 {
    static int[][] dp;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        /* 숫자 n 입력하고 한자리수라면 바로 출력 후 return */
        int n = input.nextInt();
        if (n < 10) {
            System.out.println(n);
            return;
        }

        /* dp 배열[자릿수][맨 앞 숫자] 선언 후 1자리수는 1로 채우기 */
        dp = new int[n + 1][10];
        Arrays.fill(dp[1], 1);

        /* 현재 까지의 dp 총 합계가 n을 넘는다면 print(자릿수 - 1, n - (이전까지 합계)) 함수 호출 후 return*/
        int sum = 9;
        for (int i = 2; i <= 10; ++i) {
            for (int j = 1; j <= 9; ++j) {
                for (int k = i - 2; k < j; ++k) {
                    dp[i][j] += dp[i - 1][k];
                }
                if ((sum + dp[i][j]) >= n) {
                    System.out.print(j);
                    print(i - 1, n - sum);
                    return;
                }
                sum += dp[i][j];
            }
        }

        /* 함수 호출을 하지 못했다면 해당 감소하는 수가 없으므로 -1 출력 */
        System.out.println(-1);
    }

    /* 재귀를 이용한 자릿수의 값 출력 함수 */
    static void print(int idx, int n) {
        /* 한자리 수라면  */
        if (idx == 1) {
            System.out.println(n - 1);
            return;
        }

        int sum = 0;
        for (int j = 0; j < 9; ++j) {
            if ((dp[idx][j] + sum) >= n) {
                System.out.print(j);
                print(idx - 1, n - sum);
                return;
            }
            sum += dp[idx][j];
        }
    }
}