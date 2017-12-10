
public class Board {
	
	private int size;
	private int bombPer;
	private int[][] gameBoard;
	
	public Board(int s, int b) {
		this.size = s;
		this.bombPer = b;
		gameBoard = new int[s][s];
	}
	
	

	public void generate() {
		//randomly place bombs on the map with bombPer % of the board being covered
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
}
