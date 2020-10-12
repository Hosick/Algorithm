package baekjoon.baekjoon_step.step19_Math3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Code_9375 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());

        for (int i = 0; i < t; ++i) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());   //  의상의 갯수
            HashMap<String, Integer> map = new HashMap<String, Integer>();

            /* n개의 의상 카테고리 입력받기 */
            for (int j = 0; j < n; ++j) {
                st = new StringTokenizer(br.readLine());
                st.nextToken();
                String cloth = st.nextToken();

                if (map.containsKey(cloth)) //  이미 같은 카테고리가 있다면 +1 put
                    map.put(cloth, map.get(cloth) + 1);
                else                        //  같은 카테고리가 없다면 새로 put
                    map.put(cloth, 1);
            }

            /* map에서 value 꺼내서 답 구하기 */
            int answer = 1;
            for (int k : map.values()) {
                answer *= (k+1);
            }
            System.out.println(answer - 1);
        }
    }
}