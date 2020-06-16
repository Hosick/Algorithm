package baekjoon.math;

import java.util.Scanner;

public class Code_2914 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();    //  곡의 개수
        int i = input.nextInt();    //  곡 당 멜로디 평균값

        int ans = a * (i - 1) + 1;  //  곡의 개수 * (평균 멜로디 값  - 1)에 한개의 멜로디만 더있어도 올림시 평균이 i가 된다
        System.out.println(ans);
    }
}
