package programmers.DFSAndBFS;

public class 타겟_넘버 {
    public int solution(int[] numbers, int target) {
        return findTarget(numbers, target, 0, 0);
    }

    public int findTarget(int[] numbers, int target, int depth, int result) {
        if (depth == numbers.length)
            return (result == target) ? 1 : 0;

        return findTarget(numbers, target, depth + 1, result + numbers[depth])
                + findTarget(numbers, target, depth + 1, result - numbers[depth]);
    }
}