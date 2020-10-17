package programmers.bruteForce;

import java.util.*;
import java.util.stream.IntStream;

class 모의고사 {
    public int[] solution(int[] answers) {
        int[] students = new int[3];    //  학생들의 점수 배열

        /* 학생별 반복 구간 List 배열 */
        List<Integer>[] roop = new List[3]; //  반복 구간 배열 선언
        for (int i = 0; i < 3; ++i)
            roop[i] = new ArrayList<>();
        roop[0] = Arrays.asList(1, 2, 3, 4, 5);
        roop[1] = Arrays.asList(2, 1, 2, 3, 2, 4, 2, 5);
        roop[2] = Arrays.asList(3, 3, 1, 1, 2, 2, 4, 4, 5, 5);

        /* 채점하기 */
        for (int i = 0; i < answers.length; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (answers[i] == roop[j].get(i % roop[j].size()))
                    students[j]++;
            }
        }

        /* 최대 점수와 같은 점수의 학생 번호 배열 반환  */
        return IntStream.range(1, 4)
                .filter(i -> students[i - 1] == Arrays.stream(students).max().getAsInt())
                .toArray();
    }
}