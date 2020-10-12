package baekjoon.baekjoon_step.step2_If;

import java.util.Scanner;

public class Code_5543 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int burger = Integer.MAX_VALUE;
        int drink = Integer.MAX_VALUE;

        for (int i = 0; i < 3; ++i) {
            burger = Math.min(burger, input.nextInt());
        }

        for (int i = 0; i < 2; ++i) {
            drink = Math.min(drink, input.nextInt());
        }

        System.out.print(burger + drink - 50);
    }
}