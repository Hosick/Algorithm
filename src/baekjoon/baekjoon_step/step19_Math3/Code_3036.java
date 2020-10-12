package baekjoon.baekjoon_step.step19_Math3;

import java.util.Scanner;

public class Code_3036 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();

        int[] ring = new int[n];
        for (int i = 0; i<n; ++i)
            ring[i] = input.nextInt();

        /* 첫번째 링과 i번째링을 각각 최대공약수로 나눈 값*/
        for (int i = 1; i < n; ++i) {
            int min = 1;
            for (int j = Math.min(ring[0], ring[i]); j > 0; --j) {
                if (ring[0] % j == 0 && ring[i] % j == 0) {
                    min = j;
                    break;
                }
            }
            System.out.println(ring[0] / min + "/" + ring[i] / min);
        }
    }
}
