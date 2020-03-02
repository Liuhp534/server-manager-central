package cn.liuhp.base.exception;

import lombok.Data;

/**
 * @description: 自定义异常
 * @author: liuhp534
 * @create: 2020-03-02 09:50
 */
@Data
public class CustomBusinessException extends RuntimeException {

    private String errorCode;


    public CustomBusinessException (String message) {
        super(message);
    }

    /*
    * 接收最顶层的异常，包括了error和exception
    * */
    public CustomBusinessException(Throwable cause) {
        super(cause);
    }

    public CustomBusinessException (String _errorCode, String message) {
        super(message);
        this.errorCode = _errorCode;
    }
}
