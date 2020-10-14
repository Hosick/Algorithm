package programmers.DFSAndBFS;

class 단어_변환 {
    boolean[] visited;
    int answer = 11;

    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];

        /* words 배열에서 begin, target 있는지 검사 */
        boolean isPossible = false;
        for (int i = 0; i < words.length; ++i) {
            visited[i] = (words[i].equals(begin)) ? true : false; // begin 으로 되돌아 올 필요는 없음
            isPossible = (words[i].equals(target)) ? true : isPossible; // target 이 없으면 안된다.
        }
        if (!isPossible)
            return 0;

        // dfs 이용해서 최소값 반환
        dfs(begin, target, words, 0);
        return (answer == 11) ? 0 : answer;
    }

    /* 재귀를 이용해서 target 을 찾아가는 dfs 함수 */
    public void dfs(String now, String target, String[] words, int depth) {
        // target 에 도달 했을 때
        if (now.equals(target))
            answer = (answer > depth) ? depth : answer;

        for (int i = 0; i < words.length; ++i) {
            if (!visited[i] && isChangeable(now, words[i])) {
                visited[i] = true;
                dfs(words[i], target, words, depth + 1);
                visited[i] = false;
            }
        }
    }

    /* 두 문자열이 인접한지 반환하는 함수 (알파벳 하나 차이인지) */
    public boolean isChangeable(String s1, String s2) {
        int count = 0;
        for (int i = 0; i < s1.length(); ++i) {
            if (s1.charAt(i) != s2.charAt(i))
                count++;
        }

        return (count == 1) ? true : false;
    }
}