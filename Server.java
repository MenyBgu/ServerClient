/*MenyBuganim 302490610_BaruchRothkoff */
package assig4_1;

import java.io.*;
import java.net.*;

public class Server {
	public static void run() throws IOException,UnknownHostException {
		
		String clientRequest;
		String answer;
		int x=0;
		int y=0;
		ServerSocket welcomeSocket = new ServerSocket(3456);

		Socket connectionSocket = welcomeSocket.accept();
		System.out.println("Waiting...");
		
		BufferedReader inFromClient=new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
		DataOutputStream outToClient=new DataOutputStream(connectionSocket.getOutputStream());
		clientRequest=inFromClient.readLine();
		System.out.println("server Received number: "+clientRequest);
		/*convert operation*/
		x=Integer.parseInt(clientRequest);
		while(x>0){
			y+=x%10;
			x/=10;
		}
		answer=String.valueOf(y);
		/*convert operation*/
		
		outToClient.writeBytes(answer+'\n');
		
		welcomeSocket.close();
	}
}
