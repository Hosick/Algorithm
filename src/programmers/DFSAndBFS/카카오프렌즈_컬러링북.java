package programmers.DFSAndBFS;

class 카카오프렌즈_컬러링북 {
    boolean[][] visited;

    public int[] solution(int m, int n, int[][] picture) {
        int[] answer = new int[2];
        visited = new boolean[m][n];

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (picture[i][j] != 0 && !visited[i][j]) {
                    answer[1] = Math.max(dfs(i, j, picture), answer[1]);
                    answer[0]++;
                }
            }
        }

        return answer;
    }

    public int dfs(int i, int j, int[][] picture) {
        visited[i][j] = true;
        int sum = 1;
        int now = picture[i][j];
        // 하단 이동
        if (i + 1 < picture.length && picture[i + 1][j] == now && !visited[i + 1][j])
            sum += dfs(i + 1, j, picture);
        // 상단 이동
        if (i - 1 >= 0 && picture[i - 1][j] == now && !visited[i - 1][j])
            sum += dfs(i - 1, j, picture);
        // 우측 이동
        if (j + 1 < picture[0].length && picture[i][j + 1] == now && !visited[i][j + 1])
            sum += dfs(i, j + 1, picture);
        // 좌측 이동
        if (j - 1 >= 0 && picture[i][j - 1] == now && !visited[i][j - 1])
            sum += dfs(i, j - 1, picture);
        return sum;
    }
}