package step1;

import java.util.Scanner;

public class Code_10998 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int A=0 ,B=10 ;

        while(A <= 0) {
            A = input.nextInt();
        }
        while (B >= 10){
            B = input.nextInt();
        }
        System.out.println(A*B);
    }
}
