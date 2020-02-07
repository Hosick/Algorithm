package baekjoon_step.step16_DP1;

import java.util.Scanner;

public class Code_1932 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();    //  삼각형 크기 입력
        int max = 0;    //  최대 합계

        int[][] triangle = new int[n + 1][n + 1];   //  삼각형 배열

        /*삼각형의 숫자 입력 및 합계 계산*/
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                triangle[i][j] = input.nextInt();

                /*해당 칸이 제일 왼쪽일 때*/
                if (j == 1) triangle[i][j] = triangle[i - 1][j] + triangle[i][j];
                /*해당 칸이 제일 오른쪽일 때*/
                else if (j == i) triangle[i][j] = triangle[i - 1][j - 1] + triangle[i][j];
                /*왼쪽 끝, 오른쪽 끝 이 아닐때*/
                else triangle[i][j] = Math.max(triangle[i - 1][j], triangle[i - 1][j - 1]) + triangle[i][j];

                /*가장 마지막 층에서의 합계에서 제일 큰 수 찾기*/
                if(i==n && triangle[i][j]>max)
                    max = triangle[i][j];
            }
        }

        System.out.print(max);
    }
}