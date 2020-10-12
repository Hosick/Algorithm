package baekjoon.baekjoon_step.step14_Sort;

import java.util.Scanner;

public class Code_1427 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String n = input.nextLine();    //  숫자한줄 String으로 받기
        int[] m = new int[n.length()];  //  각자리 숫자 넣은 배열 생성
        int temp;

        for (int i = 0; i < n.length(); ++i) {  //  배열 m에 각 자리 숫자 집어넣기
            m[i] = n.charAt(i) - 48;
        }
        for (int i = 0; i < n.length(); ++i) {  //  버블소트 이용한 역순정렬
            for (int j = 0; j < n.length() - 1 - i; ++j) {
                if (m[j] < m[j + 1]) {
                    temp = m[j];
                    m[j] = m[j + 1];
                    m[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < n.length(); ++i) {  //  출력
            System.out.print(m[i]);
        }
    }
}