package majorityelement;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public static void main(String[] args) {
		int[] num = {1,2,1,2,1,2,2};
		System.out.println(new Solution().majorityElement(num));
	}

	public int majorityElement(int[] num) {
		List<Integer> nums = new ArrayList<>();
		for (int n:num) {
			nums.add(n);
		}
		
		int length = num.length;
		while (true) {
			Integer first = nums.get(0);
			int lengthBeforeRemove = nums.size();
			List<Integer> numAfterRemove = new ArrayList<>();
			for (Integer n : nums) {
				if (!n.equals(first)) {
					numAfterRemove.add(n);
				}
			}
			int lengthAfterRemove = numAfterRemove.size();
			nums = numAfterRemove;
			int lengthRemove = lengthBeforeRemove - lengthAfterRemove;
			
			if (lengthRemove > length / 2) {
				return first;
			} 
		}
	}
}
