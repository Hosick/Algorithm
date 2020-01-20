package baekjoon_step.step8_Math1;

import java.util.Scanner;

public class Code_2869 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long A = input.nextLong();  //  오름
        long B = input.nextLong();  //  내림
        long V = input.nextLong();  //  높이

        long answer = 0;    //  일 수
        long dis = A - B;   //  오름-내림

        V -= B; //  마지막 날 내림은 제외
        answer = V / dis;   //  일 수는 높이 / (오름-내림)
        if (V % dis > 0)    //  오를 곳이 더남았다면 ++하루
            ++answer;

        System.out.println(answer);
    }
}