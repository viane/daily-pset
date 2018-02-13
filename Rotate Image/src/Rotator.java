public class Rotator {
	public int[][] rotate(int[][] matrix, int option) throws Exception {
    		System.out.println("Input image:");
    		displayImage(matrix);
    		
		if(option<0 || option >1) {
			// 0 for right rotation, 1 for left rotation
			throw new Exception("Invaild rotation option, only 0 and 1 can be passed");
		}

        		int[][] afterRotate = rotateMatrix(matrix, option);
        		String direction = option == 0 ? "Right" : "Left";
        		System.out.printf("After %s Rotation:\n", direction);
        		displayImage(afterRotate);
        		
        		return afterRotate;
    		
  
    }
    
    protected void displayImage(int[][] matrix) { 	
    		for(int[] row: matrix) {
    			System.out.print("| ");
    			for(int col : row) {
    				System.out.printf("%d ",col);
    			}
    			System.out.println("|");
    		}
    		System.out.println("");
    }
    
    private int[][] rotateMatrix(int[][] matrix, int option){
    	if(option == 0) {
    		// swap top/bot symmetrically
    		for(int row = 0; row < (matrix.length-1)/2;row++) {
    			for(int col = 0; col < matrix[row].length; col++) {    				    				
    				int temp = matrix[row][col];
        			matrix[row][col] = matrix[matrix.length-1-row][col];
        			matrix[matrix.length-1-row][col] = temp;
    			}
    		}
    	}
    		
    		if(option == 1) {
    			// swap left/right symmetrically
    			for(int row =0; row < matrix.length;row++) {
    				for(int col =0; col < (matrix[row].length-1)/2;col++) {
    					int temp = matrix[row][col];
    					matrix[row][col] = matrix[row][matrix[row].length-1-col];
    					matrix[row][matrix[row].length-1-col] = temp;
    				}
    			}
    		}
    		
    		// swap bottom left of matrix with top right of the matrix (around the diagonal)
    		for(int row = 0; row < matrix.length;row++) {
    			for(int col = row+1; col < matrix[row].length;col++) {
    				int temp = matrix[row][col];
    				matrix[row][col] = matrix[col][row];
    				matrix[col][row] = temp;
    			}
    		}
    		return matrix;
    }
}
