package programmers.bruteForce;

import java.util.*;
import java.util.stream.IntStream;

class 소수_찾기 {
    Set<Integer> comb = new HashSet<>();    //  가능한 조합들을 중복없이 저장할 HashSet

    public int solution(String numbers) {
        /* 문자열로 받은 종이를 종이 조각 int 배열로 매핑 */
        int[] piece = IntStream.rangeClosed(0, numbers.length() - 1)
                .map(i -> numbers.charAt(i) - '0')
                .toArray();

        // dfs 함수를 이용해 가능한 종이조각 조합을 찾아서 set 에 넣기
        boolean[] visited = new boolean[piece.length];
        for (int i = 0; i < piece.length; ++i) {
            visited[i] = true;
            findComb(piece[i], piece, visited);
            visited[i] = false;
        }

        // 조합 중 소수의 개수 반환
        return (int) comb.stream()
                .filter(this::isPrime)
                .count();
    }

    /* 조합 찾기 dfs 함수 */
    public void findComb(int result, int[] piece, boolean[] visited) {
        comb.add(result);
        for (int i = 0; i < piece.length; ++i) {
            if (!visited[i]) {
                visited[i] = true;
                findComb(result * 10 + piece[i], piece, visited);
                visited[i] = false;
            }
        }
    }

    /* 소수 Predicate */
    public Boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= (int) Math.sqrt(n); ++i)
            if (n % i == 0) return false;
        return true;
    }
}