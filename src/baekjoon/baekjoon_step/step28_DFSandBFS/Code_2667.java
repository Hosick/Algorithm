package baekjoon.baekjoon_step.step28_DFSandBFS;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Code_2667 {
    static int n;
    static int[][] map;
    static int count = 0;
    static ArrayList<Integer> complex = new ArrayList<Integer>();
    static int[] am = {-1, 1, 0, 0};
    static int[] bm = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /* 지도의 크기와 지도 입력 */
        int n = Integer.parseInt(br.readLine());
        map = new int[n + 2][n + 2];
        for (int i = 1; i <= n; ++i) {
            String st = br.readLine();
            for (int j = 1; j <= n; ++j) {
                map[i][j] = st.charAt(j - 1) - '0';
            }
        }

        /* DFS 로 단지찾기 */
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (map[i][j] == 1) {
                    count = 0;
                    dfs(i, j);
                    complex.add(count);
                }
            }
        }

        /* 단지 배열 출력 */
        bw.write(String.valueOf(complex.size())+"\n");
        Collections.sort(complex);
        for (int i : complex)
            bw.write(String.valueOf(i)+"\n");
        bw.flush();

        br.close();
        bw.close();
    }

    private static void dfs(int a, int b) {
        map[a][b] = -1;
        ++count;

        for (int i = 0; i < 4; ++i) {
            if (map[a + am[i]][b + bm[i]] == 1)
                dfs(a + am[i], b + bm[i]);
        }
    }
}
