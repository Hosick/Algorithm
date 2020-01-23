package baekjoon_step.step9_Math2;

import java.util.Scanner;

public class Code_3009 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] x = new int[3];
        int[] y = new int[3];

        for (int i = 0; i < 3; ++i) {    //  세 점의 좌표 입력
            x[i] = input.nextInt();
            y[i] = input.nextInt();
        }

        //입력된 세 좌표중 혼자 다른 x좌표와 혼자 다른 y좌표 찾아서 출력
        if (x[0] == x[1])   //  x좌표 찾아서 출력
            System.out.print(x[2] + " ");
        else if (x[0] == x[2])
            System.out.print(x[1] + " ");
        else System.out.print(x[0] + " ");

        if (y[0] == y[1])   //  y좌표 찾아서 출력
            System.out.print(y[2]);
        else if (y[0] == y[2])
            System.out.print(y[1]);
        else System.out.print(y[0]);
    }
}
