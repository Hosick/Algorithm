package baekjoon_step.step8_String;

import java.util.Scanner;

public class Code_1152 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String words = input.nextLine().trim();

        if (words.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(words.split(" ").length);
        }
    }
}