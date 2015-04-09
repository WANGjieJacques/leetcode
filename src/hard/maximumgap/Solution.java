package hard.maximumgap;

import java.util.Stack;

public class Solution {

	public static void main(String[] args) {
		int [] a = {1,2,5,4,2};
		System.out.println(new Solution().maximumGap(a));

	}
	
    public int maximumGap(int[] num) {
    	if (num.length < 2) {
    		return 0;
    	}
    	
    	int max = 0;
    	int min = Integer.MAX_VALUE;
    	int gapLow = 0;
    	int gapHigh = 0;
    	Stack<Integer> gapHistory = new Stack<>();
    	gapHistory.push(0);
        for (int i = 0; i < num.length; i++) {
        	int previousMaxGap = gapHistory.push(0);
        	int currentGap = 0;
        	if (num[i] < min) {
        		currentGap = min - num[i];
        		min = num[i];
        	} else if (num[i] > max) {
        		currentGap = num[i]-max;
        		max = num[i];
        	} else if (num[i] > gapLow && num[i] < gapHigh) {
        		currentGap
        	}
       
        	
        }
        
        return max - min;
    }

}
