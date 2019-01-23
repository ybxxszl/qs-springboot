package com.wjy.socket;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.wjy.util.PropertiesUtil;

public class SocketServer {

	private static final Integer PORT = PropertiesUtil.getIntegerValue("socket.server.port");

	private static final String CODING = PropertiesUtil.getStringValue("socket.coding");

	public static void main(String[] args) throws Exception {

		ServerSocket server = new ServerSocket(PORT);

		System.out.println("ServerSocket等待中。。。");

		Socket socket = server.accept();

		int len;
		byte[] b = new byte[1024];
		StringBuilder sb = new StringBuilder();

		InputStream is = socket.getInputStream();

		while ((len = is.read(b)) != -1) {

			sb.append(new String(b, 0, len, CODING));

		}

		System.out.println("receive message : " + sb);

		is.close();
		socket.close();
		server.close();

	}

}
