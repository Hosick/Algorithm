package baekjoon.baekjoon_step.step9_Math1;

import java.util.Scanner;

public class Code_10250 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int testCase = input.nextInt(); //  테스트 케이스 갯수 입력

        int[] height = new int[testCase];   //  테스트 케이스 별 호텔 높이
        int[] width = new int[testCase];    //  테스트 케이스 별 호텔 너비
        int[] customer = new int[testCase]; //  테스트 케이스 별 손님의 순서

        for (int i = 0; i < testCase; ++i) {
            height[i] = input.nextInt();    //  i번 케이스의 호텔 높이 입력
            width[i] = input.nextInt();     //  i번 케이스의 호텔 너비 입력
            customer[i] = input.nextInt();  //  i번 케이스의 손님 순서 입력

            int floor = customer[i] % height[i]; // 손님이 묵을 층 수
            int order = customer[i] / height[i] + 1; //  손님이 묵을 호 수

            if (floor == 0) {       //  손님의 순서 /  호텔의 층수가 0일 때
                floor = height[i];
                order -= 1;
            }

            System.out.println(floor * 100 + order);
        }
    }
}
