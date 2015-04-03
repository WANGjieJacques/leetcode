package medium.largestnumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
	public static void main(String[] args) {
		int[] num = {0,0,0};
		System.out.print(new Solution().largestNumber(num));
	}
	
	private static int getLengthOfNum(int num) {
		int length = 1;
		while(true) {
			num = num / 10;
			if (num > 0) {
				length++;
			} else {
				return length;
			}
		}
	}
	
	public String largestNumber(int[] num) {
		
		List<LargestNumber> largestNumbers = new ArrayList<>();
		
		for (int n : num) {
			largestNumbers.add(new LargestNumber(n));
		}
		
		Collections.sort(largestNumbers);
		for (; largestNumbers.size()>1;) {
			LargestNumber Ln = largestNumbers.get(0);
			int n = Ln.num;
			if (n==0) {
				largestNumbers.remove(Ln);
			} else {
				break;
			}
		}
		System.out.print(largestNumbers);
		StringBuilder sb = new StringBuilder();
		for (LargestNumber n : largestNumbers) {
			sb.append(n.toString());
		}
		return sb.toString();
	}
	
	static class LargestNumber implements Comparable<LargestNumber>{
		int num;
		public LargestNumber(int num) {
			this.num = num;
		}
		
		public String toString() {
			return num+"";
		}
		@Override
		public int compareTo(LargestNumber o) {
			int lengthA = getLengthOfNum(num);
			int lengthB = getLengthOfNum(o.num);
			long a = num + o.num * (long)Math.pow(10, lengthA);
			long b = o.num + num * (long)Math.pow(10, lengthB);
			if (a>b) {
				return 1;
			} else if (a<b) {
				return -1;
			} else {
				return 0;
			}
		}
	}
}
