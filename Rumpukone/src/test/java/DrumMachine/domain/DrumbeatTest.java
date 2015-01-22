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
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        drumbeat = new Drumbeat("Bussipysäkillä");
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void konstruktoriAsettaaNimenOikein() {
        assertEquals("Bussipysäkillä", this.drumbeat.getNimi());
    }
    
    @Test
    public void konstruktoriAsettaaPhrasenOikein() {
        // odottaa parempia aikoja...
    }

    @Test
    public void addDrumPhraseLisaaFraasin() {
        Phrase x = new Phrase();
        this.drumbeat.addDrumPhrase(x);
        assertEquals(1, this.drumbeat.getBeat().getSize());
    }
}
