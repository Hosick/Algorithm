package baekjoon_step.step18_Greedy;

import java.util.Scanner;

public class Code_1541 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String exp = input.next();  //  수식 입력
        String[] number1 = exp.split("-");   //  수식에서 '-'부호를 빼고 배열에 저장
        String[] number2;                           //  배열에 남은 수식에서 '+'부호를 빼고 저장할 배열
        int min = 0;

        for (int i = 0; i < number1.length; ++i) {
            number2 = number1[i].split("[+]");  //  i번째 수식에서 '+'부호를 빼고 배열에 저장
            int temp = 0;
            for (int j = 0; j < number2.length; ++j) {        //  이 후 j번째 수식의 수들을 더합
                temp += Integer.parseInt(number2[j]);
            }
            if (i != 0) temp *= (-1);  //  가장 앞 수를 뺀 수들은 다 뺄셈
            min += temp;
        }
        System.out.println(min);
    }
}