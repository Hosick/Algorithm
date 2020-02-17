package baekjoon_step.step21_QueueAndDeque;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Code_11866 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int k = input.nextInt();

        /* 1-n 까지 큐 채우기 */
        Queue<Integer> circle = new LinkedList<Integer>();
        for (int i = 1; i <= n; ++i) {
            circle.offer(i);
        }

        System.out.print("<");
        /* 한 개 남을 때 까지 k번째 숫자 빼기 */
        while (circle.size() > 1) {
            /* front에서 숫자를 빼서 다시 붙히기 (k-1번) */
            for (int i = 0; i < k-1; ++i)
                circle.offer(circle.poll());
            /* front를 poll하고 출력 */
            System.out.print(circle.poll()+", ");
        }
        /* 마지막 남은 숫자 출력 */
        System.out.println(circle.poll() + ">");
    }
}
