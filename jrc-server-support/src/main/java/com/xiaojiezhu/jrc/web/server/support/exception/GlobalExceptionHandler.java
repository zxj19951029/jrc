package com.xiaojiezhu.jrc.web.server.support.exception;

import com.xiaojiezhu.jrc.common.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Global exception handler
 *
 * @author xiaojie.zhu
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    public final static Logger LOG = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ResponseBody
    @ExceptionHandler
    public Result<?> handler(Throwable throwable){
        if(ExceptionMapping.isPrintError(throwable)){
            throwable.printStackTrace();
        }else{
            LOG.info(throwable.getMessage());
        }

        int errorCode = ExceptionMapping.getErrorCode(throwable);
        Result<?> result = new Result<>(errorCode,throwable.getMessage());
        return result;
    }

}