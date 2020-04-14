package com.expressage.common.excpetion;

import com.expressage.common.enums.WarehouseEnum;
import com.expressage.common.ov.ExceptionResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CommonExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionResult> handleExcoption(WarehouseException ex){
        WarehouseEnum businessEnum = ex.getBusinessEnum();
        return ResponseEntity.status(businessEnum.getCode()).body(new ExceptionResult(businessEnum));
    }
}
