package baekjoon.greedy;

import java.util.*;

public class Code_1398 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        ArrayList<Long> coin = new ArrayList<>();   //  동전 배열
        long maxPrice = (long) Math.pow(10, 15);    //  차의 최대 가격

        /* 동전 배열 채우고 정렬 */
        long i = 1;
        while (i <= maxPrice) {
            coin.add(i);
            i *= 10;
        }
        i = 25;
        while (i <= maxPrice) {
            coin.add(i);
            i *= 100;
        }
        Collections.sort(coin);

        int t = input.nextInt();
        while (t-- > 0) {
            int count = 0;
            long price = input.nextLong();

            int idx = coin.size() - 1;
            while (price > 0) {
                if (price >= coin.get(idx)) {
                    long now = coin.get(idx);
                    count += price / now;
                    price %= now;

                    if (idx > 1 && coin.get(idx - 1) * 3 > now && price >= coin.get(idx - 1) * 3 - now && ) {
                        count += 2;
                        price -= coin.get(idx - 1) * 3 - now;
                    }
                }
                idx--;
            }

            System.out.println(count);
        }
    }
}