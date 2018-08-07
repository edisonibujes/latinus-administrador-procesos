/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.latinus.arcom.comun.util;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Ignore;

/**
 *
 * @author Cristhian Herrera - Latinus
 */
public class SystemOutTest {
    
    public SystemOutTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of println method, of class SystemOut.
     */
    @Ignore
    @Test
    public void testPrintln() {
        System.out.println("println");
        String message = "--> ";
        SystemOut.println(message);
        
    }
}