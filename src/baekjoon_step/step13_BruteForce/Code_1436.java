package baekjoon_step.step13_BruteForce;

import java.util.Scanner;

public class Code_1436 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();    //  몇번째 시리즈인지 입력

        int m = 666;
        int count = 0;
        while (true){
            if(Integer.toString(m).contains("666")) //  666 포함 되어 있다면 ++count
                ++count;
            if(count==n) {
                System.out.println(m);              //  count가 n과 같아면 m출력
                break;
            }
            ++m;
        }
    }
}