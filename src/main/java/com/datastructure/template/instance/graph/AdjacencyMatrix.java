package com.datastructure.template.instance.graph;

import com.datastructure.template.element.elementinstance.graphnode.AdjacencyMatrixNode;
import com.datastructure.template.instanceapi.graph.AdjacencyMatrixApi;

import java.util.ArrayList;
import java.util.List;

public class AdjacencyMatrix<T> implements AdjacencyMatrixApi<T> {

    private int edgesNum;

    private int nodesNum;

    private AdjacencyMatrixNode<T>[] nodes;

    private int[][] edges;

    private static final int NOWEIGTH = Integer.MAX_VALUE;

    @Override
    public AdjacencyMatrixNode<T>[] getNodes() {
        return this.nodes;
    }

    @Override
    public T getNodeVal(AdjacencyMatrixNode<T> node) {
        return node.getData();
    }

    @Override
    public int[][] getEdges() {
        return this.edges;
    }

    @Override
    public int getNodesNum() {
        return this.nodesNum;
    }

    @Override
    public int getEdgesNum() {
        return this.edgesNum;
    }

    @Override
    public boolean addNode(T data) {
        if(this.nodes.length == this.nodesNum) {
            return false;
        } else {
            AdjacencyMatrixNode<T> node = new AdjacencyMatrixNode<T>();
            this.nodes[this.nodesNum] = node;
            this.nodesNum += 1;
            return true;
        }
    }

    @Override
    public boolean addEdge(int from, int to, int weight) {
        if(from > this.edges.length - 1 || to > this.edges[0].length - 1) {
            return false;
        }
        int curWeight = this.edges[from][to];
        if(curWeight != this.NOWEIGTH) {
            return false;
        } else {
            this.edges[from][to] = weight;
            this.edgesNum += 1;
            return true;
        }
    }

    @Override
    public boolean removeNode(T data) {
        int removeIndex = -1;
        for(int i = 0; i < this.nodesNum; i++) {
            if(this.nodes[i].getData().equals(data)) {
                removeIndex = i;
                break;
            }
        }
        if(removeIndex == -1) {
            return true;
        } else {
            this.nodes[removeIndex] = null;
            for(int i = 0; i < this.edges.length; i++) {
                for(int j = 0; j < this.edges[0].length; j++) {
                    if(i == removeIndex || j == removeIndex) {
                        this.edges[i][j] = this.NOWEIGTH;
                        this.edgesNum -= 1;
                    }
                }
            }
            return true;
        }
    }

    @Override
    public boolean removeEdge(int from, int to) {
        if(from > this.edges.length - 1 || to > this.edges[0].length - 1) {
            return false;
        }
        this.edges[from][to] = this.NOWEIGTH;
        this.edgesNum -= 1;
        return true;
    }

    @Override
    public int[] outDegree(int from) {
        List<Integer> tmpOutDegree = new ArrayList<>();
        for(int i = 0; i < this.edges[from].length; i++) {
            if(this.edges[from][i] == this.NOWEIGTH) {
                continue;
            } else {
                tmpOutDegree.add(i);
            }
        }
        return tmpOutDegree.stream().mapToInt(Integer::valueOf).toArray();
    }

    @Override
    public int[] inDegree(int to) {
        List<Integer> tmpInDegree = new ArrayList<>();
        for(int i = 0; i < this.edges.length; i++) {
            if(this.edges[i][to] == this.NOWEIGTH) {
                continue;
            } else {
                tmpInDegree.add(i);
            }
        }
        return tmpInDegree.stream().mapToInt(Integer::valueOf).toArray();
    }
}
