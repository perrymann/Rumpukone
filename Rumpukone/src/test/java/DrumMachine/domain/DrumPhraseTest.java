package DrumMachine.domain;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import drummachine.domain.DrumPhrase;
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
        drumPhrase = new DrumPhrase(8);
        
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void konstruktoriAsettaaPhrasenPituudenAOikein() {
        assertEquals(8, this.drumPhrase.getLength());
    }
    
    @Test
    public void addHitLisaaIskunOikein() {
        Note hit = new Note(36, 4);
        this.drumPhrase.addBassDrumHitToList(hit, 2);
        assertEquals(hit, this.drumPhrase.getNoteArray()[2]);
    }
    
}
