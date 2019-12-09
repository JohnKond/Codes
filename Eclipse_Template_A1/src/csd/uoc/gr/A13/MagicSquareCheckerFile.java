package csd.uoc.gr.A13;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import csd.uoc.gr.A12.MagicSquareChecker;

class MagicSquareCheckerFile {

	public static void main(String[] args) throws IOException {

		String filepath = " ";
		File file = null;

		/*
		 * I ask the user ,which option does he want. Select a folder or download a url
		 * file.
		 */

		String[] options = { "Text File", "URL" };
		int x = JOptionPane.showOptionDialog(null, "Choose your input", "Click a button", JOptionPane.DEFAULT_OPTION,
				JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

		switch (x) {

		case 0:
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setDialogTitle("Select a file");
			int userSelection = fileChooser.showSaveDialog(null);
			// if (userSelection == JFileChooser.APPROVE_OPTION) {
			file = fileChooser.getSelectedFile();
			filepath = file.getAbsolutePath();
			break;

		case 1:
			/*
			 * An o xrhsths epileksei Url , tote katevazei ta periexomena toy arxeiou, kai
			 * ta topothetei se ena arxeio Url.txt,pou dhmiourgeite shtn Downloader.
			 */
			Downloader.main();
			filepath = "Url.txt";
			file = new File("Url.txt");
		}

		try {
			/* Dhmiourgw enan bufferreader gia na diavase to epilegmeno arxeio */
			BufferedReader br = new BufferedReader(new FileReader(filepath));
			String line = "";
			String s = "";
			int count = 0;
			int numOfLines = 0;
			/*
			 * H metavlhth initialCommaCount einai o arithmos twn ',' ths 1hs grammhs ,kai h
			 * commaCount einai twn ypoloipwn grammwn
			 */
			int initialCommaCount = 0;
			int commaCount = 0;
			boolean struct = true;

			/*
			 * To string s periexei mesa ta periexomena tou arxeiou , kai to string line
			 * periexei ta periexomena ths kathe grammhs
			 */

			line = br.readLine();
			for (int i = 0; i <= line.length() - 1; i++) {
				if (line.charAt(i) == ',')
					initialCommaCount++;
			}

			while (line != null) {

				numOfLines++;
				s = s + line;
				commaCount = 0;

				for (int i = 0; i <= line.length() - 1; i++) {
					if (line.charAt(i) == ',')
						commaCount++;
				}
				/*
				 * An kapoia grammh den einai exei idio arithmo ',' tote h domh einai akatallhlh
				 */
				if (initialCommaCount != commaCount)
					struct = false;
				s = s + " ";
				line = br.readLine();
			}

			/*
			 * Sthn synexeia antikathistw me thn synarthsh replace ta kommata me kena, wste
			 * na mporei h synarthsh hasNextInt na scannarei tous arithmous
			 */

			s = s.replace(",", " ");

			Scanner scanner = new Scanner(s);

			while (scanner.hasNext()) {
				if (scanner.hasNextInt()) {
					count++;
				}
				scanner.nextInt();
			}

			/*
			 * If every line has the same number of numbers,depended to n.For example(3
			 * lines,3 numbers each line = 9 numbers).
			 */

			if ((numOfLines * numOfLines != count) || (struct == false)) {
				System.out.println("File structure in not correct");
				System.exit(0);
			}

			int arr[][] = new int[numOfLines][numOfLines];
			String[] integerStrings = s.split(" ");
			int i = 0;
			int j = 0;
			int k = 0;
			int num;
			int duplicate = 0;
			boolean magic = false;

			/* Ftiaxnw ena pinaka arr, kai elegxw gia duplicate me seiriaki anazhthsh */
			for (k = 0; k <= integerStrings.length - 1; k++) {

				num = Integer.parseInt(integerStrings[k]);

				if (MagicSquareChecker.search(arr, i, j, num) == true) {
					duplicate = 1;
				}
				arr[i][j] = num;
				j++;

				if (j == numOfLines) {
					j = 0;
					i++;
				}
			}

			/* Ektypwnw ton pinaka kai ta apotelesmata */

			System.out.println(" --------------------");
			for (i = 0; i <= arr.length - 1; i++) {
				for (j = 0; j <= arr.length - 1; j++) {
					System.out.print(String.format("%5d|", arr[i][j]));
				}
				System.out.print("\n");
				System.out.println(" --------------------");
			}

			if (MagicSquareChecker.checkIsMagic(arr) == true && duplicate == 0) {
				magic = true;
				System.out.println(
						"The square is magic and the magic element: " + MagicSquareChecker.getMagicNumber(arr));
			} else {
				if (duplicate == 1) {
					System.out.println("-The numbers you gave contains duplicate");
					System.out.println("This square is not a magic box");
				}
			}

			/*
			 * An to tetragwno einai magiko dinw sto xrhsth 2 epiloges, dhladh to erwthma c
			 * h d
			 */
			if (magic) {

				/*
				 * An o xrhsths prepei to epiliksei ena fakelo ,mesa sto opoio tha dhmiourghthei
				 * ena text file
				 */

				JFileChooser fileChooser2 = new JFileChooser();
				fileChooser2.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				fileChooser2.setDialogTitle("Select a folder");
				int userSelection = fileChooser2.showSaveDialog(null);
				if (userSelection == JFileChooser.APPROVE_OPTION) {
					File file2 = fileChooser2.getCurrentDirectory();
					file2 = fileChooser2.getSelectedFile();
					String filepath2 = file2.getAbsolutePath();

					File parentDir = new File(filepath2);
					parentDir.mkdir();
					String fileName = "results.txt";
					File file3 = new File(parentDir, fileName);
					file3.createNewFile();

					/* Copy the first file to the new file */
					FileChannel src = new FileInputStream(file).getChannel();
					FileChannel dest = new FileOutputStream(file3).getChannel();
					dest.transferFrom(src, 0, src.size());

					/* Append the file with new line */
					try {
						FileWriter fw = new FileWriter(file3, true); // the true appends the new data the file
						fw.write("\n\nThe square is magic and the magic element: "
								+ MagicSquareChecker.getMagicNumber(arr));// appends the string to the file
						fw.close();
					} catch (IOException e) {

					}

				}

				/*
				 * Alliws an o xrhsths dialeksei URL ,prepei na eisagei mia dieuthinsi URL, thn
				 * opoia katevazei kai sthn synexeia diavazei
				 */

			}

			scanner.close();

		} catch (InputMismatchException e) {
			JOptionPane.showMessageDialog(null, e);
		}

	}
}
