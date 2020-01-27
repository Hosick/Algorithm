package baekjoon_step.step9_Math1;

import java.util.Scanner;

public class Code_2775 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();    //  테스트 케이스 갯수 입력
        int k, n;   //  층, 호 선언

        for (int i = 0; i < t; ++i) {
            k = input.nextInt();    //  층 입력
            n = input.nextInt();    //  호 입력
            System.out.println(calc(k, n));
        }
    }

    private static int calc(int k, int n) { //  인원 계산 함수
        if (n == 0)     //  0호는 없으므로 0 리턴
            return 0;
        else if (k == 0)    //  0층에서는 호수=사람수
            return n;
        else    //  전호 인원 + 밑층 인원 = 현재층 인원
            return calc(k, n - 1) + calc(k - 1, n);
    }
}