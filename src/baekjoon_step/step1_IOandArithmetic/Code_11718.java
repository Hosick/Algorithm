package step1;

import java.util.Scanner;

public class Code_11718 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[] a = new String[100];

        for (int i = 0; i < 100; i++) {
            a[i] = input.nextLine();
            if (a[i].length() > 100 || a[i].length() == 0 || a[i].charAt(0) == ' ' || a[i].charAt(a[i].length() - 1) == ' ') {
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
