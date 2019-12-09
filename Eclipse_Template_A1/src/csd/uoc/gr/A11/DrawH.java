package csd.uoc.gr.A11;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.QuadCurve2D;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

class DrawH {

	static void drawHgraphics(int L) {
		Frame f = new Frame("Draw letter H") {

			public void paint(Graphics g) {
				Graphics2D g2 = (Graphics2D) g;
				double x1 = L * 15;
				double x2 = L * 25;
				double x3 = L * 50;
				double x4 = L * 60;
				double y1 = L * 10;
				double y2 = L * 60;
				double y3 = (y1 + y2) / 2;

				g2.draw(new Line2D.Double(x1, y2, x2, y1)); // a line
				g2.draw(new Line2D.Double(x3, y2, x4, y1));
				g2.draw(new Line2D.Double(x1, y3, x4, y3));

				QuadCurve2D q = new QuadCurve2D.Float();
				q.setCurve(L * 6, L * 50, L * 14, L * 9, L * 15, L * 60);
				g2.draw(q);

			}

		};
		f.setSize(400, 400);
		f.setVisible(true);
	}

	/*
	 * H prwth main diavazei ena char kai ena int ,kai sthn synexeia kalei thn
	 * deyterh main
	 */
	public static void main(String[] args) {

		Scanner item = new Scanner(System.in);

		char M = item.next().charAt(0); // IDE
		int L = item.nextInt();

		// char M = args[0].charAt(0); // Command line arguments
		// int L = Integer.parseInt(args[1]);

		/* An ta dedomena einai swsta proxwraei parakatw */
		if (((M == 'c') || (M == 'w') || (M == 'f') || (M == 'g')) && (L >= 3 && L <= 20)) {
			main(M, L);
		} else {
			System.out.println("Wrong input. Exiting..");
			System.exit(0);
		}
	}

	/* H deyterh main ylopoiei tis leitourgies ths askhshs */
	public static void main(char M, int L) {

		Scanner item = new Scanner(System.in);

		/* Otan h anadromh ftanei sto L=3 */
		if (L < 3 || L > 20) {
			System.out.println("Give a new value for L");
			L = item.nextInt();

		}

		if (((M == 'c') || (M == 'w') || (M == 'f') || (M == 'g')) && (L >= 3 && L <= 20)) {

			/* Draw H me '*' */
			if (M == 'c') {
				while (L >= 3 && L <= 20) {
					for (int i = 0; i <= L - 1; i++) {
						for (int j = 0; j <= L - 1; j++) {

							if ((j == 0) || (j == L - 1)) {
								System.out.print("*");
							} else {
								if (i == (L - 1) / 2) {
									System.out.print("*");

								} else
									System.out.print(" ");
							}

						}
						System.out.println();
					}
					System.out.println();

					/* Anadromh gia L = L-1 */
					main(M, L - 1);

					System.out.println("Give a new value for L");
					L = item.nextInt();
				}

				System.out.println("Wrong input. Exiting..");
				System.exit(0);
			}
			/* Otan m = w ektypwnei to H se parathiro dialogou */
			if (M == 'w') {

				UIManager.put("OptionPane.messageFont", new Font("Lucida Console", Font.BOLD, 14));
				while (L >= 3 && L <= 20) {

					String s = new String();
					for (int i = 0; i <= L - 1; i++) {
						for (int j = 0; j <= L - 1; j++) {

							if ((j == 0) || (j == L - 1)) {
								s = s + "*";
							} else {
								if (i == (L - 1) / 2) {
									s = s + "*";
								} else
									s = s + " ";
							}
						}
						s = s + "\n";
					}

					JOptionPane.showMessageDialog(null, s, "Exit window", JOptionPane.INFORMATION_MESSAGE);
					/* Anadromh gia L = L-1 */
					main(M, L - 1);
					L = Integer.parseInt(JOptionPane.showInputDialog("Give me a number ", 4));

				}
				JOptionPane.showMessageDialog(null, "Wrong input. Exiting..", "Error", JOptionPane.ERROR_MESSAGE);
				System.exit(0);
			}
			/* Otan m = f dhmiourgei ena arxeio h.html */
			if (M == 'f') {

				String html = "<!DOCTYPE html><html><head><meta http-equiv=\"content-type\" content=\"text/html;charset=utf-8\"/></head><body><font size=\"10\">H with font size ="
						+ L + "</font></body></html>";
				File f = new File("H.html");
				try {
					BufferedWriter bw = new BufferedWriter(new FileWriter(f));
					bw.write(html);
					bw.close();

					/*
					 * Anadromh gia L = L-1. Epeidh omws to arxeio ginetai overwrite tha emfanistei
					 * h teleutaia timh ,dhladh L=3
					 */
					main(M, L - 1);
					System.out.println("Give a new value for L");
					L = item.nextInt();
				} catch (IOException e) {
					System.out.println("Something is wrong");
					e.printStackTrace();
				}

			}

			/*
			 * Otan m = g zwgrafizei ena kaligrafiko H kalwntaw thn synarthsh drawHgraphics
			 */
			if (M == 'g') {
				while (L >= 3 && L <= 20) {
					drawHgraphics(L);
					/* Anadromh gia L = L-1 */
					main(M, L - 1);

					System.out.println("Give a new value for L");
					L = item.nextInt();
				}
			}

		} else {
			System.out.println("Wrong input.");
			System.out.println("Exiting..");
			System.exit(0);
		}

	}
}
