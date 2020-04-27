package Practice.Graph;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Stack;

class Graph{
    class Node{
        int data;
        LinkedList<Node> adjacentNodeList;
        boolean markded;
        public Node(int data){
            this.data = data;
            adjacentNodeList = new LinkedList<>();
            markded = false;
        }
    }
    Node[] nodes;
    public Graph(int size){
        nodes = new Node[size];
        for(int i = 0; i < size; i++){
            nodes[i] = new Node(i);
        }
    }
    public void addEdge(int i1, int i2){
        Node n1 = nodes[i1];
        Node n2 = nodes[i2];
        if( !n1.adjacentNodeList.contains(n2)){
            n1.adjacentNodeList.add(n2);
        }
        if( !n2.adjacentNodeList.contains(n1)){
            n2.adjacentNodeList.add(n1);
        }
    }
    public void dfs(){
        dfs(0);
    }
    public void dfs(int index){
        Node root = nodes[index];
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        root.markded = true;
        while( !stack.isEmpty()){
            Node temp = stack.pop();
            LinkedList<Node> adjacentList = temp.adjacentNodeList;
            for( Node node : adjacentList){
                if( !node.markded){
                    stack.push(node);
                    node.markded = true;
                }
            }
            visit(temp);
        }
    }
    public void bfs(){
        bfs(0);
    }
    public void bfs(int index){
        Node root = nodes[index];
        ArrayDeque<Node> que = new ArrayDeque<>();
        que.offer(root);
        root.markded = true;
        while(!que.isEmpty()){
            Node temp = que.poll();
            for( Node node : temp.adjacentNodeList){
                if( !node.markded ){
                    que.offer(node);
                    node.markded = true;
                }
            }
            visit(temp);
        }
    }
    public void dfsR(int index){
        Node root = nodes[index];
        dfsR(root);
    }
    public void dfsR(Node root){
      if( root == null || root.adjacentNodeList == null){
          return;
      }
      root.markded = true;
      visit(root);
      for( Node node : root.adjacentNodeList){
          if( !node.markded ){
              node.markded = true;
              dfsR(node);
          }
      }
    }
    public void visit(Node node){
        System.out.print(node.data+" ");
    }

}

public class DFS {
    public static void main(String[] args){
        Graph graph = new Graph(9);
        graph.addEdge(0,1);
        graph.addEdge(1,2);
        graph.addEdge(1,3);
        graph.addEdge(2,4);
        graph.addEdge(2,3);
        graph.addEdge(3,4);
        graph.addEdge(3,5);
        graph.addEdge(5,6);
        graph.addEdge(6,7);
        graph.addEdge(6,8);

        graph.dfsR(0);
    }
}

