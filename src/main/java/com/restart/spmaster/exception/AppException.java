package com.restart.spmaster.exception;

import com.restart.spmaster.constant.BusinessConstant;

public class AppException extends RuntimeException {
    private static final long serialVersionUID = 397623074911083068L;

    private String errorCode;
    private String errorMsg;

    public AppException(Throwable e) {
        super(e);
        this.errorCode = BusinessConstant.SYSTEM_ERROR_CODE;
    }

    /*public AppException(ResultCodeEnum resultCodeEnum) {
        this.errorCode = resultCodeEnum.getKey();
        this.errorMsg = resultCodeEnum.getName();
    }

    public AppException(ResultCodeEnum resultCodeEnum, String errorMsg) {
        this.errorCode = resultCodeEnum.getKey();
        this.errorMsg = errorMsg;
    }*/

    public AppException(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public AppException(String errorMsg) {
        this.errorCode = BusinessConstant.SYSTEM_ERROR_CODE;
        this.errorMsg = errorMsg;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

}
