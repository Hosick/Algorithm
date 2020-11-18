package programmers.math;

class 행렬의_곱셈 {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int arr1Height = arr1.length;
        int arr1Width = arr1[0].length;
        int arr2Width = arr2[0].length;
        int[][] answer = new int[arr1Height][arr2Width];

        for (int i = 0; i < arr1Height; ++i) {
            for (int j = 0; j < arr2Width; ++j) {
                for (int k = 0; k < arr1Width; ++k) {
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }

        return answer;
    }
}