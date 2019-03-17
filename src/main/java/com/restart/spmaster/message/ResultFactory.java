package com.restart.spmaster.message;

import com.restart.spmaster.constant.BusinessConstant;
import com.restart.spmaster.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import java.util.Locale;


@Component("messageFactory")
public class ResultFactory {
	@Autowired
	private MessageSource messageSource;

	private String getMsg(String key,Object[] args){
		Locale locale = LocaleContextHolder.getLocale();
		return messageSource.getMessage(key, args, locale);
	}

	public Result getSuccessResult(Object data){
		Result result = new Result(BusinessConstant.SYSTEM_SUCESS_CODE,getMsg(BusinessConstant.SYSTEM_SUCESS_CODE,null),data);
		return result;
	}

	public Result getSysErrorResult(Object data){
		Result result = new Result(BusinessConstant.SYSTEM_ERROR_CODE,getMsg(BusinessConstant.SYSTEM_ERROR_CODE,null),data);
		return result;
	}

	public Result getResult(String code,Object[] args,Object data){
		Result result = new Result(code,getMsg(code,args),data);
		return result;
	}

	public Result getResult(Result result){
		result = new Result(result.getErrorCode(),getMsg(result.getErrorCode(),null),result.getReturnObject());
		return result;
	}
}
