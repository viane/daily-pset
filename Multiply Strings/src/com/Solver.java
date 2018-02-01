package com;

public class Solver {
	private char[][] multiply_matrix;
	
	public String multiply(String s1, String s2) throws Throwable {
		checkInputs(s1,s2);
		
		int col_len = s1.length() + s2.length();
		int row_len = s1.length() * s2.length();
		
		initMatrix(row_len, col_len);
		
		sum(s1,s2);
		
		displayMatrix();
		return "";
	}
	
	private void sum(String s1, String s2) {
		int row_index= 0;
		for(int s2_digit = s2.length()-1; s2_digit>=0;s2_digit--) {
			for(int s1_digit = s1.length()-1; s1_digit>=0;s1_digit--,row_index++) {
				
			}
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
				multiply_matrix[row][col]='0';
				System.out.print(multiply_matrix[row][col]);
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
