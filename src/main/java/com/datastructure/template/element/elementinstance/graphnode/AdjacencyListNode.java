package com.datastructure.template.element.elementinstance.graphnode;

import com.datastructure.template.element.elementapi.AbstractNode;

public class AdjacencyListNode<T> extends AbstractNode<T> {

    private AdjacencyListEdge nextEdge;

    public AdjacencyListEdge getNextEdge() {
        return this.nextEdge;
    }

    public void setNextEdge(AdjacencyListEdge nextEdge) {
        this.nextEdge = nextEdge;
    }
}
