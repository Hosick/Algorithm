package baekjoon.greedy;

import java.util.Scanner;

public class Code_1969 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();   //  입력할 DNA의 갯수
        int cipher = input.nextInt();   //  입력할 DNA의 자릿수
        String[] dna = new String[number];
        for (int i = 0; i < number; ++i) {
            dna[i] = input.next();      //  DNA 입력
        }

        String minDNA = "";             //  Hamming Distance의 합이 가장 작은 DNA
        int hammingDistanceSum = 0;     //  Hamming Distance의 합

        for (int i = 0; i < cipher; ++i) {        //  첫번째 자리부터 마지막 자리까지
            int[] nucle = new int[4];       //  i번째 자리의 뉴클레오타이드의 갯수를 저장하는 배열 초기화
            for (int j = 0; j < number; ++j) {    //  DNA 들을 하나씩 검사
                switch (dna[j].charAt(i)) {  //  j번째 dna의 i번째 자릿수를 배열에 저장
                    case 'A':
                        ++nucle[0];
                        break;
                    case 'C':
                        ++nucle[1];
                        break;
                    case 'G':
                        ++nucle[2];
                        break;
                    case 'T':
                        ++nucle[3];
                        break;
                }
            }
            int max = 0;    //  i번째 자릿수에 가장 많은 뉴클레오타이드 번호
            for (int k = 0; k < 4; ++k) {          //  i번째 자리의 최대 뉴클레오타이드 찾기
                if (nucle[k] > max)
                    max = nucle[k];
            }
            hammingDistanceSum += (number - max); //  i번째 자리의 Hamming Distance의 합
            if (max == nucle[0]) {
                minDNA += "A";
            } else if (max == nucle[1]) {
                minDNA += "C";
            } else if (max == nucle[2]) {
                minDNA += "G";
            } else if (max == nucle[3]) {
                minDNA += "T";
            }
        }
        System.out.println(minDNA);
        System.out.println(hammingDistanceSum);
    }
}