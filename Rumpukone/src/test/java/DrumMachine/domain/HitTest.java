package DrumMachine.domain;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class HitTest {
    
    Hit hit;
    
    @Before
    public void setUp() {
        hit = new Hit(3, 4);
    }
    
    @Test
    public void konstruktoriAsettaaSoittimenOikein(){
        assertEquals(42, this.hit.getHit().getPitch(), 0);
    }
    @Test
    public void konstruktoriAsettaaAikaArvonOikein() {
       assertEquals(1.0, this.hit.getHit().getRhythmValue(), 0);
    }
    
    @Test 
    public void konstruktoriAsettaaDynamiikanOikeinGhostSnarelle() {
        //int x = this.hit.dynamize();
        assertEquals(this.hit.getDynamics(4), 30);
    }
    
    @Test 
    public void dynamizeToimiiOikein() {
        int x = this.hit.dynamize();
        assertEquals(true, x >= 80 && x <= 125);
    }
    
    @Test
    public void getInstrumentPalauttaaOikeanArvon(){
        for (int z = 0; z < 5; z++) {
        if (z == 0) assertEquals(35, this.hit.getInstrument(z));
        else if (z == 1) assertEquals(46, this.hit.getInstrument(z));
        else if (z == 2) assertEquals(38, this.hit.getInstrument(z));
        else if (z == 4) assertEquals(38, this.hit.getInstrument(z));
        else if (z == 3) assertEquals(42, this.hit.getInstrument(z));
        else assertEquals(-2147483648, this.hit.getInstrument(z));
        }
    }    
    
    @Test
    public void getRhythmValuePalauttaaOikeanArvon(){
        for (int i = 2; i < 5; i++) {
            int apu = (int) Math.pow(2, i);    
            if (apu == 4) assertEquals(1.0, this.hit.getRhythmValue(apu), 0);
            else if (apu == 8) assertEquals(0.5, this.hit.getRhythmValue(apu), 0);
            else if (apu == 16) assertEquals(0.25, this.hit.getRhythmValue(apu), 0);
            else {
            }
        }
    }
}
