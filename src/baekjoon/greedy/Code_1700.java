package baekjoon.greedy;

import java.util.ArrayList;
import java.util.Scanner;

public class Code_1700 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();    //  멀티탭 구멍의 개수
        int k = input.nextInt();    //  전기 용품의 사용 횟수

        int[] order = new int[k]; //  전기 용품 사용 순서
        for (int i = 0; i < k; ++i)
            order[i] = input.nextInt();

        ArrayList<Integer> multitap = new ArrayList();   //  멀티탭 ArrayList 선언

        /* 멀티탭이 꽉찰 때까지 콘센트 꽂기 */
        int idx = 0;    //  사용할 기기의 순서
        while (multitap.size() != n) {
            if (!multitap.contains(order[idx])) {
                multitap.add(order[idx]);
                //System.out.println(order[idx]+"을 꼽았어!!!!!!!!!!!!");
            }
            idx++;
        }

        int cnt = 0;    //  뽑는 횟수
        f : for (int i = idx; i < k; ++i) {
            /* 이미 i번째의 사용기기 콘센트가 꽂혀있다면 continue */
            if (multitap.contains(order[i])) {
                //System.out.println(order[i] +"는 이미 꼽혀있어!!!!!!!!1 ");
                continue;
            }
            /* 꽂혀 있지 않을 때 사용하지 않을 기기 뽑기*/
            for (int j = 0; j < multitap.size(); ++j) { //  멀티탭에 꽂혀있는 기기 번호 하나씩
                boolean use = false;
                for (int l = i + 1; l < k; ++l) {     //  남은 스케쥴의 기기 번호
                    if (multitap.get(j) == order[l]) {    //  남은 스케쥴에서 사용한다면
                        use = true;
                        break;
                    }
                }
                if(use == false){
                    //System.out.println(multitap.get(j)+"뽑고 "+order[i]+"꼽기!!!!!!!");
                    multitap.set(j, order[i]);
                    cnt++;
                    continue f;
                }
            }

            /* 꽂혀 있지 않다면 현재 꽂혀있는 기기 중 가장 늦게 사용하는 기기의 콘센트를 뽑기 */
            p : for (int j = k - 1; k > idx; --k) {
                if(multitap.contains(order[j])){
                    for (int l = 0; l < multitap.size(); ++l){
                        if (multitap.get(l) == order[j]){
                            multitap.set(l, order[i]);
                            cnt++;
                            break p;
                        }
                    }
                }
            }
        }

        System.out.println(cnt);
    }
}
