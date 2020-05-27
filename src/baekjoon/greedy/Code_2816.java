/**
 * 풀고나서 알았지만 버튼을 최소한만 누를 필요는 없는 문제였다
 * 이 사실을 몰라서 아래의 내용들은 버튼을 최소한만(아마도) 사용하도록 코딩하였다
 * 1. 우선 1번 채널이 맞춰지지 않았다면 다음채널이 KBS1일때까지 버튼3
 * 2. 버튼3을 한번 더 호출하고, 1번 채널이 맞춰지지 않았을 때 버튼2 (만약 3번버튼으로만 채널1이 맞춰지면 버튼2가 필요없기 때문)
 * 3. now 가 2일 때까지 버튼 1을 사용
 * 4. 1~2번과정을 2로 수정하여서 한번더
 **/

package baekjoon.greedy;

import java.util.Scanner;

public class Code_2816 {
    static String[] c;  //  채널 배열 (1~n)
    static int now = 1; //  현재 화살표가 있는 채널 번호
    static String temp; //  swap 에 쓸 temp
    static int n = 0;   //  채널 개수

    /* 1번버튼 : 채널 올리기 */
    static void button1() {
        now++;
        System.out.print(1);
    }

    /* 2번버튼 : 채널 내리기 */
    static void button2() {
        now--;
        System.out.print(2);
    }

    /* 3번버튼 : 다음 채널과 swap */
    static void button3() {
        temp = c[now];
        c[now] = c[now + 1];
        c[now + 1] = temp;
        now++;
        System.out.print(3);
    }

    /* 4번버튼 : 이전 채널과 swap */
    static void button4() {
        temp = c[now];
        c[now] = c[now - 1];
        c[now - 1] = temp;
        now--;
        System.out.print(4);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        /* 채널 개수와 채널 입력 */
        int n = input.nextInt();
        c = new String[n + 1];
        for (int i = 1; i <= n; ++i)
            c[i] = input.next();

        /* KBS1을 1번채널로 만들기 */
        if (!c[1].equals("KBS1")) { //  현재는 1번이 아닐때만
            /* 다음 채널이 KBS1일 때까지(그 다음 한번 더) 버튼3(다음채널 스왑) */
            while (!c[now + 1].equals("KBS1")) {
                button3();
            }
            button3();

            /* KBS1이 1번채널이 아니라면 버튼2로 now를 KBS1에 맞추기  */
            if (!c[1].equals("KBS1")) {
                button2();
            }
            /* KBS1이 1번채널이 될때까지 버튼4(이전채널 스왑) */
            while (!c[1].equals("KBS1")) {
                button4();
            }
        }

        /* KBS2를 2번 채널로 만들기 */
        if (!c[2].equals("KBS2")) { // 현재는 2번이 아닐때만
            /* now 를 2로 맞추기 */
            while (now != 2) {
                button1();
            }
            /* 1번 채널 맞추기와 같음 */
            while (!c[now + 1].equals("KBS2")) {
                button3();
            }
            button3();
            if (!c[2].equals("KBS2")) {
                button2();
            }
            while (!c[2].equals("KBS2")) {
                button4();
            }
        }
    }
}