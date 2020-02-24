package baekjoon_step.step24_BinarySearch;

import java.io.*;
import java.util.StringTokenizer;

public class Code_12015 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];

        arr[0] = Integer.parseInt(st.nextToken());
        int size = 1;
        for (int i = 1; i < n; ++i) {
            int temp = Integer.parseInt(st.nextToken());    //  배열에 수를 넣기 전에 임시로 저장
            /* 배열에서 가장 큰값보다 크다면 그 뒤에 넣기 */
            if (temp > arr[size - 1])
                arr[size++] = temp;
                /* 아니라면 그 이전의 인덱스 중 적절한 곳은 이분 탐색으로 찾아서 대체 해야한다 */
            else {
                int start = 0;
                int end = size;
                int mid = 0;
                while (start < end) {
                    mid = (start + end) / 2;
                    if (arr[mid] < temp)
                        start = mid + 1;
                    else if (arr[mid] >= temp)
                        end = mid;
                }
                arr[end] = temp;
            }
        }
        bw.write(String.valueOf(size));
        bw.flush();
        br.close();
        bw.close();
    }
}
