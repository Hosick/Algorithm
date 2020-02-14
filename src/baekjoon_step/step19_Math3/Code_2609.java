package baekjoon_step.step19_Math3;

import java.util.Scanner;

public class Code_2609 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int x = input.nextInt();
        int y = input.nextInt();
        int small = Math.min(x, y);  //  x,y 중 더 작은 값
        int big = Math.max(x, y);     //  x,y 중 더 큰 값

        /* 최대 공약수 */
        for (int i = small; i > 0; --i) {
            if (x % i == 0 && y % i == 0) {
                System.out.println(i);
                break;
            }
        }

        /* 최소 공배수 */
        for (int i = big; i <= x * y; i += big) {
            if (i % x == 0 && i % y == 0) {
                System.out.print(i);
                break;
            }
        }
    }
}
