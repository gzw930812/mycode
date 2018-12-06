package com.gzw.net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class Server extends Thread{
	
	private ServerSocket serverSocket;
	public Server(int port) throws IOException {
		serverSocket = new ServerSocket(port);
		serverSocket.setSoTimeout(100000);
	}
	
	@Override
	public void run() {
		while(true){
			System.out.println("等待远程连接，端口号："+serverSocket.getLocalPort()+"...");
			try {
				Socket client = serverSocket.accept();
				System.out.println("远程主机地址："+client.getRemoteSocketAddress());
				DataInputStream in = new DataInputStream(client.getInputStream());
				System.out.println(in.readUTF());
				DataOutputStream out = new DataOutputStream(client.getOutputStream());
				out.writeUTF("谁在连接我："+client.getRemoteSocketAddress()+"\nGoodbye!");
				client.close();
			} catch (IOException e) {
				e.printStackTrace();
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		int port = 9999;
		try {
			Thread server = new Server(port);
			server.run();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
