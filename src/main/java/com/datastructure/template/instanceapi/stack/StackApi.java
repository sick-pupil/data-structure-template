package com.datastructure.template.instanceapi.stack;

public interface StackApi<T> {

    void init(int length);

    void clear();

    boolean isEmpty();

    void push(T data);

    T pop();

    T top();

    int length();

    void traverse();
}
