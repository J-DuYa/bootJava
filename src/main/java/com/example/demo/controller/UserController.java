package com.example.demo.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.demo.entry.User;
import com.example.demo.service.User.UserService;
import com.example.demo.util.Result;
import com.example.demo.util.ResultUtil;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.crypto.spec.SecretKeySpec;
import javax.validation.Valid;
import java.security.Key;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Api(tags = "用户相关接口", description = "提供用户相关的 Rest API")
public class UserController {

	@Autowired
	private UserService userService;

	// 登录
	@PostMapping("/login")
	public Result<Object> login(@Valid User user) {
        System.out.println("user" + user);
		try {
//			return ResultUtil.success(user);
            String username = user.getUsername();
            String password = user.getPassword();
			Boolean isHasUser = userService.login(username,password);
			if (isHasUser) {
				Key KEY = new SecretKeySpec("javastack".getBytes(),
						SignatureAlgorithm.HS512.getJcaName());
				Map<String, Object> stringObjectMap = new HashMap<String, Object>();
				Map<Object, String> resultMap = new HashMap<Object, String>();
				stringObjectMap.put("type", "1");
				String payload = "{\"user: \" + user.getUsername() + \"password: \" + user.getPassword() + \"time: \" + new Date().getTime() + }";
				String compactJws = Jwts.builder().setHeader(stringObjectMap)
						.setPayload(payload).signWith(SignatureAlgorithm.HS512, KEY).compact();
				System.out.println("compactJws" + compactJws);
				resultMap.put("token", compactJws);
				return ResultUtil.success(resultMap);
			} else {
				return ResultUtil.error(50003, "用户名或密码错误");
			}
		} catch (Exception e) {
			return ResultUtil.error(50002, "登录失败");
		}
	}

	// 注册
	@PostMapping("/register")
	public Result<Object> register(@Valid User user) {
		try {
			// 获取用户名
			String username = user.getUsername();
			// 获取用户的密码密码加密
			String pwd = Base64.getEncoder().encodeToString(user.getPassword().getBytes("UTF-8"));

			String token = JWT.create().withAudience(user.getUsername()).sign(Algorithm.HMAC256(pwd));
			user.setRole("admin");
			user.setPassword(pwd);
			userService.signup(user);
			user.setToken(token);
			user.setPassword(null);
			return ResultUtil.success(user);
		} catch (Exception e) {
			System.out.println(e);
			return ResultUtil.error(50001, "注册失败");
		}
	}
}
