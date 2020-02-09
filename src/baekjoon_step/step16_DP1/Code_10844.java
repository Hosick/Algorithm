package baekjoon_step.step16_DP1;

import java.util.Scanner;

public class Code_10844 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        long[][] count = new long[101][11]; //  1~100 자리 계단수, 마지막 숫자 0~9

        /*한 자리일 때 초기화*/
        for (int i = 1; i <= 9; ++i)
            count[1][i] = 1;

        /*2~n 자리까지 초기화*/
        for (int i = 2; i <= n; ++i) {
            count[i][0] = count[i - 1][1];
            for (int j = 1; j <= 9; ++j) {
                count[i][j] = (count[i - 1][j - 1] + count[i - 1][j + 1]) % 1000000000;
            }
        }

        /*합계 및 출력*/
        long sum = 0;
        for (long i : count[n]) {
            sum += i;
        }

        System.out.println(sum % 1000000000);
    }
}
