package com.gzc.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Demo1_Server {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		ServerSocket server = new ServerSocket(33333);
		while(true) {
			final Socket socket = server.accept();
			new Thread(){
				public void run() {
				try {
					
					BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					PrintStream bs = new PrintStream(socket.getOutputStream());
					String line = br.readLine();
					line = new StringBuilder(line).reverse().toString();
					bs.println(line);
					socket.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    
				}
				
			}.start();
			
		}

	}

}
