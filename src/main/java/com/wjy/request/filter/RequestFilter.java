package com.wjy.request.filter;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import com.wjy.global.ThreadLocalEnv;
import com.wjy.global.ThreadLocalVar;

/**
 * @author ybxxszl
 * @date 2019年1月24日
 * @description 请求过滤
 */
public class RequestFilter {

	private static Set<String> ignore = new HashSet<String>();

	// 忽略验证
	static {

		ignore.add("/wechat/author/login");
		ignore.add("/wechat/author/send");
		ignore.add("/wechat/author/register");

	}

	// 添加忽略验证
	public static void add(String p) {

		ignore.add(p);

	}

	public static boolean filter(HttpServletRequest request) {

		String path = request.getRequestURI();

		String authorId = request.getHeader("H-AuthorId");

		String token = request.getHeader("H-Token");

		Boolean verify = true;

		for (String str : ignore) {

			if (path.contains(str)) {

				verify = false;

			}

		}

		if (verify) {

			if (token == null || !"token".equals(token)) {

				return false;

			} else {

				ThreadLocalVar threadLocalVar = new ThreadLocalVar();

				threadLocalVar.setToken(token);

				if (authorId != null) {

					threadLocalVar.setAuthor_id(authorId);

				}

				ThreadLocalEnv.setENV(threadLocalVar);

			}

		} else {

			ThreadLocalVar threadLocalVar = new ThreadLocalVar("unAuthorId", "unToken");

			ThreadLocalEnv.setENV(threadLocalVar);

		}

		return true;

	}

}
