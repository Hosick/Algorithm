package baekjoon.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class Code_1461 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int bookNumber = input.nextInt();       //  책의 권 수
        int bookMax = input.nextInt();          //  최대 들 수 있는 책의 권수
        int[] bookIndex = new int[bookNumber];  //  책들의 위치 배열
        int maxAbs = 0;                         //  0에서 가장 먼 거리에 있는 책 위치
        int plusIndex = 0;                      //  위치가 +인 책 갯수
        int minusIndex = 0;                     //  위치가 -인 책 갯수
        int step = 0;                           //  총 움직인 거리


        for (int i = 0; i < bookNumber; ++i) {
            bookIndex[i] = input.nextInt();
            if (bookIndex[i] > 0) ++plusIndex;         //  위치가 양수
            else if (bookIndex[i] < 0) ++minusIndex;   //  위치가 음수

            if (Math.abs(bookIndex[i]) > maxAbs) maxAbs = Math.abs(bookIndex[i]);  //  가장 먼 거리 찾기
        }

        Arrays.sort(bookIndex);                 //  책들의 위치 정렬
        for (int i = 0; i < minusIndex; i = i + bookMax) {      //  음수 책 운반
            step += Math.abs(bookIndex[i]) * 2;
        }
        for (int i = bookNumber - 1; i >= bookNumber - plusIndex; i = i - bookMax) {    //  양수 책 운반
            step += bookIndex[i] * 2;
        }
        step = step - maxAbs;   //  가장 먼 거리에서는 돌아오지 않기
        System.out.print(step);
    }
}
