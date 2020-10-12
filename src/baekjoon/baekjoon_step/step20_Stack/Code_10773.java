package baekjoon.baekjoon_step.step20_Stack;

import java.util.Scanner;
import java.util.Stack;

public class Code_10773 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int sum = 0;
        Stack<Integer> stack = new Stack<>();

        /* 장부 기입하기 */
        for (int i = 0; i < n; ++i) {
            int num = input.nextInt();

            if (num == 0)
                stack.pop();
            else
                stack.push(num);
        }

        /* 적은 수의 합 출력 */
        while (!stack.isEmpty())
            sum += stack.pop();

        System.out.print(sum);
    }
}
