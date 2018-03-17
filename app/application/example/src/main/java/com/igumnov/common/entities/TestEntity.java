package com.igumnov.common.entities;

import com.igumnov.common.orm.annotations.Entity;
import com.igumnov.common.orm.annotations.Field;
import com.igumnov.common.orm.annotations.Id;

import java.util.Date;

@Entity(tableName = "Car")
public class TestEntity {
    @Field(fieldName = "Sold", autoIncremental = false)
    private Date date;
    @Id(autoIncremental = true, fieldName = "id")
    private Integer id;
}
