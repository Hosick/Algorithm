package baekjoon.greedy;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Code_1826 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int ans = 0;
        int n = input.nextInt();    //  주유소 개수
        Queue<Station> pq = new PriorityQueue<>();  //  주유소들을 담을 pq 배열(거리 오름차순)

        /* 주유소 정보 입력 */
        int sumFuel = 0;
        for (int i = 0; i < n; ++i) {
            int l = input.nextInt();
            int f = input.nextInt();
            pq.add(new Station(l, f));

            sumFuel += f;
        }

        int l = input.nextInt();    //  목적지의 위치
        int p = input.nextInt();    //  기존에 있던 연료의 양
        sumFuel += p;

        /* 연료를 다합쳐서 목적지에 못간다면 -1 출력 후 return */
        if (sumFuel < l) {
            System.out.println(-1);
            return;
        }

        int currentLocation = 0;    //  갈 수 있는 가장 먼 주유소의 위치
        int reachableLocation = p;  //  현재 연료로 갈수 있는 위치
        int currentPetrol = p;      //  현재 연료
        Queue<Station> pq2 = new PriorityQueue<>((o1, o2) -> o2.fuel - o1.fuel);    //  연료 내림차순 pq

        /* 목적지에 갈수 있을 때 까지 */
        Station next;
        while (reachableLocation < l){
            /* 현재 연로로 갈 수 있는 정류장을 pq 에서 pq2로 옮기기 추가 */
            while (!pq.isEmpty() && pq.peek().location <= reachableLocation)
                pq2.add(pq.remove());

            /* 더 이상 갈수있는 주유소가 없다면 -1 출력 후 return */
            if (pq2.isEmpty()){
                System.out.println(-1);
                return;
            }

            next = pq2.remove();
            ans ++;

            if(next.location < currentLocation){
                reachableLocation += next.fuel;
                currentPetrol += next.fuel;
            }
            else {
                int usedFuel = next.location-currentLocation;
                currentLocation = next.location;
                currentPetrol = currentPetrol + next.fuel - usedFuel;
                reachableLocation = currentLocation+currentPetrol;
            }

        }

        System.out.println(ans);
    }
}

/* 주유소 클래스 */
class Station implements Comparable<Station> {
    int location;   //  주유소의 위치
    int fuel;       //  주유소의 연료 양

    public Station(int l, int f) {
        location = l;
        fuel = f;
    }

    @Override
    public int compareTo(Station o) {
        return this.location - o.location;
    }
}
