package baekjoon_step.step16_DP1;

import java.util.Scanner;

public class Code_1003 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[][] fibonacci = new int[41][2]; //  0과 1의 출력 갯수 저장 배열
        fibonacci[0][0] = 1;
        fibonacci[1][1] = 1;

        for (int i = 2; i < 41; ++i) {  //  출력 갯수 미리 저장하기
            fibonacci[i][0] = fibonacci[i - 1][0] + fibonacci[i - 2][0];
            fibonacci[i][1] = fibonacci[i - 1][1] + fibonacci[i - 2][1];
        }

        int t = input.nextInt();

        for (int i = 0; i < t; ++i) {
            int n = input.nextInt();
            System.out.println(fibonacci[n][0] + " " + fibonacci[n][1]);
        }
    }
}