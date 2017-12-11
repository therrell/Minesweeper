import javax.swing.plaf.synth.SynthSeparatorUI;

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
		this.gameBoard = new int[s][s];
		this.displayBoard = new char[s][s];
		this.numberOfBombs = (int)(bombPer * size * size);
		this.gameOver = false;
	}
	
	

	public void generate() {
		//randomly place bombs on the map with bombPer % of the board being covered
		gameOver = false;
		double check = 1;
		int m = 0;
		while (m < numberOfBombs) {
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					check = Math.random();
					if (check < bombPer && gameBoard[i][j] != 9
							&& m < numberOfBombs) {
						this.gameBoard[i][j] = 9;		
						m++;
					}
				}
			}
		}
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				displayBoard[i][j] = '*';
			}
		}
		
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (gameBoard[i][j] != 9)
				gameBoard[i][j] = getWeight(i, j);
			}
		}
	}
	
	private int getWeight(int row, int col) {
		int count = 0;
		
		for (int i = -1; i < 2; i++) {
			for (int j = -1; j < 2; j++) {
				if (row + i >= 0 && row + i < size 
					&& col + j >= 0  && col + j < size
					&& gameBoard[row + i][col + j] == 9) {
					count++;
				}
				
			}
		}
		
		return count;
	}

	public void reset() {
		//resets current game
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				displayBoard[i][j] = '*';
			}
		}
		this.gameOver = false;
	}
	
	public boolean checkWin() {
		//check to see if all bombs have been flagged or all other spaces selected
		int count = 0;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
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
		if (gameOver) {
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					if (gameBoard[i][j] == 9) {
						displayBoard[i][j] = 'X';
					} else {
						displayBoard[i][j] = Character.forDigit(gameBoard[i][j], 10);
					}
				}
			}
		}
		return gameOver;
	}



	public void check(int row, int col) {
		//checks the selected space to see if it is a bomb
		//displays number if it is not a bomb
		if (gameBoard[row][col] == 9) {
			this.displayBoard[row][col] = 'X';
			this.gameOver = true;
		} else {
			this.displayBoard[row][col] = Character.forDigit(this.gameBoard[row][col], 10);
			if (this.gameBoard[row][col] == 0) {
				this.printNeighbors(row, col);
			}
			
		}
		
	}
	
	public void printNeighbors(int row, int col) {
		//checks the spots surrounding any 0 tile found
		for (int i = -1; i < 2; i++) {
			for (int j = -1; j < 2; j++) {
				if (row + i >= 0 && row + i < size 
					&& col + j >= 0  && col + j < size
					&& displayBoard[row + i][col + j] == '*') {
					this.check(row + i, col + j);
				}
			}
		}
	}

	public void flag(int row, int col) {
		if (displayBoard[row][col] == '*') {
			displayBoard[row][col] = 'F';
		} else if (displayBoard[row][col] == 'F') {
			displayBoard[row][col] = '*';
		}
		
	}

	public void display() {
		System.out.print("  ");
		for (int i = 0; i < size; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
		for (int i = 0; i < displayBoard.length; i++) {
			System.out.print(i + " ");
			for (int j = 0; j < displayBoard[i].length; j++) {
				System.out.print(displayBoard[i][j] + " ");
			}
			System.out.println();
		}
	}
}
