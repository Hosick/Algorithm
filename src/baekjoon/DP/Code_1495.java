package baekjoon.DP;

import java.util.Scanner;

public class Code_1495 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();    //  곡의 개수
        int s = input.nextInt();    //  시작 볼륨
        int m = input.nextInt();    //  최대 볼륨

        int[] v = new int[n + 1];   //  i번째 곡을 시작하기전 조정해야하는 볼륨
        for (int i = 1; i <= n; ++i)
            v[i] = input.nextInt();

        int dp[][] = new int[n + 1][m + 1]; //  [i번째 노래][연주 가능한 볼륨]
        dp[0][s] = 1;

        for (int i = 1; i <= n; ++i) {
            for (int j = 0; j <= m; ++j) {
                if (dp[i - 1][j] != 0) {            //  이전 음악의 연주가 가능한 볼륨을 찾고
                    if (j + v[i] <= m)          //  이전 음악 + v[i]가 m을 넘지 않는다면
                        dp[i][j + v[i]] = 1;    //  볼륨 키우기
                    if (j - v[i] >= 0)          //  이전 음악 - v[i]가 0보다 작지 않다면
                        dp[i][j - v[i]] = 1;    //  볼륨 줄이기
                }
            }
        }

        for (int i = m; i >= 0; --i) {           //  n번째 음악의 최대볼륨 찾기
            if (dp[n][i] != 0) {
                System.out.print(i);
                return;
            }
        }
        System.out.println(-1);                 //  못찾았다면 -1 출력
    }
}