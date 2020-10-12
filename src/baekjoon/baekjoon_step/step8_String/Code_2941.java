package baekjoon.baekjoon_step.step8_String;

import java.util.Scanner;

public class Code_2941 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String word = input.next(); //  크로아티안 알파벳 단어입력
        String[] croatia = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="}; // 크로아티안 알파벳 집합

        for (int i = 0; i < 8; ++i) {
            word = word.replace(croatia[i], ".");
        }
        System.out.print(word.length());
    }
}