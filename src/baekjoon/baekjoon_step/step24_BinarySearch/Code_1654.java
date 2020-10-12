package baekjoon.baekjoon_step.step24_BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Code_1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());   //  이미 가지고 있던 랜선의 갯수
        int n = Integer.parseInt(st.nextToken());   //  필요한 랜선의 갯수

        /* 가지고 있던 랜선 길이 입력 */
        long[] line = new long[k];
        for (int i = 0; i < k; ++i) {
            line[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(line);

        /* 이분 탐색으로 n개의 랜선 최대길이 찾기 */
        long start = 1;
        long end = line[k-1];

        while (start <= end) {
            long mid = (start + end) / 2;
            long lineAmount = calc(line, mid);

            /* mid로 잘랐을 때 전선이 n개거나 n개보다 더 나올 때 */
            if (lineAmount >= n)
                start = mid + 1;
            /* mid로 잘랐을 때 전선이 n개 보다 덜 나올 때 */
            else if (lineAmount < n)
                end = mid - 1;
        }
        System.out.print(end);
    }

    /* 랜선 들을 num 의 길이로 잘랐을 때 몇개의 랜선이 나오는지  */
    private static long calc(long[] line, long length) {
        long sum = 0;
        for (int i = 0; i < line.length; ++i)
            sum += (line[i] / length);
        return sum;
    }
}
