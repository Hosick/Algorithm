package baekjoon.baekjoon_step.step3_For;

import java.util.Scanner;

public class Code_10871 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int N = input.nextInt();
        int[] A = new int[N];
        int X = input.nextInt();

        for (int i = 0; i < N; i++) {
            A[i] = input.nextInt();
        }

        for (int i = 0; i < N; i++) {
            if (A[i] < X) System.out.print(A[i] + " ");
        }

    }
}