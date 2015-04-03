package hard.ismatch;
public class Solution {
	public static void main(String[] args) {
		System.out.println(new Solution().isMatch("aab", "c*a*b"));
	}
	
    public boolean isMatch(String s, String p) {
    	String ss = "adsadsafefew";
        String result = s.replace(p, ss);
        return result.contains(ss);
    }
	
	
}
