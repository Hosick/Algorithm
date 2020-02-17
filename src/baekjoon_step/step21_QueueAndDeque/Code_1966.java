package baekjoon_step.step21_QueueAndDeque;

import java.util.LinkedList;
import java.util.Scanner;

public class Code_1966 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        LinkedList<Integer> queue = new LinkedList<>();

        /*테스트 케이스 만큼 시행*/
        int t = input.nextInt();
        for (int i = 0; i < t; ++i) {
            queue.clear();  //  이전테스트 케이스의 큐 초기화

            int n = input.nextInt();    //  문서의 갯수
            int m = input.nextInt();    //  순서를 구할 문서의 인덱스
            int count = 0; // 지금 까지 출력한 문서 갯수

            for (int j = 0; j < n; ++j) {   //  문서 중요도를 front 부터 입력
                queue.offer(input.nextInt());
            }

            /*  */
            while (m != 0 || !isMax(queue, m)) {
                /* front의 문서 중요도가 큐에서 가장 높을 때  */
                if (isMax(queue, 0)) {
                    queue.remove(0);
                    --m;    //  인덱스 m 한 칸 앞으로
                    ++count;    //  출력 갯수 추가
                }
                /* front가 m이 아니고 문서 중요도가 큐에서 가장 높지 않을 때 (뒤로 보내기) */
                else if ((m != 0) && !isMax(queue, 0)) {
                    queue.add(queue.pop());
                    --m;    //  인덱스 m 한 칸 앞으로
                }
                /*front가 m이지만 문서 중요도가 큐에서 가장 높지 않을 때 (뒤로 보내기)*/
                else if ((m == 0) && !isMax(queue, 0)) {
                    queue.add(queue.pop());
                    m = queue.size() - 1;   //  인덱스 맨 뒤로 보내기
                }
            }
            System.out.println(++count);
        }
    }

    /* x번째 숫자가 큐의 최댓값인지 확인하는 함수 */
    private static boolean isMax(LinkedList<Integer> queue, int x) {
        boolean max = true;
        for (int i = 0; i < queue.size(); ++i) {
            if (i == x) continue;
            if (queue.get(i) > queue.get(x)) {
                max = false;
                break;
            }
        }
        return max;
    }
}
