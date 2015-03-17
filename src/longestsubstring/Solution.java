package longestsubstring;

import java.util.HashMap;
import java.util.Map;


public class Solution {
	public static void main(String[] args) {
		System.out.println(new Solution().lengthOfLongestSubstring("dvdf"));
	}
	
	public int lengthOfLongestSubstring(String s) {
		int lengthOfLongest = 0;
		int startIndex = 0;
		Map<Character, Integer> substringMap = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			Character charAtI = s.charAt(i);
			
			Integer indexOfCurrentChar = substringMap.get(charAtI);
			if (indexOfCurrentChar != null) {
				if (indexOfCurrentChar >= startIndex) {
					
					startIndex = indexOfCurrentChar + 1;
				}
			}
			int length = i - startIndex + 1;
			if (length > lengthOfLongest) {
				lengthOfLongest = length;
			}
			substringMap.put(charAtI, i);
		}
		return lengthOfLongest;
	}
}
