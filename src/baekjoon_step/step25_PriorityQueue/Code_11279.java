package baekjoon_step.step25_PriorityQueue;

import java.io.*;
import java.util.ArrayList;

public class Code_11279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        MaxHeap heap = new MaxHeap();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; ++i) {
            String command = br.readLine();

            if (command.equals("0")) {
                bw.write(String.valueOf(heap.delete()));
                bw.newLine();
            } else
                heap.insert(Long.parseLong(command));
        }

        bw.flush();
        br.close();
        bw.close();
    }
}

/* 최대 힙 구현 */
class MaxHeap {
    private ArrayList<Long> heap;


    public MaxHeap() {
        heap = new ArrayList<Long>();
        heap.add(Long.MAX_VALUE);    //  heap 을 1부터 시작하기 위해 index 0에 int 최대값 넣기
    }

    /* 힙에 n을 add */
    public void insert(long n) {
        heap.add(n);
        int p = heap.size() - 1;

        /* n을 넣고 자기 부모보다 크지 않을 때까지 swap  */
        while (heap.get(p / 2) < heap.get(p)) {
            long temp = heap.get(p / 2);
            heap.set(p / 2, heap.get(p));
            heap.set(p, temp);

            p = p / 2;
        }
    }

    /* 힙에서 최대값을 삭제 후 return */
    public long delete() {
        /* 만약 힙이 비어있다면 0을 return */
        if (heap.size() - 1 < 1)
            return 0;

        long deleteValue = heap.get(1); //  삭제한 최대 값

        heap.set(1, heap.get(heap.size() - 1));   //  마지막 노드를 index 1 에 넣고
        heap.remove(heap.size() - 1);      //  마지막 노드 삭제
        int p = 1;

        /* 루트로 올린 값을 두 자식중 최대값과 바꿈 */
        /* 리프이거나 두 자식이 자신보다 작을 때까지 */
        while (p * 2 < heap.size()) {
            int bigIdx = p * 2;    //  두 자식 중 큰 값의 인덱스를 left 자식의 인덱스로 일단 초기화
            if (p * 2 + 1 < heap.size() && heap.get(bigIdx) < heap.get(p * 2 + 1)) //  right 자식이 존재하고 left 보다 클 때
                bigIdx++;                                                          //  left 자식의 인덱스로 변경

            if(heap.get(p) > heap.get(bigIdx))
                break;

            long temp = heap.get(p);
            heap.set(p, heap.get(bigIdx));
            heap.set(bigIdx, temp);
            p = bigIdx;
        }
        return deleteValue;
    }
}