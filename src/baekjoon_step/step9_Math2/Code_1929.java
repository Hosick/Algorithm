package baekjoon_step.step9_Math2;

import java.util.Scanner;

public class Code_1929 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int min = input.nextInt();  //  범위 내 최소값 입력
        int max = input.nextInt();  //  범위 내 최대값 입력
        if (min == 1)    //  1은 제외하기
            min = 2;

        boolean[] arr = new boolean[max + 1];   //  소수라면 트루
        for (int i = min; i <= max; ++i) arr[i] = true;  //  min-max 범위 전부 true로 초기화


        for (int i = 2; i * i <= max; ++i) {    //  2부터 i^2이 max를 넘기전까지 나눔
            for (int j = i + 1; j <= max; ++j) {
                if (j % i == 0)
                    arr[j] = false;
            }
        }
        for (int i = min; i <= max; ++i) {  //  범위 내 소수 전부 출력
            if (arr[i] == true)
                System.out.println(i);
        }
    }
}

