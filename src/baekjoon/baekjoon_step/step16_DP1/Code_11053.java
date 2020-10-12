package baekjoon.baekjoon_step.step16_DP1;

import java.util.Scanner;

public class Code_11053 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int answer = 0;
        int[] array = new int[n];
        int[] increase = new int[n];

        /*길이가 n인 배열 입력*/
        for (int i = 0; i < n; ++i)
            array[i] = input.nextInt();

        /*인덱스가 i보다 작은 j배열 들에서 값이 array[i]보다 작으며 거친 수들이 가장 많은 인덱스 j를 찾기*/
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (array[i] > array[j] &&  increase[j] + 1 > increase[i])
                    increase[i] = increase[j] + 1;
            }
        }

        /*가장 긴 배열 찾고 출력*/
        for (int i = 0; i < n; ++i)
            if (increase[i] > answer) answer = increase[i];

        System.out.println(answer+1);
    }
}