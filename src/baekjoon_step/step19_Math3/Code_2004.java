package baekjoon_step.step19_Math3;

import java.util.Scanner;

public class Code_2004 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int k = input.nextInt();

        /* n이 5count와 2count 초기화 */
        long fc = fiveCount(n);
        long tc = twoCount(n);

        /* k와 (n-k)의 5count와 2count를 빼기 */
        fc -= fiveCount(k);
        tc -= twoCount(k);
        fc -= fiveCount(n - k);
        tc -= twoCount(n - k);

        /* 남는 2카운트 갯수와 5카운트 갯수 중 최소를 출력 (5와 2가 함께 있을 때 0이 하나 늘기 때문) */
        System.out.print(Math.min(tc, fc));
    }

    /* 5로 나누어지는 갯수 세는 함수 */
    private static long twoCount(long x) {
        long count = 0;
        for (long i = 5; i <= x; i *= 5)
            count += x / i;
        return count;
    }

    /* 2로 나누어지는 갯수 세는 함수 */
    private static long fiveCount(long x) {
        long count = 0;
        for (long i = 2; i <= x; i *= 2)
            count += x / i;
        return count;
    }
}