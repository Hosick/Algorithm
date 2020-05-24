package baekjoon.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Code_9576 {
    static ArrayList<Integer>[] student;    //  학생이 원하는책 ArrayList 배열
    static boolean[] check;                 //  책을 이미 검사했는지 배열
    static int[] book;                      //  할당된 학생을 가르키는 책 배열
    static int ans;                         //  책이 할당된 학생 수

    /* dfs를 이용하여 이분 매칭해주는 함수 */
    static boolean dfs(int x) {
        for (int i = 0; i < student[x].size(); ++i) {   //  학생 x가 원하는책 i 하나씩 검사
            int tmp = student[x].get(i);    //  학생의 원하는 책 번호

            /* 이미 검사한 책들을 재검사하지 않게 하기위해 continue */
            /* 만약 check를 쓰지않는다면 재귀하는 과정에서 자기자신을 무한 재할당하려하기 때문에 스택오버플로우가 발생한다 */
            if (check[tmp])
                continue;
            check[tmp] = true;

            if (book[tmp] == 0 || dfs(book[tmp])) {   //  책이 아직 할당되지 않았거나 || 책의 원래 주인이 다른 책을 찾는다면
                book[tmp] = x;  //  책을 학생 x에게 할당(또는 재할당)
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int t = input.nextInt();    //  테스트 케이스 개수
        while (t-- > 0) {
            ans = 0;
            int n = input.nextInt();    //  책의 개수
            int m = input.nextInt();    //  학생 수

            student = new ArrayList[m + 1];
            check = new boolean[n + 1];
            book = new int[n + 1];

            /* 학생이 원하는 책 범위를 전부 add */
            int start, end;
            for (int i = 1; i <= m; ++i) {
                student[i] = new ArrayList<>();
                start = input.nextInt();
                end = input.nextInt();
                for (int j = start; j <= end; ++j) {
                    student[i].add(j);
                }
            }

            /* 이분 매칭을 이용한 책 할당 */
            for (int i = 1; i <= m; ++i) {
                Arrays.fill(check, false);
                if (dfs(i))
                    ans++;
            }

            System.out.println(ans);
        }
    }
}
