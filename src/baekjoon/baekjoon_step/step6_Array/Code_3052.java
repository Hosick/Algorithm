package baekjoon.baekjoon_step.step6_Array;

import java.util.Scanner;

public class Code_3052 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        boolean[] remain = new boolean[42]; //  0-41까지 수 중 나머지인 수가 있는지
        int count = 0;  //  나머지 갯수(중복 제외)

        for (int i = 0; i < 10; ++i) {
            remain[input.nextInt()%42] = true;
        }
        for (int i = 0; i<42;++i){
            if(remain[i]) ++count;
        }
        System.out.println(count);
    }
}
