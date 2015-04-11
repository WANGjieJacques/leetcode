package medium.reversewordsinastring;

public class Solution {

	public static void main(String[] args) {
		System.out.println(new Solution().reverseWords("1 "));

	}
	
    public String reverseWords(String s) {
        String reverseString =  this.reverseString(s);
        String[] words = reverseString.split(" ");
        StringBuilder sb = new StringBuilder();
        if (words.length == 1) {
        	return this.removeSpace(reverseString);
        }
        for (String word : words) {
        	
        	sb = sb.append(" ").append(this.reverseString(word));
        }
        String string = sb.toString();
        return this.removeSpace(string);
    }
    
    public String reverseWords1(String s) {
        if (s == null || s.length() <= 0) return s;
        String[] words = s.split(" +");
        StringBuilder ret = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--)
            if (words[i].length() > 0) ret.append(words[i]).append(" ");
        return ret.toString().trim();
    }
    
    private String removeSpace(String s) {
    	while (s.length() > 0 && s.toCharArray()[s.length()-1] == ' ') {
    		s = s.substring(0, s.length()-1);
        }
    	while (s.length() > 0 && s.toCharArray()[0] == ' ') {
    		s = s.substring(1, s.length());
    	}
    	return s;
    }
    
    private String reverseString(String s) {
    	char[] chars = s.toCharArray();
    	int mid = chars.length / 2;
        for (int i = 0; i < mid; i++) {
        	char temp = chars[i];
        	chars[i] = chars[chars.length-1-i];
        	chars[chars.length-1-i] = temp;
        }
        
        return String.valueOf(chars);
    }

}
