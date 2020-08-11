package com.example.demo.util;

import com.example.demo.util.Result;

public class ResultUtil {

	public static Result success(Object object) {
		Result result = new Result();
		result.setCode(10000);
		result.setMsg("成功");
		result.setData(object);
		return result;
	}	
	
	public static Result success() {
		Result result = new Result();
		result.setCode(10000);
		result.setMsg("成功");
		result.setData(null);
		return result;
	}
	
	public static Result error(Integer code, String msg) {
		Result result = new Result();
		result.setCode(code);
		result.setMsg(msg);
		return result;
	}
}
