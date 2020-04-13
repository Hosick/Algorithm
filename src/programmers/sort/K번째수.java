package programmers.sort;

import java.util.Arrays;

class K번째수 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; ++i) {
            int[] tArr = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]); //  array 배열의 부분을 복사
            Arrays.sort(tArr);  //  복사한 배열을 정렬
            answer[i] = tArr[commands[i][2] - 1];   //  정해진 순서의 값을 answer에 넣기
        }
        return answer;
    }
}
