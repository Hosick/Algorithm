package baekjoon_step.step24_BinarySearch;

import java.util.Scanner;

public class Code_1300 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int k = input.nextInt();

        int min = 1;
        int max = (int) Math.min((long) n * n, (long) 1000000000);
        int mid;
        int result = 0;

        while (min <= max) {
            mid = (min + max) / 2;

            int count = underCount(mid, n);    //  mid 이하의 숫 갯수

            if (count >= k) {
                result = mid;
                max = mid - 1;
            } else
                min = mid + 1;
        }

        System.out.print(result);
    }

    private static int underCount(int mid, int n) {
        int count = 0;
        for (int i = 1; i <= n; ++i) {  //  1행부터 mid 이하의 수 찾기
            count += Math.min(mid / i, n);
        }
        return count;
    }
}