package programmers.dp;

class 등굣길 {
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[m + 1][n + 1];

        /* 시작점은 1, 웅덩이는 -1 */
        dp[1][1] = 1;
        for (int[] p : puddles)
            dp[p[0]][p[1]] = -1;

        /* dp로 경우의 수 계산 */
        for (int x = 1; x <= m; ++x) {
            for (int y = 1; y <= n; ++y) {
                // 시작점과 웅덩이는 계산하지 않음
                if ((x == 1 && y == 1) || dp[x][y] == -1)
                    continue;
                if (dp[x - 1][y] == -1 && dp[x][y - 1] == -1)
                    continue;
                else if (dp[x - 1][y] == -1)
                    dp[x][y] = dp[x][y - 1];
                else if (dp[x][y - 1] == -1)
                    dp[x][y] = dp[x - 1][y];
                else
                    dp[x][y] = (dp[x - 1][y] + dp[x][y - 1]) % 1000000007;
            }
        }

        return dp[m][n] % 1000000007;
    }
}
