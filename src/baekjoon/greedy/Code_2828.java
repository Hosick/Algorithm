package baekjoon.greedy;

import java.util.Scanner;

public class Code_2828 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();    //  스크린의 칸 수
        int m = input.nextInt();    //  바구니의 칸 수
        int j = input.nextInt();    //  떨어지는 사과의 갯수
        int[] apple = new int[j];   //  사과가 떨어지는 칸
        int leftEndIndex = 1;       //  바구니의 왼쪽 끝 칸
        int rightEndIndex = m;      //  바구니의 오른쪽 끝 칸
        int movement = 0;           //  바구니의 이동 수

        for (int i = 0; i < j; ++i) {   //  사과의 갯수 j만큼
            apple[i] = input.nextInt();

            while (apple[i] < leftEndIndex || apple[i] > rightEndIndex) {   //  바구니 안에 i번째 사과가 들어올 수 있을 때까지 이동
                if (apple[i] < leftEndIndex) {          //   왼쪽으로 이동
                    --leftEndIndex;
                    --rightEndIndex;
                    ++movement;
                } else if (apple[i] > rightEndIndex) {  //    오른쪽으로 이동
                    ++leftEndIndex;
                    ++rightEndIndex;
                    ++movement;
                }
            }
        }
        System.out.println(movement);
    }
}