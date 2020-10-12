package baekjoon.baekjoon_step.step24_BinarySearch;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Code_1920 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];


        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            int index = Arrays.binarySearch(arr, Integer.parseInt(st.nextToken()));
            if (index < 0)
                System.out.println("0");
            else
                System.out.println("1");
        }
    }
}
