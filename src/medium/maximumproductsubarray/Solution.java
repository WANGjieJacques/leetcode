package medium.maximumproductsubarray;

public class Solution {

	// 应该用动态规划
	public static void main(String[] args) {

		int[] num = {-2};
		System.out.print(new Solution().maxProduct(num));
	}

	private static final int NO_CUR_MAX_PRODUCT = Integer.MIN_VALUE;
	public int maxProduct(int[] A) {
		int maxProduct = Integer.MIN_VALUE;
		int curMaxNegativeProduct = 1;
		int curMaxProduct = NO_CUR_MAX_PRODUCT;
		for (int n : A) {
			if (n == 0) {
				curMaxNegativeProduct = 1;
				curMaxProduct = NO_CUR_MAX_PRODUCT;
			} else if (n > 0) {
				if (curMaxNegativeProduct != 1) {
					curMaxNegativeProduct = curMaxNegativeProduct * n;
				}
				if (curMaxProduct != NO_CUR_MAX_PRODUCT) {
					curMaxProduct = curMaxProduct * n;
				} else {
					curMaxProduct = n;
				}
				
			} else {
				int temp = curMaxNegativeProduct;
				if (curMaxProduct != NO_CUR_MAX_PRODUCT) {
					curMaxNegativeProduct = curMaxProduct * n;
				} else {
					curMaxNegativeProduct = n;
				}
				if (temp == 1) {
					curMaxProduct = NO_CUR_MAX_PRODUCT;
				} else {
					curMaxProduct = temp * n;
				}
				
			}
			if (curMaxProduct > maxProduct) {
				maxProduct = curMaxProduct;
			}
			if (n > maxProduct) {
				maxProduct = n;
			}
		}
		return maxProduct;
	}

}
