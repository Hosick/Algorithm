package baekjoon.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class Code_1049 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int cutStrings = input.nextInt();       //  끊어진 기타줄 수
        int brands = input.nextInt();           //  기타줄 브랜드의 수
        int[] setPrice = new int[brands];       //  기타줄 세트 가격
        int[] piecePrice = new int[brands];     //  기타줄 낱개 가격

        int necessarySet = cutStrings / 6;      //  세트로 살 경우 필요한 세트 수
        int necessaryPiece = cutStrings % 6;    //  세트로 살 경우 남게되는 낱게 기타줄 수

        for (int i = 0; i < brands; ++i) {          //  각 브랜드의 기타줄 세트와 낱개 가격 입력
            setPrice[i] = input.nextInt();
            piecePrice[i] = input.nextInt();
        }
        Arrays.sort(setPrice);       //  기타줄 세트 가격 정렬
        Arrays.sort(piecePrice);     //  기타줄 낱개 가격 정렬

        if (piecePrice[0] * 6 <= setPrice[0]) {     //  낱개가 세트보다 저렴할 때
            System.out.println(piecePrice[0] * cutStrings); //  전부 낱개 구매
        } else if (piecePrice[0] * 6 > setPrice[0] && piecePrice[0] * necessaryPiece <= setPrice[0])    //  세트 구매가 저렴하지만 나머지 낱개로 구입하는 것이 1세트 보다는 저렴할 때
            System.out.println(setPrice[0] * necessarySet + piecePrice[0] * necessaryPiece);            //  세트 구입 + 낱개 구입
        else                                                //세트 구매가 저렴하며,또한 나머지 낱개 구입보다 세트 구입이 저렴할 경우
            System.out.println(setPrice[0] * ++necessarySet);   //  전부 세트 구매
    }
}