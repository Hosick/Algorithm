package baekjoon.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Code_1135 {
    static ArrayList<Employee>[] list;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        /* ArrayList 배열 list 를 선언, 상사 배열에 부하 넣기 */
        int n = input.nextInt();
        list = new ArrayList[n];
        for (int i = 0; i <n ;++i)
            list[i] = new ArrayList<>();
        int boss = input.nextInt();
        for (int i = 1; i < n ; ++i){
            boss = input.nextInt();
            list[boss].add(new Employee(0, i));
        }

        /* dfs 함수 호출 및 반환값 출력 */
        System.out.println(dfs(0));
    }

    /* dfs로 최소시간 구하기 함수 */
    static int dfs(int idx){
        int ans = 0;
        /* 재귀를 이용하여 서브트리의 소요시간 구해서 넣기 */
        for (int i = 0; i < list[idx].size(); ++i){
            int next = list[idx].get(i).number;
            list[idx].get(i).time = 1 + dfs(next);
        }

        Collections.sort(list[idx]); // 오래 걸리는 순으로 정렬

        /* 오래 걸리는 순으로 전화 순서(i++)를 더한다 */
        /* (이걸 안해서 틀렸었음) */
        for (int i = 0; i < list[idx].size(); ++i){
            list[idx].get(i).time += i;
            ans = Math.max(ans, list[idx].get(i).time);
        }
        return ans;
    }
}

/* 사원 class 정의 */
class Employee implements Comparable<Employee>{
    int time;   //  소요 시간
    int number; //  사원 번호

    public Employee(int time, int number){
        this.time = time;
        this.number = number;
    }

    /* 걸리는 시간 내림차순 */
    @Override
    public int compareTo(Employee o) {
        return o.time - time;
    }
}
