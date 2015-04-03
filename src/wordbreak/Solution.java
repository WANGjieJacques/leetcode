package wordbreak;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {
//		Set<String> dict = new HashSet<>(Arrays.asList("a", "aa", "aaa",
//				"aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa",
//				"aaaaaaaaaa"));
//		 Set<String> dict = new
//		 HashSet<>(Arrays.asList("bbb","bb","bbb","bbbbbbbbb","bbbbbbbbbbbbbb"));
		 Set<String> dict = new
		 HashSet<>(Arrays.asList("abbcbda","cbdaaa","b","dadaaad","dccbbbc","dccadd","ccbdbc","bbca","bacbcdd","a","bacb","cbc","adc","c","cbdbcad","cdbab","db","abbcdbd","bcb","bbdab","aa","bcadb","bacbcb","ca","dbdabdb","ccd","acbb","bdc","acbccd","d","cccdcda","dcbd","cbccacd","ac","cca","aaddc","dccac","ccdc","bbbbcda","ba","adbcadb","dca","abd","bdbb","ddadbad","badb","ab","aaaaa","acba","abbb"));

//		String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
		 String s = "acaaaaabbbdbcccdcdaadcdccacbcccabbbbcdaaaaaadb";
		// String s =
		// "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb";
		long start = System.currentTimeMillis();
		// System.out.println(new Solution().wordBreak(s, dict));
		System.out.println(System.currentTimeMillis() - start);

		long start1 = System.currentTimeMillis();
		System.out.println(new Solution().wordBreak1(s, dict));
		System.out.println(System.currentTimeMillis() - start1);

	}

	private Map<String, Boolean> results = new HashMap<>();

	public boolean wordBreak(String s, Set<String> dict) {
		if (dict.isEmpty()) {
			return false;
		}
		Set<String> matchAtBegin = new HashSet<>();
		Set<String> allMatch = new HashSet<>();
		for (String word : dict) {
			if (s.indexOf(word) == 0) {
				if (word.equals(s)) {
					return true;
				}
				matchAtBegin.add(word);
				allMatch.add(word);
			} else if (s.indexOf(word) > 0) {
				allMatch.add(word);
			}
		}

		for (String wordMatchAtBegin : matchAtBegin) {
			for (String wordMatchNotAtBegin : allMatch) {
				Set<String> newDict = new HashSet<>(allMatch);
				// newDict.remove(wordMatchNotAtBegin);
				String newFirst = wordMatchAtBegin + wordMatchNotAtBegin;
				if (allMatch.contains(newFirst)) {
					continue;
				}
				if (s.indexOf(newFirst) == 0) {
					newDict.add(newFirst);
					// System.out.println(newFirst);
					Boolean result = results.get(newFirst);
					if (result == null) {
						result = wordBreak(s, newDict);
						results.put(newFirst, result);
					}

					if (result) {
						return result;
					}
				}

			}
		}
		return false;
	}

	public static boolean wordBreak1(String s, Set<String> dict) {
		return wordBreakHelper(s, dict, 0);
	}

	static Map<Integer, Boolean> aa = new HashMap<>();

	static int maxEnd = -1;
	public static boolean wordBreakHelper(String s, Set<String> dict, int start) {
		if (start == s.length())
			return true;
		for (String a : dict) {
			int len = a.length();
			int end = start + len;
			if (end > s.length() || end <= maxEnd)
				continue;
			if (a.equals(s.substring(start, end))) {
				System.out.println(end);
				maxEnd = end;
				boolean result = wordBreakHelper(s, dict, end);
				if (result)
				{
				
	
				return true;
				}
					
				
				
			}
		}
		return false;

	}

}
