package com.wjy.chat;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.wjy.util.PropertiesUtil;

public class SocketServer {

	private static final Integer PORT = PropertiesUtil.getIntegerValue("socket.server.port");

	static List<ConnectServer> connects = new ArrayList<ConnectServer>();

	static ThreadPoolExecutor executor = new ThreadPoolExecutor(ThreadParams.COREPOOLSIZE, ThreadParams.MAXIMUMPOOLSIZE,
			ThreadParams.KEEPALIVETIME, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(),
			new ThreadFactoryCreate());

	public static void main(String[] args) {

		SocketServer server = new SocketServer();

		server.run();

	}

	private void run() {

		ServerSocket server = null;

		try {

			server = new ServerSocket(PORT);

			System.out.println("聊天等待中");

			while (true) {

				Socket socket = server.accept();

				System.out.println("发现新玩家");

				ConnectServer connectServer = new ConnectServer(socket, connects);

				executor.execute(connectServer);

			}

		} catch (Exception e) {

			if ("Address already in use: JVM_Bind".equals(e.getMessage())) {
				System.out.println("端口已占用");
			} else {
				e.printStackTrace();
			}

		}

	}

}
