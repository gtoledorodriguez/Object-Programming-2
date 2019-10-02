import java.lang.Math;
import java.util.Random;

public class SudokuApp{
	public static void main(String[] args){
		Sudoku game = new Sudoku();
		
		int min = 1;
		int max = 9;
		int rndVal;
		int range = max-min+1;
		
		int[][] sudoku = new int[9][9];
		for(int y = 0; y<9; y++){
			for(int x = 0; x<9; x++){
				rndVal = (int)((Math.random()*(range)+min));
				sudoku[y][x] = rndVal;
			}
		}
		game.addNumbers(sudoku);
		
		System.out.println("Checking rows.");
		boolean rowVal = game.checkRow();
		if(rowVal == true){
			System.out.println("There is an error in one of your rows.");
		}
		
		System.out.println("Checking columns.");
		boolean columnVal = game.checkColumn();
		if(columnVal == true){
			System.out.println("There is an error in one of your columns.");
		}
		
		if((rowVal==false)&&(columnVal==false)){
			System.out.println("You got this Sudoku right!");
		}
	}
}