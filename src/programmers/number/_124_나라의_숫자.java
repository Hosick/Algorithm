package programmers.number;

class _124_나라의_숫자 {
    public String solution(int n) {
        StringBuilder answer = new StringBuilder();

        /* 3진법 변환과 비슷 */
        /* 다른 점은 나머지로 0이 나올 때 4로 바꾸고 몫에서 1을 뺀다 */
        while (n > 0) {
            int mod = (n % 3 == 0) ? 4 : n % 3;
            answer.insert(0, mod);
            n = (mod == 4) ? n / 3 - 1 : n / 3;
        }

        return answer.toString();
    }
}
