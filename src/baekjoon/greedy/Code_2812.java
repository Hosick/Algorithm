/**
 * 맨 처음에는 문자열의 앞에서부터 k만큼 잘라서 가장 큰 값 앞을 버리는 방법을 사용했다.
 * 하지만 이렇게하면 시간복잡도가 O(n^2)이 나와서 시간초과에 걸렸다.
 * Stack, Deque, (현재 인덱스를 저장하는)배열 등을 사용하면 O(n)으로 해결이 가능했다.
 **/
package baekjoon.greedy;

import java.util.Scanner;
import java.util.Stack;

public class Code_2812 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();    //  숫자의 자리 수
        int k = input.nextInt();    //  지울 자리 수
        char value;                 //  자리의 값
        Stack<Character> stack = new Stack<>(); //  한 자리씩 value 를 넣을 스택 선언

        /* 문자열 입력받고 앞에서부터 하나씩 stack 에 넣기 */
        String str = input.next();
        for (int i = 0; i < n; ++i) {
            value = str.charAt(i);
            /* 지울 자리가 남았고, stack 의 top 이 넣을 값보다 작을 때 top 의 값 지우기 */
            while (k > 0 && !stack.isEmpty() && stack.peek() < value) {
                stack.pop();
                k--;
            }
            stack.push(value);
        }

        /* 스택의 인덱스 0부터 (stack 의 크기 - k) 미만까지 출력 출력 */
        int last = stack.size() - k;
        for (int i = 0; i < last; ++i)     //  마지막에 남은 k 만큼은 빼고 출력
            System.out.print(stack.get(i));
        System.out.println();
    }
}