package baekjoon_step.step5_Training1;

import java.util.Scanner;

public class Code_10996 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();

        for (int i = 0; i < n; ++i) {
            for (int j = 1; j <= 2; ++j) {
                /* 윗 줄 */
                if (j % 2 == 1) {
                    for (int k = 1; k <= n; ++k) {
                        if (k % 2 == 1)
                            System.out.print("*");
                        else if (k == n && n % 2 == 0)
                            continue;
                        else
                            System.out.print(" ");
                    }
                }
                /* 아래 줄 */
                else {
                    for (int k = 1; k <= n; ++k) {
                        if (k % 2 == 0)
                            System.out.print("*");
                        else
                            System.out.print(" ");
                    }
                }
                System.out.println();
            }
        }
    }
}
