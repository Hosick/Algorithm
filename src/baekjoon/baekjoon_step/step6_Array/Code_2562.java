package baekjoon.baekjoon_step.step6_Array;

import java.util.Scanner;

public class Code_2562 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] num = new int[9];
        int seq = 0;

        for (int i = 0; i < 9; ++i) {
            num[i] = input.nextInt();
            if (i > 0 && num[seq] < num[i])
                seq = i;
        }
        System.out.println(num[seq]);
        System.out.println(seq + 1);
    }
}
