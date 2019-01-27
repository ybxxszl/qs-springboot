package com.wjy.chat.socket;

import com.wjy.util.PropertiesUtil;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * socket服务
 * 
 * @author wjy
 * @date 2019年1月27日
 */
public class SocketServer {

	private static final Integer PORT = PropertiesUtil.getIntegerValue("socket.server.port");

	/*
	 * 记录连接socket服务的客户端信息
	 */
	static List<ConnectServer> connects = new ArrayList<ConnectServer>();

	/*
	 * 线程池
	 */
	static ThreadPoolExecutor executor = new ThreadPoolExecutor(ThreadParams.COREPOOLSIZE, ThreadParams.MAXIMUMPOOLSIZE,
			ThreadParams.KEEPALIVETIME, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(),
			new ThreadFactoryCreate());

	/**
	 * 1、启动服务，监听端口 2、等待客户端连接端口
	 */
	private void run() {

		ServerSocket server = null;

		try {

			server = new ServerSocket(PORT);

			System.out.println("聊天等待中");

			while (true) {

				Socket socket = server.accept();

				// 如果socket.close()时，数据没有发送完成，逗留10s
				socket.setSoLinger(true, 10000);

				// 设置连接存活
				// 如果两个小时没有数据传输，那么服务端自动发送保持存活的消息到客户端，没有响应，关闭连接
				socket.setKeepAlive(true);

				// 设置立即发送数据
				socket.setTcpNoDelay(true);

				// 设置接收缓冲大小，默认为8K
				// socket.setReceiveBufferSize(size);
				// 设置发送缓冲大小，默认为8K
				// socket.setSendBufferSize(size);

				System.out.println("发现新玩家");

				// 为每一个连接服务的客户端设置一个连接服务
				ConnectServer connectServer = new ConnectServer(socket, connects);

				// 放入线程池中运行
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

	public static void main(String[] args) {

		SocketServer server = new SocketServer();

		server.run();

	}

}
