package CC;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
	
public class Serveur {
	public static void main(String[] args) {
	try {
	System.out.println("je suis un serveur");
	int nb1, nb2, res = 0; String op;
	ServerSocket ssk = new ServerSocket(800);
	Socket sk = ssk.accept();
	System.out.println("un client est connecté");
	OutputStream os = sk.getOutputStream();
	InputStream is = sk.getInputStream();
	InputStreamReader isr = new InputStreamReader(is);
	BufferedReader br = new BufferedReader(isr);
	nb1=Integer.parseInt(br.readLine());
	nb2=Integer.parseInt(br.readLine());
	op=br.readLine();
	switch (op)
	{
	case "+": 
	res=nb1+nb2;
	break;
	case "-": 
		res=nb1-nb2;
		break;
	case "*": 
		res=nb1*nb2;
		break;
	case "/": 
		res=nb1/nb2;
		break;
	}
	PrintWriter pw=new PrintWriter(os,true);
	pw.println(Integer.toString(res));
	System.out.println("déconnexion serveur");
	sk.close();
	ssk.close();
	}catch(Exception e) {
	e.printStackTrace();
	}

	}}


