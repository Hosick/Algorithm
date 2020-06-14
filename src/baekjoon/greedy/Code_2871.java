package baekjoon.greedy;

import java.util.*;

public class Code_2871 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();    //  단어의 길이
        String word = input.next(); //  주어진 단어
        input.close();
        boolean[] visit = new boolean[n];

        String my = "";
        String your = "";
        for (int i = 0; i < n; ++i) {
            /* 상근이의 차례 */
            if (i % 2 == 0) {
                int j = word.length() - 1;
                while (visit[j]) {
                    --j;
                }
                your += word.charAt(j);
                visit[j] = true;
            }
            /* 희원이의 차례 */
            else {
                int j = word.length() - 1;
                char min = (char) ('z' + 1);
                int minIdx = 0;
                while (j > -1) {
                    if (!visit[j] && word.charAt(j) < min) {
                        min = word.charAt(j);
                        minIdx = j;
                    }
                    j--;
                }
                my += min;
                visit[minIdx] = true;
            }
        }

        for (int i = 0; i < n / 2; ++i) {
            if (my.charAt(i) < your.charAt(i)) {
                System.out.println("DA");
                break;
            } else if (my.charAt(i) > your.charAt(i)) {
                System.out.println("NE");
                break;
            }
            if (i == n / 2 - 1)
                System.out.println("NE");
        }

        System.out.println(my);
    }
}
