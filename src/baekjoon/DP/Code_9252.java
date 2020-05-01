package baekjoon.DP;

import java.io.*;

public class Code_9252 {
    static String w1, w2;
    static int len1, len2;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        w1 = br.readLine();
        w2 = br.readLine();
        len1 = w1.length();
        len2 = w2.length();
        dp = new int[len1 + 1][len2 + 1];   //  i j 까지의 LCS의 길이를 저장할 배열

        bw.write(String.valueOf(getLcsLength(len1, len2)) + "\n");
        bw.write(getLcs(len1, len2));

        br.close();
        bw.close();
    }

    /* LCS의 길이를 구하는 함수  */
    /* LCS를 구하는 함수를 사용하기전 메모제이션을 만들어놓기 위하여 구현 */
    public static int getLcsLength(int n, int m) {
        for (int i = 1; i <= len1; ++i) {
            for (int j = 1; j <= len2; ++j) {
                /* w1[i-1]와 w2[j-1]가 같은 알파벳이라면 이전 인덱스의 길이에서 더하기 */
                if (w1.charAt(i - 1) == w2.charAt(j - 1)) {
                    dp[i][j] += dp[i - 1][j - 1] + 1;
                }
                /* w1[i-1]와 w2[j-1]가 같은 알파벳이 아니라면 [i][j-1]과 [i-1][j] 중 최대값 */
                else {
                    dp[i][j] += dp[i][j - 1] > dp[i - 1][j] ? dp[i][j - 1] : dp[i - 1][j];
                }
            }
        }

        return dp[n][m];
    }

    /* LCS를 구하는 함수 */
    public static String getLcs(int n, int m) {
        if (n == 0 || m == 0)
            return "";
        else if (w1.charAt(n - 1) == w2.charAt(m - 1))
            return getLcs(n - 1, m - 1) + w1.charAt(n - 1);
        else
            return dp[n][m - 1] > dp[n - 1][m] ? getLcs(n, m - 1) : getLcs(n - 1, m);
    }
}