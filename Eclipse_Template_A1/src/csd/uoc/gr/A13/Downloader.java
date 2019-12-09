package csd.uoc.gr.A13;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;

import javax.swing.JOptionPane;

public class Downloader {

	static int download(String address) throws FileNotFoundException, UnsupportedEncodingException {
		try {
			String s = "";
			URL url = new URL(address);
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
			int c = in.read();
			while (c != -1) {

				s = s + (char) c;
				c = in.read();
			}

			/*
			 * Grafw to string s pou periexei to perixomeno tou Url ,sto text file Url.txt
			 * pou dhmiourgw parakatw.
			 */

			PrintWriter writer = new PrintWriter("Url.txt", "UTF-8");
			writer.println(s);
			writer.close();
			in.close();
		} catch (Exception e) {
			System.out.println(e);
			return -1;
		}

		return 0;
	}

	public static String main() throws FileNotFoundException, UnsupportedEncodingException {
		String toDownload = JOptionPane.showInputDialog("Give new URL address", "");
		download(toDownload);
		return toDownload;
	}

}