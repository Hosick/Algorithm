package baekjoon.DP;

import java.util.Scanner;

public class Code_2616 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();        //  객차의 개수
        int[] arr = new int[n + 1];     //  객차의 손님 수 배열 선언 및 입력
        for (int i = 1; i <= n; ++i)
            arr[i] = input.nextInt();

        int limit = input.nextInt();    //  한 기관차가 끌 수 있는 최대 객차 수
        int[][] dp = new int[4][n + 1]; //  [소형차의 순서][몇번부터 끌고가는지] 까지의 최대값

        for (int i = 1; i < 4; ++i) {    //  1~3번 소형기관차
            for (int j = (i - 1) * limit + 1; j <= n - ((4 - i) * limit)+1; ++j) { //  몇번부터 끌고가는지
                for (int k = j; k < j + limit; ++k) {   //  j번부터 limit개의 객차를 dp[i][j]에 더하기
                    dp[i][j] += arr[k];
                }
                if (i != 1)         //  첫번째 열차가 아니라면 이전열차에서 가장 많이 실어간 값을 더하기
                    dp[i][j] += dp[i - 1][j - limit];
                dp[i][j] = Math.max(dp[i][j], dp[i][j - 1]);    //  전 칸부터 시작한 값과 비교하여 최대값 넣기
            }
        }

        /* 세번째 기관차까지 실은 값의 합 중 최대값 찾고 출력 */
        int max = 0;
        for (int i = limit * 2 + 1; i <= n - limit + 1; ++i)
            max = Math.max(max, dp[3][i]);
        System.out.println(max);
    }
}