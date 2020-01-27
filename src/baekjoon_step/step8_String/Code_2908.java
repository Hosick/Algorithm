package baekjoon_step.step8_String;

import java.util.Scanner;

public class Code_2908 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int x, y;
        do {    //  x,y를 서로 다르게 입력
            x = input.nextInt();
            y = input.nextInt();
        } while (x == y);

        x = (x / 100) + ((x - x / 100 * 100) / 10 * 10) + (x - (x / 100 * 100) - (x - x / 100 * 100) / 10 * 10) * 100;  //x 거꾸로 계산
        y = (y / 100) + ((y - y / 100 * 100) / 10 * 10) + (y - (y / 100 * 100) - (y - y / 100 * 100) / 10 * 10) * 100;  //x 거꾸로 계산

        if (x > y) System.out.print(x);
        else System.out.print(y);
    }
}