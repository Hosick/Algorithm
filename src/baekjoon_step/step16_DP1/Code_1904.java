package baekjoon_step.step16_DP1;

import java.util.Scanner;

public class Code_1904 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        long[] way = new long[n];
        way[0] = 1;
        way[1] = 2;

        for (int i = 2; i < n; ++i)
            way[i] = (way[i - 1] + way[i - 2]) %15746;

        System.out.print(way[n-1]);
    }
}
