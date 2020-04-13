package com.expressage.common.excpetion;

import com.expressage.common.enums.BusinessEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BusinessException extends RuntimeException {
    private BusinessEnum businessEnum;
}
