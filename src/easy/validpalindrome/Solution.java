package easy.validpalindrome;


import java.util.ArrayList;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		System.out.println(new Solution().isPalindrome("0k.;r0.k;"));
	}

	public boolean isPalindrome(String s) {
		s = s.toLowerCase();
		List<Character> alphas = new ArrayList<>();
		for (char c : s.toCharArray()) {
			boolean isWord2 = c<='z'&&c>='a';
			boolean isWord3 = c<='Z'&&c>='A';
			boolean isNumber = c<='9'&&c>='0';
			if (isWord2 || isWord3 || isNumber) {
				alphas.add(c);
			}
		}
		System.out.println(alphas);
		int halfLength = alphas.size() / 2;
		int length = alphas.size();
		for (int i = 0; i < halfLength; i++) {
			if (!alphas.get(i).equals(alphas.get(length-1-i))) {
				return false;
			}
		}
		return true;
	}
	
	
	

}
