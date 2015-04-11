package medium.find_minimuminrotated_sorted_array;

public class Solution {
	public static void main(String[] args) {
		int[] num = {4,5,6,1,2,3};
		System.out.println(new Solution().findMin(num));
	}
	
    public int findMin(int[] num) {
        if (num == null) {
            return Integer.MIN_VALUE;
        }
        if (num.length == 0) {
            return Integer.MIN_VALUE;
        }
        if (num[0] <= num[num.length-1]) {
            return num[0];
        }
        int low = 0;
        int high = num.length-1;
        int mid = (low + high) / 2;
        while (true) {
            if (num[mid] >= num[0]) {
                low = mid + 1;
            } else if (num[mid] > num[mid-1]) {
                high = mid - 1;
            } else {
                return num[mid];
            }
            mid = (low + high) / 2;
        }
    }	
}
