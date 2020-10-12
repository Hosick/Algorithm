package baekjoon.baekjoon_step.step9_Math1;


import java.util.Scanner;

public class Code_1193 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int x = input.nextInt();

        int i = 0;  // 몇번째 지그재그 줄인지
        int sum = 0; // 그 줄 전까지의 합

        while (true) {  // 해당 줄에 도달할때까지 계산
            if (i + sum >= x) {
                break;
            }
            sum += i;
            ++i;
        }
        sum = x - sum;

        if (i % 2 == 1) {   //  홀수 줄 일 때
            System.out.println(i + 1 - sum + "/" + sum);
        } else {    //짝수 줄 일 때
            System.out.println(sum + "/" + (i + 1 - sum));
        }
    }
}
