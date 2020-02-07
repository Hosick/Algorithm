package baekjoon_step.step16_DP1;

import java.util.Scanner;

public class Code_9461 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();

        long[] padovan = new long[101];
        padovan[1] = 1;
        padovan[2] = 1;
        padovan[3] = 1;

        /*수열 채우기*/
        for (int i=4; i<=100; ++i){
                padovan[i] = padovan[i-2]+padovan[i-3];
        }

        /*수열 출력*/
        for (int i =0; i<t; ++i){
            System.out.println(padovan[input.nextInt()]);
        }
    }
}
