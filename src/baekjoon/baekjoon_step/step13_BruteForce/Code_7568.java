package baekjoon.baekjoon_step.step13_BruteForce;

import java.util.Arrays;
import java.util.Scanner;

public class Code_7568 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();    //  사람 수 입력

        int[] x = new int[n];       //  n명의 몸무게 배열
        int[] y = new int[n];       //  n명의 키 배열
        int[] rank = new int[n];    //  n명의 등 수 배열
        Arrays.fill(rank, 1);  //  전부 1등으로 초기화

        for (int i = 0; i < n; ++i) {    //  n명의 신체 스펙 입력
            x[i] = input.nextInt();
            y[i] = input.nextInt();
        }

        /*비교 학생보다 키작고 가벼우면 등수 하락*/
        for (int i = 0; i < n; ++i) {   //  등수 측정할 학생
            for (int j = 0; j < n; ++j)    //  나머지 학생
                if (x[i] < x[j] && y[i] < y[j])
                    ++rank[i];
            System.out.print(rank[i] + " ");
        }
    }
}