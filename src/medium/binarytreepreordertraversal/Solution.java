package medium.binarytreepreordertraversal;

import java.util.ArrayList;
import java.util.Collections;
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
		System.out.println(new Solution().postorderTraversal(node1));
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

	public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
		List<Integer> nodes = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		
		while (!stack.empty()) {
			root = stack.pop();
			nodes.add(root.val);
			if (root.left != null) {
				stack.push(root.left);
				
			}
			
			if (root.right != null) {
				stack.push(root.right);
			}
		}
		Collections.reverse(nodes);
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


//There is an universal idea for preorder traversal inorder traversal and postorder traversal. 
//For each node N, we process it as follows:------- push N in stack -> push left tree of N 
//in stack -> pop left tree of N -> push right tree of N in stack -> pop right tree 
//of N -> pop N--------- For preorder traversal, we visit a node when pushing it in stack. 
//For inorder traversal, we visit a node when pushing its right child in stack. 
//for postorder traversal, we visit a node when popping it. 
//lastpop represents the node which is popped the last time. For the top node in stack, 
//it has three choices, pushing its left child in stack, or pushing its right child in stack, 
//or being popped. If lastpop != top->left, meaning that its left tree has not been pushed in stack, 
//then we push its left child. If last_pop == top->left, we push its right child. Otherwise, 
//we pop the top node.

//
//traversal.cpp
//codingameXcode
//
//Created by WANG Jie on 4/6/15.
//Copyright (c) 2015 WANG Jie. All rights reserved.
//

//#include "traversal.h"
//#include <stack>
//#include <iostream>
//struct TreeNode {
//int val;
//TreeNode *left;
//TreeNode *right;
//TreeNode(int x) : val(x), left(NULL), right(NULL) {}
//};
//using namespace::std;
//void preorder_traversal_iteratively(TreeNode* root)
//{
//if (root == 0)
//    return;
//
//stack<TreeNode*> s;
//s.push(root);
//cout << root->val << ' '; // visit root
//TreeNode* last_pop = root;
//while (!s.empty())
//{
//    TreeNode* top = s.top();
//    if (top->left != 0 && top->left != last_pop && top->right != last_pop) // push_left
//    {
//        s.push(top->left);
//        cout << top->left->val << ' '; // visit top->left
//    }
//    else if (top->right != 0 && top->right != last_pop && (top->left == 0 || top->left == last_pop)) // push_right
//    {
//        s.push(top->right);
//        cout << top->right->val << ' '; // visit top->right
//    }
//    else // pop
//    {
//        s.pop();
//        last_pop = top;
//    }
//}
//}
//
//void inorder_traversal_iteratively(TreeNode* root)
//{
//if (root == 0)
//    return;
//stack<TreeNode*> s;
//s.push(root);
//TreeNode* last_pop = root;
//while (!s.empty())
//{
//    TreeNode* top = s.top();
//    if (top->left != 0 && top->left != last_pop && top->right != last_pop) // push_left
//    {
//        s.push(top->left);
//    }
//    else if (top->right != 0 && top->right != last_pop && (top->left == 0 || top->left == last_pop)) // push_right
//    {
//        s.push(top->right);
//        cout << top->val << ' '; // visit top
//    }
//    else // pop
//    {
//        s.pop();
//        last_pop = top;
//        if (top->right == 0)
//            cout << top->val << ' '; // visit top
//    }
//}
//}
//
//void postorder_traversal_iteratively(TreeNode* root)
//{
//if (root == 0)
//    return;
//stack<TreeNode*> s;
//s.push(root);
//TreeNode* last_pop = root;
//while (!s.empty())
//{
//    TreeNode* top = s.top();
//    if (top->left != 0 && top->left != last_pop && top->right != last_pop) // push_left
//    {
//        s.push(top->left);
//    }
//    else if (top->right != 0 && top->right != last_pop && (top->left == 0 || top->left == last_pop)) // push_right
//    {
//        s.push(top->right);
//    }
//    else // pop
//    {
//        s.pop();
//        last_pop = top;
//        cout << top->val << ' '; // visit top
//    }
//}
//}
