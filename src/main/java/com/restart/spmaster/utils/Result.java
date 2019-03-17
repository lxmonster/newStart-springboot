package com.restart.spmaster.utils;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

import java.io.Serializable;

/**
 * 接口返回结果对象类
 *
 * @author huanghj2
 * @Description 类作用说明:
 * @Date 2016年6月16日
 */
@Data
@ApiModel(value = "接口返回类")
public class Result implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 错误码
     */
    @ApiModelProperty(value = "错误码")
    private String errorCode;

    /**
     * 错误消息
     */
    @ApiModelProperty(value = "错误消息")
    private String errorMsg;

    /**
     * 返回数据
     */
    @ApiModelProperty(value = "返回数据")
    private Object returnObject;

    public Result() {
    }

    public Result(String errorCode, String errorMsg, Object data) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
        this.returnObject = data;
    }

    public Result(String errorCode, Object data) {
        this.errorCode = errorCode;
        this.errorMsg = SpringUtil.getBean(MessageSource.class).getMessage(errorCode, null, LocaleContextHolder.getLocale());
        this.returnObject = data;
    }

}
