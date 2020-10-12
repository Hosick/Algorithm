package baekjoon.baekjoon_step.step10_Math2;

import java.util.Scanner;

public class Code_2581 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int min = input.nextInt();  //  범위 내 최대값
        int max = input.nextInt();  //  범위 내 최소값
        int dcmMin = 0;  //  범위 내 소수 중 최소값
        int sum = 0;    //  범위 내 소수 합계

        for (int i = max; i >= min; --i) {
            int j = i - 1;

            while (true) {          //  해당 숫자가 소수인지 검사
                if (i == 1)          //  해당 숫자가 1이면 다음숫자
                    break;
                if (j == 1) {       //  소수면 ++decimal
                    sum += i;       //  소수 합계에 추가
                    dcmMin = i;     //  소수 최소값 update
                    break;
                }
                if (i % j == 0)     //  아니면 다음숫자
                    break;
                --j;
            }
        }
        if (sum == 0)
            System.out.print(-1);
        else {
            System.out.println(sum);
            System.out.print(dcmMin);
        }
    }
}