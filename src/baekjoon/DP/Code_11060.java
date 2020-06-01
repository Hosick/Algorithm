package baekjoon.DP;

import java.util.Arrays;
import java.util.Scanner;

public class Code_11060 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        /* 미로의 길이와 미로 안 숫자 입력 */
        int n = input.nextInt();
        int[] maze = new int[n + 1];
        for (int i = 1; i <= n; ++i)
            maze[i] = input.nextInt();

        /* dp를 이용해 최소 점프 수 계산 */
        int[] dp = new int[n + 1];   //  i까지 오는데의 최소 점프 수
        Arrays.fill(dp, 1001);  //  dp를 최대값으로 채우기
        dp[1] = 0;
        for (int i = 1; i <= n; ++i) {
            if (dp[i] == 1001)  // i에 도달할 수가 없다면 continue
                continue;
            for (int j = 1; j <= maze[i]; ++j) { // 도달했다면 1 ~ maze[i]만큼 점프해보기
                if (i + j <= n)
                    dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
            }
        }

        System.out.println((dp[n] == 1001) ? -1 : dp[n]);
    }
}
