package com.wjy.global;

/**
 * 定义线程环境
 *
 * @author ybxxszl
 * @date 2018年10月7日
 * @description TODO
 */
public class ThreadLocalEnv {

    private static final ThreadLocal<ThreadLocalVar> ENV = new ThreadLocal<ThreadLocalVar>();

    /**
     * GET当前环境变量
     *
     * @return ThreadLocalVar
     * @date 2018年10月7日
     * @author ybxxszl
     * @description TODO
     */
    public static ThreadLocalVar getENV() {

        ThreadLocalVar threadLocalVar = ENV.get();

        return threadLocalVar;

    }

    /**
     * SET当前环境变量
     *
     * @param threadLocalVar
     * @date 2018年10月7日
     * @author ybxxszl
     * @description TODO
     */
    public static void setENV(ThreadLocalVar threadLocalVar) {

        ENV.set(threadLocalVar);

    }

}
