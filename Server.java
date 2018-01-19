/*MenyBuganim 302490610_BaruchRothkoff */
package assig4_1;

import java.io.*;
import java.net.*;

public class Server {
	public static void run() throws IOException,UnknownHostException {
		
		String clientRequest;
		String answer;
		int x=0;
		ServerSocket welcomeSocket = new ServerSocket(3456);

		System.out.println("Waiting...");	//print "wait" before block
		Socket connectionSocket = welcomeSocket.accept();	//This is a blocked code
		
		BufferedReader inFromClient=new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
		DataOutputStream outToClient=new DataOutputStream(connectionSocket.getOutputStream());
		clientRequest=inFromClient.readLine();
		System.out.println("server Received number: "+clientRequest);
		/*convert operation*/
		String[]result=clientRequest.split(",");
		for(String string:result)
			x+=Integer.parseInt(string);
		
		System.out.println("x:" +x);
		answer=String.valueOf(x);
		/*convert operation*/
		
		outToClient.writeBytes(answer+'\n');
		
		welcomeSocket.close();
	}
}

 
