package baekjoon_step.step9_Math1;

import java.util.Scanner;

public class Code_1712 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int fixedCost = input.nextInt();    //  고정 비용
        int cost = input.nextInt();   //  1대 당 생산비용
        int price = input.nextInt();    //  노트북의 판매가격
        int quantity = 1;   //  노트북 대 수

        if (price <= cost)
            quantity = -1;
        else
            quantity = fixedCost / (price - cost) + 1;

        System.out.println(quantity);
    }
}