package baekjoon_step.step23_DivideAndConquer;

import java.util.Scanner;

public class Code_1629 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int a = input.nextInt();
        int b = input.nextInt();
        int c = input.nextInt();

        System.out.print(square(a, b, c));
    }

    private static long square(int a, int b, int c) {
        if (b == 0)     //  a^0 = 1
            return 1;

        long n = square(a, b / 2, c);   //   a^n = (짝수) a^(n/2) * a^(n/2)
        long temp = n * n % c;              //         (홀수) a^(n/2) * a^(n/2) * a 이기 때문

        if (b % 2 == 0)
            return temp;
        else
            return temp * a % c;
    }
}
