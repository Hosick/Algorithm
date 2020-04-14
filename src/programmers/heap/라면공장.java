package programmers.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

class 라면공장 {
    public int solution(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());  //  우선순위 큐 (최대) 선언

        int idx = 0;
        for (int i = 1; i < k; ++i) {
            --stock;    //  1톤 소모

            if (idx < dates.length && dates[idx] == i)   //  해외 공급 날짜라면
                q.add(supplies[idx++]);                 //  q에 넣기

            if (stock == 0) {                             //  재고가 바닥났다면
                stock += q.poll();                      //  공급받을 수 있던 양 중 가장 많은 양 공급
                answer++;                               //  공급받은 수++
            }
        }
        return answer;
    }
}