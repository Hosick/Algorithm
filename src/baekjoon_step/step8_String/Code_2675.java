package baekjoon_step.step8_String;

import java.util.Scanner;

public class Code_2675 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int T = input.nextInt();    //케이스 갯수
        String[] S = new String[T]; // 문자열 배열
        int[] R = new int[T];       // 반복횟수 배열
        String[] P = new String[T]; // 변환 문자 배열

        for (int i = 0; i < T; i++) {
            R[i] = input.nextInt();
            S[i] = input.next();
            for (int j = 0; j < S[i].length(); j++) { // i번째 문자열의 길이만큼
                for (int k = 0; k < R[i]; k++) {  // R번 붙히기
                    System.out.print(S[i].charAt(j));
                }
            }
            System.out.println();
        }
    }
}
