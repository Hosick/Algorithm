package baekjoon_step.step16_DP1;

import java.util.Scanner;

public class Code_2579 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();

        int[] floor = new int[n];   //  계단 별 점수
        for (int i = 0; i < n; ++i)
            floor[i] = input.nextInt();

        int[][] sum = new int[n][2];     //  계단 까지 합계 점수(0은 다음 칸을 갈 수 있고, 1은 다음 칸을 갈 수 없다)
        sum[0][0] = floor[0];            // 0
        sum[1][0] = floor[1];            // 1
        sum[1][1] = floor[0] + floor[1]; // 0+1

        for (int i = 2; i < n; ++i) {
            sum[i][0] = Math.max(sum[i - 2][0], sum[i - 2][1]) + floor[i];  //  두 칸 밑에서 점프함 (다음 칸을 밟을 수 있음)
            sum[i][1] = sum[i - 1][0] + floor[i];                           //  한 칸 밑에서 올라옴 (다음 칸을 밟지 못함)
        }

        System.out.print(Math.max(sum[n - 1][0], sum[n - 1][1]));
    }
}