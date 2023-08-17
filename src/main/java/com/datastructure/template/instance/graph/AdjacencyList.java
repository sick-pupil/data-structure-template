package com.datastructure.template.instance.graph;

import com.datastructure.template.element.elementinstance.graphnode.AdjacencyListEdge;
import com.datastructure.template.element.elementinstance.graphnode.AdjacencyListNode;
import com.datastructure.template.instanceapi.graph.AdjacencyListApi;

import java.util.ArrayList;
import java.util.List;

public class AdjacencyList<T> implements AdjacencyListApi<T> {

    private AdjacencyListNode<T>[] nodesArr;

    @Override
    public AdjacencyListNode<T>[] getNodes() {
        return this.nodesArr;
    }

    @Override
    public int[] getAdjacentNodesIndex(AdjacencyListNode<T> node) {
        AdjacencyListEdge edge = node.getNextEdge();
        List<Integer> result = new ArrayList<>();
        while(edge != null) {
            result.add(edge.getNodeIndex());
            edge = edge.getNextEdge();
        }
        return result.stream().mapToInt(Integer::valueOf).toArray();
    }

    @Override
    public T getNodeVal(AdjacencyListNode<T> node) {
        return node.getData();
    }

    @Override
    public AdjacencyListEdge[] getEdges(AdjacencyListNode<T> node) {
        AdjacencyListEdge edge = node.getNextEdge();
        List<AdjacencyListEdge> result = new ArrayList<>();
        while(edge != null) {
            result.add(edge);
            edge = edge.getNextEdge();
        }
        return result.toArray(new AdjacencyListEdge[result.size()]);
    }

    @Override
    public int getNodesNum() {
        return this.nodesArr.length;
    }

    @Override
    public int getAdjacentNodesNum(AdjacencyListNode<T> node) {
        return getAdjacentNodesIndex(node).length;
    }

    @Override
    public int getEdgesNum(AdjacencyListNode<T> node) {
        return getEdges(node).length;
    }

    @Override
    public boolean addNode(T data) {
        int freeIndex = -1;
        for(int i = 0; i < this.nodesArr.length; i++) {
            if(this.nodesArr[i] == null) {
                freeIndex = i;
                break;
            } else {
                continue;
            }
        }
        if(freeIndex == -1) {
            return false;
        } else {
            AdjacencyListNode<T> node = new AdjacencyListNode<>();
            node.setNextEdge(null);
            node.setData(data);
            this.nodesArr[freeIndex] = node;
            return true;
        }
    }

    @Override
    public boolean addEdge(int from, int to, int weight) {
        if(from > this.nodesArr.length - 1 || from < 0) {
            return false;
        }
        if(to > this.nodesArr.length - 1 || to < 0) {
            return false;
        }
        AdjacencyListNode fromNode = this.nodesArr[from];
        AdjacencyListNode toNode = this.nodesArr[to];
        if(fromNode == null || toNode == null) {
            return false;
        }
        AdjacencyListEdge edge = fromNode.getNextEdge();
        AdjacencyListEdge newEdge = new AdjacencyListEdge();
        newEdge.setNodeIndex(to);
        newEdge.setWeight(weight);
        newEdge.setNextEdge(null);
        if(edge == null) {
            fromNode.setNextEdge(newEdge);
        } else {
            while(edge.getNextEdge() != null) {
                edge = edge.getNextEdge();
            }
            edge.setNextEdge(newEdge);
        }
        return true;
    }

    @Override
    public boolean removeNode(T data) {
        boolean flag = false;
        int nodeIndex = -1;
        for(int i = 0; i < this.nodesArr.length; i++) {
            AdjacencyListNode curNode = this.nodesArr[i];
            if(curNode != null && curNode.getData().equals(data)) {
                flag = true;
                nodeIndex = i;
                break;
            } else {
                continue;
            }
        }
        if(flag == false && nodeIndex == -1) {
            return false;
        } else {
            this.nodesArr[nodeIndex] = null;
            for(int i = 0; i < this.nodesArr.length; i++) {
                AdjacencyListNode node = this.nodesArr[i];
                if(node == null) {
                    continue;
                } else {
                    AdjacencyListEdge edge = node.getNextEdge();
                    if(edge == null) {
                        continue;
                    } else if(edge != null && edge.getNodeIndex() == nodeIndex) {
                        node.setNextEdge(edge.getNextEdge());
                        continue;
                    } else if(edge != null && edge.getNodeIndex() != nodeIndex) {
                        while(edge.getNextEdge() != null) {
                            AdjacencyListEdge nextEdge = edge.getNextEdge();
                            if(nextEdge.getNodeIndex() == nodeIndex) {
                                edge.setNextEdge(nextEdge.getNextEdge());
                                break;
                            } else {
                                edge = edge.getNextEdge();
                            }
                        }
                    }
                }
            }
            return true;
        }
    }

    @Override
    public boolean removeEdge(int from, int to) {
        if(from > this.nodesArr.length - 1 || from < 0) {
            return false;
        }
        if(to > this.nodesArr.length - 1 || to < 0) {
            return false;
        }
        AdjacencyListNode fromNode = this.nodesArr[from];
        AdjacencyListNode toNode = this.nodesArr[to];
        if(fromNode == null || toNode == null) {
            return false;
        }
        AdjacencyListEdge edge = fromNode.getNextEdge();
        if(edge != null && edge.getNodeIndex() == to) {
            fromNode.setNextEdge(edge.getNextEdge());
            return true;
        } else {
            while(edge != null) {
                if(edge.getNextEdge() != null && edge.getNextEdge().getNodeIndex() == to) {
                    edge.setNextEdge(edge.getNextEdge().getNextEdge());
                } else {
                    edge = edge.getNextEdge();
                }
            }
            return true;
        }
    }

    @Override
    public int[] outDegree(int from) {
        AdjacencyListNode node = this.nodesArr[from];
        AdjacencyListEdge edge = node.getNextEdge();
        List<Integer> result = new ArrayList<>();
        while(edge != null) {
            result.add(edge.getNodeIndex());
            edge = edge.getNextEdge();
        }
        return result.stream().mapToInt(Integer::valueOf).toArray();
    }

}
