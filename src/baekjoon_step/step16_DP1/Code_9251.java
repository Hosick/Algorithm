package baekjoon_step.step16_DP1;

import java.util.Scanner;

public class Code_9251 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String word1 = input.nextLine();
        String word2 = input.nextLine();

        /*두 단어의 길이 x 길이의 2차원 배열 선언*/
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        /* 두 단어의 인덱스를 서로 비교 */
        for (int i = 1; i <= word1.length(); ++i) {
            for (int j = 1; j <= word2.length(); ++j) {
                /* 비교하는 두 char가 다르다면 배열 위 또는 좌 방향 중 Max */
                if (word1.charAt(i - 1) != word2.charAt(j - 1))
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                /*  비교하는 두 char가 같다면 배열 좌상 방향의 값+1 */
                else
                    dp[i][j] = dp[i - 1][j - 1] + 1;
            }
        }

        /* 2차원 배열의 마지막 수 출력*/
        System.out.print(dp[word1.length()][word2.length()]);
    }
}
