package step1;

import java.util.Scanner;

public class Code_2588 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int x = input.nextInt();
        int y = input.nextInt();

        int a = x*(y%10);
        int b = x*(y%100-y%10)/10;
        int c = x*(y/100);
        int d= a+b*10+c*100;

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
    }
}
