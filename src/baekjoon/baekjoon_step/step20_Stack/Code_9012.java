package baekjoon.baekjoon_step.step20_Stack;

import java.util.Scanner;
import java.util.Stack;

public class Code_9012 {
    public static Stack stack;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int t = Integer.parseInt(input.nextLine());

        for (int i = 0; i < t; ++i) {
            stack = new Stack();
            String ps = input.nextLine();
            String YN = "YES";

            for (int j = 0; j < ps.length(); ++j) {
                if (ps.charAt(j) == '(')
                    stack.push("@");
                else if (ps.charAt(j) == ')' && !stack.isEmpty())
                    stack.pop();
                else if (ps.charAt(j) == ')' && stack.isEmpty()) {
                    YN = "NO";
                    break;
                }
            }

            System.out.println((stack.isEmpty()) ? YN : "NO");
        }
    }
}