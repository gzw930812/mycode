package com.gzw.net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Arrays;

public class Client {
	
	public static void main(String[] args) {
		
		System.out.println(Arrays.toString(args));
		String serverName = "127.0.0.1";
		int port = 9999;
		
		System.out.println("主机："+serverName+",端口："+port);
		try {
			Socket client = new Socket(serverName, port);
			System.out.println("远程主机:"+client.getRemoteSocketAddress());
			OutputStream outToServer = client.getOutputStream();
			DataOutputStream out = new DataOutputStream(outToServer);
			out.writeUTF("hello from:"+client.getRemoteSocketAddress());
			DataInputStream in = new DataInputStream(client.getInputStream());
			System.out.println("服务器响应："+in.readUTF());
			client.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
