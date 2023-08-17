package com.datastructure.template.instanceapi.graph;

import com.datastructure.template.element.elementinstance.graphnode.AdjacencyMatrixNode;

public interface AdjacencyMatrixApi<T> {

    AdjacencyMatrixNode<T>[] getNodes();

    T getNodeVal(AdjacencyMatrixNode<T> node);

    int[][] getEdges();

    int getNodesNum();

    int getEdgesNum();

    boolean addNode(T data);

    boolean addEdge(int from, int to, int weight);

    boolean removeNode(T data);

    boolean removeEdge(int from, int to);

    int[] outDegree(int from);

    int[] inDegree(int to);
}
