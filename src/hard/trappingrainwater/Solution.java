package hard.trappingrainwater;


public class Solution {

	public static void main(String[] args) {
		int[] a = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(new Solution().trap(a));
	}
	
	public int trap(int[] A) {
		if (A == null) {
			return 0;
		}
		int maxIndex = this.getMaxIndex(A);
		int previousMax = 0;
		int water = 0;
		for (int i = 0; i < maxIndex; i++) {
			int currentWater = previousMax - A[i];
			if (currentWater > 0) {
				water = water + currentWater;
			} else {
				previousMax = A[i];
			}
		}
		
		previousMax = 0;
		for (int i = A.length - 1; i > maxIndex; i--) {
			int currentWater = previousMax - A[i];
			if (currentWater > 0) {
				water = water + currentWater;
			} else {
				previousMax = A[i];
			}
		}
		return water;
	}
	
	
	private int getMaxIndex(int[] a) {
		int max = 0;
		int maxIndex = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] > max) {
				max = a[i];
				maxIndex = i;
			}
		}
		
		return maxIndex;
	}
	
    public int trap1(int[] A) {
    	if (A == null) {
    		return 0;
    	}
        int[] b = A.clone();
        int water = 0;
        for (;;) {
        	int oneLineWater = this.singleLine(b);
        	if (oneLineWater == -1) {
        		break;
        	}
        	water = water + oneLineWater;
        	for (int i = 0; i < b.length; i++) {
        		b[i]--;
        	}
        }
        
        return water;
    }
    
    public int singleLine(int[] A) {
    	if (A == null) {
    		return 0;
    	}
    	int firstBar = -1;
    	int lastBar = -1;
    	boolean firstBarHasValue = false;
    	for (int i = 0; i < A.length; i++) {
    		if (A[i] > 0 && !firstBarHasValue) {
    			firstBar = i;
    			firstBarHasValue = true;
    		}
    		if (A[i] > 0) {
    			lastBar = i;
    		}
    	}
    	if (firstBar == -1) {
    		return -1;
    	}
    	

    	int water = 0;
    	for (int i = firstBar+1; i < lastBar; i++) {
    		if (A[i] < 1) {
    			water = water + 1;
    		}
    	}
    	
    	return water;
    }

}
