package baekjoon.greedy;

import java.io.*;
import java.util.*;

public class Code_1911 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());    //  웅덩이의 개수
        int l = Integer.parseInt(st.nextToken());    //  널빤지의 길이

        int[][] pool = new int[n][2];   //  웅덩이 배열(시작과 끝)

        /* 웅덩이 입력 및 정렬 */
        for (int i = 0; i < n; ++i) {
            st = new StringTokenizer(br.readLine());
            pool[i][0] = Integer.parseInt(st.nextToken());  //  웅덩이의 시작
            pool[i][1] = Integer.parseInt(st.nextToken());  //  웅덩이의 끝
        }
        Arrays.sort(pool, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int ans = 0;    //  필요한 널빤지 개수의 총합
        int now = 1;    //  나의 현재위치
        for (int i = 0; i < n; ++i) {
            if (now >= pool[i][1])                                       //  현재 위치가 i번째 웅덩이를 넘었다면 패스
                continue;
            if (now < pool[i][0])                                        //  현재 위치가 i번째 웅덩이의 이전이라면 웅덩이 시작으로 이동
                now = pool[i][0];
            int size = pool[i][1] - now;                                 //  현재 웅덩이의 남은 사이즈
            int needs = (size % l == 0) ? (size / l) : (size / l) + 1;   //  필요한 널빤지의 개수
            now += (l * needs);                                          //  널빤지가 끝나는 곳으로 이동
            ans += needs;
        }

        System.out.println(ans);
    }
}
