package baekjoon_step.step14_Sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Code_10814 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();

        String[][] user = new String[n][2];

        for (int i = 0; i < n; ++i) {
            user[i][0] = input.next();
            user[i][1] = input.next();
        }

        Arrays.sort(user, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return Integer.compare(Integer.parseInt(o1[0]), Integer.parseInt(o2[0]));
            }
        });

        for (int i = 0; i < n; ++i) {
            System.out.println(user[i][0] + " " + user[i][1]);
        }
    }
}
