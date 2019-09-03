package baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Code_10610 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String N = input.next();    //  N을 String으로 입력받기
        int sum = 0;    //  각 자릿수의 합
        ArrayList<Integer> n = new ArrayList<>();   // N의 각 자릿수를 넣을 배열 n선언

        for (int i = 0; i < N.length(); ++i) {  //  int형으로 각 자릿수를 n에 초기화 및 sum에 더하기
            n.add(N.charAt(i) - 48);
            sum += n.get(i);
        }
        Collections.sort(n);    //  정렬
        Collections.reverse(n); //  역순

        if (n.get(n.size()-1) == 0 && sum % 3 == 0) {   //  n에 0이 포함되어 있으며, 각 자릿수 값의 합이 3
            for (int i : n)
                System.out.print(i);    //출력
        } else
            System.out.print(-1);
    }
}