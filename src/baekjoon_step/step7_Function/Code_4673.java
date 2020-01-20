package baekjoon_step.step7_Function;

public class Code_4673 {
    public static void main(String[] args) {
        int[] nonSelf = new int[10000]; // 셀프 넘버가 아닌 수
        int[] self = new int[10000]; // 셀프 넘버

        for (int i = 1; i < 10000; i++) {
            self[i] = i;
        }

        for (int i = 1; i < 10000; i++) {
            String x = Integer.toString(i);
            int a = 0, b = 0, c = 0, d = 0;

            if (i / 1000 != 0) {
                a = x.charAt(0) - 48;
                b = x.charAt(1) - 48;
                c = x.charAt(2) - 48;
                d = x.charAt(3) - 48;
            } //4자리 숫자일때
            else if (i / 100 != 0) {
                a = x.charAt(0) - 48;
                b = x.charAt(1) - 48;
                c = x.charAt(2) - 48;
            } //3자리 숫자일때
            else if (i / 10 != 0) {
                a = x.charAt(0) - 48;
                b = x.charAt(1) - 48;
            } //2자리 숫자일때
            else a = x.charAt(0) - 48; //1자리 숫자일때

            nonSelf[i] = i + a + b + c + d;
        }

        for (int i = 1; i < 10000; i++) {
            for (int j = 1; j < 10000; j++) {
                if (self[i] == nonSelf[j]) self[i] = 0;
            }
            if (self[i] != 0) System.out.println(self[i]);
        }


    }
}
