package baekjoon.baekjoon_step.step19_Math3;

import java.util.Scanner;

public class Code_5086 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (true) {
            int a = input.nextInt();
            int b = input.nextInt();
            if (a == 0 && b == 0) return;
            if(b%a == 0) System.out.println("factor");
            else if(a%b == 0) System.out.println("multiple");
            else System.out.println("neither");
        }
    }
}
