package com.example.demo.handle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.exception.CommonException;
import com.example.demo.util.Result;
import com.example.demo.util.ResultUtil;

@ControllerAdvice
public class HandleException {

	private final static Logger logger = LoggerFactory.getLogger(HandleException.class);
	
	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public Result handle(Exception e) {
		if(e instanceof CommonException) {
			CommonException commonException = (CommonException) e;
			return ResultUtil.error(commonException.getCode(), commonException.getMessage());
		} else {
			logger.error("【系统异常】 {}", e);
			return ResultUtil.error(-1, "未知错误");
		}
	}
}
