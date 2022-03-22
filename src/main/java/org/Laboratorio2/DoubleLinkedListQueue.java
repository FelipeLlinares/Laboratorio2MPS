package org.Laboratorio2;

import jdk.jshell.execution.StreamingExecutionControl;

import java.util.Comparator;

public class DoubleLinkedListQueue<T> implements DoubleEndedQueue<T>{

    private DequeNode<T> first;
    private DequeNode<T> last;

    @Override
    public void append(DequeNode<T> node) {
        if(node == null) {
            throw new RuntimeException("Append : Can not add a not existing node");
        }

        if(first == null) {
            first = node;
            last = node;
        } else {
            node.setPrevious(last);
            last.setNext(node);
            last = node;
        }
    }

    @Override
    public void appendLeft(DequeNode node) {

        if(node == null) {
            throw new RuntimeException("Append : Can not add a not existing node");
        }

        if(first == null) {
            first = node;
            last = node;
        } else {

            first.setPrevious(node);
            node.setNext(first);

            first = node;
        }

    }

    @Override
    public void deleteFirst() {

        if(first == null) {
            throw new RuntimeException("Empty list : Can not delete first");
        }

        if(this.size() == 1) {
            first = null;
            last = null;
        } else {
            DequeNode aux = first.getNext();
            aux.setPrevious(null);
            first = aux;
        }

    }

    @Override
    public void deleteLast() {
        if(first == null) {
            throw new RuntimeException("Empty list : Can not delete last");
        }

        if(this.size() == 1) {
            first = null;
            last = null;

        } else {

            DequeNode aux = last.getPrevious();
            aux.setNext(null);
            last = aux;

        }
    }

    @Override
    public DequeNode peekFirst() {
        return first;
    }

    @Override
    public DequeNode peekLast() {
        return last;
    }

    @Override
    public int size() {
        DequeNode aux = first;
        int sz = 0;

        while(aux != null) {
            aux = aux.getNext();
            sz++;
        }
        return sz;
    }

    @Override
    public DequeNode<T> getAt(int position) {
        if(position < 0){
            throw new RuntimeException("Negative index on getAt(): " + position);
        }else if(position > this.size()-1){
            throw new RuntimeException("Out of bounds index on getAt(): " + position);
        }

        DequeNode aux = first;
        int i = 0;

        while(i<position) {
            aux = aux.getNext();
            i++;
        }

        return aux;
    }

    @Override
    public DequeNode<T> find(T item) {
        DequeNode aux = first;

        while(aux != null && !aux.getItem().equals(item) ) {
            aux = aux.getNext();
        }
        return aux;
    }

    @Override
    public void delete(DequeNode<T> node) {
        if(node.isFirstNode()){
            deleteFirst();
        }else if(node.isLastNode()){
            deleteLast();
        }else{
            node.getPrevious().setNext(node.getNext());
            node.getNext().setPrevious(node.getPrevious());
        }
    }

    @Override
    public void sort(Comparator<T> comparator) {
        if (this.size() > 1) {
            for (int limit = this.size() - 1; limit > 0; limit--) {
                for (int firstIndex = 0; firstIndex < limit; firstIndex++) {
                    int secondIndex = firstIndex + 1;

                    if (comparator.compare(this.getAt(firstIndex).getItem(),this.getAt(secondIndex).getItem()) > 0) {
                        changeNodes(this.getAt(firstIndex),this.getAt(secondIndex));
                    }
                }
            }
        }
    }

    private void changeNodes(DequeNode node1,DequeNode node2){
        node1.setNext(node2.getNext());
        node1.getPrevious().setNext(node2);
        node2.setNext(node1);
        node2.setPrevious(node1.getPrevious());
        node1.setPrevious(node2);
        node1.getNext().setPrevious(node1);
    }
}
