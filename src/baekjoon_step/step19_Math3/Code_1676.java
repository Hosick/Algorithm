package baekjoon_step.step19_Math3;

import java.util.Scanner;

public class Code_1676 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        zeroCount(n);
    }

    private static void zeroCount(int n) {
        int count = 0;
            for (int i = n; i >= 5; --i) {  // 5~i까지
            int temp = i;
            /* i가 5로 나누어 지는 수만큼 0의 갯수가 늘어난다 */
            while (true) {
                if (temp % 5 == 0) {
                    ++count;
                    temp /= 5;
                } else break;
            }
        }
        System.out.print(count);
    }
}
