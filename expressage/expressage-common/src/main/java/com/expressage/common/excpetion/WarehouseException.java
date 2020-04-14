package com.expressage.common.excpetion;

import com.expressage.common.enums.WarehouseEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WarehouseException extends RuntimeException {
    private WarehouseEnum businessEnum;
}
