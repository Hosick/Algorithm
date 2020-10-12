package step1;

import java.util.Scanner;

public class Code_1008 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int A=0 ,B=10001 ;

        while(A < 1) {
            A = input.nextInt();
        }
        while (B > 10000){
            B = input.nextInt();
        }
        System.out.println(A+B);
        System.out.println(A-B);
        System.out.println(A*B);
        System.out.println(A/B);
        System.out.println(A%B);
    }
}
