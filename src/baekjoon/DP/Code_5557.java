package baekjoon.DP;

import java.util.Scanner;

public class Code_5557 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int[] arr = new int[n + 1];
        long[][] memo = new long[21][n + 1];    //  메모제이션 배열 선언
                                                //  [현재 계산값인 0 ~ 20][현재까지 계산한 인덱스] = 개수

        for (int i = 1; i <= n; ++i)
            arr[i] = input.nextInt();

        memo[arr[1]][1] = 1;    //  memo[1의 값][1] 을 1로 초기화

        for (int i = 1; i < n - 1; ++i) {   //  n-1 인덱스 까지 계산하기
            for (int j = 0; j <= 20; ++j) { //  0 - 20까지 현재까지 결과값을 계산
                if (memo[j][i] != 0) {       //  결과값이 있을 때
                    if (j + arr[i + 1] <= 20)   //  더하기 연산
                        memo[j + arr[i + 1]][i + 1] += memo[j][i];

                    if (0 <= j - arr[i + 1])    //  빼기 연산
                        memo[j - arr[i + 1]][i + 1] += memo[j][i];
                }
            }
        }

        System.out.print(memo[arr[n]][n - 1]);  //  인덱스 n-1까지 모두 계산했을 때 총 값이 arr[n]이 되는 경우의 수 출력
    }
}