package com.expressage.dao;

import com.expressage.entity.Warehouse;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

public interface WarehouseMapper extends Mapper<Warehouse> {
    @Select("SELECT MAX(warehouse_id) FROM warehouse")
    Integer selWarehouseID();
}
