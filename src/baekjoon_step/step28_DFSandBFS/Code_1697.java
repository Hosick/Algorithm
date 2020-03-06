package baekjoon_step.step28_DFSandBFS;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Code_1697 {
    static int[] move;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        move = new int[100002];

        bw.write(String.valueOf(bfs(n, k)));
        bw.flush();
        br.close();
        bw.close();
    }

    private static int bfs(int n, int k) {
        Queue<Integer> q = new LinkedList<Integer>();
        move[n] = 0;
        q.offer(n);

        if (k == n)
            return 0;

        while (!q.isEmpty()) {
            int temp = q.poll();

            /* 앞으로 한 칸 이동 */
            if (temp + 1 < 100002 && move[temp + 1] == 0) {
                move[temp + 1] = move[temp] + 1;
                if (temp + 1 == k) return move[temp + 1];
                q.offer(temp + 1);
            }

            /* 뒤로 한 칸 이동 */
            if (temp - 1 >= 0 && move[temp - 1] == 0) {
                move[temp - 1] = move[temp] + 1;
                if (temp - 1 == k) return move[temp - 1];
                q.offer(temp - 1);
            }

            /* 순간 이동 */
            if (temp * 2 < 100002 && move[temp * 2] == 0) {
                move[temp * 2] = move[temp] + 1;
                if (temp * 2 == k) return move[temp * 2];
                q.offer(temp * 2);
            }
        }
        return -1;
    }
}
