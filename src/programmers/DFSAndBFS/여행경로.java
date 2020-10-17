package programmers.DFSAndBFS;

import java.util.*;

class 여행경로 {
    boolean[] used; //  표를 사용했는지 저장하는 boolean 배열
    String[] answer; // 경로 문자열 배열

    public String[] solution(String[][] tickets) {
        used = new boolean[tickets.length];
        answer = new String[tickets.length + 1];

        // 티켓 배열을 도착지 사전순으로 정렬하고 dfs 실행
        Arrays.sort(tickets, Comparator.comparing(t -> t[1]));
        dfs(0, "ICN", tickets);

        return answer;
    }

    /* dfs 경로 찾기 함수 */
    public void dfs(int depth, String now, String[][] tickets) {
        // 경로를 모두 채웠을 때 종료
        if (answer[tickets.length] != null)
            return;

        answer[depth] = now;

        for (int i = 0; i < tickets.length; ++i) {
            if (!used[i] && tickets[i][0].equals(now)) {
                used[i] = true;
                dfs(depth + 1, tickets[i][1], tickets);
                used[i] = false;
            }
        }
    }
}