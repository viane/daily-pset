package com;

public class Solver {
	private char[][] multiply_matrix;
	
	public String multiply(String s1, String s2) throws Throwable {
		checkInputs(s1,s2);
		
		int col_len = s1.length() + s2.length();
		int row_len = s1.length() * s2.length();
		
		// 
		
		initMatrix(row_len, col_len);
		
		return sum(s1,s2,row_len,col_len);
	}
	
	private String sum(String s1, String s2, int row_len, int col_len) {
		int row_index= 0;
		int carry_out = 0;
		
		// place proper multiplyed digit into matrix
		for(int s2_digit = s2.length()-1; s2_digit>=0;s2_digit--) {
			for(int s1_digit = s1.length()-1; s1_digit>=0;s1_digit--,row_index++) {
				int single_digit_multiply = (s1.charAt(s1_digit) - '0') * (s2.charAt(s2_digit) - '0');

				single_digit_multiply += carry_out;
	
				carry_out = single_digit_multiply >= 10 ?  single_digit_multiply/10 : 0;
				single_digit_multiply = single_digit_multiply % 10;
				
				multiply_matrix[row_index][s2_digit+s1_digit+1] = (char) ('0'+ single_digit_multiply);
						
//				System.out.printf("%d , %d => %s \n",row_index,s2_digit+s1_digit+1, single_digit_multiply);
//				
//				System.out.println(multiply_matrix[row_index][s2_digit+s1_digit+1]);
			}
		}
		
		// for ending carry out
		multiply_matrix[--row_index][0] =  carry_out > 0 ? (char)('0' +carry_out) : '0';
		
		StringBuilder sb = new StringBuilder();
		carry_out = 0;
		for(int digit_col_index= col_len-1;digit_col_index>=0;digit_col_index--) {
			int digit_sum_per_col = 0;
			for(int digit_row_index = row_len-1;digit_row_index>=0;digit_row_index--) {
				digit_sum_per_col += multiply_matrix[digit_row_index][digit_col_index] - '0';
			}
			digit_sum_per_col += carry_out;
			
			carry_out = digit_sum_per_col >= 10 ? digit_sum_per_col/10 : 0;
			
			digit_sum_per_col = digit_sum_per_col % 10;
			
			sb.insert(0, (char)('0'+digit_sum_per_col));
			
		}
		
//		displayMatrix();
		
		if(sb.charAt(0) == '0') {
			return sb.substring(1).toString();
		}else {
			return sb.toString();
		}

	}
	
	private void checkInputs(String s1, String s2) throws Throwable {
		int col_len = s1.length() + s2.length();
		int row_len = s1.length() * s2.length();
		
		if(col_len==0 || row_len==0) {
			throw new Exception("One of the string is empty");
		}
		
		for(int mul_digit = s2.length()-1; mul_digit>=0;mul_digit--) {
			if(s2.charAt(mul_digit) - '0'>9) {
				throw new Exception("One of the digit is not a position number");
			}
		}
		
		for(int mul_digit = s1.length()-1; mul_digit>=0;mul_digit--) {
			if(s1.charAt(mul_digit) - '0'>9) {
				throw new Exception("One of the digit is not a position number");
			}
		}
	}
	
	private void displayMatrix() {
		for(int row = 0; row<multiply_matrix.length;row++) {
			for(int col = 0; col < multiply_matrix[row].length;col++) {
				System.out.print(multiply_matrix[row][col] + " ");
			}
			System.out.print('\n');
		}
	}
	
	private void initMatrix(int row_len, int col_len) {
		multiply_matrix = new char[row_len][col_len];
		for(int row = 0; row<multiply_matrix.length;row++) {
			for(int col = 0; col < multiply_matrix[row].length;col++) {
				multiply_matrix[row][col]='0';
			}
		}
	}
}
