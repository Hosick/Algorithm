package programmers.stack_queue;

import java.util.Stack;

public class 탑 {
    class Tower {
        int index;
        int value;

        public Tower(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

    public int[] solution(int[] heights) {
        int[] answer = new int[heights.length];
        Stack<Tower> stack = new Stack<>(); //  각 탑이 들어갈 stack 선언

        for (int i = 0; i < heights.length; ++i) {
            Tower t = new Tower(i + 1, heights[i]); //  i+1번째 탑 만들기

            while (!stack.isEmpty()) {  //  앞에 탑이 있을 때
                Tower top = stack.peek();
                if (top.value > t.value) {  //  앞에 있는 탑이 현재 탑보다 높다면
                    answer[i] = top.index;  //  해당 탑의 인덱스를 넣기
                    break;
                }
                stack.pop();                //  아니라면 pop 후 그 앞에 있는 탑 탐색
            }
            stack.push(t);  //  현재 탑을 stack에 push
        }

        return answer;
    }
}