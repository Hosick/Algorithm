package baekjoon.math;

import java.util.Scanner;

public class Code_10569 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();    //

        while (T != 0) {
            int V = input.nextInt();    //  꼭지점의 개수
            int E = input.nextInt();    //  모서리의 개수

            System.out.println(2 - V + E);  //  면의 개수 = 2 - 꼭지점의 개수 + 모서리의 개수

            T--;
        }
    }
}