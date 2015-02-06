package DrumMachine.domain;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import DrumMachine.domain.*;
import jm.music.data.*;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author pnikande
 */
public class DrumPhraseTest {
    
    DrumPhrase drumPhrase;
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        drumPhrase = new DrumPhrase();
        
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void konstruktoriAsettaaPhrasenAloitusAjanOikein() {
        assertEquals(0.0, this.drumPhrase.getPhrase().getStartTime(), 0);
    }
    
    @Test
    public void addHitLisaaIskun() {
        Hit hit = new Hit(4, 4);
        this.drumPhrase.addHit(hit);
        assertEquals(1, this.drumPhrase.getPhrase().getSize());
    }
        
   

}
