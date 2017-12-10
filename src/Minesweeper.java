import java.util.Scanner;

public class Minesweeper {

	public static void main(String[] args) {
		int size = 10;
		int perc = 30;
		Board board = new Board(size, perc);
		Scanner sc = new Scanner(System.in);
		
		board.generate();
		System.out.println("Enter the row, column, and move you would like to make separated by a space");
		System.out.println("Possible moves: \"flag\" and \"check\"");
		
		while (!(board.checkLose() || board.checkWin())) {
			String[] move = sc.nextLine().split(" ");
			int cRow = Integer.parseInt(move[0]);
			int cCol = Integer.parseInt(move[1]);

			
		}
		

	}

}
