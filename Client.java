package assig4_1;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
	private static Scanner sc;

	public static void run() throws Exception {
		sc = new Scanner(System.in);

		String number;
		String ansNumber;
		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
		Socket clientSocket = new Socket("localhost", 3456);
		DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
		BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		System.out.println("Enter number please: ");
		number = sc.nextLine();

		outToServer.writeBytes(number + '\n');
		System.out.println("Sended.");

		ansNumber = inFromServer.readLine();
		System.out.println("From Server: " + ansNumber);

		clientSocket.close();
	}
}