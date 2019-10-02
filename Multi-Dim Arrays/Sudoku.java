public class Sudoku{
	int [][] sudokuGrid;
	
	public Sudoku(){
		sudokuGrid = new int[9][9];
	}
	
	public void addNumbers(int[][] filledGrid){
		for(int i = 0; i<9; i++){
			for(int j = 0; j<9; j++){
				sudokuGrid[i][j]=filledGrid[i][j];
			}
		}
	}
	
	public boolean checkRow(){
		boolean returnRowValue = false;
		//return true if rows are the same... This means there is an error
		int rlRow = 1;
		int[] row = new int [9];
		for(int i = 0; i<9; i++){
			//System.out.println("Checking row: " + rlRow);
			for(int x = 0; x<9; x++){
				row[x] = sudokuGrid[i][x];
			}
			for(int x =0; x<9; x++){
				if(row[i] == row[x]){
					//System.out.print("Error in row: " + rlRow);
					returnRowValue = true;
				}
				else{
					returnRowValue = false;
				}
			}
			
			rlRow++;
		}
		return returnRowValue;
	}
	public boolean checkColumn(){
		boolean returnColumnValue = false;
		//return true if columns are the same... This means there is an error
		int rlColumn = 1;
		int[] column = new int [9];
		for(int i=0; i<9;i++){
			//System.out.println("Checking column: " + rlColumn + "\n");
			for(int y = 0; y<9; y++){
				column[y]= sudokuGrid[y][i];
			}
			for(int y = 0; y<9; y++){
				if(column[i] == column[y]){
					//System.out.print("Error in column: " + rlColumn  + "\n");
					returnColumnValue = true;
				}
				else{
					returnColumnValue = false;
				}
			}
			
			rlColumn++;
		}
		return returnColumnValue;
	}
	
}