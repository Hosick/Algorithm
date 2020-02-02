package baekjoon_step.step15_Backtracking;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Code_15652 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int n;
    static int m;
    private static int[] num = new int[10];   //  0-9까지

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());   //  최대값
        m = Integer.parseInt(st.nextToken());   //  라인 당 숫자 갯수

        printSeq();

        bw.flush();
        br.close();
        bw.close();
    }

    private static void printSeq() throws IOException {
        printSeq(0);
    }

    private static void printSeq(int index) throws IOException {
        if (index == m) {
            int[] temp = Arrays.copyOf(num, m); //  temp 배열에 num 배열복사(m까지만)
            int[] temp2 = Arrays.copyOf(num, m); //  temp 2배열에도 num 배열복사(m까지만)
            Arrays.sort(temp);  //  temp 만정렬

            if (Arrays.equals(temp, temp2)) { //  num 배열이 오른 차순으로 정렬되었을때만 출력
                for (int i = 0; i < m; ++i)    //  수열 한 줄 write 후 리턴
                    bw.write(Integer.toString(num[i]) + " ");
                bw.newLine();
            }
            return;
        }
        for (int i = 1; i <= n; ++i) {
            num[index] = i;   //  배열의 index번 째 수는 i
            printSeq(index + 1);  //  배열 다음 원소 구하는 재귀
        }
    }
}
