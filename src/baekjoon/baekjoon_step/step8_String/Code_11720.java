package baekjoon.baekjoon_step.step8_String;


import java.util.Scanner;

public class Code_11720 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = 0;
        String x = "";
        int sum = 0;
        while (N < 1 || N > 100) {
            N = input.nextInt();
        }
        while (x.length() != N) {
            x = input.next();
        }
        for (int i = 0; i < N; i++) {
            sum += (x.charAt(i) - '0');
        }
        System.out.println(sum);
    }
}

