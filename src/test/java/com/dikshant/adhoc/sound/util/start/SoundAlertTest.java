/*
 *  All rights reserved.
 */
package com.dikshant.adhoc.sound.util.start;

import com.sun.net.httpserver.Authenticator;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author DikshantS
 */
public class SoundAlertTest {
    
    public SoundAlertTest() {
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
     * Test of init method, of class SoundAlert.
     */
    @Test
    public void testInit() {
        System.out.println("init");
        SoundAlert instance = new SoundAlert();
        try {
            instance.init();
        } catch (IOException ex) {
            fail("Errow while locating the source WAV file for generating the alert.");
        }
    }

    /**
     * Test of alert method, of class SoundAlert.
     */
    @Test
    public void testAlert() {
        System.out.println("alert");
        SoundAlert instance = new SoundAlert();
        instance.alert();
    }

    /**
     * Test of close method, of class SoundAlert.
     */
    @Test
    public void testClose() { }
}
