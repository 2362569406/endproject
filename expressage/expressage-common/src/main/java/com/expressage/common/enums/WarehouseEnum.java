package com.expressage.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum WarehouseEnum {
    BRAND_LIST_NOT_FOUND(404,"仓库列表不存在");
    private int code;
    private String msg;
}
