package csd.uoc.gr.A12;

import java.util.Scanner;

public class MagicSquareChecker {

	/* Synartisi pou epistrefei true an to tetragwnno einai magiko, alliws false */
	public static boolean checkIsMagic(int[][] s) {
		/*
		 * O pinakas R ,periexei to athroisma twn grammwn ,kai o pinakas C periexei to
		 * athroisma twn sthlwn.Telos D1 to athroisma ths prwths diagwniou kai D2 ths
		 * deyterhs diagoniou
		 */
		int[] R = new int[s.length];
		int[] C = new int[s.length];
		int D1 = 0;
		int D2 = 0;

		for (int i = 0; i <= s.length - 1; i++) {
			R[i] = sumOfRow(s, i);
			for (int j = 0; j <= s.length - 1; j++) {
				C[j] = sumOfColumn(s, j);

			}
		}

		D1 = sumOfDiagonal1(s);
		D2 = sumOfDiagonal2(s);

		int firstRowElement = R[0];
		int firstColumnElement = C[0];
		int rowCount = 0;
		int columnCount = 0;

		/*
		 * Elegxw an to athroisma twn grammwn kai twn sthlwn einai pantou idio
		 * ,sygkrinontas me to prwto stoixeio
		 */
		for (int i = 0; i <= s.length - 1; i++) {
			if (R[i] == firstRowElement) {
				rowCount++;
			} else {
				System.out.println("-Row " + 0 + " and row " + i + " don't have same sum");
			}

			if (C[i] == firstColumnElement) {
				columnCount++;
			} else {
				System.out.println("-Collumn " + 0 + " and collumn " + i + " don't have same sum");
			}
		}

		/*
		 * An ola ta athroismata einai idia ,sygkrinw to athroisma me to athoisma twn
		 * diagwniwn. An einai idia,epistrefei true ,alliws false
		 */

		if (R[0] == D1 && D1 == D2) {
			return true;
		}

		return false;
	}

	/* Synarthsh poy epistrefei ton magiko arithmo */
	public static int getMagicNumber(int s[][]) {
		int add = 0;
		for (int k = 0; k <= s.length - 1; k++) {
			add = add + s[k][0];
		}
		return add;
	}

	/* Synarthsh pou epistrefei to athroisma twn grammwn */
	private static int sumOfRow(int[][] s, int k) {

		int sumR = 0;

		for (int j = 0; j <= s.length - 1; j++) {
			sumR = sumR + s[k][j];
		}
		return sumR;
	}

	/* Synarthsh pou epistrefei to athroisma twn sthlwn */
	private static int sumOfColumn(int[][] s, int k) {

		int sumC = 0;

		for (int i = 0; i <= s.length - 1; i++) {
			sumC = sumC + s[i][k];
		}
		return sumC;

	}

	/* Synarthsh pou epistrefei to athroisma ths prwths diagoniou */
	private static int sumOfDiagonal1(int[][] s) {

		int sumD1 = 0;

		for (int i = 0; i <= s.length - 1; i++) {
			for (int j = 0; j <= s.length - 1; j++) {
				if (i == j) {
					sumD1 = sumD1 + s[i][j];
				}
			}
		}
		return sumD1;
	}

	/* Synarthsh pou epistrefei to athroisma ths deyterhs diagoniou */
	private static int sumOfDiagonal2(int[][] s) {

		int sumD2 = 0;

		for (int i = 0; i <= s.length - 1; i++) {
			for (int j = 0; j <= s.length - 1; j++) {
				if (i + j == s.length - 1) {
					sumD2 = sumD2 + s[i][j];
				}
			}
		}
		return sumD2;

	}

	/*
	 * H synarthsh search einai mia seiriaki anazhthsh gia thn euresh diplotypwn.
	 * Epistrefei true an vrethei kapoio ,alliws false
	 */
	public static boolean search(int[][] s, int i, int j, int x) {
		for (int k = 0; k <= i; k++) {
			for (int t = 0; t <= j; t++) {
				if (s[k][t] == x) {
					return true;

				}
			}
		}
		return false;
	}

	public static void main(String[] args) {

		Scanner item = new Scanner(System.in);
		System.out.println("Type the number of n");
		int n = item.nextInt();
		if (n < 2 || n > 10) {
			System.out.println("Wrong input");
			System.exit(0);
		}

		int[][] arr = new int[n][n];
		int num, duplicate = 0;
		int add = 0;

		System.out.println("Type " + n * n + " numbers");
		for (int i = 0; i <= n - 1; i++) {
			for (int j = 0; j <= n - 1; j++) {

				num = item.nextInt();
				/* An o pinakas periexei diplotypa kane thn metavlhth duplicate =1 */
				if (search(arr, i, j, num) == true) {
					duplicate = 1;
				}

				arr[i][j] = num;

			}
		}
		/* Ektypwnw ton pinaka poy plhktrologhthike */

		System.out.println(" --------------------");
		for (int i = 0; i <= arr.length - 1; i++) {
			for (int j = 0; j <= arr.length - 1; j++) {
				System.out.print(String.format("%5d|", arr[i][j]));
			}
			System.out.print("\n");
			System.out.println(" --------------------");
		}

		/*
		 * Telos, an to tetragwno einai magiko ,ektypwnnw ton magiko arithmo, an oxi,
		 * ektypwnw tous logous gia tous opoious den einai.
		 */
		if (checkIsMagic(arr) == true && duplicate == 0) {

			System.out.println("The square is magic and the magic element: " + getMagicNumber(arr));
		} else {
			if (duplicate == 1)
				System.out.println("-The numbers you gave contains duplicate");
			System.out.println("This square is not a magic box!");

		}

	}
}
