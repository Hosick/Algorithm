package baekjoon.greedy;

import java.util.Scanner;

public class Code_1783 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();    //  보드판 행의 개수
        int m = input.nextInt();    //  보드판 열의 개수
        int answer = 0; // 최대 방문 칸 수 (초기 칸만 방문으로 초기화)

        /* 4가지 방법을 모두 사용하려면 n이 3이상, m이 7이상 이어야 함 */
        if (n == 1)         //  높이가 1이라면 이동불가
            answer = 1;
        else if (n == 2)    //  높이가 2라면 2,3번째 방법만 반복 가능(두 칸씩 우측 전진)
            answer = Math.min((m + 1) / 2, 4);  //  4가지 방법을 모두 안썼기 때문에 3번 사용(4)이 최대
        else if (m < 7)     //  높이가 3이상이지만, 너비가 7보다 작다면 1,4번째 방법 반복이 효율적(한 칸씩 우측 전진)
            answer = Math.min(m, 4);            //  4가지 방법을 모두 안썼기 때문에 3번 사용(4)이 최대
        else                //  높이가 3이상이고,  너비가 7이상이라면 (n,7)부터 시작해서 1,4번째 방법 반복이 효율적(5 + 한 칸씩 우측 전진)
            answer = m - 2;

        System.out.println(answer);
    }
}