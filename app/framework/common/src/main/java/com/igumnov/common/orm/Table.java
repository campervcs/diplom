package com.igumnov.common.orm;

import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Table {
    private Type Entity;
    private String TableName;
    private List<SimpleField> fields;
    private Map<String, String> mapping;

    public Table(Type entity, String tableName, List<SimpleField> fields) {
        Entity = entity;
        TableName = tableName;
        this.fields = fields;
        mapping = new LinkedHashMap<>();
        for(SimpleField f: fields)
        mapping.put(f.getJavaName(),f.getDbName());
    }

    public String getTableName() {
        return TableName;
    }

    public void setTableName(String tableName) {
        TableName = tableName;
    }

    public List<SimpleField> getFields() {
        return fields;
    }

    public void setFields(List<SimpleField> fields) {
        this.fields = fields;
    }

    public Type getEntity() {
        return Entity;
    }

    public void setEntity(Type entity) {
        Entity = entity;
    }

    public Map<String, String> getMapping(){
        return mapping;
    }

}
