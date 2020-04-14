package com.expressage.common.ov;

import com.expressage.common.enums.WarehouseEnum;
import lombok.Data;

@Data
public class ExceptionResult {
    private int code;//状态码
    private String msg;//异常消息
    private Long timestamp;//时间戳

    public ExceptionResult(WarehouseEnum businessEnum){
        this.code = businessEnum.getCode();
        this.msg = businessEnum.getMsg();
        this.timestamp = System.currentTimeMillis();//系统时间
    }
}
