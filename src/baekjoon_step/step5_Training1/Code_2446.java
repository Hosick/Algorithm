package baekjoon_step.step5_Training1;

import java.util.Scanner;

public class Code_2446 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        int std = 2 * n - 1;
        int temp = std;

        for (int i = 0; i < std; ++i) {
            int empty = (std - temp) / 2;
            for (int j = 0; j < std; ++j) {
                if (j < empty)
                    System.out.print(" ");
                else if(j >= std -empty)
                    continue;
                else
                    System.out.print("*");
            }
            System.out.println();
            if (i < n - 1)
                temp -= 2;
            else
                temp += 2;
        }
    }
}