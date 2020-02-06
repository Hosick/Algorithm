package baekjoon_step.step16_DP1;

import java.util.Scanner;

public class Code_2748 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        long f[] = new long[91];
        f[0] = 0;
        f[1] = 1;

        for (int i = 2; i <= 90; ++i) {
            f[i] = f[i - 1] + f[i - 2];
        }
        System.out.print(f[n]);
    }
}
