package baekjoon.baekjoon_step.step25_PriorityQueue;

import java.io.*;
import java.util.ArrayList;

public class Code_1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        MinHeap heap = new MinHeap();
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

/* 최소 힙 구현 */
class MinHeap {
    private ArrayList<Long> heap;

    public MinHeap() {
        heap = new ArrayList<Long>();
        heap.add(Long.MIN_VALUE);
    }

    public void insert(long n) {
        heap.add(n);
        int p = heap.size() - 1;

        while (heap.get(p) < heap.get(p / 2)) {
            long temp = heap.get(p / 2);
            heap.set(p / 2, n);
            heap.set(p, temp);

            p = p / 2;
        }
    }

    public long delete() {
        /* 만약 힙이 비어있다면 0을 return */
        if (heap.size() - 1 < 1)
            return 0;

        long deleteValue = heap.get(1);

        heap.set(1, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        int p = 1;

        while (p * 2 < heap.size()) {
            int smallIdx = p * 2;
            if (p * 2 + 1 < heap.size() && heap.get(smallIdx) > heap.get(p * 2 + 1))
                smallIdx++;

            if (heap.get(p) < heap.get(smallIdx))
                break;

            long temp = heap.get(p);
            heap.set(p, heap.get(smallIdx));
            heap.set(smallIdx, temp);

            p = smallIdx;
        }
        return deleteValue;
    }
}
