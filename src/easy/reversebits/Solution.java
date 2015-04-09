package easy.reversebits;

public class Solution {

	public static void main(String[] args) {

		System.out.println(new Solution().reverseBits(1));
	}

	public int reverseBits(int n) {
		String binary = Integer.toBinaryString(n);
		
		int length = binary.length();
		char[] preZeros = new char[32-length];
		for (int i = 0; i < preZeros.length; i++) {
			preZeros[i] = '0';
		}
		binary = new String(preZeros) + binary;
		binary = new StringBuilder(binary).reverse().toString();
		long result = 0;
		System.out.println(binary);
		int i = 0;
		for (char b : binary.toCharArray()) {
			result = result + (long) Math.pow(2, 31 - i) * (b-48);
			i++;
		}
		
		return (int)result;
	}
	public int reverseBits1(int n) {
        long sum=0;
        for(int i=0;i<32;i++){
           sum+=Math.pow(2,31-i)*(n&1);
            n=n>>1;
        }
       return (int)sum;
    }
}
