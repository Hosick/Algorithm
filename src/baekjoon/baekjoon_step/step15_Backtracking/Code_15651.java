package baekjoon.baekjoon_step.step15_Backtracking;

import java.io.*;
import java.util.StringTokenizer;

public class Code_15651 {
    private static int[] num = new int[10];   //  0-9까지
    private static boolean[] visit = new boolean[10];   //
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());    //  최대 값
        int m = Integer.parseInt(st.nextToken());    //  한 줄당 출력할 수

        printSeq(0, n, m);  //  출력
        bw.flush();

        br.close();
        bw.close();
    }

    /*수열 출력 함수 정의*/
    private static void printSeq(int index, int n, int m) throws IOException {
        if (index == m) {   //  m(한 줄 당 출력할 수)가 (배열에) 다 채워졌다면
            for (int i = 0; i < m; ++i)    //  배열 전부 출력 후 리턴
                bw.write(Integer.toString(num[i]) + " ");
            bw.newLine();
            return;
        }
        for (int i = 1; i <= n; ++i) {  //  1~n(최댓값)까지
            num[index] = i;   //  배열의 index번 째 수는 i
            printSeq(index + 1, n, m);  //  배열 다음 원소 구하는 재귀
        }
    }
}
