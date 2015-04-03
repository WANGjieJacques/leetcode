package hard.candy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	public static void main(String[] args) {
		int[] ratings = {4,2,3,4,1};
		
		System.out.println(new Solution().candy1(ratings));
	}
	
public int atoi(String str) {
	return Integer.valueOf(str);
    }

	public int candy(int[] ratings) {
		int[] candys = new int[ratings.length];
		while (true) {
			this.caculateCandy(candys, ratings);
			if (!contains0(candys)) {
				break;
			}
		}
		
		int sum = 0;
		for (int candy : candys) {
			sum = sum + candy;
		}
		
		return sum;
	}
	
	private boolean contains0(int[] candys) {
		for (int candy : candys) {
			if (candy == 0) {
				return true;
			}
		}
		
		return false;
	}
	
	private void caculateCandy(int[] candys, int[] ratings) {
		for (int i = 0; i < ratings.length; i++) {
			int ratingLeft = this.getRatingAt(i-1, ratings);
			int ratingRight = this.getRatingAt(i+1, ratings);
			int rating = this.getRatingAt(i, ratings);
			if (rating <= ratingLeft && rating <= ratingRight) {
				candys[i] = 1;
			} else if (rating <= ratingLeft && rating > ratingRight) {
				if (candys[i+1] != 0) {
					candys[i] = candys[i+1] + 1;
				}
			} else if (rating > ratingLeft && rating <= ratingRight) {
				if (candys[i-1] != 0) {
					candys[i] = candys[i-1] + 1;
				}
			} else {
				if (candys[i-1] != 0 && candys[i+1] != 0) {
					if (candys[i-1] > candys[i+1]) {
						candys[i] = candys[i-1] + 1;
					} else {
						candys[i] = candys[i+1] + 1;
					}
				}
			}
		}
	}
	
	private int getRatingAt(int index, int[] ratings) {
		if (index >= 0 && index < ratings.length) {
			return ratings[index];
		} else {
			return Integer.MAX_VALUE;
		}
	}
	
//	private int assignCandy(int index, int[] ratings, int[] candy) {
//		int currentRating = ratings[index];
//		int leftRating = ratings[index];
//		int rightRating = ratings[index];
//		if (currentRating < leftRating && currentRating < rightRating) {
//			return 1;
//		}
//		if (currentRating > leftRating && currentRating > rightRating) {
//			if (leftRating > rightRating) {
//				if (candy[index-1] == 0) {
//					candy[index-1] = assignCandy(index-1, ratings, candy);
//				}
//				return candy[index-1];
//			}
//		}
//	}
	
	public int candy1(int[] ratings) {
		int length = ratings.length;
		int[] candy = new int[length];
		candy[0] = 0;
		int min = 0;
		List<Integer> listForMin = new ArrayList<>();
		List<Integer> listForMinNumber = new ArrayList<>();
		int i = 0;
		listForMinNumber.add(0);
		for (i = 1; i < length; i++) {
			if (ratings[i] > ratings[i-1]) {
				candy[i] = candy[i-1] + 1;
			} else if (ratings[i] < ratings[i-1]) {
				candy[i] = candy[i-1] - 1;
				if (min > candy[i]) {
					min = candy[i];
				}
			} else {
				candy[i] = 0;
				listForMin.add(min);
				listForMinNumber.add(i);
				candy[i] = 0;
				min = 0;
			}
		}
		
		listForMin.add(min);
		listForMinNumber.add(i);
		
		int sum = 0;
		for (int j = 0; j < length; j++) {
			sum = sum + candy[j];
		}
		System.out.println(Arrays.toString(candy));
		
		for (int j = 0; j < listForMin.size(); j++) {
			int offset = -listForMin.get(j) + 1;
			
			int num = listForMinNumber.get(j+1) - listForMinNumber.get(j);
			
			sum = sum + num * offset;
		}
		
		return sum;
	}
}
