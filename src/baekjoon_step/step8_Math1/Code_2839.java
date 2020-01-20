package baekjoon_step.step8_Math1;


import java.util.Scanner;

public class Code_2839 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = 0;

        while (N < 3 || N > 5000) {
            N = input.nextInt();
        }
        input.close();

        int result5 = 0, result3 = 0;

        if (N % 5 == 0) { //5KG 봉지로 딱 나눠질 때
            System.out.println(N / 5);
            return;
        } else {
            for (result5 = N / 5; result5 >= 0; result5--) {
                if ((N - result5 * 5) % 3 == 0) {
                    result3 = (N - result5 * 5) / 3;
                    System.out.println(result5 + result3);
                    return;
                }
            }
        }
        if (result3 == 0)
            System.out.println(-1);

    }
}