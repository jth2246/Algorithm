package Programmers.stackQueue;

import java.util.Arrays;
import java.util.Stack;

public class TOP {
    public static void main(String[] args){
        int[] heigh = {3,9,9,3,5,7,2};
        System.out.println(Arrays.toString( Solution(heigh)));
    }
    public  static int[] Solution(int[] heights){
        int[] answer = new int[heights.length];
        Stack<Tower> towerStack = new Stack<>();
        int receiveIndex = 0;
        for(int i=0; i < heights.length; i++){
            Tower tower = new Tower(i, heights[i]);

            while( !towerStack.isEmpty() ){
                Tower prevTower = towerStack.peek();
                if( prevTower.heigh > tower.heigh){
                    receiveIndex = prevTower.index+1;
                    break;
                }

                towerStack.pop();
            }

            towerStack.push(tower);
            answer[i] = receiveIndex;

        }

        return answer;
    }
    static class Tower{
        public int index;
        public int heigh;

        public Tower(int index, int heigh){
            this.index = index;
            this.heigh = heigh;
        }
    }



    /*
    public static int[] Solution(int[] heights){
        int[] answer = new int[heights.length];
        for( int i = heights.length -1 ; i >= 0; i--){
            int topHeigh = heights[i];
            answer[i] = calcHeighTop(heights,topHeigh,i);
        }
        return answer;
    }
    public static int calcHeighTop(int[] heights, int topHeigh, int index){
        for( int i = index -1 ; i >= 0; i--){
            if( heights[i] > topHeigh ){
                return i+1;
            }
        }
        return 0;
    }

     */
}
