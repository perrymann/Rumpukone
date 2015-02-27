/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DrumMachine.domain;

import drummachine.domain.Machine;
import drummachine.domain.DrumPhrase;
import jm.music.data.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pnikande
 */
public class MachineTest {
    Machine machine;
    DrumPhrase drumPhrase = new DrumPhrase(4);
   
    public MachineTest() {
    }
    
    @Before
    public void setUp() {
        machine = new Machine();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void formatDrumPhraseAlustaaOikein() {
        this.machine.formatDrumPhrases();
        assertEquals(drumPhrase.getNoteArray().length, 4);
    }
    
   
}
