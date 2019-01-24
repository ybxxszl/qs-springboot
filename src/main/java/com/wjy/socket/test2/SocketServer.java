package com.wjy.socket.test2;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.wjy.util.PropertiesUtil;

public class SocketServer {

	private static final Integer PORT = PropertiesUtil.getIntegerValue("socket.server.port");

	private static final String CODING = PropertiesUtil.getStringValue("socket.coding");
	
	static ExecutorService pool = Executors.newFixedThreadPool(10);

	public static void main(String[] args) throws Exception {

		ServerSocket server = new ServerSocket(PORT);

		System.out.println("ServerSocket等待中。。。");

		Socket socket = server.accept();

		InputStream is = socket.getInputStream();

		byte[] b;

		while (true) {

			int first = is.read();

			if (first == -1) {
				break;
			}

			int second = is.read();

			b = new byte[(first << 8) + second];

			is.read(b);

			System.out.println("server receive message : " + new String(b, CODING));

			System.out.println(first);
			System.out.println(second);

		}

		is.close();
		socket.close();
		server.close();

	}

}
