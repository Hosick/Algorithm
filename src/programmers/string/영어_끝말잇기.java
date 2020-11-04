package programmers.string;

import java.util.HashSet;
import java.util.Set;

class 영어_끝말잇기 {
    public int[] solution(int n, String[] words) {
        char preLast = words[0].charAt(0);
        Set<String> set = new HashSet<>();

        for (int i = 0; i < words.length; ++i) {
            //  마지막 사람이 말한 단어의 마지막 문자로 시작하는지
            //  이미 나온 단어가 아닌지
            //  한 글자인 단어가 아닌지
            if (preLast != words[i].charAt(0) || set.contains(words[i]) || words[i].length() == 1)
                return new int[]{i % n + 1, i / n + 1};

            preLast = words[i].charAt(words[i].length() - 1);
            set.add(words[i]);
        }
        return new int[]{0, 0};
    }
}