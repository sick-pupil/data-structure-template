package com.datastructure.template.element.elementapi;

public interface NodeValOper<T> {

    String getStr();

    boolean setStr(String val);

    Integer getInt();

    boolean setInt(Integer val);

    Double getDouble();

    boolean setDouble(Double val);

    Long getLong();

    boolean setLong(Long val);

    Boolean getBoolean();

    boolean setBoolean(Boolean val);

    Object getObj();

    void setObj(Object data);

    T getData();

    void setData(T data);

    void destory();
}
