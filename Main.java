package assig4_1;

import java.io.IOException;

public class Main {
	public static void main(String[] args) {

		Thread client = new Thread(new Runnable() {

			public void run() {
				try {
					Client.run();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		Thread server = new Thread(new Runnable() {

			public void run() {
				try {
					Server.run();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		client.start();
		server.start();

		try {
			client.join();
			server.interrupt();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Bye");

	}
}
