package org.Laboratorio2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoubleLinkedListQueueTest {

    private DoubleLinkedListQueue<DequeNode<Integer>> list;

    @BeforeEach
    public void setup() {
        list = new DoubleLinkedListQueue<>();
    }

    @Test
    public void shouldThrowExceptionWhenAppendNullNode() {
        assertThrows(RuntimeException.class, () -> list.append(null));
    }

    @Test
    public void appendNodeWhenEmptyListShouldSetFirstNodeAsNewNode() {
        DequeNode<Integer> expectedValue = new DequeNode<>(1, null, null);
        list.append(expectedValue);
        DequeNode<Integer> obtainedValue = list.peekLast();
        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void appendNodeWhenEmptyListShouldHaveSize1() {
        int expectedValue = 1;
        list.append(new DequeNode(1, null, null));
        int obtainedValue = list.size();
        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void appendNodeWhenOnlyOneElementIsInTheListShouldSetLastNodeAsNewNode() {
        DequeNode<Integer> expectedValue = new DequeNode<>(2, null, null);
        list.append(new DequeNode(1, null, null));
        list.append(expectedValue);
        DequeNode<Integer> obtainedValue = list.peekLast();
        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void appendNodeWhenOnlyOneElementIsInTheListShouldHaveSize2() {
        int expectedValue = 2;
        list.append(new DequeNode(1, null, null));
        list.append(new DequeNode(2, null, null));
        int obtainedValue = list.size();
        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void appendNodeShouldSetLastAsNewNode() {
        list.append(new DequeNode(1, null, null));
        list.append(new DequeNode(2, null, null));
        list.append(new DequeNode(3, null, null));
        list.append(new DequeNode(4, null, null));
        DequeNode<Integer> expectedValue = new DequeNode(5, null, null);
        list.append(expectedValue);
        DequeNode<Integer> obtainedValue = list.peekLast();
        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void appendNodeShouldIncrementSizeBy1() {
        list.append(new DequeNode(1, null, null));
        list.append(new DequeNode(2, null, null));
        list.append(new DequeNode(3, null, null));
        list.append(new DequeNode(4, null, null));
        int expectedValue = list.size() + 1;
        list.append(new DequeNode(5, null, null));
        int obtainedValue = list.size();
        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void shouldThrowExceptionWhenAppendLeftNullNode() {
        assertThrows(RuntimeException.class, () -> list.appendLeft(null));
    }

    @Test
    public void appendlLeftNodeWhenEmptyListShouldSetFirstNodeAsNewNode() {
        DequeNode<Integer> expectedValue = new DequeNode<>(1, null, null);
        list.appendLeft(expectedValue);
        DequeNode<Integer> obtainedValue = list.peekLast();
        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void appendLeftNodeWhenEmptyListShouldHaveSize1() {
        int expectedValue = 1;
        list.appendLeft(new DequeNode(1, null, null));
        int obtainedValue = list.size();
        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void appendLeftNodeWhenOnlyOneElementIsInTheListShouldSetFirstNodeAsNewNode() {
        DequeNode<Integer> expectedValue = new DequeNode<>(2, null, null);
        list.appendLeft(new DequeNode(1, null, null));
        list.appendLeft(expectedValue);
        DequeNode<Integer> obtainedValue = list.peekFirst();
        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void appendLeftNodeWhenOnlyOneElementIsInTheListShouldHaveSize2() {
        int expectedValue = 2;
        list.appendLeft(new DequeNode(1, null, null));
        list.appendLeft(new DequeNode(2, null, null));
        int obtainedValue = list.size();
        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void appendLeftNodeShouldSetFirstAsNewNode() {
        list.appendLeft(new DequeNode(1, null, null));
        list.appendLeft(new DequeNode(2, null, null));
        list.appendLeft(new DequeNode(3, null, null));
        list.appendLeft(new DequeNode(4, null, null));
        DequeNode<Integer> expectedValue = new DequeNode(5, null, null);
        list.appendLeft(expectedValue);
        DequeNode<Integer> obtainedValue = list.peekFirst();
        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void appendLeftNodeShouldIncrementSizeBy1() {
        list.appendLeft(new DequeNode(1, null, null));
        list.appendLeft(new DequeNode(2, null, null));
        list.appendLeft(new DequeNode(3, null, null));
        list.appendLeft(new DequeNode(4, null, null));
        int expectedValue = list.size() + 1;
        list.appendLeft(new DequeNode(5, null, null));
        int obtainedValue = list.size();
        assertEquals(expectedValue, obtainedValue);
    }
}