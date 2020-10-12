package baekjoon.baekjoon_step.step19_Math3;

import java.util.Arrays;
import java.util.Scanner;

public class Code_1037 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();

        /* 약수 배열 입력 */
        int[] divisor = new int[n];
        for (int i = 0; i < n; ++i)
            divisor[i] = input.nextInt();

        Arrays.sort(divisor);   //  약수 배열 정렬

        System.out.print(divisor[0] * divisor[divisor.length - 1]);
    }
}
