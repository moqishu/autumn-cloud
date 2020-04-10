package com.natsucloud.common.constants;

/**
 * 自定义返回码
 *
 * @author moqishu
 * */
public enum ErrorCode {
    /**
     * 成功
     * */
    OK(0,"success"),
    FAIL(1000, "fail"),
    ALERT(1001, "alert"),

    /**
     * 系统错误
     */
    ERROR(5000, "error");

    private int code;
    private String message;

    ErrorCode(){
    }

    private ErrorCode(int code,String message){
        this.code = code;
        this.message = message;
    }

    public static ErrorCode getResultEnum(int code){
        for (ErrorCode type:ErrorCode.values()){
            if(type.getCode() == code){
                return type;
            }
        }
        return ERROR;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }



}
