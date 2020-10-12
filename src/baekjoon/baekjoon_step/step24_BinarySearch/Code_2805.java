package baekjoon.baekjoon_step.step24_BinarySearch;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Code_2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());   //  나무의 그루 수
        int m = Integer.parseInt(st.nextToken());   //  필요한 나무의 길이

        int[] tree = new int[n];    //  나무의 길이 배열
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; ++i)
            tree[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(tree);

        /* M의 나무를 얻을 수 있는 톱날 높이의 최고높이 찾기  */
        int start = 0;
        int end = tree[n - 1];

        while (start <= end) {
            int mid = (start + end) / 2;

            long temp = 0;   //  mid 높이의 톱날로 나무를 잘랐을 때 나오는 나무의 길이 계산
            for (int i = 0; i < n; ++i)
                if (mid < tree[i])
                    temp += tree[i] - mid;

            if(temp >= m)   //  나무가 더 나오거나 딱맞게 나오면 톱날 올리기
                start = mid+1;
            else if(temp < m)   //  나무가 덜 나온다면 톱날 내리기
                end = mid-1;
        }

        bw.write(String.valueOf(end));  // 정답 출력
        bw.flush();
        br.close();
        bw.close();
    }
}