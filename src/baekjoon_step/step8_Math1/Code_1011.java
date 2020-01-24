package baekjoon_step.step8_Math1;

import java.util.Scanner;

public class Code_1011 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int t = input.nextInt(); //  테스트 케이스 횟수 입력

        for (int i = 0; i < t; ++i) {   // t번 시행
            int x = input.nextInt();
            int y = input.nextInt();

            System.out.println(calc(y - x));
        }
    }

    /*거리를 받아서 최수 이동 횟수 계산하는 함수*/
    public static int calc(int distance) {  //   (거리의 제곱근의 올림) + (제곱근의 올림-(1또는2))은 이동횟수이다
        int x = (int) Math.ceil(Math.sqrt(distance));    //  거리의 제곱근의 올림 구하기
        if(distance > x*x-x)    //  거리가 x*x-x 보다 크면
            return 2*x-1;       //  (거리의 제곱근의 올림) + (제곱근의 올림-1)
        else                    //  아니라면
            return 2*x-2;       //  (거리의 제곱근의 올림) + (제곱근의 올림-2)
    }
}