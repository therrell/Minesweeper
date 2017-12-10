
public class Board {
	
	private int size;
	private double bombPer;
	private int[][] gameBoard;
	private char[][] displayBoard;
	private int numberOfBombs;
	private boolean gameOver;
	
	public Board(int s, double b) {
		this.size = s;
		this.bombPer = b;
		gameBoard = new int[s][s];
		displayBoard = new char[s][s];
		numberOfBombs = (int)(bombPer * gameBoard.length * gameBoard.length);
		gameOver = false;
	}
	
	

	public void generate() {
		//randomly place bombs on the map with bombPer % of the board being covered
		double check = 1;
		int m = 0;
		while (m < numberOfBombs) {
			for (int i = 0; i < gameBoard.length; i++) {
				for (int j = 0; j < gameBoard.length; j++) {
					check = Math.random();
					if (check < bombPer && gameBoard[i][j] != 9) {
						gameBoard[i][j] = 9;		
						m++;
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
		int count = 0;
		for (int i = 0; i < gameBoard.length; i++) {
			for (int j = 0; j < gameBoard.length; j++) {
				if (displayBoard[i][j] == '*' || displayBoard[i][j] == 'F') {
					count++;
				}
			}
		}
		if (count == numberOfBombs) {
		return true;
		} else {
			return false;
		}
	}
	
	public boolean checkLose() {
		//check to see if a bomb has been hit
		return gameOver;
	}



	public void check(int cRow, int cCol) {
		// TODO Auto-generated method stub
		
		if (gameBoard[cRow][cCol] == 9) {
			gameOver = true;
		}
		
	}

	public void flag(int cRow, int cCol) {
		displayBoard[cRow][cCol] = 'F';
		
	}

	public void display() {
		for (int i = 0; i < displayBoard.length; i++) {
			for (int j = 0; j < displayBoard[i].length; j++) {
				System.out.print(displayBoard[i][j] + " ");
			}
			System.out.println();
		}
	}
}
