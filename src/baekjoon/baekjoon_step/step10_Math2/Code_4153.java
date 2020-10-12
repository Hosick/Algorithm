package baekjoon.baekjoon_step.step10_Math2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Code_4153 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        ArrayList<Integer> array = new ArrayList();  //  정렬용 ArrayList

        while (true) {
            for (int i = 0; i < 3; ++i) //  세변의 길이 입력
                array.add(input.nextInt());

            if (array.get(0) == 0 && array.get(1) == 0 && array.get(2) == 0)    //  반복 종료 조건
                return;

            Collections.sort(array);    //  제일 긴 변 찾기

            if (array.get(2) * array.get(2) == array.get(0) * array.get(0) + array.get(1) * array.get(1))   //  피타고라스 정리로 직각 검사
                System.out.println("right");
            else
                System.out.println("wrong");
            array.clear();  //  array 초기화
        }
    }
}
