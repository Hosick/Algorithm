package baekjoon_step.step19_Math3;

import java.util.Scanner;

public class Code_11653 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        while (n != 1) {
            for (int i = 2; true; ++i) {
                if (n % i == 0) {
                    System.out.println(i);
                    n /= i;
                    break;
                }
            }
        }
    }
}
