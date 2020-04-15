package programmers.heap;

import java.util.PriorityQueue;

class 디스크컨트롤러 {
    public int solution(int[][] jobs) {
        int sum = 0;    //  대기 시간

        PriorityQueue<Integer> q = new PriorityQueue(); //  작업을 넣어 둘 우선순위 큐 선언

        int idx = 0;    //  다음 작업의 인덱스
        int ing = 0;    //  실행중인 작업의 남은 시간
        for (int i = 0; true; ++i) {
            if (idx < jobs.length && jobs[idx][0] == i) //  작업을 요청받았다면 우선순위 큐에 넣기
                q.add(jobs[idx++][1]);
            sum += q.size();    //  대기중인 시간 더하기

            if (ing > 0) {  //  실행중인 작업이 있을 때
                ing--;      //  시간이 흐름
                sum++;      //  실행중인 시간 더하기
            }
            else{   //  실행중인 작업이 없을 때
                if(!q.isEmpty()){   //  대기중인 작업이 있을 때
                    ing = q.poll() - 1;
                }
                else{   //  대기중인 작업이 없을 때
                    if(idx < jobs.length)   //  들어올 작업이 남아 있을 때
                        continue;
                    else    //  들어올 작업 또한 없을 때
                        break;
                }
            }
        }
        return sum/jobs.length;
    }
}