package com.datastructure.template.element.elementinstance.graphnode;

public class AdjacencyListEdge {

    private int nodeIndex;

    private int weight;

    private AdjacencyListEdge nextEdge;

    public int getNodeIndex() {
        return this.nodeIndex;
    }

    public void setNodeIndex(int nodeIndex) {
        this.nodeIndex = nodeIndex;
    }

    public int getWeight() {
        return this.weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public AdjacencyListEdge getNextEdge() {
        return this.nextEdge;
    }

    public void setNextEdge(AdjacencyListEdge nextEdge) {
        this.nextEdge = nextEdge;
    }
}
