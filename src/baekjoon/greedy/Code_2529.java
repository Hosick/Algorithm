package baekjoon.greedy;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Code_2529 {
    static int k;       //  부등호 개수
    static char[] ineq; //  부등호 배열
    static boolean[] visit = new boolean[10];   //  방문 배열
    static ArrayList<String> list = new ArrayList<String>(); //  길이가 k이고 부등호 순서에 맞는 문자열 List

    /* 백트래킹(dfs)를 이용해서 조건에 맞는 문자 수열 만들어서 list에 넣기 */
    static void dfs(int value, int deep, String str) {
        /* 길이가 k인 str을 완성시켰으므로 list에 넣기 */
        if (deep == k) {
            list.add(str);
        }
        /* 백트래킹(재귀)을 이용해 적절한값 넣어나가기 */
        else {
            for (int i = 0; i <= 9; ++i) {  //  다음에 들어갈 수 i찾기
                if (!visit[i]) {    //  이미 사용하지 않은 수만 가능
                    if (ineq[deep] == '<' && i <= value)    // value와 i사이의 부등호가 '<'일 때 i <= value라면 넘기기
                        continue;
                    else if (ineq[deep] == '>' && i >= value)   // value와 i사이의 부등호가 '>'일 때 i >= value라면 넘기기
                        continue;
                    /* 조건에 맞다면 재귀해서 다음 숫자찾기 */
                    visit[i] = true;
                    dfs(i, deep + 1, str + i);
                }
            }
        }
        visit[value] = false;   //  돌아올 때 방문기록 지우기
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        k = Integer.parseInt(br.readLine());    //  부등호 개수 입력

        /* 부등호 순서대로 입력 후 배열에 저장 */
        ineq = new char[k];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; ++i)
            ineq[i] = st.nextToken().charAt(0);
        br.close();

        /* dfs 함수를 통하여 조건에 맞는 문자열들 list에 넣기 */
        for (int i = 0; i <= 9; i++) {
            visit[i] = true;
            dfs(i, 0, i + "");
        }

        System.out.println(list.get(list.size() - 1));
        System.out.println(list.get(0));
    }
}