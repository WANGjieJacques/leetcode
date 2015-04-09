package compareversionnumbers;

public class Solution {

	public static void main(String[] args) {
		System.out.println(new Solution().compareVersion("1", "1.2"));
	}

	public int compareVersion(String version1, String version2) {
		int num1 = 0;
		int num2 = 0;
		
		int firstPointIndex1 = version1.indexOf('.');
		if (firstPointIndex1 == -1) {
			firstPointIndex1 = version1.length();
		}
		System.out.println(version1);
		String n1 = version1.substring(0, firstPointIndex1);
		num1 = Integer.parseInt(n1);
		int firstPointIndex2 = version2.indexOf('.');
		if (firstPointIndex2 == -1) {
			firstPointIndex2 = version2.length();
		}
		
		String n2 = version2.substring(0, firstPointIndex2);
		num2 = Integer.parseInt(n2);
		
		if (num1 > num2) {
			return 1;
		} else if (num1 < num2) {
			return -1;
		} else {
			int start1 = firstPointIndex1+1;
			int start2 = firstPointIndex2+1;
			if (start1 > version1.length()) {
				start1 = version1.length();
			}
			if (start2 > version2.length()) {
				start2 = version2.length();
			}
			String nextVersion1 = version1.substring(start1);
			String nextVersion2 = version2.substring(start2);
			
			if (nextVersion1.equals("") && nextVersion2.equals("")) {
				return 0;
			} else if (nextVersion1.equals("")) {
				nextVersion1 = "0";
			} else if (nextVersion2.equals("")) {
				nextVersion2 = "0";
			}
			return compareVersion(nextVersion1, nextVersion2);
		}
	}
}
