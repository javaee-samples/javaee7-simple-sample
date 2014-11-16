package org.javaee7.sample;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author arungupta
 */
public class PersonTest {
    
    public PersonTest() {
    }
    
    /**
     * Test of get method, of class Person.
     */
    @Test
    public void testGetAll() {
        System.out.println("get");
        Person instance = new Person();
        String expResult = "";
        String result = instance.get();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of get method, of class Person.
     */
    @Test
    public void testGetOne() {
        System.out.println("get");
        int id = 0;
        Person instance = new Person();
        String expResult = "";
        String result = instance.get(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
