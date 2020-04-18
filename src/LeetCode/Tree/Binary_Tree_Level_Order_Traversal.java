package LeetCode.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Binary_Tree_Level_Order_Traversal {
    public static void main(String[] args){
        TreeNode root = new TreeNode(3);
        TreeNode left1 = new TreeNode(9);
        TreeNode right1 = new TreeNode(20);
        TreeNode left2 = new TreeNode(15);
        TreeNode right2 = new TreeNode(7);

        root.left = left1;
        root.right = right1;
        right1.left = left2;
        right1.right = right2;

        Solution(root);

    }

    public static List<List<Integer>> Solution(TreeNode root){
        List result = null;
        List treeLevelList = new ArrayList<Integer>();
        Map<Integer,List<Integer>> treeDepthMap = new HashMap<Integer,List<Integer>>();
        int depth = 0;
        travleTree(root,depth,treeDepthMap);
        for( int i =0; i< treeDepthMap.size(); i++){
            treeLevelList.add( treeDepthMap.get(i));
        }
        return treeLevelList;
    }

    public static void travleTree(TreeNode node, int depth, Map<Integer,List<Integer>> treeDepthMap){
        if( node == null){
            return;
        }

        List<Integer> nodeList = treeDepthMap.get(depth);

        if( nodeList == null){
            nodeList = new ArrayList<Integer>();
            nodeList.add(node.val);
            treeDepthMap.put(depth,nodeList);
        }else{
            nodeList.add(node.val);
        }
        depth++;
        travleTree(node.left,depth,treeDepthMap);
        travleTree(node.right,depth,treeDepthMap);

    }
}
