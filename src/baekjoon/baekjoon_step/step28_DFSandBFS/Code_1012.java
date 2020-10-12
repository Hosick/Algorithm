package baekjoon.baekjoon_step.step28_DFSandBFS;

import java.io.*;
import java.util.StringTokenizer;

public class Code_1012 {
    static int[][] farm;
    static int count;
    static final int[] am = {-1, 1, 0, 0};
    static final int[] bm = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());    //  테스트 케이스 개수
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());

            int m = Integer.parseInt(st.nextToken());   //  밭의 가로 길이
            int n = Integer.parseInt(st.nextToken());   //  밭의 세로 길이
            int k = Integer.parseInt(st.nextToken());   //  배추의 개수
            farm = new int[m + 2][n + 2];               //  가로세로 길이의 양쪽의 공백을 더한 농장배열 생성
            count = 0;

            /* 배추위치 입력(좌측과 상측에 공백을 만들었기때문에 +1 */
            for (int i = 0; i < k; ++i) {
                st = new StringTokenizer(br.readLine());
                farm[Integer.parseInt(st.nextToken()) + 1][Integer.parseInt(st.nextToken()) + 1] = 1;
            }

            /* dfs 를 이용해 배추 군집의 개수 찾기  */
            for (int i = 1; i <= m; ++i) {
                for (int j = 1; j <= n; ++j) {
                    if (farm[i][j] == 1) {
                        dfs(i, j);
                        ++count;
                    }
                }
            }
            bw.write(String.valueOf(count) + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }

    private static void dfs(int a, int b) {
        farm[a][b] = 0;

        for (int i = 0; i < 4; ++i) {   //  am, bm 배열을 이용한 좌우하상 탐색
            if (farm[a + am[i]][b + bm[i]] == 1)
                dfs(a + am[i], b + bm[i]);
        }
    }
}
