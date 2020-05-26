package baekjoon.greedy;

import java.util.Scanner;

public class Code_1041 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        long n = input.nextInt();    //  한변의 주사위 개수
        int[] dice = new int[7];    //  주사위의 각 면의 숫자 배열
        for (int i = 1; i < 7; ++i)
            dice[i] = input.nextInt();

        /* n이 1일 때  */
        if (n == 1) {
            int sum = 0;
            int max = 0;

            for (int i = 1; i < 7; ++i) {
                sum += dice[i];
                max = Math.max(max, dice[i]);
            }
            System.out.println(sum - max);
            return;
        }

        long show3 = 4;                      //  밖으로 3면이 보이는 주사위는 4개 고정(모서리)
        long show2 = (n - 2) * 4 + (n - 1) * 4;            //  밖으로 2면이 보이는 주사위는 모서리와 최고층 모서리, 가운데 제외
        long show1 = (n - 2) * (n - 2) + (n - 2) * (n - 1) * 4;     //  밖으로 1면이 보이는 주사위는 all - show3 - show2

        /* 접한 3면의 최소값 구하기 (8개의 조합가능) */
        int min3 = 151;
        for (int i = 1; i <= 6; i = i + 5) {
            for (int j = 2; j <= 5; j = j + 3) {
                for (int k = 3; k <= 4; k = k + 1) {
                    min3 = Math.min(min3, dice[i] + dice[j] + dice[k]);
                }
            }
        }

        /* 접한 2면의 최소값 구하기 */
        int min2 = 101;
        for (int i = 1; i <= 6; ++i) {
            for (int j = i + 1; j <= 6; ++j) {
                if (i + j == 7)
                    continue;
                min2 = Math.min(min2, dice[i] + dice[j]);
            }
        }

        /* 1면의 최소값 구하기 */
        int min1 = 51;
        for (int i = 1; i <= 6; ++i)
            min1 = Math.min(min1, dice[i]);

        /* 전체 최소값 계산 및 출력 */
        long ans = (min1 * show1) + (min2 * show2) + (min3 * show3);
        System.out.println(ans);
    }
}