package longestpalindrome;

import java.util.ArrayList;
import java.util.List;


public class Solution {
	public static void main(String[] args) {
		System.out.println(new Solution().longestPalindrome("1223212121"));
	}

	public String longestPalindrome(String s) {
		int length = s.length();
		String longestPalindrome = "";
		for (int i = 0; i < length; i++) {
			String temp = "";
			for (int start = 0; start <= i; start++) {
				temp = s.substring(start, i+1);
				if (this.isPalindrome(temp) && temp.length() > longestPalindrome.length()) {
					longestPalindrome = temp;
				}
			}
		}
		
		return longestPalindrome;
	}
	
	public boolean isPalindrome(String s) {
		
		int halfLength = s.length() / 2;
		int length = s.length();
		for (int i = 0; i < halfLength; i++) {
			if (!(s.charAt(i)==s.charAt(length-1-i))) {
				return false;
			}
		}
		return true;
	}
}
