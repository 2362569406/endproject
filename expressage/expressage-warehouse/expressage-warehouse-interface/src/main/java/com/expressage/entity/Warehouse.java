package com.expressage.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "warehouse")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Warehouse implements Serializable {
    @Id
    private Integer warehouseId;

    private String warehouseName;

    private Double warehouseArea;

    private String warehouseType;

    private String warehouseManager;

    private String warehouseAddress;

    private Date warehouseBuildDate;
    @JsonIgnore
    private String reserve1;
    @JsonIgnore
    private String reserve2;
    @JsonIgnore
    private String reserve3;
}