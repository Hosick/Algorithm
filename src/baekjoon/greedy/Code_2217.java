package baekjoon.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class Code_2217 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();    //  로프의 갯수
        int maxWeight = 0;
        int[] rope = new int[n];
        for (int i = 0; i < n; ++i) {
            rope[i] = input.nextInt();  //  i번째 로프가 버틸 수 있는 최대 중량
        }
        Arrays.sort(rope);  //  중량순으로 로프 배열 정렬

        for (int i = 0; i < n; ++i) {
            int temp = rope[i] * (n - i);   //  i번째 로프부터 사용했을 때
            if (maxWeight < temp) maxWeight = temp; //  최대 중량인지?
        }
        System.out.println(maxWeight);
    }
}
