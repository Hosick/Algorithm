package baekjoon.baekjoon_step.step11_Recursion;

import java.util.Scanner;

public class Code_10872 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int N = input.nextInt();
        int sum = 1;

        for (int i = N; i > 1; --i) {
            sum *= i;
        }
        System.out.print(sum);
    }
}