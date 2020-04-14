package com.expressage.web;

import com.expressage.common.ov.PageResult;
import com.expressage.entity.Warehouse;
import com.expressage.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/warehouse")
public class WarehouseController {
    @Autowired
    private WarehouseService warehouseService;

    @GetMapping("/listWarehouse")
    public ResponseEntity<PageResult<Warehouse>> listWarehouse(Integer page,Integer limit){
        PageResult<Warehouse> pageResult = warehouseService.listWarehouse(page,limit);
        return ResponseEntity.status(HttpStatus.OK).body(pageResult);
    }

    /**
     * http://localhost:8000/warehouse/saveWarehouse
     * 如果有ID修改如果没有保存
     * @param warehouse
     * @return
     */
    @PostMapping("/saveWarehouse")
    public ResponseEntity<Void> saveWarehouse(Warehouse warehouse){
        Boolean aBoolean = null;
        if (warehouse.getWarehouseId()==null){
            warehouse.setWarehouseId(warehouseService.selWarehouseID()+1);
            //暂定
            warehouse.setWarehouseManager("root");
            aBoolean = warehouseService.insertWarehouse(warehouse);
        }else{
            aBoolean = warehouseService.updateWarehouse(warehouse);
        }
        if(aBoolean == false){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/delWarehouse/{warehouseId}")
    public ResponseEntity<Void> delWarehouse(@PathVariable("warehouseId")int warehouseId){
        if (warehouseService.delWarehouse(warehouseId)){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.badRequest().build();
    }
}
