package baekjoon.greedy;

import java.util.Scanner;

public class Code_1449 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int leakNumber = input.nextInt();       //  물이 새는 위치 수
        int tapeLength = input.nextInt();       //  테이프의 길이
        int tapeCount = 0;                      //  사용한 테이프의 갯수
        boolean[] leak = new boolean[1001];     //  파이프의 위치 Boolean배열
        for (int i = 0; i < leakNumber; ++i) {
            leak[input.nextInt()] = true;       //  물이 새는 위치는 true
        }

        for (int i = 1; i <= 1000; ++i) {        //  파이프를 누수여부를 1-1000까지 검사
            if (leak[i] == true) {               //  누수라면
                ++tapeCount;                     //  테이프 1개 소모
                i += (tapeLength - 1);           //  테이프의 끝부터 다시 검사
            }
        }
        System.out.println(tapeCount);
    }
}
