package baekjoon.sort;

import java.util.Arrays;
import java.util.Scanner;

public class Code_3047 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] number = new int[3];
        for (int i = 0; i < 3; ++i) {
            number[i] = input.nextInt();
        }

        Arrays.sort(number);

        String s = input.next();

        for (int i = 0; i < 3; ++i) {
            if (s.charAt(i) == 'A')
                System.out.print(number[0]+" ");
            else if (s.charAt(i) == 'B')
                System.out.print(number[1]+" ");
            else
                System.out.print(number[2]+" ");
        }
        System.out.println();
    }
}