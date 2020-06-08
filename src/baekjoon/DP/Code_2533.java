package baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Code_2533 {
    static int n;                       //  총 노드의 수
    static boolean[] visit;             //  노드의 방문 체크 함수
    static LinkedList<Integer>[] lists; //  친구의 list 배열
    static int[][] dp;                  //  dp 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        visit = new boolean[n + 1];
        lists = new LinkedList[n + 1];
        dp = new int[n + 1][2];         //  자신이 얼리어답터일 때 or 자신이 얼리어답터가 아닐 때

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
        System.out.println(Math.min(dp[1][0], dp[1][1]));   //  두가지 케이스 중 최소값
    }

    /* dfs를 이용해서 필요한 얼리어답터 수 계산하는 함수 */
    static void dfs(int idx) {
        visit[idx] = true;
        dp[idx][0] = 0;
        dp[idx][1] = 1;

        LinkedList<Integer> item = lists[idx];

        for (int i : item) {
            if (!visit[i]) {
                dfs(i);
                dp[idx][0] += dp[i][1];     //  자신이 얼리어답터가 아니라면 모든 친구가 얼리어답터 이여야 함
                dp[idx][1] += Math.min(dp[i][0], dp[i][1]); //  자신이 얼리어답터라면 친구는 얼리어답터일 수 있고 아닐 수 있음
            }
        }
    }
}