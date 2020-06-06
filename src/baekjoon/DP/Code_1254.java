package baekjoon.DP;

import java.util.Scanner;

public class Code_1254 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String s = input.nextLine();
        int len = s.length();

        /* 팰린드롬의 길이를 나타내는 dp 배열 선언 및 길이가 1인 구간 1로 초기화 */
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; ++i)
            dp[i][i] = true;

        /* dp 배열 채우기 */
        for (int gab = 1; gab < len; ++gab) {
            for (int i = 0; (i + gab) < len; ++i) {
                int j = i + gab;
                if (s.charAt(i) == s.charAt(j) && (gab == 1 || dp[i + 1][j - 1]))
                    dp[i][j] = true;
            }
        }

        /* i부터 len-1 까지의 구간이 긴 순서대로 팰린드롬이라면 왼쪽 구간을 오른쪽에 붙힌 숫자 출력 */
        for (int i = 0; i < len; ++i)
            if (dp[i][len-1]) {
                System.out.println(len + i);
                return;
            }
    }
}