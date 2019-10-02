package baekjoon.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class Code_5545 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int toppingNumber = input.nextInt();                //  토핑의 갯수
        double doughPrice = input.nextDouble();             //  도우의 가격
        double toppingPrice = input.nextDouble();           //  토핑의 가격
        double doughKcal = input.nextDouble();              //  도우의 열량
        double[] toppingKcal = new double[toppingNumber];   //  토핑의 열량 배열

        for (int i = 0; i < toppingNumber; ++i) {             //  각 토핑의 열량 입력
            toppingKcal[i] = input.nextDouble();
        }
        Arrays.sort(toppingKcal);       //  토핑의 열량 정렬

        double pizzaPrice = doughPrice; //  피자의 총 가격
        double pizzaKcal = doughKcal;  //  피자의 총 열량

        for (int i = toppingNumber - 1; i >= 0; --i) {
            if (pizzaKcal / pizzaPrice < (pizzaKcal + toppingKcal[i]) / (pizzaPrice + toppingPrice)) {   //  i번째 토핑을 올렸을 때
                pizzaKcal += toppingKcal[i];                                                      //  가성비가 좋아진다면
                pizzaPrice += toppingPrice;                                                       //  올리기
            }
        }
        System.out.println((int) (pizzaKcal / pizzaPrice));    //  만든 피자의 1원 당 열량 출력
    }
}