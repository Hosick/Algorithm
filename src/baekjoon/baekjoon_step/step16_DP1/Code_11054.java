package baekjoon.baekjoon_step.step16_DP1;

import java.util.Scanner;

public class Code_11054 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int answer = 0;
        int[] array = new int[n];
        int[] increase = new int[n];
        int[] decrease = new int[n];

        /*길이가 n인 배열 입력*/
        for (int i = 0; i < n; ++i)
            array[i] = input.nextInt();

        /*인덱스 별 앞의 최대 증가 수열 구하기*/
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (array[i] > array[j] && increase[j] + 1 > increase[i])
                    increase[i] = increase[j] + 1;
            }
        }

        /*인덱스 별 뒤의 최대 감소 수열 구하기*/
        for (int i = n - 2; i >= 0; --i) {
            for (int j = n - 1; j > i; --j) {
                if (array[i] > array[j] && decrease[j] + 1 > decrease[i])
                    decrease[i] = decrease[j] + 1;
            }
        }

        /* 최대 바이토닉 부분 수열 구하기*/
        for (int i = 0; i < n; ++i) {
            if (increase[i] + decrease[i] > answer)
                answer = increase[i] + decrease[i];
        }

        System.out.println(answer + 1);
    }
}
