/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.latinus.arcom.comun.configuracion;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Cristhian Herrera - Latinus
 */
public class ConfiguracionTest {
    
    public ConfiguracionTest() {
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
     * Test of getInstance method, of class Configuracion.
     */
    @Ignore
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        Configuracion expResult = null;
        Configuracion result = Configuracion.getInstance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProperty method, of class Configuracion.
     */
    @Ignore
    @Test
    public void testGetProperty() {
        System.out.println("getProperty");
        String key = "configuracion.alfresco.usuario";
        Configuracion instance = Configuracion.getInstance();
     
        String result = instance.getProperty(key);
        
        System.out.println(" --> "+result + " ");
    }
}