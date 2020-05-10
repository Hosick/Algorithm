package baekjoon.DP;

import java.util.Scanner;

public class Code_3943 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] dp = new int[27483084];   // 최대값 dp배열을 최대로 할당할수 있는 만큼 할당함
        int now, max;   //  현재 수, 지금까지의 최대값
        for (int i = 1; i <= 100000; ++i) { //  1 ~ 100000까지
            now = i;    //  현재값은 i부터 시작
            max = now;  //  최대값은 현재값
            while (now != 1) {  //  현재값이 1이될때까지
                if (now % 2 == 0)   //  짝수 연산
                    now /= 2;
                else                //  홀수 연산
                    now = now * 3 + 1;

                /* 현재가 dp배열 최대 인덱스보다 작고, dp[now]가 이미 구해졌다면 */
                if (now < 27483084 && dp[now] != 0) {
                    max = (dp[now] > max) ? dp[now] : max;  //  현재까지의 최대값과 앞으로의 최대값 중 더 큰값이 max
                    break;
                }
                max = (now > max) ? now : max;  // 아니라면 max구하고 계속
            }
            dp[i] = max;
        }

        /* 테스트 케이스 만큼 입력 및 출력 */
        int t = input.nextInt();
        while (t-- > 0) {
            int n = input.nextInt();

            System.out.println(dp[n]);
        }
    }
}