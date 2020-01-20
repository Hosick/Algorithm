package baekjoon_step.step7_Function;


import java.util.Scanner;

public class Code_1065 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int N = input.nextInt();

        System.out.println(han(N));
    }

    public static int han(int N) {
        int count = 99;
        if (N < 100) count = N;
        else {
            for (int i = 100; i <= N; i++) {
                String M = Integer.toString(i);
                if ((M.charAt(0) - M.charAt(1)) == (M.charAt(1) - M.charAt(2))) {
                    ++count;
                }
            }
        }
        return count;
    }
}
