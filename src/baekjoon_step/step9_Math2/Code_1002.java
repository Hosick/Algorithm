package baekjoon_step.step9_Math2;

import java.util.Scanner;

public class Code_1002 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int t = input.nextInt();    //  테스트 케이스 갯수

        for (int i = 0; i < t; ++i) {
            int x1 = input.nextInt();
            int y1 = input.nextInt();
            int r1 = input.nextInt();
            int x2 = input.nextInt();
            int y2 = input.nextInt();
            int r2 = input.nextInt();
            System.out.println(calc(x1, y1, r1, x2, y2, r2));
        }
    }

    private static int calc(int x1, int y1, int r1, int x2, int y2, int r2) {
        double distance = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));  //  터렛 사이의 걸이

        /*두 원이 겹칠 때*/
        if (x1 == x2 && y1 == y2 && r1 == r2) return -1;
        /*두 원이 너무 멀 때 */ /*두 원의 중심이 같지만 반지름이 다를 때*/ /*한 원안에 다른 원이 들어가있고 접하지않을 때*/
        else if (distance > r1 + r2 || (x1 == x2 && y1 == y2 && r1 != r2) || distance < Math.abs(r1 - r2)) return 0;
        /*e두 원이 서로 바깥에 있고 한점에서 만날 때*/ /*한 원 안에 다른 원이 들어가있고 한점에서 접할 때*/
        else if (distance == r1 + r2 || distance == Math.abs(r1 - r2)) return 1;
        /*두 원이 두개의 접점을 가질 때*/
        else return 2;
    }
}
