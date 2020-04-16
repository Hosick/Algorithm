package programmers.heap;

import java.util.*;

/* 작업 객체 구현 */
class Job implements Comparable<Job> {
    int request;      //  작업 요청 시간
    int time;   //  작업 소요 시간

    public Job(int start, int time) {
        this.request = start;
        this.time = time;
    }

    //걸리는 소요시간이 짧을수록, 시작 시간이 짧을 수록 우선수위를 높게함
    @Override
    public int compareTo(Job j) {
        if (this.time < j.time) return -1;  //  소요시간이 짧아야 우선
        else if (this.time == j.time) {     //  소요시간이 같을 때에는
            if (this.request < j.request) return -1;    //  요청 시간이 빠른게 우선
            else return 1;
        } else return 1;
    }
}

class 디스크컨트롤러 {
    public int solution(int[][] jobs) {
        PriorityQueue<Job> pq = new PriorityQueue<>();
        List<Job> list = new ArrayList<>();

        /* 우선순위 큐를 사용해서 작업을 우선순위 순으로 정렬 */
        for (int i = 0; i < jobs.length; i++) {
            pq.add(new Job(jobs[i][0], jobs[i][1]));
        }

        /* 정렬된 작업을 리스트에 넣기 */
        for (int i = 0; i < jobs.length; i++) {
            list.add(pq.poll());
        }

        int now = 0;   //  현재 시간
        int sum = 0;    //  총 걸린 시간
        while (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                if (now >= list.get(i).request) {       //  현재시간이 요청시간의 이후여야 작업 가능
                    now += list.get(i).time;            //  현재시간에 작업에 소요된 시간 더하기
                    sum += now - list.get(i).request;   //  현재시간에서 작업에 요청받은시간 빼서 sum에 더하기
                    list.remove(i);                     //  리스트에서 작업 삭제
                    break;
                }
                if (i == list.size() - 1) now++;        //  요청 시간이 현재 시간보다 이전인 것이 없다면 시간 1초 증가
            }
        }

        return sum / jobs.length;
    }
}