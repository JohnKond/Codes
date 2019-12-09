package csd.uoc.gr.A14;

import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Sudoku {

	private static final int BOARD_SIZE = 9;
	private static final int SUBSECTION_SIZE = 3;
	private static final int BOARD_START_INDEX = 0;

	private static final int NO_VALUE = 0;
	private static final int MIN_VALUE = 1;
	private static final int MAX_VALUE = 9;

	private static int[][] board = { { 8, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 3, 6, 0, 0, 0, 0, 0 },
			{ 0, 7, 0, 0, 9, 0, 2, 0, 0 }, { 0, 5, 0, 0, 0, 7, 0, 0, 0 }, { 0, 0, 0, 0, 4, 5, 7, 0, 0 },
			{ 0, 0, 0, 1, 0, 0, 0, 3, 0 }, { 0, 0, 1, 0, 0, 0, 0, 6, 8 }, { 0, 0, 8, 5, 0, 0, 0, 1, 0 },
			{ 0, 9, 0, 0, 0, 0, 4, 0, 0 } };

	public static void main(String[] args) {
		Sudoku solver = new Sudoku();
		Scanner item = new Scanner(System.in);
		int[][] boardSud = new int[BOARD_SIZE][BOARD_SIZE];

		System.out.println("How many pairs of sudoku you want?");
		int N = item.nextInt();

		System.out.println("How many blanks you want?");
		int X = item.nextInt();

		int i = 0, validBoards = 0, invalidBoards = 0, unsolvableBoards = 0;
		long start = System.currentTimeMillis();

		while (i <= N - 1) {

			/* Dhmiourgw neo board . An einai epilysimo synexizw , alliws ksanaprospathw */
			boardSud = newBoard(X);

			if (solver.isSolvable(boardSud) == true) {

				System.out.println("Board #" + (i + 1));

				solver.printBoard(boardSud);
				if (solver.solve(boardSud)) {
					System.out.println("Solution of the Board #" + (i + 1));
					solver.printBoard(boardSud);
					validBoards++;
					i++;
				} else
					unsolvableBoards++;
			} else {
				invalidBoards++;
			}

		}

		long end = System.currentTimeMillis();
		float sec = (end - start) / 1000F;

		System.out.println("Empty cells per board:      " + X);
		System.out.println("Valid boards created:       " + validBoards);
		System.out.println("Invalid boards created:     " + invalidBoards);
		System.out.println("Unsolvable boards created:  " + unsolvableBoards);
		System.out.println("Elapsed time in seconds:    " + sec);

	}

	/*
	 * H synarthsh isValid elegxei an o arxikos pinakas einai swstos , me thn
	 * voihtheia twn parakatw synarthsewn
	 */
	private boolean isValidBoard(int[][] brd) {
		int count = 0, blank = 0;

		for (int i = 0; i <= BOARD_SIZE - 1; i++) {
			for (int j = 0; j <= BOARD_SIZE - 1; j++) {

				if (brd[i][j] < 0 || brd[i][j] > 9)
					return false;

				if (brd[i][j] == 0) {
					blank++;
					continue;
				}
				if (isValid(brd, i, j))
					count++;

			}
		}

		/*
		 * An ta kena mazi me tous arithmous einai sto synolo 81 tote to arxiko sudoku
		 * einai swsto
		 */
		if (blank + count == 81)
			return true;
		return false;
	}

	private boolean isSolvable(int[][] brd) {
		if (isValidBoard(brd))
			return true;
		return false;
	}

	public static int[][] newBoard(int blanks) {

		Random randomGenerator = new Random();
		int r = 0, k = 0;
		/*
		 * Ftiaxnw ena pinaka randNums, o opoios periexei mesa (81-kena) tyxaious
		 * arithmous, kai arxikopoiw enan 2D pinaka me 0.
		 */
		int[] randNums = new int[BOARD_SIZE * BOARD_SIZE - blanks];
		int[][] board2 = new int[BOARD_SIZE][BOARD_SIZE];

		for (r = 0; r <= randNums.length - 1; r++) {
			randNums[r] = randomGenerator.nextInt(MAX_VALUE - MIN_VALUE + 1) + MIN_VALUE;
		}

		for (int i = 0; i <= BOARD_SIZE - 1; i++) {
			for (int j = 0; j <= BOARD_SIZE - 1; j++) {
				board2[i][j] = 0;
			}
		}

		/*
		 * Sthn synexeia me tuxaious arithmous grammwn kai sthlwn (i kai j), gemizw
		 * (81-blank) theseis tou pinaka menoun (81-blanks),enw oi ypoloipes exoun hdh
		 * arxikopoihthei me 0
		 */

		r = 0;
		while (r <= randNums.length - 1) {
			int row = randomGenerator.nextInt(8 - 0 + 1) + 0;
			int column = randomGenerator.nextInt(8 - 0 + 1) + 0;

			if (board2[row][column] == 0) {
				board2[row][column] = randNums[r];
				r++;
			}
		}

		return board2;
	}

	private void printBoard(int[][] board) {
		for (int row = BOARD_START_INDEX; row < BOARD_SIZE; row++) {
			for (int column = BOARD_START_INDEX; column < BOARD_SIZE; column++) {
				System.out.print(board[row][column] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private boolean solve(int[][] board) {
		for (int row = BOARD_START_INDEX; row < BOARD_SIZE; row++) {
			for (int column = BOARD_START_INDEX; column < BOARD_SIZE; column++) {
				if (board[row][column] == NO_VALUE) {
					for (int k = MIN_VALUE; k <= MAX_VALUE; k++) {
						board[row][column] = k;
						if (isValid(board, row, column) && solve(board)) {
							return true;
						}
						board[row][column] = NO_VALUE;
					}
					return false;
				}
			}
		}
		return true;
	}

	private boolean isValid(int[][] board, int row, int column) {
		return rowConstraint(board, row) && columnConstraint(board, column) && subsectionConstraint(board, row, column);
	}

	private boolean subsectionConstraint(int[][] board, int row, int column) {
		boolean[] constraint = new boolean[BOARD_SIZE];
		int subsectionRowStart = (row / SUBSECTION_SIZE) * SUBSECTION_SIZE;
		int subsectionRowEnd = subsectionRowStart + SUBSECTION_SIZE;

		int subsectionColumnStart = (column / SUBSECTION_SIZE) * SUBSECTION_SIZE;
		int subsectionColumnEnd = subsectionColumnStart + SUBSECTION_SIZE;

		for (int r = subsectionRowStart; r < subsectionRowEnd; r++) {
			for (int c = subsectionColumnStart; c < subsectionColumnEnd; c++) {
				if (!checkConstraint(board, r, constraint, c))
					return false;
			}
		}
		return true;
	}

	private boolean columnConstraint(int[][] board, int column) {
		boolean[] constraint = new boolean[BOARD_SIZE];
		return IntStream.range(BOARD_START_INDEX, BOARD_SIZE)
				.allMatch(row -> checkConstraint(board, row, constraint, column));
	}

	private boolean rowConstraint(int[][] board, int row) {
		boolean[] constraint = new boolean[BOARD_SIZE];
		return IntStream.range(BOARD_START_INDEX, BOARD_SIZE)
				.allMatch(column -> checkConstraint(board, row, constraint, column));
	}

	private boolean checkConstraint(int[][] board, int row, boolean[] constraint, int column) {
		if (board[row][column] != NO_VALUE) {
			if (!constraint[board[row][column] - 1]) {
				constraint[board[row][column] - 1] = true;
			} else {
				return false;
			}
		}
		return true;
	}
}