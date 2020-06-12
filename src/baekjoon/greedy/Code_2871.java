package baekjoon.greedy;

import java.util.ArrayList;
import java.util.Scanner;

public class Code_2871 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        String word = input.next();

        ArrayList<Character> card = new ArrayList<>();
        for (int i = 0; i < n; ++i)
            card.add(word.charAt(i));

        String my = "";
        String your = "";
        for (int i = 0; i < n; ++i) {
            if (i % 2 == 0) //  상대 차례
                your += card.remove(card.size() - 1);
            else {
                char min = 'z' + 1;
                int minIdx = 0;
                for (int j = card.size() - 1; j >= 0; --j) {
                    if (card.get(j) < min) {
                        min = card.get(j);
                        minIdx = j;
                    }
                }
                my += card.remove(minIdx);
            }
        }

        for (int i = 0; i < (n / 2); ++i) {
            if (my.charAt(i) < your.charAt(i)) {
                System.out.println("DA");
                break;
            } else if (my.charAt(i) > your.charAt(i)) {
                System.out.println("NE");
                break;
            }
            if (i == (n / 2 - 1)) {
                System.out.println("NE");
            }
        }
        System.out.println(my);
    }
}
