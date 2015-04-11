package medium.binarysearchtreeiterator;

import java.util.Stack;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class BSTIterator {
	
	private Stack<Integer> stack = new Stack<>();
	public static void main(String[] args) {
		TreeNode root4 = new TreeNode(4);
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		root4.left = node2;
		root4.right = node6;
		node2.left = node1;
		node2.right = node3;
		
		node6.left = node5;
		node6.right = node7;
		BSTIterator bst = new BSTIterator(root4);
//		System.out.println(bst.stack);
		while (bst.hasNext()) {
			System.out.println(bst.next());
		}
		
	}

	public BSTIterator(TreeNode root) {
		this.aa(root);
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		if (stack.isEmpty()) {
			return false;
		}
		
		return true;
	}

	public int next() {
		return stack.pop();
	}
	/** @return the next smallest number */
	public void aa(TreeNode node) {
		if (node.right != null) {
			this.aa(node.right);
		}
		this.stack.add(node.val);
		if (node.left != null) {
			this.aa(node.left);
		}
	}
}

/**
 * Your BSTIterator will be called like this: BSTIterator i = new
 * BSTIterator(root); while (i.hasNext()) v[f()] = i.next();
 */
