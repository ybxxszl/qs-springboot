package com.wjy.chat.netty.client;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import com.wjy.util.PropertiesUtil;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

public class NettyClient {

	private static final String HOST = PropertiesUtil.getStringValue("socket.server.host");
	private static final Integer PORT = PropertiesUtil.getIntegerValue("socket.server.port");

	private void run() {

		NioEventLoopGroup group = new NioEventLoopGroup();

		Bootstrap b = new Bootstrap();

		b.group(group);
		b.channel(NioSocketChannel.class);
		b.handler(new ChannelInitializerHandle());

		Channel channel = b.connect(HOST, PORT).channel();

		while (true) {
			channel.writeAndFlush(new Date() + " - Hello World !!!");
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) {
		NettyClient client = new NettyClient();
		client.run();
	}

}
