package baekjoon_step.step20_Stack;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Code_1874 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();

        Stack<Integer> stack = new Stack<>();

        /* 수열 입력 */
        int[] num = new int[n];
        for (int i = 0; i < n; ++i) {
            num[i] = input.nextInt();
        }

        /* 1-n까지 수열 넣고 꺼내기 */
        int temp = 1;
        ArrayList<Character> sign = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            while (temp <= num[i]) {    //  i번째 num까지 push
                stack.push(temp++);
                sign.add('+');
            }
            if (stack.peek() == num[i]) { //  스택의 top이 i번째 num이라면 pop
                stack.pop();
                sign.add('-');
            }
        }

        if (sign.size() == n * 2)   //  push와 pop이 각각 n번 이루어 졌다면 부호 출력
            for (char i : sign)
                System.out.println(i);
        else System.out.print("NO");//  아니라면 NO 출력
    }
}