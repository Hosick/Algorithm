package baekjoon.greedy;

import java.util.Scanner;

public class Code_11047 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int kinds = input.nextInt();    //  동전의 종류 수
        int value = input.nextInt();    //  동전을 조합해서 만들어야 할 값
        int[] coin = new int[kinds];    //  동전 종류 배열
        int min = 0;                    //  동전의 최소 개수

        for (int i=0; i<kinds;++i){     //  동전 종류 입력
            coin[i] = input.nextInt();
        }

        for(int i = kinds-1; i>=0; --i){    //  가장 큰 동전부터
            min += value/coin[i];   //  i번째 동전이 원하는 값보다 작을 경우 사용할 수 있는 갯수만큼 사용
            value = value%coin[i];  //  value는 나머지 금액
            if(value==0)            //  금액을 다 채웠다면 끝
                continue;
        }
        System.out.print(min);      //  최소 동전 갯수 출력
    }
}