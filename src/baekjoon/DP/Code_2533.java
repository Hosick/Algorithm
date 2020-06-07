package baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Code_2533 {
    static int n;
    static boolean[] visit;
    static LinkedList<Integer>[] lists;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        visit = new boolean[n + 1];
        lists = new LinkedList[n + 1];
        dp = new int[n + 1][2];

        for (int i = 1; i <= n; ++i)
            lists[i] = new LinkedList<>();

        for (int i = 1; i < n; ++i) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            lists[a].add(b);
            lists[b].add(a);
        }

        dfs(1);
        System.out.println(Math.min(dp[1][0], dp[1][1]));

    }

    static void dfs(int idx) {
        visit[idx] = true;
        dp[idx][0] = 0;
        dp[idx][1] = 1;

        LinkedList<Integer> item = lists[idx];

        for (int i : item) {
            if (!visit[i]) {
                dfs(i);
                dp[idx][0] += dp[i][1];
                dp[idx][1] += Math.min(dp[i][0], dp[i][1]);
            }
        }
    }
}
