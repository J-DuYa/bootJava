package com.example.demo.handle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.exception.GirlException;
import com.example.demo.util.Result;
import com.example.demo.util.ResultUtil;

@ControllerAdvice
public class HandleException {

	private final static Logger logger = LoggerFactory.getLogger(HandleException.class);
	
	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public Result handle(Exception e) {
		if(e instanceof GirlException) {
			GirlException  girlException = (GirlException) e;
			return ResultUtil.error(girlException.getCode(), girlException.getMessage());
		} else {
			logger.error("【系统异常】 {}", e);
			return ResultUtil.error(-1, "未知错误");
		}
	}
}
