package baekjoon.sort;

import java.util.Arrays;
import java.util.Scanner;

public class Code_3047 {
    static int[][] resultArray = null;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int arr[] = new int[3];

        arr[0] = input.nextInt();
        arr[1] = input.nextInt();
        arr[2] = input.nextInt();

        String str = input.nextLine().trim();

        Arrays.sort(arr);

        for (int i = 0; i < 3; i++) {
            char c = str.charAt(i);

            if (c == 'A')
                System.out.print(arr[0] + " ");
            if (c == 'B')
                System.out.print(arr[1] + " ");
            if (c == 'C')
                System.out.print(arr[2] + " ");
        }
    }
}


출처:https://ktko.tistory.com/entry/백준알고리즘-3047번-ABC [KTKO 개발 블로그와 여행 일기]