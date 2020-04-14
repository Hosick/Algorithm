/* 최소 힙으로 풀 수 있는 문제다 */
/* priority queue로 간단하게 풀 수 있지만 */
/* 최소 힙을 구현해서 풀었다. */

package programmers.heap;

import java.util.ArrayList;

class 더맵게 {
    /* 최소 힙 구현 */
    class MinHeap {
        private ArrayList<Integer> heap;

        /* 생성자 */
        public MinHeap() {
            heap = new ArrayList<>();
            heap.add(0);    //  인덱스 0을 채우기
        }

        /* 삽입 함수 구현 */
        public void insert(int v) {
            heap.add(v);
            int idx = heap.size() - 1;  //  현재 인덱스

            while (idx > 1 && heap.get(idx / 2) > heap.get(idx)) {  //  인덱스가 1보다 작아야하며, 부모의 값보다 클 때
                int temp = heap.get(idx);
                heap.set(idx, heap.get(idx / 2));
                heap.set(idx / 2, temp);

                idx = idx / 2;
            }
        }

        /* 삭제 함수 구현 */
        public int delete() {
            if (heap.size() <= 1)
                return 0;

            int value = heap.get(1);

            heap.set(1, heap.get(heap.size() - 1));   //  root값을 마지막 값과 바꾸고
            heap.remove(heap.size() - 1);      //  마지막 값 삭제

            int idx = 1;    //현재 인덱스
            while ((idx * 2) < heap.size()) {  //      자식이 없을 때 까지
                /* 왼쪽 자식 */
                int min = heap.get(idx * 2);
                int minIdx = idx * 2;
                /* 오른쪽 자식이 있다면 오른쪽 자식 */
                if (minIdx + 1 < heap.size() && min > heap.get(minIdx + 1)) {
                    min = heap.get(idx * 2 + 1);
                    minIdx++;
                }

                if (heap.get(idx) < min) //  이미 자식보다 작다면 break
                    break;

                /* swap */
                int temp = heap.get(idx);
                heap.set(idx, min);
                heap.set(minIdx, temp);
                idx = minIdx;
            }
            return value;   //  삭제한 값 return;
        }

        public int min() {
            return heap.size() > 1 ? heap.get(1) : -1;
        }

        public int size() {
            return heap.size() - 1;
        }
    }

    public int solution(int[] scoville, int K) {
        int answer = 0;

        MinHeap heap = new MinHeap();

        for (int i : scoville)
            heap.insert(i);

        while (heap.min() < K) {
            if (heap. size() < 2)
                return -1;

            int min1 = heap.delete();
            int min2 = heap.delete();
            heap.insert(min1 + (min2 * 2));

            answer++;
        }
        return answer;
    }
}