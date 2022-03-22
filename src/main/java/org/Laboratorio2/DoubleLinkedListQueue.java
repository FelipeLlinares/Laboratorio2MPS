package org.Laboratorio2;

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
}
