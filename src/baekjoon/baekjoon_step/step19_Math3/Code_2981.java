package baekjoon.baekjoon_step.step19_Math3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Code_2981 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        /* 종이에 숫자 적기 */
        int[] arr = new int[n];
        for (int i = 0; i < n; ++i)
            arr[i] = Integer.parseInt(br.readLine());
        Arrays.sort(arr);

        /* 인접한 값들의 차 간의 최대공약수 구하기 */
        int gcd = arr[1] - arr[0];
        for (int i = 2; i < n; ++i) {
            int difference = arr[i] - arr[i - 1];
            gcd = getGcd(gcd, difference);
        }

        /* 구한 최대공약수의 약수들을 출력 */
        getCd(gcd);

        br.close();
    }

    /* 두 수의 최대 공약수 구하는 함수 */
    private static int getGcd(int i, int j) {
        while (j > 0) {
            int temp = i;
            i = j;
            j = temp % j;
        }
        return i;
    }

    /* 약수를 오름차순으로 출력하는 함수 */
    private static void getCd(int gcd) {
        for (int i = 2; i <= gcd; ++i)
            if(gcd%i == 0) System.out.print(i+" ");
    }
}