package baekjoon.greedy;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Code_1946 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());    //  테스트 횟수
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());    //  지원자의 수

            /* 지원자들의 1, 2차 점수 입력 */
            int[] applicant = new int[n+1];
            for (int i = 0; i < n; ++i) {
                st = new StringTokenizer(br.readLine());
                applicant[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
            }

            int pass = n;   //  합격 가능자
            int pivot = applicant[1];   //  초기 값을 1차 1등의 2차 등수로 정함
            for (int i = 2; i <= n; ++i){
                if(applicant[i] > pivot)    //
                    --pass;
                else
                    pivot = applicant[i];
            }

            bw.write(String.valueOf(pass));
            bw.newLine();
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
