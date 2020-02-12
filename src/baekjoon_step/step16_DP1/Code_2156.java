package baekjoon_step.step16_DP1;

import java.util.Scanner;

public class Code_2156 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int max = 0; // 마실 수 있는 최대 양

        int[] glass = new int[n + 1];   //  잔 별 포도주의 양 (기본 값을 1까지 넣을 수 있게하기 위해 n+1개
        for (int i = 0; i < n; ++i)
            glass[i] = input.nextInt();

        int[][] drink = new int[n + 1][2];  //  마신 포도주의 총 합(0은 다음 칸을 갈 수 있고, 1은 다음 칸을 갈 수 없다)
        drink[0][0] = glass[0];         // 0
        drink[1][0] = glass[1];         //  1
        drink[1][1] = glass[0] + glass[1];// 0+1
        max = Math.max(drink[0][0], Math.max(drink[1][0], drink[1][1])); //  max 값 0-1번째잔의 최대값으로 초기화

        for (int i = 2; i < n; ++i) {
            drink[i][0] = Math.max(drink[i - 2][0], drink[i - 2][1]) + glass[i];    //  전 잔을 마시지않음 (다음 잔을 마실 수 있음)
            if (i >= 3)
                drink[i][0] = Math.max(drink[i][0], drink[i - 3][1] + glass[i]);    //  이 전 두잔을 마시지않음 (다음 잔을 마실 수 있음)
            drink[i][1] = drink[i - 1][0] + glass[i];                               //  전 잔을 마심 (다음 잔을 마실 수 없음)

            /*최대로 마실 수 있다면 max에 저장*/
            if (Math.max(drink[i][0], drink[i][1]) > max)
                max = Math.max(drink[i][0], drink[i][1]);
        }

        System.out.print(max);
    }
}