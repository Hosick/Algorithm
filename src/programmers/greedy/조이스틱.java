package programmers.greedy;

class 조이스틱 {
    public int solution(String name) {
        int answer = 20;

        /*********************** 좌우 이동 ********************************/
        int pass = 0;

        /* 역방향으로 갈 때 건너뛸 수 있는 칸의 수 */
        for (int i = 1; i < name.length(); ++i) {
            if (name.charAt(i) == 'A')
                pass++;
            else break;
        }
        answer = name.length() - 1 - pass;
        pass = 0;
        /* 정방향으로 갈 때 건너뛸 수 있는 칸의 수 */
        for (int i = name.length() - 1; i > 0; --i) {
            if (name.charAt(i) == 'A')
                pass++;
            else break;
        }
        answer = Math.min(answer, name.length() - 1 - pass);

        /* 정방향으로 갔다가 되돌아서 역방향으로 갈 때  */
        int start = 0;
        int end = -1;
        int min = 20;
        for (int i = 2; i < name.length() - 2; ++i) {
            if (name.charAt(i - 1) != 'A' && name.charAt(i) == 'A')
                start = i;
            if (name.charAt(i + 1) != 'A' && name.charAt(i) == 'A') {
                end = i;
                min = Math.min((start - 1) * 2 + (name.length() - 1 - end), min);
            }
        }
        answer = Math.min(answer, min);

        /*********************************** 상하 이동 *********************************/
        int now = 'A';  // A에서 시작
        for (int i = 0; i < name.length(); ++i) {
            char next = name.charAt(i);
            int gab = now > next ? now - next : next - now;     //  위로 이동 vs 아래로 이동
            gab = gab > 13 ? 26 - gab : gab;                    //  중 최소값을 찾기

            answer += gab;
        }

        return answer;
    }
}