package easy.houserobber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Solution {

	public static void main(String[] args) {

	}

	public int rob(int[] num) {
		if (num.length == 0) {
			return 0;
		}
		int sum0 = num[0];
		if (num.length == 1) {
			return sum0;
		}
		int sum1 = Math.max(sum0, num[1]);
		if (num.length == 2) {
			return sum1;
		}
		
		int previousSum = sum0;
		int currentSum = sum1;
		for (int i = 2; i < num.length; i++) {
			int currentSumOld = currentSum;
			currentSum = Math.max(previousSum + num[i], currentSum);
			previousSum = currentSumOld;
		}
		
		
		return currentSum;
	}
	
	
}
