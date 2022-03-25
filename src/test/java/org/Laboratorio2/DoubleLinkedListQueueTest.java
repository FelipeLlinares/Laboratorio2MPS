package org.Laboratorio2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import java.util.Comparator;


import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class DoubleLinkedListQueueTest {

    private DoubleLinkedListQueue<Integer> list;

    @BeforeEach
    public void setup() {
        list = new DoubleLinkedListQueue<>();
    }


    @Test
    public void shouldThrowExceptionWhenAppendNullNode() {
        assertThrows(RuntimeException.class, () -> list.append(null));
    }

    @Test
    public void appendNodeWhenEmptyListShouldSetNewNodeAsTheFirstOne() {
        DequeNode<Integer> expectedValue = new DequeNode<>(1, null, null);
        list.append(expectedValue);
        DequeNode<Integer> obtainedValue = list.peekLast();
        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void appendNodeWhenEmptyListShouldHaveSize1() {
        int expectedValue = 1;
        list.append(new DequeNode<>(1, null, null));
        int obtainedValue = list.size();
        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void appendNodeWhenOnlyOneElementIsInTheListShouldSetNewNodeAsTheLastOne() {
        DequeNode<Integer> expectedValue = new DequeNode<>(2, null, null);
        list.append(new DequeNode<>(1, null, null));
        list.append(expectedValue);
        DequeNode<Integer> obtainedValue = list.peekLast();
        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void appendNodeWhenOnlyOneElementIsInTheListShouldHaveSize2() {
        int expectedValue = 2;
        list.append(new DequeNode<>(1, null, null));
        list.append(new DequeNode<>(2, null, null));
        int obtainedValue = list.size();
        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void appendNodeShouldSetNewNodeAsTheLastOne() {
        list.append(new DequeNode<>(1, null, null));
        list.append(new DequeNode<>(2, null, null));
        list.append(new DequeNode<>(3, null, null));
        list.append(new DequeNode<>(4, null, null));

        DequeNode<Integer> expectedValue = new DequeNode<>(5, null, null);
        list.append(expectedValue);

        DequeNode<Integer> obtainedValue = list.peekLast();
        assertEquals(expectedValue, obtainedValue);
        assertEquals(5,list.size());
    }

    @Test
    public void appendNodeShouldIncrementSizeBy1() {
        list.append(new DequeNode<>(1, null, null));
        list.append(new DequeNode<>(2, null, null));
        list.append(new DequeNode<>(3, null, null));
        list.append(new DequeNode<>(4, null, null));
        int expectedValue = list.size() + 1;
        list.append(new DequeNode<>(5, null, null));
        int obtainedValue = list.size();
        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void appendNodeShouldDoNothingIfNodeIsThere(){
        DequeNode<Integer> node = new DequeNode<>(1,null,null);
        list.append(node);
        list.append(node);
        list.append(node);
        list.append(node);
        DequeNode<Integer> obtainedValue = list.peekLast();
        assertEquals(node, obtainedValue);
        assertEquals(1,list.size());
    }

    @Test
    public void shouldThrowExceptionWhenAppendLeftNullNode() {
        assertThrows(RuntimeException.class, () -> list.appendLeft(null));
    }

    @Test
    public void appendLeftNodeWhenEmptyListShouldSetNewNodeAsTheFirstOne() {
        DequeNode<Integer> expectedValue = new DequeNode<>(1, null, null);
        list.appendLeft(expectedValue);
        DequeNode<Integer> obtainedValue = list.peekLast();
        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void appendLeftNodeWhenEmptyListShouldHaveSize1() {
        int expectedValue = 1;
        list.appendLeft(new DequeNode<>(1, null, null));
        int obtainedValue = list.size();
        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void appendLeftNodeWhenOnlyOneElementIsInTheListShouldSetNewNodeAsTheFirstOne() {
        DequeNode<Integer> expectedValue = new DequeNode<>(2, null, null);
        list.appendLeft(new DequeNode<>(1, null, null));
        list.appendLeft(expectedValue);
        DequeNode<Integer> obtainedValue = list.peekFirst();
        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void appendLeftNodeWhenOnlyOneElementIsInTheListShouldHaveSize2() {
        int expectedValue = 2;
        list.appendLeft(new DequeNode<>(1, null, null));
        list.appendLeft(new DequeNode<>(2, null, null));
        int obtainedValue = list.size();
        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void appendLeftNodeShouldSetNewNodeAsTheFirstOne() {
        list.appendLeft(new DequeNode<>(1, null, null));
        list.appendLeft(new DequeNode<>(2, null, null));
        list.appendLeft(new DequeNode<>(3, null, null));
        list.appendLeft(new DequeNode<>(4, null, null));
        DequeNode<Integer> expectedValue = new DequeNode<>(5, null, null);
        list.appendLeft(expectedValue);
        DequeNode<Integer> obtainedValue = list.peekFirst();
        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void appendLeftNodeShouldIncrementSizeBy1() {
        list.appendLeft(new DequeNode<>(1, null, null));
        list.appendLeft(new DequeNode<>(2, null, null));
        list.appendLeft(new DequeNode<>(3, null, null));
        list.appendLeft(new DequeNode<>(4, null, null));
        int expectedValue = list.size() + 1;
        list.appendLeft(new DequeNode<>(5, null, null));
        int obtainedValue = list.size();
        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void appendLeftShouldDoNothingIfNodeIsThere(){
        DequeNode<Integer> node = new DequeNode<>(1,null,null);
        list.append(node);
        list.append(node);
        list.append(node);
        list.append(node);
        DequeNode<Integer> obtainedValue = list.peekLast();
        assertEquals(node, obtainedValue);
        assertEquals(1,list.size());
    }


    @Test
    public void deleteFirstShouldThrowAnExceptionIfListIsEmpty() {
        assertThrows(RuntimeException.class, () -> list.deleteFirst());
    }

    @Test
    public void deleteFirstWhenThereIsOnlyOneNodeShouldSetFirstAsNullNode() {
        list.append(new DequeNode<>(1, null, null));
        list.deleteFirst();
        assertNull(list.peekFirst());
        assertNull(list.peekLast());
    }

    @Test
    public void deleteFirstWhenThereIsOnlyOneNodeShouldReturnSize0() {
        list.append(new DequeNode<>(1, null, null));
        list.deleteFirst();
        int expectedValue = 0;
        int obtainedValue = list.size();
        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void deleteFirstShouldSetSecondNodeAsTheFirstOne() {
        list.append(new DequeNode<>(1, null, null));
        DequeNode<Integer> expectedValue = new DequeNode<>(2, null, null);
        list.append(expectedValue);
        list.deleteFirst();
        DequeNode<Integer> obtainedValue = list.peekFirst();
        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void deleteFirstShouldDecreaseSizeBy1() {
        list.append(new DequeNode<>(1, null, null));
        list.append(new DequeNode<>(2, null, null));
        list.deleteFirst();
        int expectedValue = 1;
        int obtainedValue = list.size();
        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void deleteLastShouldThrowAnExceptionIfListIsEmpty() {
        assertThrows(RuntimeException.class, () -> list.deleteLast());
    }

    @Test
    public void deleteLastWhenThereIsOnlyOneNodeShouldSetFirstAsNullNode() {
        list.append(new DequeNode<>(1, null, null));
        list.deleteLast();
        assertNull(list.peekFirst());
        assertNull(list.peekLast());
    }

    @Test
    public void deleteLastWhenThereIsOnlyOneNodeShouldReturnSize0() {
        list.append(new DequeNode<>(1, null, null));
        list.deleteLast();
        int expectedValue = 0;
        int obtainedValue = list.size();
        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void deleteLastShouldSetSecondToLastNodeAsTheLastOne() {
        DequeNode<Integer> expectedValue = new DequeNode<>(1, null, null);
        list.append(expectedValue);
        list.append(new DequeNode<>(2, null, null));
        list.deleteLast();
        DequeNode<Integer> obtainedValue = list.peekLast();
        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void deleteLastShouldDecreaseSizeBy1() {
        list.append(new DequeNode<>(1, null, null));
        list.append(new DequeNode<>(2, null, null));
        list.deleteLast();
        int expectedValue = 1;
        int obtainedValue = list.size();
        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void shouldThrowExceptionWhenGetAtNegativePosition() {
        list.append(new DequeNode<>(1, null, null));
        list.append(new DequeNode<>(2, null, null));
        assertThrows(RuntimeException.class, () -> list.getAt(-2));
    }

    @Test
    public void shouldThrowExceptionWhenGetAtOutOfBoundsPosition() {
        list.append(new DequeNode<>(1, null, null));
        list.append(new DequeNode<>(2, null, null));
        assertThrows(RuntimeException.class, () -> list.getAt(3));
    }

    @Test
    public void getAtShouldReturnFirstNodeAtPosGiven0() {
        list.append(new DequeNode<>(1, null, null));
        list.append(new DequeNode<>(2, null, null));
        list.append(new DequeNode<>(6, null, null));
        list.append(new DequeNode<>(8, null, null));
        DequeNode<Integer> expectedValue = list.peekFirst();
        DequeNode<Integer> obtainedValue = list.getAt(0);
        assertEquals(expectedValue,obtainedValue);
    }

    @Test
    public void getAtShouldReturnLastNodeAtPosGivenSizeMinus1() {
        list.append(new DequeNode<>(1, null, null));
        list.append(new DequeNode<>(2, null, null));
        list.append(new DequeNode<>(6, null, null));
        list.append(new DequeNode<>(8, null, null));
        DequeNode<Integer> expectedValue = list.peekLast();
        DequeNode<Integer> obtainedValue = list.getAt(list.size()-1);
        assertEquals(expectedValue,obtainedValue);
    }

    @Test
    public void getAtShouldReturnDequeNodeAtPosGiven() {
        list.append(new DequeNode<>(1, null, null));
        list.append(new DequeNode<>(2, null, null));
        DequeNode<Integer> expectedValue = new DequeNode<>(6, null, null);
        list.append(expectedValue);
        list.append(new DequeNode<>(8, null, null));
        DequeNode<Integer> obtainedValue = list.getAt(2);
        assertEquals(expectedValue,obtainedValue);
    }



    @Test
    public void findShouldReturnNullWhenItemNotThere() {
        list.append(new DequeNode<>(1, null, null));
        list.append(new DequeNode<>(2, null, null));
        list.append(new DequeNode<>(6, null, null));
        list.append(new DequeNode<>(8, null, null));
        DequeNode<Integer> obtainedValue = list.find(9);
        assertNull(obtainedValue);
    }

    @Test
    public void findShouldReturnFirstNodeWhenItemGivenIsInFirst(){
        list.append(new DequeNode<>(1, null, null));
        list.append(new DequeNode<>(2, null, null));
        list.append(new DequeNode<>(6, null, null));
        list.append(new DequeNode<>(8, null, null));
        DequeNode<Integer> obtainedValue = list.find(1);
        assertEquals(list.peekFirst(),obtainedValue);
    }

    @Test
    public void findShouldReturnLastNodeWhenItemGivenIsInLast(){
        list.append(new DequeNode<>(1, null, null));
        list.append(new DequeNode<>(2, null, null));
        list.append(new DequeNode<>(6, null, null));
        list.append(new DequeNode<>(8, null, null));
        DequeNode<Integer> obtainedValue = list.find(8);
        assertEquals(list.peekLast(),obtainedValue);
    }

    @Test
    public void findShouldReturnNodeWithItemGiven(){
        list.append(new DequeNode<>(1, null, null));
        list.append(new DequeNode<>(2, null, null));
        DequeNode<Integer> expectedValue = new DequeNode<>(6, null, null);
        list.append(expectedValue);
        list.append(new DequeNode<>(8, null, null));
        DequeNode<Integer> obtainedValue = list.find(6);
        assertEquals(expectedValue,obtainedValue);
    }



    @Test
    public void deleteShouldDoNothingIfNodeIsNotInList(){
        list.append(new DequeNode<>(1, null, null));
        list.append(new DequeNode<>(2, null, null));
        list.append(new DequeNode<>(6, null, null));
        list.append(new DequeNode<>(8, null, null));
        DoubleLinkedListQueue<Integer> aux = new DoubleLinkedListQueue<>(list);

        list.delete(new DequeNode<>(4,null,null));

        for(int i=0;i<list.size();i++){
            assertEquals(list.getAt(i).getItem(),aux.getAt(i).getItem());
        }
    }

    @Test
    public void deleteShouldDeleteFirstNodeWhenNodeGivenIsFirstOne(){
        DequeNode<Integer> node = new DequeNode<>(1, null, null);
        list.append(node);
        list.append(new DequeNode<>(2, null, null));
        list.append(new DequeNode<>(6, null, null));
        list.append(new DequeNode<>(8, null, null));
        DoubleLinkedListQueue<Integer> aux = new DoubleLinkedListQueue<>(list);
        list.delete(node);

        int expectedValue = list.peekFirst().getItem();

        assertNotEquals(expectedValue,node.getItem());
        for(int i=0;i<list.size();i++){
            assertEquals(list.getAt(i).getItem(),aux.getAt(i+1).getItem());
        }
        assertEquals(list.size(),aux.size()-1);
    }

    @Test
    public void deleteShouldDeleteLastNodeWhenNodeGivenIsLastOne(){
        DequeNode<Integer> node = new DequeNode<>(1, null, null);
        list.append(new DequeNode<>(2, null, null));
        list.append(new DequeNode<>(6, null, null));
        list.append(new DequeNode<>(8, null, null));
        list.append(node);

        DoubleLinkedListQueue<Integer> aux = new DoubleLinkedListQueue<>(list);
        list.delete(node);

        int expectedValue = list.peekLast().getItem();

        assertNotEquals(expectedValue,node.getItem());
        for(int i=0;i<list.size();i++){
            assertEquals(list.getAt(i).getItem(),aux.getAt(i).getItem());
        }
        assertEquals(list.size(),aux.size()-1);
    }

    @Test
    public void deleteShouldDeleteNodeNodeGiven(){
        DequeNode<Integer> node = new DequeNode<>(1, null, null);
        list.append(new DequeNode<>(2, null, null));
        list.append(new DequeNode<>(6, null, null));
        list.append(node);
        list.append(new DequeNode<>(8, null, null));

        DoubleLinkedListQueue<Integer> aux = new DoubleLinkedListQueue<>(list);
        list.delete(node);

        for(int i=0;i<2;i++){
            assertEquals(list.getAt(i).getItem(),aux.getAt(i).getItem());
        }
        assertEquals(list.getAt(2).getItem(),aux.getAt(3).getItem());
        assertEquals(list.size(),aux.size()-1);
    }

    @Test
    public void sortShouldDoNothingIfEmptyList(){
        DoubleLinkedListQueue<Integer> aux = new DoubleLinkedListQueue<>(list);
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        assertEquals(list.peekFirst(),aux.peekFirst());
    }
    @Test
    public void sortShouldDoNothingIfListSizeIsOne(){
        list.append(new DequeNode<>(1,null,null));
        DoubleLinkedListQueue<Integer> aux = new DoubleLinkedListQueue<>(list);
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        assertEquals(list.peekFirst().getItem(),aux.peekFirst().getItem());
        assertEquals(list.size(),aux.size());
    }

    @Test
    public void sortShouldSortListByComparatorParameter(){
        DequeNode<Integer> node1 = new DequeNode<>(2,null,null);
        DequeNode<Integer> node2 = new DequeNode<>(4,null,null);
        DequeNode<Integer> node3 = new DequeNode<>(6,null,null);
        DequeNode<Integer> node4 = new DequeNode<>(8,null,null);

        list.append(node3);
        list.append(node2);
        list.append(node4);
        list.append(node1);

        DoubleLinkedListQueue<Integer> aux = new DoubleLinkedListQueue<>(list);


        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        int[] array = new int[]{3,1,0,2};

        for(int i=0;i<list.size();i++){
            assertEquals(list.getAt(i).getItem(),aux.getAt(array[i]).getItem());
        }
    }

    @Test
    public void sortShouldSortListByComparatorParameter2(){
        DequeNode<Integer> node1 = new DequeNode<>(1,null,null);
        DequeNode<Integer> node2 = new DequeNode<>(2,null,null);
        DequeNode<Integer> node3 = new DequeNode<>(3,null,null);
        DequeNode<Integer> node4 = new DequeNode<>(4,null,null);
        DequeNode<Integer> node5 = new DequeNode<>(5,null,null);
        DequeNode<Integer> node6 = new DequeNode<>(6,null,null);

        list.append(node2);
        list.append(node4);
        list.append(node1);
        list.append(node6);
        list.append(node5);
        list.append(node3);

        DoubleLinkedListQueue<Integer> aux = new DoubleLinkedListQueue<>(list);


        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        int[] array = new int[]{2,0,5,1,4,3};

        for(int i=0;i<list.size();i++){
            assertEquals(list.getAt(i).getItem(),aux.getAt(array[i]).getItem());

        }
        /*
        assertNull(node1.getPrevious());
        assertEquals(node2.getPrevious(),node1);
        assertEquals(node3.getPrevious(),node2);
        assertEquals(node4.getPrevious(),node3);
        assertEquals(node5.getPrevious(),node4);
        assertEquals(node6.getPrevious(),node5);
         */

    }




}