package baekjoon.baekjoon_step.step6_Array;


import java.util.Scanner;

public class Code_4344 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int C = input.nextInt(); // 테스트케이스의 갯수

        int[][] N = new int[C][1000];
        int[] stu = new int[C];
        double[] sum = new double[C];
        for (int i = 0; i < C; i++) {

            stu[i] = input.nextInt(); // 학생 수
            for (int j = 0; j < stu[i]; j++) {

                N[i][j] = input.nextInt();
                sum[i] += N[i][j];
            }
        }
        double[] avg = new double[C];

        for (int i = 0; i < C; i++) {
            avg[i] = sum[i] / stu[i];
        }

        int[] highStuSum = new int[C];
        double[] per = new double[C];
        String[] per2 = new String[C];
        for (int i = 0; i < C; i++) {
            for (int j = 0; j < stu[i]; j++) {
                if (N[i][j] > avg[i]) highStuSum[i] += 1;
            }
            per[i] = (double) highStuSum[i] / stu[i] * 100;
            per2[i] = String.format("%.3f", per[i]);
            System.out.println(per2[i] + "%");
        }
    }
}