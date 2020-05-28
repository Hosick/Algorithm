/**
 처음에는 박스를 하나씩 무거운 크레인 순으로 list에서 지워나가는 방법을 사용하였지만 시간초과가 나서 다시 풀었다.
 다시 푼 방법은 우선 크레인을 정렬하고 크레인마다 자신이 들수있는 박스의 개수를 저장하는 possible 배열을 선언하고 채운다
 크레인이 작동할 때에는 자신의 possible의 수를 줄여나가는데 0이 되었다면 하위크레인의 수를 줄여준다.
 **/

package baekjoon.greedy;

import java.util.*;

public class Code_1092 {
    static int n, m;

    /* 배열이 비어있는지 검사하여 부울린을 반환하는 함수 */
    static boolean isEmpty(int[] arr){
        for (int i = 0; i < n; ++i)
            if (arr[i] > 0)
                return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        /* 크레인 개수 및 최대 무게 입력 후 정렬 */
        n = input.nextInt();            //  크레인 개수
        Integer[] crane = new Integer[n];   //  크레인이 나를 수 있는 최대무게 배열
        for (int i = 0; i < n; ++i)
            crane[i] = input.nextInt();
        Arrays.sort(crane);

        /* 크레인 별 나를 수 있는 박스의 개수 구하기 */
        m = input.nextInt();
        int[] possible = new int[n];        //  크레인이 나를 수 있는 박스의 개수
        for (int i = 0; i < m; ++i) {
            int weight = input.nextInt();
            for (int j = 0; j < n; ++j) {
                if (weight <= crane[j]) {
                    possible[j]++;
                    break;
                }
                if (j == n - 1) {               //  나를 수 없는 박스가 있다면 -1 출력 후 return
                    System.out.println(-1);
                    return;
                }
            }
        }

        /* 박스 나르기 */
        int ans = 0;
        int idx;
        while (!isEmpty(possible)) { //  나를 박스가 없을 때까지
            ans++;                   //  이동횟수++
            for (int i = n - 1; i >= 0; --i) {      //  가장 무거운 크레인부터
                idx = i;
                /* 자신만 들수있는 박스 위주로 (아니라면 더 낮은 크라인 도와주기) */
                while (idx > 0 && possible[idx] == 0) {
                    idx--;
                }
                if (possible[idx] > 0) {
                    possible[idx]--;
                }
            }
        }

        System.out.println(ans);
    }
}
