package programmers.stack_queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class 프린터 {
    public int solution(int[] priorities, int location) {
        int answer = 0;                                 //  꺼낸 문서의 개수
        int l = location;                               //  선택한 문서의 인덱스

        Queue<Integer> q = new LinkedList<Integer>();   //  문서를 가지고 있는 프린터를 큐로 선언
        for(int i : priorities){                        //  중요도를 모두 add
            q.add(i);
        }

        Arrays.sort(priorities);                        //  문서 중요도 배열 정렬
        int size = priorities.length-1;                 //  아직 인쇄를 시작하지 않았을 때 문서의 개수

        /* 인쇄 */
        while(!q.isEmpty()){                            //  큐가 비어있지 않을 때 까지
            Integer i = q.poll();                       //  일단 가장 앞에 있는 문서 꺼내기

            if(i == priorities[size - answer]){         //  꺼낸 문서가 가장 큰 문서라면
                answer++;                               //  꺼낸 문서++
                l--;                                    //  선택한 인덱스 땡기기
                if(l <0)                                //  l이 0보다 작다면 모두 꺼낸 것
                    break;
            }else{                                      //  꺼낸 문서가 가장 큰 문서가 아니라면
                q.add(i);                               //  문서 다시 맨뒤에 넣기
                l--;                                    //  선택한 인덱스 땡기기
                if(l<0)                                 //  맨 앞이었다면
                    l=q.size()-1;                       //  맨 뒤로 보내기
            }
        }

        return answer;
    }
}