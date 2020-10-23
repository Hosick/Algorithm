package programmers.number;

import java.util.Arrays;

public class 폰켓몬 {
    public int solution(int[] nums) {
        int get = nums.length / 2;
        int kind = (int) Arrays.stream(nums)
                .distinct()
                .count();

        return Math.min(get, kind);
    }
}
