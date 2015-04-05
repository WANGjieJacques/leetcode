package medium.sortlist;

public class Solution {
	public static void main(String[] args) {
		int num[] = {3,1,4,2};
		ListNode node = new ListNode(num[0]);
		ListNode nextNode = node;
		for (int i = 1; i < num.length; i++) {
			nextNode.next = new ListNode(num[i]);
			nextNode = nextNode.next;
		}
		System.out.println(node);
		System.out.println(new Solution().sortList(node));
	}

	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode firstMid = head;
		ListNode lastMid = head;
		ListNode smallPartHead = null;
		ListNode largePartHead = null;
		ListNode smallPartCurrent = null;
		ListNode largePartCurrent = null;
		while (head.next != null) {
			head = head.next;
			if (head.val < firstMid.val) {
				if (smallPartCurrent == null) {
					smallPartCurrent = head;
				} else {
					smallPartCurrent.next = head;
					smallPartCurrent = head;
				}
				if (smallPartHead == null) {
					smallPartHead = head;
				}
			} else if (head.val > firstMid.val) {
				if (largePartCurrent == null) {
					largePartCurrent = head;
				} else {
					largePartCurrent.next = head;
					largePartCurrent = head;
				}
				if (largePartHead == null) {
					largePartHead = head;
				}
			} else {
				lastMid.next = head;
				lastMid = head;
			}
			
		}
		if (largePartCurrent != null)
			largePartCurrent.next = null;
		if (smallPartCurrent != null)
			smallPartCurrent.next = null;
//		System.out.println(smallPartHead);
		if (smallPartHead != null)
			smallPartHead = sortList(smallPartHead);
		if (largePartHead != null)
			largePartHead = sortList(largePartHead);
		ListNode lastNode = smallPartHead;
		while (lastNode != null && lastNode.next != null) {
			lastNode = lastNode.next;
		}
		if (lastNode != null) 
		    lastNode.next = firstMid;
		lastMid.next = largePartHead;
		return smallPartHead;
		
	}
}

// Definition for singly-linked list.
class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
	
	public String toString() {
		String s = val + " ";
		if (this.next != null) {
			s = s + this.next.toString();
		}
		
		return s;
	}
}
