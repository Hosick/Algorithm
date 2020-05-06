package baekjoon.DP;

import java.util.Scanner;

public class Code_2449 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();    //  전구의 개수
        int k = input.nextInt();    //  색의 개수

        int[] bulb = new int[n + 1];    //  n개의 전구 배열 (크기는 n 이지만 인접한 같은 색상은 한개로 취급한다.
        bulb[1] = input.nextInt();      //  첫번째 전구 먼저 초기화
        int amount = 1;                 //  중복을 제외한 전구의 개수
        int temp;
        for (int i = 2; i <= n; ++i) {  //  2 ~ n의 전구 입력
            temp = input.nextInt();     //  입력받은 전구의 색상이
            if (temp != bulb[amount])   //  이전 색상과 다르다면
                bulb[++amount] = temp;  //  배열에 추가
        }

        int dp[][] = new int[amount + 1][amount + 1];        //  [시작 인덱스][끝 인덱스] 사이에 바꿔야하는 전구 개수
        for (int gab = 1; gab < amount; ++gab) {             //  시작인덱스( 1 ~ amount)
            for (int i = 1; i + gab <= amount; ++i) {        //  시작인덱스와 끝 인덱스의 거리( 1 ~ (amount-1))
                int j = i + gab;                             //  마지막 인덱스
                dp[i][j] = Integer.MAX_VALUE;                //  우선 dp를  MAX로 초기화
                for (int l = i; l < j; ++l) {                 //  dp[i][j]를 분할해서 더한 값과 계속 비교
                    dp[i][j] = Math.min(dp[i][j], dp[i][l] + dp[l + 1][j] + (bulb[i] == bulb[l + 1] ? 0 : 1));   //  분할한 양쪽의 맨 앞 전구가 같은 색이라면 +1
                }
            }
        }
        System.out.println(dp[1][amount]);
    }
}