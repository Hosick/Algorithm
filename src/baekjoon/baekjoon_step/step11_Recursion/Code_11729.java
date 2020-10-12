package baekjoon.baekjoon_step.step11_Recursion;

import java.util.Scanner;

public class Code_11729 {
    static int count = 0;  //  이동 횟수
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();    //  원판 갯수
        move(n, 1, 2, 3);
        sb.insert(0, count + "\n");
        System.out.println(sb);

    }

    public static void move(int n, int start, int mid, int end) {   //  출발, 중간, 마지막 장대
        ++count;

        if (n == 1)
            sb.append(start + " " + end + "\n");
        else {
            move(n - 1, start, end, mid);
            sb.append(start + " " + end + "\n");
            move(n - 1, mid, start, end);
        }
    }
}
