package baekjoon_step.step21_QueueAndDeque;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Code_1021 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();    //  덱에 넣을 숫자 갯수
        int m = input.nextInt();    //  덱에서 1번 연산을 수행할 숫자 갯수

        /* 덱에 숫자 넣기 */
        Deque<Integer> deque = new LinkedList<Integer>();
        for (int i = 1; i <= n; ++i)
            deque.offer(i);

        int count = 0;  //  2,3 번 연산 수행 횟수
        /* m개의 숫자 찾기 */
        for (int i = 0; i < m; ++i) {
            int num = input.nextInt();

            /* 찾는 값의 인덱스 알아내기 */
            int index = 0;
            for (int j = 0; j < deque.size(); ++j) {
                if (((LinkedList<Integer>) deque).get(j) == num)
                    index = j;
            }
            /* 찾는 값 num을 first로 부를때까지 */
            while (deque.peekFirst() != num) {
                /* 2번 연산 수행 */
                if (deque.size() / 2 >= index) {
                    deque.offerLast(deque.pollFirst());
                    ++count;
                }
                /* 3번 연산 수행 */
                else {
                    deque.offerFirst(deque.pollLast());
                    ++count;
                }
            }
            deque.pollFirst();  //  찾은 값 poll
        }
        System.out.print(count);
    }
}