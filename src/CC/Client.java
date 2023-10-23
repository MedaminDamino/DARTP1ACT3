package CC;

import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;
import java.net.InetAddress;
import java.net.InetSocketAddress;

public class Client {

	public static void main(String[] args) {

		try {

			InetAddress inetAdd = InetAddress.getByName("198.200.122.12");
			InetSocketAddress isa = new InetSocketAddress(inetAdd, 500);
			Socket s = new Socket();
			s.connect(isa);

			System.out.println("je suis connecté");
			Scanner scanner = new Scanner(System.in);
			int nb1, nb2;
			String op1;

			nb1 = scanner.nextInt();
			nb2 = scanner.nextInt();
			do {

				System.out.println("ecrire un operateur");
				op1 = scanner.nextLine();
			} while (!op1.equals("+") && !op1.equals("-") && !op1.equals("*") && !op1.equals("/"));
			OutputStream os = s.getOutputStream();
			PrintWriter pw = new PrintWriter(os, true);

			pw.println(nb1);
			pw.println(nb2);
			pw.println(op1);
			InputStream is = s.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			System.out.println(nb1 + op1 + nb2 + "=" + br.readLine());
			System.out.println("déconnexion client");

			s.close();
		} catch (Exception e) {

			e.printStackTrace();
		}

	}
}
