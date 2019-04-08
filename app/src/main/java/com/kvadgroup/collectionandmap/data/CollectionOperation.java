package com.kvadgroup.collectionandmap.data;

import java.util.List;

public class CollectionOperation {

    private CollectionOperationType type;
    private long time;
    private List<Integer> list;

    public CollectionOperationType getType() {
        return type;
    }

    public void setType(CollectionOperationType type) {
        this.type = type;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public List<Integer> getList() {
        return list;
    }

    public void setList(List<Integer> list) {
        this.list = list;
    }
}
