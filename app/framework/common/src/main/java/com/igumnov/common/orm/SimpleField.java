package com.igumnov.common.orm;

import java.lang.reflect.Type;

public class SimpleField {
    private String javaName;
    private String dbName;
    private Type type;
    private boolean isPK;
    private boolean autoincrement;

    public SimpleField(String javaName, String dbName, Type type, boolean isPK, boolean autoincrement) {
        this.javaName = javaName;
        this.dbName = dbName;
        this.type = type;
        this.isPK = isPK;
        this.autoincrement = autoincrement;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getJavaName() {
        return javaName;
    }

    public void setJavaName(String javaName) {
        this.javaName = javaName;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public boolean isPK() {
        return isPK;
    }

    public void setPK(boolean PK) {
        isPK = PK;
    }

    public boolean isAutoincrement() {
        return autoincrement;
    }

    public void setAutoincrement(boolean autoincrement) {
        this.autoincrement = autoincrement;
    }
}
