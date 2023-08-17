package com.datastructure.template.instanceapi.list;

public interface ListApi<T> {

    void init(int length);

    void clear();

    boolean isEmpty();

    T get(int index);

    int get(T data);

    boolean contains(T data);

    boolean insert(int index, T data);

    boolean insert(T data);

    boolean remove(int index);

    boolean remove(T data);

    int length();

    void traverse();
}
