package baekjoon_step.step29_ShortestPath;

import java.io.*;
import java.util.*;

public class Code_1504 {
    static int n, e;

    static boolean[] visit;
    static int[] dist;
    static List<List<Node>> list;

    static class Node implements Comparable<Node> {
        int index;
        int distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        public int compareTo(Node n) {
            return this.distance - n.distance;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());   //  정점의 개수
        int e = Integer.parseInt(st.nextToken());   //  간선의 개수

        /* 노드 배열을 v개 만큼 넣기 */
        list = new ArrayList<List<Node>>();
        for (int i = 0; i <= n; ++i)
            list.add(new ArrayList<Node>());

        visit = new boolean[n + 1];
        dist = new int[n + 1];

        /* 간선을 인접리스트에 input */
        for (int i = 0; i < e; ++i) {
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list.get(f).add(new Node(l, v));
            list.get(l).add(new Node(f, v));
        }

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        long answer1 = d(1, a, b, n);   //  1 -> A -> B -> N
        long answer2 = d(1, b, a, n);   //  1 -> B -> A -> N

        bw.write(String.valueOf(answer1 > answer2 ? answer2 : answer1));
        bw.flush();
        br.close();
        bw.close();
    }

    /* 다익스트라 함수를 3번 돌려 중간점 두개를 순서대로 탐색하는 함수 */
    private static long d(int i, int a, int b, int n) {
        long n1 = dijkstra(1, a);
        long n2 = dijkstra(a, b);
        long n3 = dijkstra(b, n);

        return (n1 == Integer.MAX_VALUE || n2 == Integer.MAX_VALUE || n3 == Integer.MAX_VALUE) ? -1 : (n1 + n2 + n3);
    }


    private static long dijkstra(int start, int end) {
        Arrays.fill(dist, Integer.MAX_VALUE);   //  정답 배열 최대값으로 채우기
        Arrays.fill(visit, false);

        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        pq.add(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            int now = pq.poll().index;
            if (visit[now] == true)
                continue;
            visit[now] = true;

            for (Node n : list.get(now)) {
                if (dist[n.index] > dist[now] + n.distance) {
                    dist[n.index] = dist[now] + n.distance;
                    pq.add(new Node(n.index, dist[n.index]));
                }
            }
        }
        return dist[end];
    }
}
