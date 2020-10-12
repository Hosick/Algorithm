package baekjoon.baekjoon_step.step4_While;

import java.util.Scanner;

public class Code_10951 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextInt())
            System.out.println(scan.nextInt() + scan.nextInt());
    }
}
