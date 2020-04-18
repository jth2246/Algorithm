package Programmers.stackQueue;

import java.util.*;

public class Printer {
    public static void main(String[] args){
        int[] arr = {2,1,3,2};
        System.out.println(solution(arr,1));
    }

    public static int solution(int[] priorities, int location) {
        int answer = 0;
        int priorMaxIndex = priorities.length;
        ArrayDeque<Integer> que = new ArrayDeque<>(); // printer 목록을 que로 표현
        for( int i = 0; i < priorities.length; i++){
            que.add(priorities[i]);
        }

        Arrays.sort(priorities); // 우선순위를 sort하여 location의 prio보다 높은 것들이 다 나가는지 확인.

        while( !que.isEmpty() ){
            int currentPriority = que.poll();
            if( currentPriority == priorities[priorMaxIndex-1]){ // priority 순서로대로 빠지는 경우.
                answer++;
                location--;
                priorMaxIndex--;
                if( location < 0){ // lcation에 해당하는 index가 처리되는 경우.
                    break;
                }
            }else{// que에서 처리해야할 index가 priroty가 낮은 경우
                que.add(currentPriority);
                location--;
                if( location < 0){
                    location = que.size()-1;
                }
            }

        }

        return answer;
    }
}
