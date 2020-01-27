package baekjoon_step.step9_Math1;

import java.util.Scanner;

public class Code_2292 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        int step = 1;   //  지나야하는 방 수
        int stepSum = 1;    //  해당단계 방의 끝의 수

        while (true) {
            stepSum += 6 * (step - 1);  //  방의 최고값 수는 1부터 시작해서  6*(방 수-1)씩 늘어남
            if (stepSum >= n) break; // n이 해당 단계의 최고수 보다 낮으면 break;
            ++step;                 // 높으면 계속 진행
        }
        System.out.println(step);
    }
}