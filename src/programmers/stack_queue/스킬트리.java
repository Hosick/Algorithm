package programmers.stack_queue;

import java.util.Stack;

class 스킬트리 {
    public int solution(String skill, String[] skill_trees) {
        int answer = skill_trees.length;
        Stack<Character> stack;

        for (int i = 0; i < skill_trees.length; ++i) {
            /* 스택 초기화 */
            stack = new Stack<>();
            for (int j = skill.length() - 1; j >= 0; --j) {
                stack.add(skill.charAt(j));
            }

            for (int j = 0; j < skill_trees[i].length(); ++j) {
                char now = skill_trees[i].charAt(j);
                if (stack.contains(now) && stack.pop() != now) {
                    answer--;
                    break;
                }
            }
        }

        return answer;
    }
}
