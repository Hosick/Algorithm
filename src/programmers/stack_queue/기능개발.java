package programmers.stack_queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class 기능개발 {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();  //  현재 작업 중인 기능들
        for(int i : progresses)                 //  기능들의 현 진행상태를 큐에 넣기
            q.offer(i);

        int day = 0;    //  경과 일 수
        int idx = 0;    //  배포 대기중인 기능들의 가장 앞 인덱스
        ArrayList<Integer> list = new ArrayList<>();    //  배포 별 기능의 개수 배열
        while (!q.isEmpty()){   //  모든 기능이 완료될 때까지
            day++;  //  하루 경과
            int tmp = 0;    //  배포의 기능 개수
            while (idx < speeds.length && q.peek()+speeds[idx]*day > 100){  //  다음 기능이 미완일 때 까지
                q.poll();   //  기능 완료
                idx++;      //  다음 기능의 인덱스로
                tmp++;      //  해당 배포의 기능 개수++
            }
            if(tmp > 0)     //  기능이 한개라도 완료 되었다면
                list.add(tmp);  //  배포 별 기능 개수 배열에 추가
        }

        /* answer으로 옮기기 */
        int[] answer  = new int[list.size()];
        for (int i = 0; i < list.size(); ++i)
            answer[i] = list.get(i);

        return answer;
    }
}
