package baekjoon_step.step9_Math2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Code_1085 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int x = input.nextInt();
        int y = input.nextInt();
        int w = input.nextInt();
        int h = input.nextInt();

        ArrayList arrayList = new ArrayList();
        arrayList.add(x);   //  좌표에서 왼쪽 끝까지 거리
        arrayList.add(y);   //  좌표에서 위쪽 끝까지 거리
        arrayList.add(w-x); //  좌표에서 오른쪽 끝까지 거리
        arrayList.add(h-y); //  좌표에서 아래쪽 끝까지 거리

        Collections.sort(arrayList);    //  정렬
        System.out.print(arrayList.get(0)); //  최소값 출력
    }
}
