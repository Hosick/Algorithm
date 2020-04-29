package baekjoon.DP;

import java.util.Scanner;

public class Code_9507 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        long[] fib = new long[68];
        fib[0] = fib[1] = 1;
        fib[2] = 2;
        fib[3] = 4;
        for (int i = 4; i <= 67; ++i)
            fib[i] = fib[i - 1] + fib[i - 2] + fib[i - 3] + fib[i - 4];

        int t = input.nextInt();
        while (t-- > 0)
            System.out.println(fib[input.nextInt()]);
    }
}
