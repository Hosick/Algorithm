package baekjoon.baekjoon_step.step6_Array;

import java.util.Scanner;

public class Code_2577 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int A = input.nextInt();
        int B = input.nextInt();
        int C = input.nextInt();

        int D = A * B * C;  // 세 수의 곱
        String stringD = Integer.toString(D); //곱한 수 문자열 변환
        int lengthD = stringD.length(); // 곱한 수의 길이

        int[] arrayD = new int[10]; // 숫자 갯수의 배열

        for (int i = 0; i < lengthD; i++) { // 각 자리별로 숫자 갯수 배열++
            int x = stringD.charAt(i) - 48;
            arrayD[x]++;
        }

        for (int i = 0; i < 10; i++) { // 숫자 갯수 배열 출력
            System.out.println(arrayD[i]);
        }
    }
}
