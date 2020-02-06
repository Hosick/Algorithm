package baekjoon_step.step16_DP1;

import java.util.Scanner;

public class Code_1149 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();

        int[][] paintingPrice = new int[n + 1][3];

        for (int i = 1; i <= n; ++i) {
            paintingPrice[i][0] = input.nextInt();
            paintingPrice[i][1] = input.nextInt();
            paintingPrice[i][2] = input.nextInt();
        }

        for (int i = 2; i <= n; ++i) {
            paintingPrice[i][0] += Math.min(paintingPrice[i - 1][1], paintingPrice[i - 1][2]);
            paintingPrice[i][1] += Math.min(paintingPrice[i - 1][0], paintingPrice[i - 1][2]);
            paintingPrice[i][2] += Math.min(paintingPrice[i - 1][0], paintingPrice[i - 1][1]);
        }

        System.out.print(Math.min(paintingPrice[n][0], Math.min(paintingPrice[n][1], paintingPrice[n][2])));
    }
}
