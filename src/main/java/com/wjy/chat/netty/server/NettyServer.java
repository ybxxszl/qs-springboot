package com.wjy.chat.netty.server;

import com.wjy.util.PropertiesUtil;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class NettyServer {

	private static final Integer PORT = PropertiesUtil.getIntegerValue("socket.server.port");

	private void run() {

		EventLoopGroup bossGroup = new NioEventLoopGroup(); // 接收已进来的连接
		EventLoopGroup workGroup = new NioEventLoopGroup(); // 处理已进来的连接

		// System.out.println("监听端口：" + PORT);

		try {

			ServerBootstrap b = new ServerBootstrap();

			b.group(bossGroup, workGroup);
			b.channel(NioServerSocketChannel.class);
			b.childHandler(new ChannelInitializerHandle());
			b.option(ChannelOption.SO_BACKLOG, 128);
			b.childOption(ChannelOption.SO_KEEPALIVE, true);

			ChannelFuture channelFuture = b.bind(PORT).sync();

			channelFuture.channel().closeFuture().sync();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			workGroup.shutdownGracefully();
			bossGroup.shutdownGracefully();
		}
	}

	public static void main(String[] args) {
		NettyServer server = new NettyServer();
		server.run();
	}

}
