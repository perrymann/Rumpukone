package DrumMachine.domain;


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
public class DrumbeatTest {

    Drumbeat drumbeat;
    
    public DrumbeatTest() {
    }
    
    @Before
    public void setUp() {
        drumbeat = new Drumbeat(120);
    }
    
    @Test
    public void konstruktoriAsettaaTemponOikein() {
        assertEquals(120, this.drumbeat.getTempo());
    }
    
    @Test
    public void addDrumPhraseLisaaFraasin() {
        Phrase x = new Phrase();
        this.drumbeat.addDrumPhrase(x);
        assertTrue(1 == this.drumbeat.getBeat().getSize());
    }
   
}
