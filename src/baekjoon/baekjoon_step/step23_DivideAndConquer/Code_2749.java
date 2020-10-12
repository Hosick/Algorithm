package baekjoon.baekjoon_step.step23_DivideAndConquer;

import java.util.Scanner;

public class Code_2749 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long n = input.nextLong();

        /*피보나치 수를 나눌 수를 K라고 할 때 k=10^n 이면, 피사노 주기는 15*10^(n-1) 이다. */
        /* 피사노 주기를 넘는다면 다시 K로 나누면 된다 */
        int pisano = 1500000;
        long[] Fibonacci = new long[pisano];
        Fibonacci[0] = 0;
        Fibonacci[1] = 1;

        /* DP로 피보나치 배열 구하기 */
        for (int i = 2; i < pisano && i <= n; i++) {
            Fibonacci[i] = (Fibonacci[i - 1] + Fibonacci[i - 2]) % 1000000;
        }
        
        if (n >= pisano) {
            n %= pisano;
        }

        System.out.print(Fibonacci[(int) n]);
    }
}
