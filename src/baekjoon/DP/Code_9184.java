package baekjoon.DP;

import java.io.*;
import java.util.StringTokenizer;

public class Code_9184 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int[][][] dp = new int[21][21][21]; //  최대 인덱스가 dp[20][20][20]인 dp배열 선언
        for (int i = 0; i <= 20; ++i) {
            for (int j = 0; j <= 20; ++j) {
                for (int k = 0; k <= 20; ++k) {
                    if (i == 0 || j == 0 || k == 0) //  i, j, k 중 하나라도 0이면 1
                        dp[i][j][k] = 1;
                    else if (i < j && j < k)        //  i < j < k 일 때
                        dp[i][j][k] = dp[i][j][k - 1] + dp[i][j - 1][k - 1] - dp[i][j - 1][k];
                    else                            //  나머지
                        dp[i][j][k] = dp[i - 1][j][k] + dp[i - 1][j - 1][k] + dp[i - 1][j][k - 1] - dp[i - 1][j - 1][k - 1];
                }
            }
        }


        int a, b, c;
        while (true) {
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            if (a == -1 && b == -1 && c == -1)  //  a=b=c=-1 일 때 루프 종료
                break;

            bw.write("w(" + String.valueOf(a) + ", " + String.valueOf(b) + ", " + String.valueOf(c) + ") = ");
            if (a <= 0 || b <= 0 || c <= 0)    //  a,b,c 중 하나라도 자연수가 아니라면 dp[0][0][0]
                bw.write(String.valueOf(dp[0][0][0]));
            else if (a > 20 || b > 20 || c > 20)     //  a,b,c 중 하나라도 20이 넘는다면 dp[20][20][20]
                bw.write(String.valueOf(dp[20][20][20]));
            else                                    //  a,b,c 모두 1~20 사이라면 dp[a][b][c]
                bw.write(String.valueOf(dp[a][b][c]));
            bw.newLine();
        }

        bw.flush();

        br.close();
        bw.close();
    }
}