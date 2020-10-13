package programmers.DFSAndBFS;

class 네트워크 {
    boolean[] visit;    //  방문 여부 배열

    public int solution(int n, int[][] computers) {
        visit = new boolean[n];
        int answer = 0;

        for (int i = 0; i < n; ++i) {
            if (!visit[i]) {    //  아직 연결된 네트워크가 없을 때만
                dfs(computers, i);
                answer++;
            }
        }
        return answer;
    }

    public void dfs(int[][] computers, int idx) {
        visit[idx] = true;
        for (int i = 0; i < computers[idx].length; ++i) {
            if (computers[idx][i] == 1 && !visit[i])    //  idx 번 컴퓨터와 연결되어 있으면서 방문한 적 없는 컴퓨터만
                dfs(computers, i);
        }
    }
}