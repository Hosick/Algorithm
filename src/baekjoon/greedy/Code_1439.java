package baekjoon.greedy;

import java.util.Scanner;

public class Code_1439 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String s = input.next();

        int answer = 0;             //  뒤집어야 하는 횟수
        int start = 0;              //  문자열의 시작 인덱스
        int end = s.length() - 1;   //  문자열의 마지막 인덱스
        char temp;                  //  문자열 start 인덱스의 값

        while (start < end) {       //  start가 end보다 작을 때까지
            temp = s.charAt(start);

            while (start < s.length() && s.charAt(start) == temp)   //  temp와 같을때까지 start++
                ++start;
            if (start > end)                                        //  end를 넘어가면 break;
                break;
            while (end > 0 && s.charAt(end) == temp)                //  temp와 같을때까지 end--
                --end;
            answer++;                                               //  수가 바뀌고 횟수++
        }

        System.out.println(answer);
    }
}
