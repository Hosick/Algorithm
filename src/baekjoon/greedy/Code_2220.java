package baekjoon.greedy;

import java.util.Scanner;

public class Code_2220 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        /* n입력 및 힙 배열 선언 */
        int n = input.nextInt();
        int heap[] = new int[n + 1];

        /* 2 ~ n까지 최대힙에 넣어서 채워주고 마지막에 n 자리에 1을 넣기  */
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 1; j /= 2)
                heap[j] = heap[j / 2];
            heap[1] = i + 1;
        }
        heap[n] = 1;

        /* 힙 출력 */
        for (int i = 1; i <= n; i++)
            System.out.print(heap[i] + " ");
    }
}