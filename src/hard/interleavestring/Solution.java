package hard.interleavestring;


public class Solution {
	public static void main(String[] args) {
//		System.out.println(new Solution().insertCharToStringAt(3, 'v', "abcd"));
		System.out.println(new Solution().isInterleave("ac", "ab", "abac"));
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
			char c;
			c = s1.charAt(i);
			System.out.println(i);
			boolean hasSolution = false;
			
			String s = interleaveS.substring(0, insertPos+1);
			if (s.equals(s3.substring(0, insertPos+1))) {
				interleaveS = s;
				insertPos++;
			}
			for (int j = insertPos-1; j < interleaveS.length()+1; j++) {
				String str;
				str = this.insertCharToStringAt(j, c, interleaveS);
				
				System.out.println(str+" "+s3+" "+j + " " + insertPos);
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
		if (c == '.') {
			return string;
		}
		return string.substring(0, index) + c + string.substring(index, string.length());
	}
}
