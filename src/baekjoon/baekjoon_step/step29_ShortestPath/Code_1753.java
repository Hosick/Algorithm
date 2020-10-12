package baekjoon.baekjoon_step.step29_ShortestPath;

import java.io.*;
import java.util.*;

public class Code_1753 {
    static int v, e, start;
    static int[] answer;
    static List<List<Node>> list;

    /* 인접 리스트를 위한 Node class */
    static class Node implements Comparable<Node> {
        int index, distance;

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

        v = Integer.parseInt(st.nextToken());   //  정점의 개수
        e = Integer.parseInt(st.nextToken());   //  간선의 개수
        start = Integer.parseInt(br.readLine());   //  시작하는 정점

        answer = new int[v + 1];  //  최단거리 배열
        Arrays.fill(answer, Integer.MAX_VALUE); //  int 최대값으로 초기화

        /* 노드 배열을 v개 만큼 넣기 */
        list = new ArrayList<List<Node>>();
        for (int i = 0; i <= v; ++i)
            list.add(new ArrayList<Node>());

        /* 간선을 인접리스트에 input */
        for (int i = 0; i < e; ++i) {
            st = new StringTokenizer(br.readLine());
            list.get(Integer.parseInt(st.nextToken())).add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        /* 다익스트라 알고리즘을 이용해서 최소거리구하기 */
        dijkstra(list, answer, start);

        /* answer[i]가 초기값 그대로라면 INF 출력 */
        for (int i = 1; i <= v; ++i) {
            bw.write((answer[i] == Integer.MAX_VALUE) ? "INF" + "\n" : String.valueOf(answer[i]) + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    /* 다익스트라 알고리즘으로 노드 별 최단거리 구하기 */
    private static void dijkstra(List<List<Node>> list, int[] answer, int start) {
        boolean[] visit = new boolean[v + 1];
        PriorityQueue<Node> pq = new PriorityQueue<Node>();

        answer[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            int now = pq.poll().index;

            if (visit[now]) continue;
            visit[now] = true;

            for (Node node : list.get(now)) {
                if (answer[node.index] > answer[now] + node.distance){
                    answer[node.index] = answer[now] + node.distance;
                    pq.add(new Node(node.index, answer[node.index]));
                }
            }
        }
    }
}
