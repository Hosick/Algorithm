package baekjoon_step.step4_While;

import java.util.Scanner;

public class Code_1110 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int N = input.nextInt(); //정수입력
        int cycle = 0; // 반복횟수
        int M = N; //변하는 정수

        do { //한번의 실행
            int a = M / 10;   //변한 수의 앞자리 수
            int b = M % 10;   //변한 수의 뒷자리 수
            M = b * 10 + (a + b) % 10; //M을 변경
            cycle++; // 싸이클+1
        } while (M != N);    //최초의 정수와 같아질 때 까지

        System.out.println(cycle);
    }
}