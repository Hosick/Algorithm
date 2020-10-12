package baekjoon.baekjoon_step.step18_Greedy;

import java.util.Arrays;
import java.util.Scanner;

public class Code_11399 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] person = new int[input.nextInt()];    //  n명의 사람 배열 생성
        int minTime = 0;

        for (int i = 0; i < person.length; ++i) {
            person[i] = input.nextInt();    //  i번 사람의 인출 속도
        }
        Arrays.sort(person);    //  인출 속도가 빠른 순으로 사람을 정렬

        for (int i = 0; i < person.length; ++i) {
            minTime += (person[i] * (person.length - i));     //  i번째 사람의 인출 시간을 사람수-1만큼 곱한 후 전부 더함
        }
        System.out.println(minTime);
    }
}