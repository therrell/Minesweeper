import java.util.Scanner;

public class Minesweeper {

	public static void main(String[] args) {
		int size = 10;
		double perc = 0.20;
		Board board = new Board(size, perc);
		Scanner sc = new Scanner(System.in);
		
		board.generate();
		System.out.println("Enter the move, row, and column you would like to perform");
		System.out.println("Possible moves: \"flag\" and \"check\"");
		System.out.println("Find all non-bomb spaces to win!");
		
		while (!(board.checkLose() || board.checkWin())) {
			board.display();
			String[] move = sc.nextLine().split(" ");
			
			int cRow, cCol;
			
			
			try {
			cRow = Integer.parseInt(move[1]);
			cCol = Integer.parseInt(move[2]);
			
			if (move[0].equals("flag")) {
				board.flag(cRow,cCol);
			} else if (move[0].equals("check")) {
				board.check(cRow,cCol);
			} else {
				System.out.println("Invalid move");
				System.out.println("Possible Moves: \"flag\" and \"check\"");
			}
			
			} catch (NumberFormatException|ArrayIndexOutOfBoundsException n) {
				System.out.println("Invalid input");
			}
			
		}
		
		if (board.checkWin()) {
			System.out.println("You win!");
		} else if (board.checkLose()) {
			System.out.println("You lose.");
		} else {
			System.out.println("This should never print");
		}
		
		
	}

}
