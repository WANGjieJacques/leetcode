package medium.excelsheetcolumnnumber;


public class Solution {
	public static void main(String[] args) {
		System.out.println(new Solution().titleToNumber("A"));
		System.out.println(new Solution().titleToNumber("Z"));
		System.out.println(new Solution().titleToNumber("AA"));
		System.out.println(new Solution().titleToNumber(""));
		System.out.println(new Solution().titleToNumber(null));
	}
	
    public int titleToNumber(String s) {
    	if (s == null) {
    		return 0;
    	}
    	int num = 0;
        for (char c : s.toCharArray()) {
        	num = num * 26 + (c-'A')+1;
        }
        
        return num;
    }
}
