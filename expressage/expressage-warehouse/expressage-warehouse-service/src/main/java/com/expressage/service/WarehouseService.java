package com.expressage.service;

import com.expressage.common.enums.WarehouseEnum;
import com.expressage.common.excpetion.WarehouseException;
import com.expressage.common.ov.PageResult;
import com.expressage.dao.WarehouseMapper;
import com.expressage.entity.Warehouse;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

@Service
public class WarehouseService {
    @Autowired
    private WarehouseMapper warehouseMapper;

    /**
     * 分页查询
     * @param page 当前页
     * @param limit 几条数据
     * @return
     */
    public PageResult<Warehouse> listWarehouse(Integer page,Integer limit){
        PageHelper.startPage(page,limit);
        PageInfo info = new PageInfo(warehouseMapper.selectAll());
        List list = info.getList();
        if (CollectionUtils.isEmpty(list)){
            throw new WarehouseException(WarehouseEnum.BRAND_LIST_NOT_FOUND);
        }
        PageResult<Warehouse> pageResult = new PageResult<>();
        pageResult.setData(list);
        pageResult.setCode(0);
        pageResult.setCount(info.getTotal());
        return pageResult;
    }

    @Transactional
    public Boolean insertWarehouse(Warehouse warehouse){
        warehouse.setWarehouseBuildDate(new Date());
        return warehouseMapper.insertSelective(warehouse)==1;
    }

    @Transactional
    public Boolean updateWarehouse (Warehouse warehouse){
        int i = warehouseMapper.updateByPrimaryKeySelective(warehouse);
        return i==1;
    }

    public Boolean delWarehouse(Integer warehouseId){
        int i = warehouseMapper.deleteByPrimaryKey(warehouseId);
        return i>0;
    }

    public int selWarehouseID(){
        return warehouseMapper.selWarehouseID();
    }
}
