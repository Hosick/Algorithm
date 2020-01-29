package baekjoon_step.step14_Sort;

import java.util.Arrays;
import java.util.Scanner;

public class Code_2750 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();    //  숫자 갯수 입력
        int[] num = new int[n];

        for (int i = 0; i < n; ++i)   //  n개의 숫자 입력
            num[i] = input.nextInt();

        Arrays.sort(num);   //  오름차순 정렬

        for (int x : num) {   //  출력
            System.out.println(x);
        }
    }
}