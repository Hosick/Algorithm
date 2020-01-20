package baekjoon_step.step2_If;

import java.util.Scanner;

public class Code_10817 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int A, B, C;

        A = input.nextInt();
        B = input.nextInt();
        C = input.nextInt();

        if (A > B) {
            if (C >= A) System.out.println(A);
            else if (B >= C) System.out.println(B);
            else System.out.println(C);
        } else if (B > A) {
            if (C >= B) System.out.println(B);
            else if (A >= C) System.out.println(A);
            else System.out.println(C);
        } else System.out.println(A);
    }
}
