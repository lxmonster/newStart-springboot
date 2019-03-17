package com.restart.spmaster.common;

import com.restart.spmaster.message.ResultFactory;
import com.restart.spmaster.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;

public class BaseManageController {
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

	/*@ModelAttribute
	protected User getUser(HttpServletRequest request){
		User user=(User)request.getAttribute("user");
		return user;
	}*/

}
