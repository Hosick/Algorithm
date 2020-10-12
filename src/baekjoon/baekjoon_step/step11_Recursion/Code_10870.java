package baekjoon.baekjoon_step.step11_Recursion;

import java.util.Scanner;

public class Code_10870 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();

        System.out.println(fibonacci(num));
    }

    public static int fibonacci(int num) {
        if (num == 0)
            return 0;
        if (num == 1)
            return 1;
        return fibonacci(num - 1) + fibonacci(num - 2);
    }
}
