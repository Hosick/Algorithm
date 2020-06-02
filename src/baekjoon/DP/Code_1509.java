package baekjoon.DP;

import java.util.Scanner;

public class Code_1509 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String word = input.nextLine();             //  문자열 입력
        int len = word.length();                    //  문자열의 길이
        boolean[][] isPalin = new boolean[len + 1][len + 1];     //  dp 배열 선언([인덱스 간 차이][시작 인덱스]);

        /* 팰린드롬 시작과 끝의 인덱스 구하기 */
        word = " " + word;  //  인덱스 계산 편의
        for (int gab = 0; gab < len; ++gab) {                   //  인덱스 간 차이
            for (int start = 1; (start + gab) <= len; ++start) { //  시작 인덱스
                int last = start + gab;                         //  마지막 인덱스
                if (gab == 0)
                    isPalin[start][last] = true;
                else if (word.charAt(start) == word.charAt(last))
                    if (gab < 2 || isPalin[start + 1][last - 1])
                        isPalin[start][last] = isPalin[last][start] = true;
            }
        }

        /* 팰린드롬의 분할 개수 구하기*/
        int[] dp = new int[len + 1];    //  dp[i] = i번 인덱스까지의 팰린드롬 분할 최소개수
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= i; j++) {
                if (isPalin[j][i]) {
                    if (dp[i] == 0 || dp[i] > dp[j - 1] + 1) {
                        System.out.println(dp[i] + " " + (dp[j - 1] + 1));
                        System.out.println("dp[" + i + "] = dp[" + (j - 1) + "] + 1");
                        dp[i] = dp[j - 1] + 1;
                    }
                }
            }
        }
        System.out.println(dp[len]);

    }
}