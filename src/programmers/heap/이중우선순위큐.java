package programmers.heap;

import java.util.*;

class 이중우선순위큐 {
    public int[] solution(String[] operations) {
        int[] answer = {0, 0};

        PriorityQueue<Integer> q = new PriorityQueue<>();   //  최소값 우선 큐
        PriorityQueue<Integer> rq = new PriorityQueue<>(Collections.reverseOrder());    //  최대값 우선 큐

        for (String i : operations) {
            String command[] = i.split(" ");    //  공백제거
            /* Insert */
            if (command[0].equals("I")) {
                q.add(Integer.parseInt(command[1]));
                rq.add(Integer.parseInt(command[1]));
            }
            /* Delete */
            else {
                if (q.size() > 0) {
                    /* 최대값 제거 */
                    if (command[1].equals("1")) {
                        int max = rq.poll();
                        q.remove(max);
                    }
                    /* 최소값 제거 */
                    else {
                        int min = q.poll();
                        rq.remove(min);
                    }
                }
            }
        }

        if (q.size() >= 2){
            answer[0] = rq.poll();
            answer[1] = q.poll();
        }

        return answer;
    }
}