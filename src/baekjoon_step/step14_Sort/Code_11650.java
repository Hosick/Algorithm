package baekjoon_step.step14_Sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Code_11650 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int[][] point = new int[n][2];

        for (int i = 0; i < n; ++i) {
            point[i][0] = input.nextInt();
            point[i][1] = input.nextInt();
        }

        Arrays.sort(point, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0])
                    return Integer.compare(o1[1], o2[1]);
                return Integer.compare(o1[0], o2[0]);
            }
        });

        for (int i = 0; i < n; ++i) {
            System.out.println(point[i][0] + " " + point[i][1]);
        }
    }
}
