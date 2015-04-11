package hard.maximumgap;

import java.util.Arrays;

// 基数排序， 桶排序
public class Solution {

	public static void main(String[] args) {
		int[] a = { 1, 2, 5, 4, 2 };
		System.out.println(new Solution().maximumGap(a));

	}

	public int maximumGap(int[] num) {
		if (num.length < 2) {
			return 0;
		}

		Arrays.sort(num);
		int maxGap = 0;
		for (int i = 0; i < num.length - 1; i++) {
			int gap = num[i + 1] - num[i];
			if (gap > maxGap) {
				maxGap = gap;
			}
		}

		return maxGap;
	}

}
