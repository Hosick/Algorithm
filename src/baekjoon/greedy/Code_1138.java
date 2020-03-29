package baekjoon.greedy;

import java.util.ArrayList;
import java.util.Scanner;

public class Code_1138 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();

        /* 왼쪽에 있는 사람 수 배열 */
        int[] person = new int[n];
        for (int i = 0; i < n; ++i)
            person[i] = input.nextInt();

        /* 키가 제일 큰 사람부터 순서찾기 */
        ArrayList<Integer> order = new ArrayList<Integer>();
        for (int i = n - 1; i >= 0; --i)
            order.add(person[i], i);

        /* 출력 */
        for (int i = 0; i < n; ++i)
            System.out.print(order.get(i) + 1 + " ");
    }
}
