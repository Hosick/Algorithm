package programmers.greedy;

class 점프와_순간_이동 {
    public int solution(int n) {
        int answer = 1;
        while (n != 1) {
            answer += n % 2;
            n = n / 2;
        }
        return answer;
    }
}