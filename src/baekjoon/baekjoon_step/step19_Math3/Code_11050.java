package baekjoon.baekjoon_step.step19_Math3;

import java.util.Scanner;

public class Code_11050 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();

        /*이항 계수 계산*/
        if (k == 0)
            System.out.print(1);
        else if (k == n)
            System.out.print(1);
        else
            System.out.print(fac(n) / (fac(k) * fac(n - k)));
    }

    /*팩토리얼 계산*/
    private static int fac(int x) {
        if (x == 0 || x == 1) return x;
        return x * fac(x - 1);
    }
}

