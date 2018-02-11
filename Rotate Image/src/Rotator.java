import java.util.Scanner;

public class Rotator {
    @SuppressWarnings("finally")
	public int[][] rotate(int[][] matrix) {
    		System.out.println("Input image:");
    		displayImage(matrix);
    		
    		int option = 0;  // 0 for right rotation, 1 for left rotation
    		
    		try {
    			System.out.println("Input rotation direction (0 for right rotation, 1 for left rotation) ");
    			Scanner sc = new Scanner(System.in);
    			do {
    			    while (!sc.hasNextInt()) {System.out.println("Input rotation direction (0 for right rotation, 1 for left rotation) "); sc.next();}
    			    
    			    option = sc.nextInt();
    			} while (option < 0 || option > 1);
    			sc.close();
    		}catch(Exception e) {
    			throw e;
    		}finally {

        		int[][] afterRotate = rotateMatrix(matrix, option);
        		System.out.println("\nAfter Rotation:");
        		displayImage(afterRotate);
        		
        		return afterRotate;
    		}
  
    }
    
    protected void displayImage(int[][] matrix) { 	
    		for(int[] row: matrix) {
    			System.out.print("| ");
    			for(int col : row) {
    				System.out.printf("%d ",col);
    			}
    			System.out.println("|");
    		}
    		
    }
    
    private int[][] rotateMatrix(int[][] matrix, int option){
    		// swap row[0] with row[last]...
    		for(int row = 0; row < (matrix.length-1)/2;row++) {
    			for(int col = 0; col < matrix[row].length; col++) {    				    				
    				int temp = matrix[row][col];
        			matrix[row][col] = matrix[matrix.length-1-row][col];
        			matrix[matrix.length-1-row][col] = temp;
    			}
    		}
    		
    	
    		for(int row = 0; row < matrix.length;row++) {
    			for(int col = row+1; col < matrix[row].length;col++) {    				if(row == col) continue;
    				int temp = matrix[row][col];
    				matrix[row][col] = matrix[col][row];
    				matrix[col][row] = temp;
    			}
    		}
    		return matrix;
    }
}
