package easy.intersectionof_two_linked_lists;

public class Solution {
	public static void main(String[] args) {
		
	}
	
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
        	return null;
        }
        
        int lengthA = getLengthOfListNode(headA);
        int lengthB = getLengthOfListNode(headB);
        
        if (lengthA > lengthB) {
        	return getIntersectionNode(headA, headB, lengthA-lengthB);
        }
        return getIntersectionNode(headB, headA, lengthB-lengthA);
    }
    
    private int getLengthOfListNode(ListNode head) {
    	int length = 0;
        for (; head.next != null; head = head.next) {
        	length++;
        }
        return length;
    }
    
    public ListNode getIntersectionNode(ListNode longListNode, ListNode shortListNode, int diff) {
    	for (int i = 0; i < diff; i++) {
    		longListNode = longListNode.next;
    	}
    	
    	for (; longListNode != null; longListNode = longListNode.next, shortListNode = shortListNode.next) {
    		if (longListNode == shortListNode) {
    			return longListNode;
    		}
    		
    	}
    	return null;
    }
    
    
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}
