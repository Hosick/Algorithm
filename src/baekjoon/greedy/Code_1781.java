package baekjoon.greedy;

import java.io.*;
import java.util.*;

/* 숙제 Class */
class Homework implements Comparable<Homework>{
    private int deadline;
    private int reward;

    public Homework(int deadline, int reward){
        this.deadline = deadline;
        this.reward = reward;
    }

    public int getDeadline(){
        return deadline;
    }

    public int getReward(){
        return reward;
    }

    @Override
    public int compareTo(Homework o) {
        return o.reward - this.reward;
    }
}

public class Code_1781 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());        //  숙제의 개수
        ArrayList<Homework> list = new ArrayList<>();   //  숙제를 넣을 ArrayList

        /* list에 숙제 객체를 하나씩 넣고 데드라인 내림차순 정렬*/
        for (int i = 0; i < n; ++i){
            st = new StringTokenizer(br.readLine());
            Homework homework = new Homework(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            list.add(homework);
        }
        Collections.sort(list, (o1, o2) -> o2.getDeadline() - o1.getDeadline());
        br.close();

        PriorityQueue<Homework> pq = new PriorityQueue<>(); //  현재 시간에 해결할 수 있는 숙제를 담을 pq 선언
        int ans = 0;

        /* 늦은 시간부터 하나씩 해결 */
        int idx = 0;
        for (int i = n; i > 0; --i){    //  현재 시간 i (늦은시간 부터)
            /* 데드라인이 현재 시간인 숙제들을 넣기 */
            while (idx < n && list.get(idx).getDeadline() == i){
                pq.offer(list.get(idx++));
            }
            /* i 시간에 할수 있는 최고보상의 숙제를 하기  */
            if (!pq.isEmpty())
                ans += pq.poll().getReward();
        }

        System.out.println(ans);
    }
}