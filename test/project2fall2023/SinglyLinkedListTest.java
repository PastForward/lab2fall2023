package project2fall2023;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.runner.RunWith;

/** tests the SinglyLinkedList class
 *
 * @author Aron Kabai-Tokes
 */
@RunWith(Enclosed.class)
public class SinglyLinkedListTest {
    private static SinglyLinkedList<Container> instance;
    
    @RunWith(ReplaceUnderscores.class)
    public static class normalClasses {
        
        @Before
        public void setUp() {
            instance = new SinglyLinkedList();
        }
        
        /**
         * Test of getSize method, of class SinglyLinkedList.
         */
        @Test
        public void get_size_of_list() {
            int expResult = 0;
            int result = instance.getSize();
            assertEquals(expResult, result);
        }

        /**
         * Test of add method, of class SinglyLinkedList.
         */
        @Test
        public void test_add() {
            Container newElement = new Container("name", 10);
            instance.add(newElement);
            assertTrue(instance.getSize() == 1);
            // TODO review the generated test code and remove the default call to fail.
    //        fail("element not added.");
        }

        @Ignore
        @Test
        public void keep_order_when_adding_new_items() {
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
        public void test_exists() {
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
        public void test_count_occurences() {
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
    @RunWith(ReplaceUnderscores.class)
    public static class removeItems {
        
        @Before
        public void set_up() {
            instance = new SinglyLinkedList();
        }
    
        @Test
        public void removing_item_when_only_one() {
            Container target = new Container("name", 10);
            instance.add(target);
            boolean expResult = true;
            boolean result = instance.remove(target);
            assertTrue(expResult == result);
        }
        
        @Test
        public void removing_item_From_head_when_more_than_one() {
            Container target = new Container("name", 10);
            instance.add(target);
            instance.add(new Container("name2", 11));
            instance.add(new Container("name2", 12));
            boolean expResult = true;
            boolean result = instance.remove(target);
            assertTrue(expResult == result);
        }
        
        @Test
        public void removing_item_from_middle() {
            Container target = new Container("name", 10);
            instance.add(new Container("name", 9));
            instance.add(target);
            instance.add(new Container("name2", 11));
            boolean expResult = true;
            boolean result = instance.remove(target);
            assertTrue(expResult == result);
        }
        
        @Test
        public void removing_item_from_tail() {
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
