package com.restart.spmaster.common;

import com.restart.spmaster.message.ResultFactory;
import com.restart.spmaster.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;


public class BaseOpenController {
	@Autowired
	protected ResultFactory resultFactory;

	protected Result getSuccessResult(Object data){
		return resultFactory.getSuccessResult(data);
	}

	protected Result getResult(Object data,String code,Object[] args){
		return resultFactory.getResult(code, args, data);
	}

	protected Result getResult(Result result){
		return resultFactory.getResult(result);
	}

}
