package baekjoon.greedy;

import java.util.Scanner;

public class Code_2262 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int answer = 0;             //  랭킹 차이의 합
        int i, j;                   //  for 루프를 나눠서 돌게하기 위한 전역변수
        int n = input.nextInt();    //  인원 수

        int[] person = new int[258];    //  최대 256명의 선수와 그 옆 공백
        for (i = 1; i <= n; ++i)
            person[i] = input.nextInt();

        for (i = n; i > 1; --i) {   //  랭킹 n부터 2까지 찾기 (랭킹이 낮은 사람을 먼저 올려보내야 해서)
            for (j = 1; j <= n; ++j)
                if (person[j] == i) //  찾았다면 우선 멈추고
                    break;
            answer += (i - Math.max(person[j - 1], person[j + 1])); //  양쪽 중 더 랭킹이 낮은 사람과 차이
            for (; j <= n; ++j)     //  한칸씩 미뤄서 n등 선수 없애기
                person[j] = person[j + 1];
        }

        System.out.print(answer);
    }
}