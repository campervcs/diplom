package com.igumnov.common.entities;

import com.igumnov.common.orm.annotations.Entity;
import com.igumnov.common.orm.annotations.Field;
import com.igumnov.common.orm.annotations.Id;

import java.math.BigDecimal;

@Entity(tableName = "Person")
public class Cl {
    @Field(fieldName = "name", autoIncremental = false)
    private String name;
    @Field(fieldName = "age" , autoIncremental = false)
    private int age;
    @Field(fieldName = "gender" , autoIncremental = false)
    private String sex;
    @Id(autoIncremental = true, fieldName = "id")
    private BigDecimal id;
}
