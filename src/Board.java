
public class Board {
	
	private int size;
	private double bombPer;
	private int[][] gameBoard;
	private char[][] displayBoard;
	
	public Board(int s, double b) {
		this.size = s;
		this.bombPer = b;
		gameBoard = new int[s][s];
	}
	
	

	public void generate() {
		//randomly place bombs on the map with bombPer % of the board being covered
		double check = 1;
		int numberOfBombs = (int)(bombPer * gameBoard.length * gameBoard.length);
		for (int m = 0; m < numberOfBombs; m++) {
			for (int i = 0; i < gameBoard.length; i++) {
				for (int j = 0; j < gameBoard.length; j++) {
					check = Math.random();
					if (check < bombPer && gameBoard[i][j] != 9) {
						gameBoard[i][j] = 9;						
					}
				}
			}
		}
		for (int i = 0; i < gameBoard.length; i++) {
			for (int j = 0; j < gameBoard.length; j++) {
				displayBoard[i][j] = '*';
			}
		}
	}

	public void reset() {
		//reset the game and generate a new board
	}
	
	public boolean checkWin() {
		//check to see if all bombs have been flagged
		
		return false;
	}
	
	public boolean checkLose() {
		//check to see if a bomb has been hit
		
		return false;
	}



	public void check(int cRow, int cCol) {
		// TODO Auto-generated method stub
		
	}



	public void flag(int cRow, int cCol) {
		// TODO Auto-generated method stub
		
	}



	public void display() {
		// TODO Auto-generated method stub
		
	}
}
