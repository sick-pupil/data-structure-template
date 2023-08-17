package com.datastructure.template.instanceapi.queue;

public interface QueueApi<T> {

    void init(int length);

    void clear();

    boolean isEmpty();

    void enQueue(T data);

    boolean contains(T data);

    T deQueue();

    int length();

    void traverse();
}
