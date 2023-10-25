package project2fall2023;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;

/** tests the SinglyLinkedList class
 *
 * @author Aron Kabai-Tokes
 */
@RunWith(Enclosed.class)
public class SinglyLinkedListTest {
    private static SinglyLinkedList<Container> instance;
    
    public static class normalClasses {
        
        @Before
        public void setUp() {
            instance = new SinglyLinkedList();
        }
        
        /**
         * Test of getSize method, of class SinglyLinkedList.
         */
        @Test
        public void testGetSize() {
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
            instance.add(newElement);
            assertTrue(instance.getSize() == 1);
            // TODO review the generated test code and remove the default call to fail.
    //        fail("element not added.");
        }

        @Ignore
        @Test
        public void testAddKeepOrder() {
            Container newElement = new Container("zzzz", 10);
            instance.add(newElement);
            instance.add(new Container("aaaa", 10));
            instance.add(new Container("aab", 10));
    //        assertTrue(instance);
        }

        /**
         * Test of exists method, of class SinglyLinkedList.
         */
        @Test
        public void testExists() {
            Container target = new Container("name", 10);
            instance.add(target);
            boolean expResult = true;
            boolean result = instance.exists(target);
            assertTrue(expResult == result);
        }

        /**
         * Test of countOccurences method, of class SinglyLinkedList.
         */
        @Test
        public void testCountOccurences() {
            Container target = new Container("name", 10);
            instance.add(new Container("name", 10));
            instance.add(new Container("name", 10));
            instance.add(new Container("name2", 11));
            int expResult = 2;   
            int result = instance.countOccurences(target);
            assertEquals(expResult, result);
        }
    }

    /**
     * Test of remove method, of class SinglyLinkedList.
     */
    public static class removeItems {
        
        @Before
        public void setUp() {
            instance = new SinglyLinkedList();
        }
    
        @Test
        @DisplayName("removing item from head when it is the only item")
        public void removingItemWhenOnlyOne() {
            Container target = new Container("name", 10);
            instance.add(target);
            boolean expResult = true;
            boolean result = instance.remove(target);
            assertTrue(expResult == result);
        }
        
        @Test
        @DisplayName("removing item from head with more than one item")
        public void removingItemFromHeadWhenMoreThanOne() {
            Container target = new Container("name", 10);
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
            instance.add(new Container("name", 8));
            instance.add(new Container("name2", 9));
            instance.add(target);
            boolean expResult = true;
            boolean result = instance.remove(target);
            assertTrue(expResult == result);
        }
    }
}
