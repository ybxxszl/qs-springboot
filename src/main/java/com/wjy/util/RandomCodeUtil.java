package com.wjy.util;

import java.util.UUID;

/**
 * @author ybxxszl
 * @date 2018年10月9日
 * @description RandomCode工具类
 */
public class RandomCodeUtil {

    /**
     * @return String 随机的32位字符串
     * @date 2018年10月9日
     * @author ybxxszl
     * @description 获取UUID
     */
    public static String getUUID() {

        return UUID.randomUUID().toString();

    }

    /**
     * @return String 随机的6位字符串
     * @date 2018年11月11日
     * @author ybxxszl
     * @description 获取验证码
     */
    public static String getVerifyCode() {

        return (int) ((Math.random() * 9 + 1) * 100000) + "";

    }

}
