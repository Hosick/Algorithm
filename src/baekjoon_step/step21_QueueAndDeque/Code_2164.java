package baekjoon_step.step21_QueueAndDeque;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Code_2164 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int card = input.nextInt();


        /* 카드 배치 */
        Queue<Integer> que = new LinkedList<Integer>();
        for (int i = 1; i <= card; ++i) {
            que.offer(i);
        }

        /* 카드 한 장씩 버리거나 새로 넣기*/
        boolean alter = false;
        while (card > 1) {  //  한장 남을 때까지
            if (!alter) {   //  버리기
                que.poll();
                --card;
                alter = true;
            } else {        //  새로 넣기
                que.offer(que.poll());
                alter = false;
            }
        }

        /* 남은 한 장 출력 */
        System.out.print(que.poll());
    }
}