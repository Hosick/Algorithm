package baekjoon.baekjoon_step.step6_Array;

import java.util.Scanner;

public class Code_1546 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int N = input.nextInt();
        double[] test = new double[N];

        for (int i = 0; i < N; i++) {        //시험점수 입력
            test[i] = input.nextDouble();
        }

        double max = test[0];   //가장잘본과목 점수찾기
        for (int i = 1; i < N; i++) {
            if (test[i] > max) max = test[i];
        }
        double sum = 0.0;
        for (int i = 0; i < N; i++) { //점수 조작
            test[i] = test[i] / max * 100;
            sum += test[i];
        }
        System.out.println(sum / N);
    }
}
