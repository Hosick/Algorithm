package baekjoon.baekjoon_step.step5_Training1;

import java.util.Scanner;

public class Code_10039 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] score = new int[5];
        int scoreSum = 0;

        for (int i = 0; i < 5; i++) {
            score[i] = input.nextInt();
            if (score[i] < 40) score[i] = 40;
            scoreSum += score[i];
        }
        System.out.println(scoreSum / 5);
    }
}