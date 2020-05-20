package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Code_1202 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());    //  보석의 개수
        int k = Integer.parseInt(st.nextToken());    //  가방의 개수

        /* 보석 무게, 가치 입력 */
        Jewelry[] jewelries = new Jewelry[n];    //  n개의 보석 배열
        for (int i = 0; i < n; ++i) {
            st = new StringTokenizer(br.readLine());
            jewelries[i] = new Jewelry(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        /* 가방 최대 무게 입력 */
        int[] bag = new int[k];
        for (int i = 0; i < k; ++i)
            bag[i] = Integer.parseInt(br.readLine());

        /* 가방 오름차순, 보석 무게 오름차순 정렬 */
        Arrays.sort(bag);
        Arrays.sort(jewelries);

        /* 훔칠 수 있는 최대값 구하기 */
        long sum = 0;    //  훔친 보석 가치합
        int idx = 0;     //  무게 오름차순으로 정렬된 보석배열 인덱스
        PriorityQueue<Integer> pq = new PriorityQueue<>();  //  가치만 담는 pq
        for (int i = 0; i < k; ++i) {        //  가장 작은 가방부터
            /* 인덱스가 보석 개수를 넘지 않으며, 가방 최대무게보다 작을 때까지 보석 담기 */
            while (idx < n && jewelries[idx].m <= bag[i]) {
                pq.add(jewelries[idx++].v * (-1));  //  담을 때는 내림차순으로 만들기 위해 -1을 곱한 후 넣는다
            }
            if (!pq.isEmpty())                      //  담을 수 있는게 없지않다면 최대가치 담기
                sum += Math.abs(pq.poll());
        }

        System.out.println(sum);
        br.close();
    }
}

/* 보석 클래스 */
class Jewelry implements Comparable<Jewelry> {
    int m;  //  무게
    int v;  //  가치

    public Jewelry(int m, int v) {
        this.m = m;
        this.v = v;
    }

    /* max heap을 사용하기 위한 compareTo 함수 */
    @Override
    public int compareTo(Jewelry o) {
        return m - o.m;
    }
}
