package com.igumnov.common.cache;

import java.util.LinkedList;

public class Value {

    private String key;
    private Object object;
    private long expireBy;
    private LinkedList<String> tags = new LinkedList<>();
    private boolean removed = false;

    public boolean isRemoved() {
        return removed;
    }

    public void setRemoved(boolean removed) {
        this.removed = removed;
    }


    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public long getExpireBy() {
        return expireBy;
    }

    public void setExpireBy(long expireBy) {
        this.expireBy = expireBy;
    }

    public LinkedList<String> getTags() {
        return tags;
    }

    public void setTags(LinkedList<String> tags) {
        this.tags = tags;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
