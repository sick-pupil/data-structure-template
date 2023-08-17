package com.datastructure.template.element.elementapi;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.math.NumberUtils;

public abstract class AbstractNode<T> implements NodeValOper<T> {

    protected T data;

    @Override
    public String getStr() {
        return String.valueOf(data);
    }

    @Override
    public boolean setStr(String val) {
        if(data instanceof String) {
            data = (T)val;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Integer getInt() {
        return NumberUtils.toInt(getStr());
    }

    @Override
    public boolean setInt(Integer val) {
        if(data instanceof Integer) {
            data = (T)val;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Double getDouble() {
        return NumberUtils.toDouble(getStr());
    }

    @Override
    public boolean setDouble(Double val) {
        if(data instanceof Double) {
            data = (T)val;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Long getLong() {
        return NumberUtils.toLong(getStr());
    }

    @Override
    public boolean setLong(Long val) {
        if(data instanceof Long) {
            data = (T)val;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Boolean getBoolean() {
        return BooleanUtils.toBoolean(getStr());
    }

    @Override
    public boolean setBoolean(Boolean val) {
        if(data instanceof Boolean) {
            data = (T)val;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Object getObj() {
        return data;
    }

    @Override
    public void setObj(Object data) {
        this.data = (T)data;
    }

    @Override
    public T getData() {
        return data;
    }

    @Override
    public void setData(T data) {
        this.data = data;
    }

    @Override
    public void destory() {
        data = null;
    }

    @Override
    public String toString() {
        return "node data: " + getStr();
    }
}
