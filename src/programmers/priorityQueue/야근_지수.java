package programmers.priorityQueue;

import java.util.*;

import static java.util.stream.Collectors.summingLong;
import static java.util.stream.Collectors.toList;

class 야근_지수 {
    public long solution(int n, int[] works) {
        // 우선 순위 큐 생성 후 works 를 모두 넣기
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        heap.addAll(Arrays.stream(works).boxed().collect(toList()));

        // 작업량이 높은 순으로 1씩 해결
        for (int i = 0; i < n; ++i)
            heap.offer(heap.poll() - 1);

        // 남은 작업량이 0보다 큰 작업들의 제곱을 합해서 반환
        return heap.stream().filter(i -> i > 0).collect(summingLong(i -> i * i));
    }
}
