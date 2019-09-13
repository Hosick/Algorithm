package baekjoon.greedy;

import java.util.Scanner;

public class Code_1120 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String x = input.next();
        String y = input.next();
        int minDiff = 50;    //  최소차이
        int tempDiff;       // i번째 시도의 문자열 차이

        for (int i = 0; i <= y.length() - x.length(); ++i) {    //  y.length() - x.length()번 시도
            tempDiff = 0;
            for (int j = 0; j < x.length(); ++j) {              //  0~(x의 길이)까지
                if (x.charAt(j) != y.charAt(j + i)) ++tempDiff; //  x의 j번째 자리와 y의 j+i번째 자리가 다르면 차이++
            }
            if (tempDiff < minDiff) minDiff = tempDiff;         //  i번째 시도가 최소 차이면 minDiff 업데이트
        }
        System.out.println(minDiff);
    }
}