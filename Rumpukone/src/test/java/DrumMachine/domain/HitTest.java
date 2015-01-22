package DrumMachine.domain;


import DrumMachine.domain.Hit;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class HitTest {
    
    Hit hit;
    
    @Before
    public void setUp() {
        hit = new Hit(4, 4);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void konstruktoriAsettaaSoittimenOikein(){
        assertEquals(42, this.hit.getNuotti().getPitch(), 0);
    }
    @Test
    public void konstruktoriAsettaaAikaArvonOikein() {
       assertEquals(1.0, this.hit.getNuotti().getRhythmValue(), 0);
    }
    
    @Test
    public void getInstrumentPalauttaaOikeanArvon(){
        for (int z = 0; z < 5; z++) {
        if (z == 1) assertEquals(35, this.hit.getInstrument(z));
        else if (z == 2) assertEquals(36, this.hit.getInstrument(z));
        else if (z == 3) assertEquals(38, this.hit.getInstrument(z));
        else if (z == 4) assertEquals(42, this.hit.getInstrument(z));
        else assertEquals(-2147483648, this.hit.getInstrument(z));
        }
    }    
    
    @Test
    public void getRhythmValuePalauttaaOikeanArvon(){
        for (int i = 2; i < 5; i++) {
            int apu = (int) Math.pow(2, i);    
            if (apu == 1) assertEquals(1.0, this.hit.getRhythmValue(apu), 0);
            else if (apu == 2) assertEquals(0.5, this.hit.getRhythmValue(apu), 0);
            else if (apu == 3) assertEquals(0.25, this.hit.getRhythmValue(apu), 0);
        }
    }
}
