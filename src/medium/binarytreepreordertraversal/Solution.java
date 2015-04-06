package medium.binarytreepreordertraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		TreeNode node2 = new TreeNode(2);
		TreeNode node1 = new TreeNode(1);
		TreeNode node3 = new TreeNode(3);
		node1.right = node2;
		node1.left = node3;
		System.out.println(new Solution().preorderTraversal_(node1));
		System.out.println(new Solution().inorderTraversal(node1));
	}

	public List<Integer> preorderTraversal(TreeNode root) {
		if (root == null)
			return new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		List<Integer> nodes = new ArrayList<Integer>();
		stack.add(root);

		while (!stack.empty()) {
			// System.out.println(new Solution().preorderTraversal(node1));
			nodes.add(root.val);
			if (root.left != null) {
//				stack.add(root.left);
				stack.push(root.left);
				root = root.left;
			} else {
				if (!stack.empty() && root.right != null)
					root = stack.pop();
				while (root.right == null && !stack.empty()) {
					root = stack.pop();
				}
				// if (!stack.empty() && root.right!=null)
				// root = stack.pop();
				if (root.right != null) {

					stack.add(root.right);
					root = root.right;
				}

			}
		}
		return nodes;
	}
	
	
	public List<Integer> preorderTraversal_(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		List<Integer> list = new ArrayList<>();
		if (root==null) {
			return list;
		}
		stack.push(root);
		while(!stack.empty()) {
			
			TreeNode n = stack.pop();
			
			list.add(n.val);
			if (n.right!=null) {
				stack.push(n.right);
			}
			
			if (n.left!=null) {
				stack.push(n.left);
			}
			
		}
		return list;
	}

	public List<Integer> inorderTraversal(TreeNode root) {
		if (root == null)
			return new ArrayList<>();
		LinkedList<TreeNode> stack = new LinkedList<>();
		List<Integer> nodes = new ArrayList<Integer>();
		stack.add(root);

		while (!stack.isEmpty()) {
			while (root.left != null) {
				root = root.left;
				stack.add(root);
			}
			// stack.pop();
			// nodes.add(root.val);
			if (root.right != null && !stack.isEmpty()) {

				root = stack.removeLast();
				nodes.add(root.val);

			}
			while (root.right == null && !stack.isEmpty()) {

				root = stack.removeLast();
				
				nodes.add(root.val);

			}
			if (root.right != null) {
				// nodes.add(root.right.val);
				root = root.right;
				stack.add(root);
			}
		}
		return nodes;
	}

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}

		@Override
		public String toString() {
			return val + "";
		}
	}

}
