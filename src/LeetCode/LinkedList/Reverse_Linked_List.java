package LeetCode.LinkedList;

import LeetCode.LinkedList.ListNode;

import java.util.*;

public class Reverse_Linked_List {
    public static void main(String[] args){
        ListNode node1= new ListNode(0);
        ListNode node2= new ListNode(1);
        ListNode node3= new ListNode(4);
        ListNode node4= new ListNode(-2);
//        ListNode node5= new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
//        node4.next = node5;

        ListNode reverseNode = Solution(node1);
        while(reverseNode != null){
            System.out.println(reverseNode.val);
            reverseNode = reverseNode.next;
        }
    }

    public static ListNode Solution(ListNode head){
        ArrayList<ListNode> list = new ArrayList<ListNode>();
        while( head != null){
            list.add(head);
            head = head.next;
        }
        for(int i=list.size()-1; i > 0; i--){
            list.get(i).next = list.get(i-1);
        }
        list.get(0).next = null;

        return list.get(list.size()-1);
    }
}
