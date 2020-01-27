package baekjoon_step.step10_Math2;

import java.util.Scanner;

public class Code_3053 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int r = input.nextInt();    //  반지름 입력

        System.out.println(String.format("%.6f", Math.PI * r * r)); //  유클리드 기하학 넓이 계산
        System.out.println(String.format("%.6f", (double) 2 * r * r));   //  택시 기하학 넓이 계산
    }
}
