package baekjoon_step.step10_Math2;

import java.util.Scanner;

public class Code_1978 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();    //  주어지는 숫자 갯수
        int[] num = new int[n];     //  n개의 숫자 배열
        int decimal = 0;            //  소수의 갯수 카운트

        for (int i : num) {         //  n개의 숫자를 순서대로 검사
            i = input.nextInt();
            int j = i - 1;
            while (true) {          //  해당 숫자가 소수인지 검사
                if (i == 1)          //  해당 숫자가 1이면 다음숫자
                    break;
                if (j == 1) {       //  소수면 ++decimal
                    ++decimal;
                    break;
                }
                if (i % j == 0)     //  아니면 다음숫자
                    break;
                --j;
            }
        }

        System.out.print(decimal);
    }
}
