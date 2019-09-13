package baekjoon.greedy;

import java.util.Scanner;

public class Code_5585 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int price = input.nextInt();    //  물건 가격
        int change = 1000-price;        //  거스름 돈
        int[] coin = {500,100,50,10,5,1};// 동전 종류
        int count = 0;                  //  거스름 돈 동전 최소 갯수

        for (int i = 0; i<6;++i){
            count += change/coin[i];    //  i번째 동전을 사용가능한 만큼 사용
            change = change%coin[i];    //  나머지 거스름 돈
            if(change==0) continue;     //  줘야할 돈이 업스면 continue
        }
        System.out.print(count);
    }
}
