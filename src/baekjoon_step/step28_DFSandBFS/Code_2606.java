package baekjoon_step.step28_DFSandBFS;

import java.io.*;
import java.util.StringTokenizer;

public class Code_2606 {
    static boolean[][] line;
    static boolean[] visited;
    static int count = -1;
    static int com;
    static int net;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        com = Integer.parseInt(br.readLine());
        net = Integer.parseInt(br.readLine());
        line = new boolean[com + 1][com + 1];
        visited = new boolean[com + 1];
        for (int i = 0; i < net; ++i) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            line[a][b] = true;
            line[b][a] = true;
        }

        dfs(1);

        bw.write(String.valueOf(count));
        bw.flush();
        br.close();
        bw.close();
    }



    private static void dfs(int i) {
        ++count;
        visited[i] = true;
        for (int j = 1; j <= com; ++j) {
            if (!visited[j] && line[i][j])
                dfs(j);
        }
    }
}