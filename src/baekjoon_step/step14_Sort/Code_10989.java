package baekjoon_step.step14_Sort;

import java.io.*;

public class Code_10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] num = new int[10001];

        for (int i = 0; i < n; ++i)
            ++num[Integer.parseInt(br.readLine())];

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /*카운팅 정렬*/
        for (int i = 1; i < 10001; ++i) {
            if (num[i] > 0)    //  숫자 i가 하나도 없으면 pass
                for (int j = 0; j < num[i]; ++j)
                    bw.write(Integer.toString(i) + "\n");
        }
        br.close();
        bw.close();
    }
}
