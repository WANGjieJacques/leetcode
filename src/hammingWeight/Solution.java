package hammingWeight;

public class Solution {
	
	public static void main(String[] args) {
		
        System.out.println(new Solution().hammingWeight(11));
	}
	public int hammingWeight(int n) {
        String bytes = Integer.toBinaryString(n);
        char[] ccs = bytes.toCharArray();
        int num = 0;
        for (char c : ccs) {
        	if (c == '1') {
        		num++;
        	}
        }
        return num;
    }
}
