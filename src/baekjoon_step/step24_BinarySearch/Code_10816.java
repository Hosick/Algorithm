package baekjoon_step.step24_BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Code_10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        /* n개의 카드 입력 후 정렬*/
        int n = Integer.parseInt(br.readLine());
        int[] card = new int[n];
        st = new StringTokenizer(br.readLine());
        /* 카드의 갯수 해쉬맵에 넣기 */
        for (int i = 0; i < n; ++i) {
            card[i] = Integer.parseInt(st.nextToken());
            if (map.containsKey(card[i]))
                map.put(card[i], map.get(card[i]) + 1);
            else
                map.put(card[i], 1);

        }
        Arrays.sort(card);

        /* 카드 배열에서 상근이의 카드 갯수찾기(이분 탐색) */
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; ++i) {
            int num = Integer.parseInt(st.nextToken());
            int count = 0;
            int start = 0;
            int end = n - 1;

            while (start <= end) {
                int mid = (start + end) / 2;

                /* 찾는 카드가 mid보다 작을 때 */
                if (num < card[mid])
                    end = mid - 1;
                    /* 찾는 카드가 mid보다 클 때 */
                else if (num > card[mid])
                    start = mid + 1;
                    /* 찾는 카드가 mid 라면 앞 뒤 탐색해서 갯수찾기 */
                else {
                    count = map.get(num);
                    break;
                }
            }
            System.out.print(count + " ");
        }
    }
}
