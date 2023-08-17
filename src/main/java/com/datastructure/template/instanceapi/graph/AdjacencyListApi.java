package com.datastructure.template.instanceapi.graph;

import com.datastructure.template.element.elementinstance.graphnode.AdjacencyListEdge;
import com.datastructure.template.element.elementinstance.graphnode.AdjacencyListNode;

public interface AdjacencyListApi<T> {

    AdjacencyListNode<T>[] getNodes();

    int[] getAdjacentNodesIndex(AdjacencyListNode<T> node);

    T getNodeVal(AdjacencyListNode<T> node);

    AdjacencyListEdge[] getEdges(AdjacencyListNode<T> node);

    int getNodesNum();

    int getAdjacentNodesNum(AdjacencyListNode<T> node);

    int getEdgesNum(AdjacencyListNode<T> node);

    boolean addNode(T data);

    boolean addEdge(int from, int to, int weight);

    boolean removeNode(T data);

    boolean removeEdge(int from, int to);

    int[] outDegree(int from);

}
