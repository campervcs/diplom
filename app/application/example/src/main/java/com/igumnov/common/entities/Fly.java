package com.igumnov.common.entities;

import com.igumnov.common.orm.annotations.Entity;
import com.igumnov.common.orm.annotations.Field;
import com.igumnov.common.orm.annotations.Id;

@Entity(tableName = "Fly")
public class Fly {
    @Field(fieldName = "speed", autoIncremental = false)
    private int speed;
    @Id(autoIncremental = true, fieldName = "id")
    private int id;

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
