
package DrumMachine.domain;

import java.util.Random;
import jm.music.data.*;

public final class Hit {
    private Note nuotti;
    
    public Hit(int instrument, int rhythmValue) {
        this.nuotti = new Note(getInstrument(instrument), getRhythmValue(rhythmValue));
        
    }
    public int getInstrument(int instrument) {
        if (instrument == 1) {
            instrument = 35; //Bassdrum
        }
        else if (instrument == 2) {
            instrument = 36; //toinen Bass drum
        }
        else if (instrument == 3) { // snare
            instrument = 38;
        }
        else if (instrument == 4) { // hi-hat 
            instrument = 42;
        } else {
            instrument = -2147483648;
        }
        return instrument;
    }
    
    public double getRhythmValue(int rhythmValue) {
        double x = rhythmValue;
        
        if (x == 4) {
            x = 1.0;
        }
        if (x == 8) {
            x = 0.5;
        }
        if (x == 16) {
            x = 0.25;
        }
        return x;
    }
    
    public Note getNuotti() {
        return this.nuotti;
    }
    
    public String toString () {
        return this.nuotti.getFrequency() + ", " + this.nuotti.getRhythmValue() + ", " + this.nuotti.getDynamic();
    }
    
    private int dynamize() {
        Random x = new Random(10);
        int volume = 110 - x.nextInt();
        return volume;
    }
}
