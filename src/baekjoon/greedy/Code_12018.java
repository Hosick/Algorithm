package baekjoon.greedy;

import java.io.*;
import java.util.*;

public class Code_12018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());   //  과목 수
        int m = Integer.parseInt(st.nextToken());   //  마일리지 양
        int[] needs = new int[n];                    //  과목 별 필요한 최소 마일리지 배열

        /* 과목 별 정보 입력 */
        for (int i = 0; i < n; ++i) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());   //  과목 신청자 수
            int l = Integer.parseInt(st.nextToken());   //  과목 수강인원 수

            /* 신청자 수가 수강인원보다 적다면 최소한의 마일리지인 1만 사용 */
            if (p < l) {
                needs[i] = 1;
                br.readLine();  //  @@ 여기때문에 한참 헤멨음 입력하지않고 넘어간다면 한줄은 skip 해줘야함
                continue;
            }

            /* 신청자들의 마일리지 입력 및 정렬*/
            int[] applicant = new int[p];   //  신청자 배열
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < p; ++j)
                applicant[j] = Integer.parseInt(st.nextToken());
            Arrays.sort(applicant);

            /* 인원제한의 마지막 신청자의 마일리지를 따라하면 수강 가능 */
            needs[i] = applicant[p - l];
        }
        br.close();

        /* 적은 마일리지를 요하는 수업을 하나씩 넣어서 몇개까지 들을 수 있는지 구하기 */
        Arrays.sort(needs);

        int ans = 0;
        for (int i : needs){
            if (m >= i){
                m -= i;
                ans++;
            }
            else break;
        }

        System.out.println(ans);
    }
}
