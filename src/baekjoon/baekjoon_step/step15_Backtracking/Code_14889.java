package baekjoon.baekjoon_step.step15_Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Code_14889 {
    public static int answer = 19001;   //  양팀간의 케미합 차이
    public static boolean[] choice;
    public static int n;
    public static int[][] chemi;
    public static int chemiSum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        choice = new boolean[n];    //  1팀으로 선택된 사람들
        chemi = new int[n][n];
        chemiSum = 0;   //  케미의 전체 합

        /*팀원 i와 j의 케미 입력*/
        for (int i = 0; i < n; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; ++j) {
                chemi[i][j] = Integer.parseInt(st.nextToken());
                chemiSum += chemi[i][j];
            }
        }
        division(0, 0);
        System.out.print(answer);

        br.close();
    }

    private static void division(int start, int deep) {
        /* n/2명의 팀원을 다 골랐다면 각 팀의 전력 비교 */
        if (deep == n / 2) {
            int team1 = 0;
            int team2 = 0;
            for (int i = 0; i < n; ++i) {
                for (int j = i + 1; j < n; ++j) {
                    if (choice[i] && choice[j]) {
                        team1 += chemi[i][j];
                        team1 += chemi[j][i];
                    } else if (!choice[i] && !choice[j]) {
                        team2 += chemi[i][j];
                        team2 += chemi[j][i];
                    }
                }
            }
            /*두 팀의 전력 차이 비교하기*/
            if (Math.abs(team1 - team2) < answer)
                answer = Math.abs(team1 - team2);
            return;
        }

        /* 팀원을 중복되지 않게 한명씩 고르기 */
        for (int i = start; i < n; ++i) {
            choice[i] = true;
            division(i+1,deep + 1);
            choice[i] = false;
        }
    }
}