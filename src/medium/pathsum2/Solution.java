package medium.pathsum2;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public static void main(String[] args) {
		TreeNode root5 = new TreeNode(5);
		TreeNode node4 = new TreeNode(4);
		TreeNode node8 = new TreeNode(8);
		root5.left = node4;
		root5.right = node8;
		TreeNode node11 = new TreeNode(11);
		node4.left = node11;
		TreeNode node7 = new TreeNode(7);
		TreeNode node2 = new TreeNode(2);
		node11.left = node7;
		node11.right = node2;
		
		TreeNode node13 = new TreeNode(13);
		TreeNode node4_ = new TreeNode(4);
		node8.left = node13;
		node8.right = node4_;
		
		TreeNode node5 = new TreeNode(5);
		TreeNode node1 = new TreeNode(1);
		node4_.left = node5;
		node4_.right = node1;
//		TreeNode root2 = new TreeNode(1);
//		TreeNode node1 = new TreeNode(1);
//	    root2.left = node1;
		System.out.println(new Solution().pathSum(root5, 22));
	}

	public int rob(int[] num) {
		return 0;
	}
	

	private List<List<Integer>> paths = new ArrayList<>();
	
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		this.calSum(0, root, new ArrayList<Integer>(), sum);
		return paths;
	}
	
	private void calSum(int previousSum, TreeNode node, List<Integer> path, int sum) {
		if (node == null) {
			return;
		}
		int localSum = previousSum + node.val;
		path.add(node.val);
		if (sum == localSum && node.left == null && node.right == null) {
			paths.add(new ArrayList<>(path));
			return;
		}
		
		calSum(localSum, node.left, path, sum);
		if (node.left != null)
			path.remove(path.size() - 1);
		
		calSum(localSum, node.right, path, sum);
		if (node.right != null)
			path.remove(path.size() - 1);
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
