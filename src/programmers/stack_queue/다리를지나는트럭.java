package programmers.stack_queue;

import java.util.LinkedList;
import java.util.Queue;

public class 다리를지나는트럭 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        Queue<Integer> q = new LinkedList<Integer>();   //  다리위에 있는 트럭 구현 Queue
        for (int i = 0; i < bridge_length; ++i)         //  큐에 다리길이만큼 0(빈 공간)으로 채우기
            q.offer(0);

        int idx = 0;    //  대기중인 다음 차례 트럭의 index
        int sum_weights = 0;    //  현재 다리위에 있는 트럭들의 무게 합

        do {
            answer++;                   //  1초 경과
            sum_weights -= q.poll();    //  한 칸 씩 전진 (poll)
            if (idx < truck_weights.length && sum_weights + truck_weights[idx] <= weight) { //  대기하는 차량이 있을 때, 다리에 올라갈 수 있다면
                sum_weights += truck_weights[idx];  //  다리 현재 무게에 추가하고
                q.offer(truck_weights[idx++]);      //  다리(queue)에 올리기(offer)
            } else                                  //  대기하는 차량이 없거나, 다리에 올라갈 수 없다면
                q.offer(0);                     //  다리에는 빈 공간(0)이 생김(offer)
        } while (sum_weights > 0);                  //  다리 위 무게가 0이라면 종료

        return answer;
    }
}