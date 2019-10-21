package baekjoon_step.step3_For;

import java.util.Scanner;

public class Code_2741 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N=-1;

        while (N>100000 || N<0){
            N = input.nextInt();
        }
        for (int i=1; i<=N; i++){
            System.out.println(i);
        }
    }
}
