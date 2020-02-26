package baekjoon_step.step25_PriorityQueue;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

public class Code_1655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /* 최대힙과 최소힙 한개 씩 선언 */
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());    //  최대 힙
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();  //  최소 힙

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; ++i) {
            int num  =  Integer.parseInt(br.readLine());

            /* 최대힙의 크기가 1크거나 최소힙과 같도록 숫자를 넣기 */
            if(maxHeap.size()==minHeap.size())
                maxHeap.offer(num);
            else if(maxHeap.size() > minHeap.size())
                minHeap.offer(num);
            /* 최대힙의 루트가 최소힙의 루트보다 작도록 유지 */
            if (minHeap.size()!=0 && maxHeap.peek() > minHeap.peek()){
                int temp = maxHeap.poll();
                maxHeap.offer(minHeap.poll());
                minHeap.offer(temp);
            }

            /* 최대힙의 루트 출력 */
            bw.write(String.valueOf(maxHeap.peek()));
            bw.newLine();
        }

        bw.flush();
        br.close();
        bw.close();
    }
}