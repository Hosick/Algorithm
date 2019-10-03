package baekjoon.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class Code_2012 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int students = input.nextInt(); //  대회에 참가한 학생 수
        int[] prediction = new int[students];   //  학생들의 예상 등수 배열
        for (int i = 0; i < students; ++i)
            prediction[i] = input.nextInt();

        Arrays.sort(prediction);    //  정렬
        long diss = 0;              //  불만도의 합

        for (int i = 0; i < students; i++)
            diss += Math.abs(prediction[i] - (i + 1));  //  오름차순으로 등수와 비교 후 불만도(절대값) 구하기

        System.out.println(diss);   //  불만도 출력
    }
}