package interleavestring;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public static void main(String[] args) {
//		System.out.println(new Solution().insertCharToStringAt(3, 'v', "abcd"));
		System.out.println(new Solution().isInterleave("aa", "ab", "abaa"));
	}

	public boolean isInterleave(String s1, String s2, String s3) {
		String interleaveS = s2;
		int insertPos = 0;
		if (s1.length() + s2.length() != s3.length()) {
			return false;
		}
		if (s1.length() == 0) {
			return s2.equals(s3);
		}
		if (s2.length() == 0) {
			return s1.equals(s3);
		}
		
		for (int i = 0; i < s1.length(); i++) {
			char c = s1.charAt(i);
			boolean hasSolution = false;
			for (int j = insertPos; j < interleaveS.length()+1; j++) {
				String str = this.insertCharToStringAt(j, c, interleaveS);
				System.out.println(str + " " + s3);
				if (str.substring(0, j+1).equals(s3.substring(0, j+1))) {
					interleaveS = str;
					insertPos = ++j;
					hasSolution = true;
					break;
				}
			}
			
			if (!hasSolution) {
				return false;
			}
		}
		return true;
	}
	
	private String insertCharToStringAt(int index, char c, String string) {
		return string.substring(0, index) + c + string.substring(index, string.length());
	}
}
