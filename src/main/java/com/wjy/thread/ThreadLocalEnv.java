package com.wjy.thread;

/**
 * 定义线程环境
 * 
 * @date 2018年10月7日
 * @author ybxxszl
 * @description TODO
 */
public class ThreadLocalEnv {

	private static final ThreadLocal<ThreadLocalVar> ENV = new ThreadLocal<ThreadLocalVar>();

	/**
	 * GET当前环境变量
	 * 
	 * @date 2018年10月7日
	 * @author ybxxszl
	 * @description TODO
	 * @return ThreadLocalVar
	 */
	public static ThreadLocalVar getENV() {

		ThreadLocalVar threadLocalVar = ENV.get();

		return threadLocalVar;

	}

	/**
	 * SET当前环境变量
	 * 
	 * @date 2018年10月7日
	 * @author ybxxszl
	 * @description TODO
	 * @param threadLocalVar
	 */
	public static void setENV(ThreadLocalVar threadLocalVar) {

		ENV.set(threadLocalVar);

	}

}
