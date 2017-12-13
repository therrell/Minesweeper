import java.util.Scanner;

public class Minesweeper {

	public static void main(String[] args) {
		int size = 10;
		double perc = 0.20;
		Board board = new Board(size, perc);
		Scanner sc = new Scanner(System.in);
		boolean keepGoing = true;
		int losses = 0;
		int wins = 0;
		
		board.generate();
		System.out.println("Enter the move, row, and column you would like to perform");
		System.out.println("Possible moves: \"flag\" and \"check\"");
		System.out.println("Find all non-bomb spaces to win!");
		
		while (keepGoing) {
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
				board.display();
				System.out.println("You win!");
				wins++;
			} else if (board.checkLose()) {
				board.display();
				System.out.println("You lose.");
				losses++;
			} else {
				System.out.println("This should never print");
			}
			
			System.out.println("Current Score: " + wins + " wins and " + losses + " losses.");
			System.out.println("quit, new game, or reset");
			String comm = sc.nextLine();
			
			if (comm.equals("quit") ) {
				keepGoing = false;
			} else if (comm.equals("new game")) {
				board.generate();
			} else if (comm.equals("reset")) {
				board.reset();
			}
		}
	}
}
