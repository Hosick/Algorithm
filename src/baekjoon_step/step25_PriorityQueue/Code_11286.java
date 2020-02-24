package baekjoon_step.step25_PriorityQueue;

import java.io.*;
import java.util.ArrayList;

public class Code_11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        AbsMinHeap heap = new AbsMinHeap();
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
class AbsMinHeap {
    private ArrayList<Long> heap;

    public AbsMinHeap() {
        heap = new ArrayList<Long>();
        heap.add(0L);   //  힙을 인덱스 1부터 시작하기 위해 절댓값이 최소인 0을 인덱스 0 에 넣고 시작
    }

    public void insert(long n) {
        heap.add(n);    //  heap 마지막 index에 n넣기
        int p = heap.size() - 1;    //  n의 index 저장

        while (Math.abs(heap.get(p)) <= Math.abs(heap.get(p / 2))) {
            if (Math.abs(heap.get(p)) == Math.abs(heap.get(p / 2)) && heap.get(p) >= heap.get(p / 2))  //  절대값이 같지만 부모노드가 더 작거나 같다면 break
                break;

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

        long deleteValue = heap.get(1); //  삭제할 절대값의 최솟값

        heap.set(1, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        int p = 1;

        while (p * 2 < heap.size()) {   //  자식이 없을 때까지
            int smallIdx = p * 2;   //  두 자식 중 절대값이 작은 인덱스를 left 자식의 인덱스로 일단 초기화
            if (p * 2 + 1 < heap.size() && Math.abs(heap.get(smallIdx)) > Math.abs(heap.get(p * 2 + 1)))  //  오른쪽자식의 절대값이 더 작을 때
                smallIdx++;
            else if (p * 2 + 1 < heap.size() && Math.abs(heap.get(smallIdx)) == Math.abs(heap.get(p * 2 + 1)) && heap.get(smallIdx) > heap.get(p * 2 + 1)) // 절대값은 같지만 왼쪽자식의 값이 더 작을 때
                smallIdx++;


            if (Math.abs(heap.get(p)) < Math.abs(heap.get(smallIdx)))   //  자식의 절대값보다 작다면 break
                break;
            else if (Math.abs(heap.get(p)) == Math.abs(heap.get(smallIdx)) && heap.get(p) < heap.get(smallIdx)) // 절대값이 같지만 값이 자식보다 더 작다면
                break;

            long temp = heap.get(p);
            heap.set(p, heap.get(smallIdx));
            heap.set(smallIdx, temp);

            p = smallIdx;
        }
        return deleteValue;
    }
}