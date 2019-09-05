package step1;

import java.util.Scanner;

public class Code_11719 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[] a = new String[100];

        for (int i = 0; i < 100; i++) {
            a[i] = input.nextLine();
            if (a[i].length() > 100) {
                a[i] = null;
                break;
            }
        }
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] != null)
                System.out.println(a[i]);
        }
    }
}
