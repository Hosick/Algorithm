package baekjoon.DP;

import java.util.Scanner;

public class Code_5582 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        /* 문자열 입력 및 길이 변수 선언 */
        String a = input.nextLine();
        String b = input.nextLine();
        int lenA = a.length();
        int lenB = b.length();


        /* dp를 이용하여 최장 공통부분 문자열의 길이구하기 */
        int max = 0;
        int[][] dp = new int[lenA][lenB];
        for (int i = 0; i < a.length(); ++i){
            for (int j = 0; j < b.length(); ++j){
                if (a.charAt(i) == b.charAt(j)){
                    if (i == 0 || j == 0)
                        dp[i][j] = 1;
                    else {
                        dp[i][j] = dp[i-1][j-1] + 1;
                    }
                    max = Math.max(max, dp[i][j]);
                }
            }
        }

        System.out.println(max);
    }
}
