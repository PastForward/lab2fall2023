package project2fall2023;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;

/**
 *
 * @author Aron Kabai-Tokes
 */
public class SinglyLinkedListTest {

    /**
     * Test of getSize method, of class SinglyLinkedList.
     */
    @Test
    public void testGetSize() {
        SinglyLinkedList instance = new SinglyLinkedList();
        int expResult = 0;
        int result = instance.getSize();
        assertEquals(expResult, result);
    }

    /**
     * Test of add method, of class SinglyLinkedList.
     */
    @Test
    public void testAdd() {
        Container newElement = new Container("name", 10);
        SinglyLinkedList<Container> instance = new SinglyLinkedList();
        instance.add(newElement);
        assertTrue(instance.getSize() == 1);
        // TODO review the generated test code and remove the default call to fail.
//        fail("element not added.");
    }

    /**
     * Test of exists method, of class SinglyLinkedList.
     */
    @Test
    public void testExists() {
        Container target = new Container("name", 10);
        SinglyLinkedList<Container> instance = new SinglyLinkedList();
        instance.add(target);
        boolean expResult = true;
        boolean result = instance.exists(target);
        assertTrue(expResult == result);
        
//        fail("The test case is a prototype.");
    }

    /**
     * Test of countOccurences method, of class SinglyLinkedList.
     */
    @Test
    public void testCountOccurences() {
        SinglyLinkedList<Container> instance = new SinglyLinkedList<>();
        Container target = new Container("name", 10);
        instance.add(new Container("name", 10));
        instance.add(new Container("name", 10));
        instance.add(new Container("name2", 11));
        int expResult = 2;   
        int result = instance.countOccurences(target);
        assertEquals(expResult, result);
    }

    /**
     * Test of remove method, of class SinglyLinkedList.
     */
    @Test
    @DisplayName("removing item from head when it is the only item")
    public void removingItemWhenOnlyOne() {
        Container target = new Container("name", 10);
        SinglyLinkedList<Container> instance = new SinglyLinkedList();
        instance.add(target);
        boolean expResult = true;
        boolean result = instance.remove(target);
        assertTrue(expResult == result);
    }

    @Test
    @DisplayName("removing item from head with more than one item")
    public void removingItemFromHeadWhenMoreThanOne() {
        Container target = new Container("name", 10);
        SinglyLinkedList<Container> instance = new SinglyLinkedList();
        instance.add(target);
        instance.add(new Container("name2", 11));
        instance.add(new Container("name2", 12));
        boolean expResult = true;
        boolean result = instance.remove(target);
        assertTrue(expResult == result);
    }

    @Test
    @DisplayName("removing item from middle")
    public void removingItemFromMiddle() {
        Container target = new Container("name", 10);
        SinglyLinkedList<Container> instance = new SinglyLinkedList();
        instance.add(new Container("name", 9));
        instance.add(target);
        instance.add(new Container("name2", 11));
        boolean expResult = true;
        boolean result = instance.remove(target);
        assertTrue(expResult == result);
    }

    @Test
    @DisplayName("removing item from tail")
    public void removingItemFromTail() {
        Container target = new Container("name", 10);
        SinglyLinkedList<Container> instance = new SinglyLinkedList();
        instance.add(new Container("name", 8));
        instance.add(new Container("name2", 9));
        instance.add(target);
        boolean expResult = true;
        boolean result = instance.remove(target);
        assertTrue(expResult == result);
    }
}
