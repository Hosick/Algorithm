package programmers.stack_queue;

import java.util.Stack;

class 쇠막대기 {
    public int solution(String arrangement) {
        int answer = 0;
        arrangement = arrangement.replace("()", "R");   //  ()를 R(레이저)로 대체
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < arrangement.length(); ++i) {
            char part = arrangement.charAt(i);
            if(part == '(')         //  ( 일 때 스택에 push
                stack.push(part);
            else if (part == 'R')  //   R 일 때 answer에 스택의 size를 더함
                answer += stack.size();
            else {                  //  ) 일 때 스택을 pop하고 answer에 1을 더함
                stack.pop();
                answer += 1;
            }
        }

        return answer;
    }
}
