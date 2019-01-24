package com.wjy.filter;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.wjy.thread.ThreadLocalEnv;
import com.wjy.thread.ThreadLocalVar;
import com.wjy.util.TokenUtil;

/**
 * @date 2019年1月24日
 * @author ybxxszl
 * @description 请求过滤
 */
@Component
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

			if (token == null || !TokenUtil.verifyToken(token)) {

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
