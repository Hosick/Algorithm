package baekjoon_step.step2_If;

import java.util.Scanner;

public class Code_14681 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int x = input.nextInt();
        int y = input.nextInt();
        int quadrant = 0;

        if(x>0 && y>0)
            quadrant = 1;
        else if(x<0 && y>0)
            quadrant = 2;
        else if(x<0 && y<0)
            quadrant = 3;
        else
            quadrant = 4;

        System.out.print(quadrant);
    }
}
