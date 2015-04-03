package medium.threesum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Solution {
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		int[] num = {-15,10,0,-2,14,-1,-10,-14,10,12,6,-6,10,2,-11,-9,2,13,2,-9,-14,-12,-10,-12,13,13,-10,-3,2,-11,3,-6,6,10,7,5,-13,4,-2,12,1,-11,14,-4,6,-12,-6,-14,8,11,-8,1,7,-3,5,5,-13,10,9,-3,6,-10,6,-3,7,-9,-13,9,10,0,-1,-11,4,-10,-8,-13,-15,2,-12,8,-2,-12,-14,-10,-8,6,2,-5,-7,-11,7,14,-6,-10,-12,8,-4,-10,-5,14,-3,9,-12,8,14,-13};
		System.out.println(new Solution().threeSum1(num));
		System.out.println(System.currentTimeMillis() - start);
	}
	
	public List<List<Integer>> threeSum1(int[] num) {
	    Arrays.sort(num);
	    List<List<Integer>> res = new LinkedList<>(); 
	    for (int i = 0; i < num.length-2; i++) {
	        if (i == 0 || (i > 0 && num[i] != num[i-1])) {
	            int lo = i+1, hi = num.length-1, sum = 0 - num[i];
	            while (lo < hi) {
	                if (num[lo] + num[hi] == sum) {
	                    res.add(Arrays.asList(num[i], num[lo], num[hi]));
	                    while (lo < hi && num[lo] == num[lo+1]) lo++;
	                    while (lo < hi && num[hi] == num[hi-1]) hi--;
	                    lo++; hi--;
	                } else if (num[lo] + num[hi] < sum) lo++;
	                else hi--;
	           }
	        }
	    }
	    return res;
	}
	
	
	public List<List<Integer>> threeSum(int[] num) {
		Set<Integer> negativePartSet = new HashSet<Integer>();
		List<Integer> negativePartList = new ArrayList<>();
		
		Set<Integer> positivePartSet = new HashSet<Integer>();
		List<Integer> positivePartList = new ArrayList<Integer>();
		boolean containsZero = false;
		for (int n : num) {
			if (n < 0) {
				negativePartSet.add(n);
				negativePartList.add(n);
			} else if(n > 0) {
				positivePartList.add(n);
				positivePartSet.add(n);
			} else {
				containsZero = true;
			}
		}
		
		Collections.sort(negativePartList);
		Collections.sort(positivePartList);
		
		Set<List<Integer>> tripletSet = new HashSet<List<Integer>>();
		if (containsZero) {
			for (int n : negativePartList) {
				if (positivePartSet.contains(-n)) {
					tripletSet.add(Arrays.asList(n,0,-n));
				}
			}
		}
		
//		int min = negativePartList.get(0);
//		int max = positivePartList.get(positivePartList.size()-1);
		for (int i = 0; i < negativePartList.size(); i++) {
			for (int j = i+1; j < negativePartList.size(); j++) {
				int negativeSum = negativePartList.get(i)+negativePartList.get(j);
				if (positivePartSet.contains(-negativeSum)) {
					tripletSet.add(Arrays.asList(negativePartList.get(i), 
							negativePartList.get(j), -negativeSum));
				}
			}
		}
		
		for (int i = 0; i < positivePartList.size(); i++) {
			for (int j = i+1; j < positivePartList.size(); j++) {
				int positiveSum = positivePartList.get(i)+positivePartList.get(j);
				if (negativePartSet.contains(-positiveSum)) {
					tripletSet.add(Arrays.asList(-positiveSum, 
							positivePartList.get(j), positivePartList.get(i)));
				}
			}
		}
		
		return new ArrayList<>(tripletSet);
	}
}
