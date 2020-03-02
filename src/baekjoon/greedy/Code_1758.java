package baekjoon.greedy;

import java.io.*;
import java.util.Arrays;

public class Code_1758 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] tip = new int[n];
        for (int i = 0; i< n; ++i)
            tip[i] = Integer.parseInt(br.readLine());

        Arrays.sort(tip);

        long sum = 0;
        int order = 0;  //  팁에서 뺄 금액
        for (int i = n-1; i >= 0; --i){
            tip[i] -= order++;  //  팁에서 금액빼기 (1씩 증가)
            sum += tip[i]>0? tip[i] : 0;    //  음수가 아니라면 합계에 더하기
        }

        bw.write(String.valueOf(sum));
        bw.flush();
        br.close();
        bw.close();
    }
}
