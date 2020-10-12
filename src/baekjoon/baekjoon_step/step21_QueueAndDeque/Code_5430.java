package baekjoon.baekjoon_step.step21_QueueAndDeque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Code_5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Deque<Integer> deque = new LinkedList<Integer>();

        int t = Integer.parseInt(br.readLine());

        /* 테스트 케이스 갯수 만큼 시행 */
        while (t-- != 0) {
            deque.clear();
            String command = br.readLine(); //  명령어 입력받기
            int n = Integer.parseInt(br.readLine());    //  배열 초기 갯수 입력받기
            String array = br.readLine();

            /* 갯수가 0이 아니라면 덱에 넣기 */
            if (n != 0) {
                int length = array.length() - 1;
                StringTokenizer st = new StringTokenizer(array.substring(1, length), ",");
                for (int i = 0; i < n; ++i) {
                    deque.offer(Integer.parseInt(st.nextToken()));
                }
            }

            /* 명령어 하나 씩 시행*/
            boolean reverse = false;
            boolean error = false;
            for (int i = 0; i < command.length(); ++i) {
                if (command.charAt(i) == 'D' && deque.isEmpty()) {  //  명령어가 D인데 덱이 비어있다면 error=true
                    error = true;
                    break;
                } else if (command.charAt(i) == 'D' && !reverse)  //  명령어가 D이고 배열이 뒤집혀 있지않다면 앞에서 poll
                    deque.pollFirst();
                else if (command.charAt(i) == 'D' && reverse)   //  명령어가 D이고 배열이 뒤집혀 있다면 뒤에서 poll
                    deque.pollLast();
                else if (command.charAt(i) == 'R')              //  명령어가 R 이라면 reverse = !reverse
                    reverse = !reverse;
            }

            /* 남은 배열 출력 (error가 참이면 "error"출력) */
            if (error)
                System.out.println("error");
            else {
                System.out.print("[");
                while (!deque.isEmpty()) {
                    System.out.print(reverse ? deque.pollLast() : deque.pollFirst());   //  문자열이 뒤집혀있다면 뒤에서, 아니라면 앞에서 부터 poll
                    System.out.print(deque.isEmpty() ? "" : ",");
                }
                System.out.println("]");
            }
        }
        br.close();
    }
}