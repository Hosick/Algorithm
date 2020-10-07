package programmers.collection_season_1;

import java.util.Set;
import java.util.TreeSet;

public class 두_개_뽑아서_더하기 {
    public int[] solution(int[] numbers) {
        Set<Integer> set = new TreeSet<>(); //  자동 정렬 해주는 HashSet 선언

        for (int i = 0; i < numbers.length - 1; ++i) {
            for (int j = i + 1; j < numbers.length; ++j) {
                set.add(numbers[i] + numbers[j]);
            }
        }

        int[] answer = new int[set.size()];
        int index = 0;
        for (int n : set) {
            answer[index++] = n;
        }

        return answer;
    }
}