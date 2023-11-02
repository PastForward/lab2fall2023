package project2fall2023;

import junit.textui.ResultPrinter;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.runner.RunWith;

/**
 * Tests the various methods in the Bottle.java class
 * @author Aron Kabai-Tokes
 */
@RunWith(Enclosed.class)
public class BottleTest {
    
    /**
     *  Runs the tests
     */
    @RunWith(ReplaceUnderscores.class)
    public static class GettersAndSettersTest {
        static Bottle instance;

        @AfterClass
        public static void tearDownClass() {
            instance = null;
        }
        @Before
        public void set_up() {
            instance = null;
        }
        
        @AfterClass
        public static void tear_down() {
            instance = null;
        }
        
        /**
        * Test of getColor method, of class Bottle.
        */
       @Test
       public void Get_Color() {
           System.out.println("getColor");
           String expResult = "red";
           instance = new Bottle("name", 10, expResult, 0);
           String result = instance.getColor();
           System.out.println("expResult: " + expResult);
           System.out.println("actual: " + result);
           assertTrue(expResult.equals(result), expResult + "!=" + result);
       }

       /**
        * Test of setColor method, of class Bottle.
        */
       @Test
       public void testSetColor() {
           System.out.println("setColor");
           boolean expResult = true;
           String newColor = "red";
           instance = new Bottle("name", 10, newColor, 0);
           instance.setColor(newColor);
           assertTrue(newColor.equals(instance.getColor()), expResult + "!=" + instance.getColor());
       }

       /**
        * Test of getContentTemperature method, of class Bottle.
        */
       @Test
       public void testGetContentTemperature() {
           System.out.println("getContentTemperature");
           int expResult = 0;
           instance = new Bottle("name", 10, "red", expResult);
           int result = instance.getContentTemperature();
           assertEquals(expResult, result);
       }

       /**
        * Test of setContentTemperature method, of class Bottle.
        */
       @Test
       public void testSetContentTemperature() {
           System.out.println("setContentTemperature");
           int newContentTemperature = 0;
           instance = new Bottle("name", 10, "red", 3);
           instance.setContentTemperature(newContentTemperature);
           assertEquals(newContentTemperature, instance.getContentTemperature());
       }
    }

    
    @RunWith(ReplaceUnderscores.class)
    public static class CompareToTest {
        private static Bottle bottle;
        private static Bottle otherBottle;
        
        @Before
        public void set_up() {
            bottle = null;
            otherBottle = null;
        }
        
        @AfterClass
        public static void tear_down() {
            bottle = null;
            otherBottle = null;
        }
        
        /**
        * Test of compareTo method with two objects of the same value, of class Bottle.
        */
       @Test
       public void compare_with_same_values() {
           System.out.println("compare with same values");
           int expResult = 0;
           bottle = new Bottle("name", 10, "red", 0);
           otherBottle = new Bottle("name", 10, "red", 0);
           int result = bottle.compareTo(otherBottle);
           assertEquals(expResult, result);
        }
       
        /**
        * Test of compareTo method with the names being the same value
        */
        @Test
        public void comparing_name_values_same() {
            System.out.println("compare with different name values");
            System.out.println("compare with same name ");
            int expResultSameName = 0;
            bottle = new Bottle("a", 10, "red", 0);
            otherBottle = new Bottle("a", 10, "red", 0);
            int resultSameName = bottle.compareTo(otherBottle);
            assertEquals(expResultSameName, resultSameName);
        }
       
        /**
         * Test of compareTo method with different name values by 1
         */
        @Test
        public void comparing_name_values_different_by_1() {
            System.out.println("compare with different name by 1 lex.");
            int expResultDiffNameBy1After = 1;
            bottle = new Bottle("b", 10, "red", 0);
            otherBottle = new Bottle("a", 10, "red", 0);
            int resultDiffNameBy1After = bottle.compareTo(otherBottle);
            assertEquals(expResultDiffNameBy1After, resultDiffNameBy1After);
            
        }
        
        /**
         * Test of compareTo method with different name values by -1
         */
        @Test
        public void comparing_name_values_different_by_negative_1() { 
            System.out.println("compare with different name by -1 lex.");
            int expResultDiffNameBy1Before = -1;
            bottle = new Bottle("a", 10, "red", 0);
            otherBottle = new Bottle("b", 10, "red", 0);
            int resultDiffBy1Before = bottle.compareTo(otherBottle);
            assertEquals(expResultDiffNameBy1Before, resultDiffBy1Before);
        }
        
        /**
         * Test of compareTo method with different storage capacity values by 1
         */
        @Test
        public void comparing_storage_capacity_values_different_by_1() {
            int expResult = 1;
            bottle = new Bottle("name", 15, "red", 0);
            otherBottle = new Bottle("name", 10, "red", 0);
            int result = bottle.compareTo(otherBottle);
            assertEquals(expResult, result);
            
            int expResult2 = -1;
            int result2 = otherBottle.compareTo(bottle);
            assertEquals(expResult2, result2);
        }
    }   
}
