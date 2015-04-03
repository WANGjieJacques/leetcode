package medium.addtwonumbers;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class Solution {
	public static void main(String[] args) {
		ListNode L1 = new ListNode(1);
//		L1.next = new ListNode(8);
//		L1.next.next = new ListNode(3);
		
		ListNode L2 = new ListNode(9);
		L2.next = new ListNode(9);
//		L2.next.next = new ListNode(4);
		
		ListNode result = new Solution().addTwoNumbers(L1, L2);
		for (ListNode node = result; node != null; node = node.next) {
			System.out.println(node.val);
		}
	}
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode resultNode = new ListNode(0);
		ListNode nextResultNode = resultNode;
		ListNode nextL1 = l1;
		ListNode nextL2 = l2;
		int v10Pre = 0;
		while (true) {
			int v1, v2;
			if (nextL1 == null) {
				v1 = 0;
			} else {
				v1 = nextL1.val;
				nextL1 = nextL1.next;
			}
			
			if (nextL2 == null) {
				v2 = 0;
			} else {
				v2 = nextL2.val;
				nextL2 = nextL2.next;
			}
			
			int result = v1 + v2;
			
			int sum = result + v10Pre;
			nextResultNode.val = sum % 10;
			v10Pre = sum / 10;
			
			
			if (nextL1 == null && nextL2 == null) {
				if (v10Pre != 0) {
					nextResultNode.next = new ListNode(v10Pre);
				}
				break;
			}
			nextResultNode.next = new ListNode(0);
			nextResultNode = nextResultNode.next;
		}

		return resultNode;
	}
}